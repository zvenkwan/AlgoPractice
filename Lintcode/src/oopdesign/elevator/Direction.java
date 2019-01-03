package oopdesign.elevator;

public enum Direction {
	up(0), down(1), wait(2);
	
	private final int value;
	
	Direction(int value) {
		this.value = value;
	}
	
	int getValue() {
		return this.value;
	}
}
