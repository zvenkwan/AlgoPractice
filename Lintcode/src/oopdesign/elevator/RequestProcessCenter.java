package oopdesign.elevator;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestProcessCenter implements Runnable {

	private static RequestProcessCenter instance = null;
	private BlockingQueue<FloorRequest> queue;
	private ArrayList<Elevator> elevators;
	private RequestProcessCenter() {
		queue = new LinkedBlockingQueue<FloorRequest>();
		elevators = new ArrayList<Elevator>();
		Elevator el1 = new Elevator("No1");
		elevators.add(el1);
		Thread el1t = new Thread(el1);
		el1t.start();
	}
	
	public static RequestProcessCenter getInstance() {
		if (instance == null) {
			synchronized (Elevator.class) {
				instance = new RequestProcessCenter();
			}
		}
		return instance;
	}

	public void run() {
		while (true) {
			processRequestInQueue();
		}
	}

	private void processRequestInQueue() {
		if(!queue.isEmpty()) {
			FloorRequest frq = queue.poll();
			processFloorRequest(frq);
		} else {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(" no floor request for now, waiting");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void processFloorRequest(FloorRequest floorRequest) {
		Elevator el = findElevator(floorRequest);
		
		if(el == null) {
			System.out.println("can not find elevators!");
			queuingFloorRequest(floorRequest);
		}
		
		el.takeFloorRequest(floorRequest);
	}

	public void queuingFloorRequest(FloorRequest floorRequest) {
		System.out.println(" add request  to queue");
		queue.offer(floorRequest);
	}

	private Elevator findElevator(FloorRequest floorRequest) {
		for(Elevator el: elevators) {
			if(el.ignore(floorRequest.getToFloor())) {
				continue;
			}
			if(el.getDirection() == Direction.wait) {
				return el;
			}
			if(el.getDirection() == floorRequest.getDirection()) {
				if(el.getDirection() == Direction.up && el.getFloorLevel() < floorRequest.getToFloor()) {
					return el;
				}
				if(el.getDirection() == Direction.down && el.getFloorLevel() > floorRequest.getToFloor()) {
					return el;
				}
			}
		}
		return null;
	}
}