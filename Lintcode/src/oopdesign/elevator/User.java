package oopdesign.elevator;

public class User {
	private String name;
	
	private Floor currentFloor;
	
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

	public void pressButton(Floor currentFloor, Direction dir) {
		FloorButton fb = currentFloor.getBtns()[dir.getValue()];
		fb.pressed();
	}
	
	public void pickUp(int currentFloor) {
		
	}
}