package oopdesign.elevator;

public class User implements Runnable {
	private String name;
	private Direction dir;
	private Floor currentFloor;
	
	public User(String name, Floor currentFloor, Direction dir) {
		super();
		this.name = name;
		this.currentFloor = currentFloor;
		this.dir = dir;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;
	}

	public void pressButton() {
		FloorButton fb = currentFloor.getBtns()[Math.min(currentFloor.getBtns().length - 1, dir.getValue())];
		System.out.println(fb.getLevel() + " " + dir + " was pressed.");
		fb.pressed();
	}

	@Override
	public void run() {
		pressButton();
	}
	
}