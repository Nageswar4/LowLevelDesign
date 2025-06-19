package com.parking.parkingStrategy;

import java.util.Collection;
import java.util.List;

import com.parking.beans.VehicleType;
import com.parking.exception.NoVehicleTypeFoundException;
import com.parking.manager.ParkingFloor;
import com.parking.parkingspot.ParkingSpot;

public class NearestParkingStrategy implements ParkingSpotFindStrategy {

	@Override
	public ParkingSpot findParkingSpot(List<ParkingFloor> parkingFloors, VehicleType vehicleType)
			throws NoVehicleTypeFoundException {

		for (ParkingFloor floor : parkingFloors) {

			Collection<ParkingSpot> parkingspots = floor.getParkingSpots(vehicleType).values();
			for (ParkingSpot parkingSpot : parkingspots) {
				if (parkingSpot.isEmpty())
					return parkingSpot;
			}

		}
		return null;

	}

}
