package com.parking.parkingspot;

import com.parking.beans.ParkingSpotStatus;
import com.parking.beans.VehicleType;

public abstract class ParkingSpot {
	protected boolean isEmpty;
	protected String parkingSpotId;
	protected String vehicleId;
	protected int floorId;
	protected ParkingSpotStatus parkingSpotStatus;

	public ParkingSpot(String parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
		this.parkingSpotStatus = ParkingSpotStatus.ACTIVE;
		this.isEmpty = true;
	}

	public abstract boolean isValidSpot(VehicleType vehicleType);

	public ParkingSpotStatus getParkingSpotStatus() {
		return parkingSpotStatus;
	}

	public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
		this.parkingSpotStatus = parkingSpotStatus;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getParkingSpotId() {
		return parkingSpotId;
	}

	public void setParkingSpotId(String parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

}
