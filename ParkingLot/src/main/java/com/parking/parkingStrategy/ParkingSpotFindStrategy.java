package com.parking.parkingStrategy;

import java.util.List;

import com.parking.beans.VehicleType;
import com.parking.exception.NoVehicleTypeFoundException;
import com.parking.manager.*;

import com.parking.parkingspot.ParkingSpot;

public interface ParkingSpotFindStrategy {

	public abstract ParkingSpot findParkingSpot(List<ParkingFloor> parkingFloors, VehicleType vehicleType)
			throws NoVehicleTypeFoundException;
}
