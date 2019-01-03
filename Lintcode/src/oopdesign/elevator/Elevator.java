package oopdesign.elevator;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class Elevator implements Runnable {
	private String label;
	private int floorLevel;
	private Direction dir;
	private HashSet<Integer> nonService;
	private PriorityQueue<Integer> upStops;
	private PriorityQueue<Integer> downStops;
	private long secondsOneFloor;
	
	public Elevator(String label) {
		this.dir = Direction.wait;
		nonService = new HashSet<Integer>();
		upStops = new PriorityQueue<Integer>();
		downStops = new PriorityQueue<Integer>(Collections.reverseOrder());
		this.label = label;
		this.secondsOneFloor = 2000;
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
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setFloorLevel(this.floorLevel + 1);
			if(this.floorLevel == upStops.peek()) {
				upStops.poll();
				stop();
			}
		}
	}

	public void moveDown() {
		this.dir = Direction.down;
		System.out.println(label + " moving down");
		while(!downStops.isEmpty()) {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setFloorLevel(this.floorLevel - 1);
			if(this.floorLevel == downStops.peek()) {
				upStops.poll();
				stop();
			}
		}
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
	}

	private void closeDoor() {
		System.out.println(label + " door closing on floor " + this.floorLevel);
	}

	private void openDoor() {
		System.out.println(label + " door opening on floor " + this.floorLevel);
	}

	public void takeFloorRequest(FloorRequest floorRequest) {
		if(floorRequest.getDirection() == Direction.up) {
			upStops.add(floorRequest.getToFloor());
		}
		
		if(floorRequest.getDirection() == Direction.down) {
			downStops.add(floorRequest.getToFloor());
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
		while(true) {
			if(upStops.isEmpty() && downStops.isEmpty()) {
				waitForUsers();
			}
			if(this.getDirection() == Direction.wait) {
				if(!upStops.isEmpty()) {
					moveUp();
				}
				
				if(!downStops.isEmpty()) {
					moveDown();
				}
			} else if(this.getDirection() == Direction.up) {
				if(!upStops.isEmpty()) {
					moveUp();
				}
			} else {
				if(!downStops.isEmpty()) {
					moveDown();
				}
			}
		}
	}
}