package oopdesign.elevator;

public class FloorRequest {
	private int toFloor;
	public int getToFloor() {
		return toFloor;
	}

	public void setToFloor(int toFloor) {
		this.toFloor = toFloor;
	}

	public Direction getDirection() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	private Direction dir;

	public FloorRequest(int toFloor, Direction dir) {
		this.toFloor = toFloor;
		this.dir = dir;
	}

	public void send() {
		RequestProcessCenter rpc = RequestProcessCenter.getInstance();
		rpc.queuingFloorRequest(this);
	}

}
