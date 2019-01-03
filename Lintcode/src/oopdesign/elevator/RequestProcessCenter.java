package oopdesign.elevator;

import java.util.ArrayList;
import java.util.LinkedList;

public class RequestProcessCenter implements Runnable {

	private static RequestProcessCenter instance = null;
	private LinkedList<FloorRequest> queue;
	private ArrayList<Elevator> elevators;
	private RequestProcessCenter() {
		queue = new LinkedList<FloorRequest>();
		elevators = new ArrayList<Elevator>();
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
		// TODO Auto-generated method stub
		
	}

	public void removeRequest(FloorRequest request) {
		queue.remove(request);
	}


	public void processFloorRequest(FloorRequest floorRequest) {
		Elevator el = findElevator(floorRequest);
		
		if(el == null) {
			queuingFloorRequest(floorRequest);
		}
		
		el.takeFloorRequest(floorRequest);
	}

	private void queuingFloorRequest(FloorRequest floorRequest) {
		System.out.println("can not find elevators!");
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