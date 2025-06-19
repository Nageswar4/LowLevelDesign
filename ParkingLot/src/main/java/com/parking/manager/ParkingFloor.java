package com.parking.manager;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.parking.beans.Vehicle;
import com.parking.beans.VehicleType;
import com.parking.exception.NoVehicleTypeFoundException;
import com.parking.parkingspot.FourWheeler;
import com.parking.parkingspot.ParkingSpot;
import com.parking.parkingspot.TwoWheeler;

public class ParkingFloor {
	private Map<String, ParkingSpot> twoWheelerMapping;
	private Map<String, ParkingSpot> fourWheelerMapping;
	private int maxTwoWheelerCount;
	private int maxFourWheelerCount;
	private int twoWheelerBookedCount;
	private int fourWheelerBookedCount;
	private int floorId;

	public ParkingFloor(Map<String, ParkingSpot> twoWheelerMapping, Map<String, ParkingSpot> fourWheelerMapping,
			int maxTwoWheelerCount, int maxFourWheelerCount, int twoWheelerBookedCount, int fourWheelerBookedCount) {
		super();
		this.twoWheelerMapping = twoWheelerMapping;
		this.fourWheelerMapping = fourWheelerMapping;
		this.maxTwoWheelerCount = maxTwoWheelerCount;
		this.maxFourWheelerCount = maxFourWheelerCount;
		this.twoWheelerBookedCount = twoWheelerBookedCount;
		this.fourWheelerBookedCount = fourWheelerBookedCount;
	}

	public ParkingFloor() {

	}

	public ParkingFloor(int floorId) {
		this.floorId = floorId;
	}

	public Map<String, ParkingSpot> getTwoWheelerMapping() {
		return twoWheelerMapping;
	}

	public void setTwoWheelerMapping(Map<String, ParkingSpot> twoWheelerMapping) {
		this.twoWheelerMapping = twoWheelerMapping;
	}

	public Map<String, ParkingSpot> getFourWheelerMapping() {
		return fourWheelerMapping;
	}

	public void setFourWheelerMapping(Map<String, ParkingSpot> fourWheelerMapping) {
		this.fourWheelerMapping = fourWheelerMapping;
	}

	public int getMaxTwoWheelerCount() {
		return maxTwoWheelerCount;
	}

	public void setMaxTwoWheelerCount(int maxTwoWheelerCount) {
		this.maxTwoWheelerCount = maxTwoWheelerCount;
	}

	public int getMaxFourWheelerCount() {
		return maxFourWheelerCount;
	}

	public void setMaxFourWheelerCount(int maxFourWheelerCount) {
		this.maxFourWheelerCount = maxFourWheelerCount;
	}

	public int getTwoWheelerBookedCount() {
		return twoWheelerBookedCount;
	}

	public void setTwoWheelerBookedCount(int twoWheelerBookedCount) {
		this.twoWheelerBookedCount = twoWheelerBookedCount;
	}

	public int getFourWheelerBookedCount() {
		return fourWheelerBookedCount;
	}

	public void setFourWheelerBookedCount(int fourWheelerBookedCount) {
		this.fourWheelerBookedCount = fourWheelerBookedCount;
	}

	public void intializeParkingFloor(int twoWheeler, int fourWheeler) {
		this.twoWheelerMapping = new ConcurrentHashMap<>();
		this.fourWheelerMapping = new ConcurrentHashMap<>();
		this.maxTwoWheelerCount = twoWheeler;
		this.maxFourWheelerCount = fourWheeler;
		this.twoWheelerBookedCount = 0;
		this.fourWheelerBookedCount = 0;
		for (int i = 1; i < twoWheeler; i++) {
			ParkingSpot spot = new TwoWheeler(i + "");
			spot.setFloorId(this.floorId);
			this.twoWheelerMapping.put(spot.getParkingSpotId(), spot);
		}
		for (int i = 1; i < fourWheeler; i++) {
			ParkingSpot spot = new FourWheeler(i + "");
			spot.setFloorId(this.floorId);
			this.fourWheelerMapping.put(spot.getParkingSpotId(), spot);
		}

	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public Map<String, ParkingSpot> getParkingSpots(VehicleType vehicleType) throws NoVehicleTypeFoundException {
		if (vehicleType.equals(VehicleType.TWO_WHEELER))
			return this.twoWheelerMapping;
		else if (vehicleType.equals(VehicleType.FOUR_WHEELER))
			return this.fourWheelerMapping;
		else
			throw new NoVehicleTypeFoundException(
					"For a given VehicleType Parking Space is Not Available in Our Parking Lot");
	}

	public void parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
		
		synchronized(parkingSpot) {
			parkingSpot.setEmpty(false);
			parkingSpot.setVehicleId(vehicle.getVehicleId());
			
		}
		
		
	}

}
