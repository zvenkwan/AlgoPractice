package oopdesign.parkinglot;

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;

	public Level(int floor, int numberSpots) {
		this.floor = floor;
	}
	
	public int availableSpots() {
		return this.availableSpots;
	}
	
//	private boolean parkStartingAtSpot(int number, Vehicle v) {}
	
//	private int findAvailableSpots(Vehicle vehicle) {}
	
	public void spotFreed() {
		availableSpots ++;
	}
}
