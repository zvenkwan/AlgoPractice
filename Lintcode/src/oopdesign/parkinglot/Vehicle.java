package oopdesign.parkinglot;

import java.util.ArrayList;

public abstract class Vehicle {

	protected ArrayList<ParkingSpot> parkingLots = new ArrayList<>();
	
	protected VehicleSize size;
	
	protected String plate;
	
	protected int spotsNeeded;
	
	public void park(ParkingSpot lot) {
		parkingLots.add(lot);
	}
	
	public void unPark() {
		parkingLots.removeAll(parkingLots);
	}
	
	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	
	public VehicleSize getSize() {
		return size;
	}
	
	public String getPlate() {
		return this.plate;
	}
}
