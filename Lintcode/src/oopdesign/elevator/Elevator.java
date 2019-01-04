package oopdesign.elevator;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Elevator implements Runnable {
	private String label;
	private int floorLevel;
	private Direction dir;
	private HashSet<Integer> nonService;
	private PriorityBlockingQueue<Integer> upStops;
	private PriorityBlockingQueue<Integer> downStops;
	private long secondsOneFloor;
	
	public Elevator(String label) {
		this.dir = Direction.wait;
		nonService = new HashSet<Integer>();
		upStops = new PriorityBlockingQueue<Integer>();
		downStops = new PriorityBlockingQueue<Integer>(10, Collections.reverseOrder());
		this.label = label;
		this.secondsOneFloor = 2;
		this.floorLevel = 1;
	}
	
	public int getFloorLevel() {
		return this.floorLevel;
	}
	
	public void setFloorLevel(int floorLevel) {
		this.floorLevel = floorLevel;
	}
	
	

	public void moveUp() {
		this.dir = Direction.up;
		System.out.println(label + " moving up");
		while(!upStops.isEmpty()) {
			moveToFloor(upStops.peek());
			upStops.poll();
			stop();
		}
	}

	public void moveDown() {
		this.dir = Direction.down;
		System.out.println(label + " moving down");
		while(!downStops.isEmpty()) {
			moveToFloor(downStops.peek());
			downStops.poll();
			stop();
		}
	}
	
	public void moveToFloor(int floorLevel) {
		int diff = floorLevel - this.floorLevel;
		if(diff == 0) {
			this.setDirection(Direction.wait);
			return;
		} else if(diff > 0) {
			this.setDirection(Direction.up);
			diff = 1;
		} else {
			this.setDirection(Direction.down);
			diff = -1;
		}
		
		while(this.floorLevel != floorLevel) {
			try {
				System.out.println(label + " start moving current at " + this.floorLevel);
				TimeUnit.SECONDS.sleep(secondsOneFloor);
				setFloorLevel(this.floorLevel + diff);
				System.out.println(label + " arrived at " + this.floorLevel);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(label + " arrived at " + this.floorLevel);
	}
	
	public void stop() {
		openDoor();
		stopForUsers();
		closeDoor();
	}
	
	private void stopForUsers() {
		System.out.println(label + " waiting for users for 2 seconds ");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void waitForUsers() {
		this.setDirection(Direction.wait);
		System.out.println(label + " waiting for users ");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeDoor() {
		System.out.println(label + " door closing on floor " + this.floorLevel);
	}

	private void openDoor() {
		System.out.println(label + " door opening on floor " + this.floorLevel);
	}

	public void takeFloorRequest(FloorRequest floorRequest) {
		System.out.println(this.label + " will take this request to " + floorRequest.getToFloor());
		if(floorRequest.getDirection() == Direction.up) {
			upStops.add(floorRequest.getToFloor());
			System.out.println(" there are " + upStops.size() +" stop requests in the up");
		}
		
		if(floorRequest.getDirection() == Direction.down) {
			downStops.add(floorRequest.getToFloor());
			System.out.println(" there are " + downStops.size() +" stop requests in the down");
		}
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}

	public boolean ignore(int toFloor) {
		return nonService.contains(toFloor);
	}

	@Override
	public void run() {
		System.out.println("Elevator " + label + " starting");
		while(true) {
			if(upStops.isEmpty() && downStops.isEmpty()) {
				waitForUsers();
			}
			if(this.getDirection() == Direction.wait) {
				System.out.println("Elevator " + label + " waiting");
				if(!upStops.isEmpty()) {
					moveUp();
				}
				
				if(!downStops.isEmpty()) {
					moveDown();
				}
			} else if(this.getDirection() == Direction.up) {
				System.out.println("Elevator " + label + " moving up");
				if(!upStops.isEmpty()) {
					moveUp();
				}
			} else {
				if(!downStops.isEmpty()) {
					System.out.println("Elevator " + label + " moving down");
					moveDown();
				}
			}
		}
	}
}