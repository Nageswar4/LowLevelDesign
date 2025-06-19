package com.parking.parkingspot;

import com.parking.beans.VehicleType;

public class FourWheeler extends ParkingSpot {

	public FourWheeler(String parkingSpotId) {
		super(parkingSpotId);
	}

	@Override
	public boolean isValidSpot(VehicleType vehicleType) {
		return VehicleType.FOUR_WHEELER.equals(vehicleType);
	}

}
