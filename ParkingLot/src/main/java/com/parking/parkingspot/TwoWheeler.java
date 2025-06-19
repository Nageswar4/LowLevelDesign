package com.parking.parkingspot;

import com.parking.beans.VehicleType;

public class TwoWheeler extends ParkingSpot {

	public TwoWheeler(String parkingSpotId) {
		super(parkingSpotId);
	}

	@Override
	public boolean isValidSpot(VehicleType vehicleType) {

		return VehicleType.TWO_WHEELER.equals(vehicleType);
	}

}
