package oopdesign.parkinglot;

public class ParkingSpot {

	private int number;
//	boolean available;
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private Level level;
	
	public ParkingSpot(Level level, int number, VehicleSize spotSize) {
		this.level = level;
		this.number = number;
		this.spotSize = spotSize;
	}
	
	public void park(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void unPark() {
		this.vehicle = null;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public int getNumber() {
		return this.number;
	}
}
