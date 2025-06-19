package com.parking.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.parking.beans.Vehicle;
import com.parking.beans.VehicleType;
import com.parking.exception.NoParkingSpotAvailabeException;
import com.parking.exception.NoVehicleTypeFoundException;
import com.parking.parkingStrategy.ParkingSpotFindStrategy;
import com.parking.parkingStrategy.ParkingStrategyMapping;
import com.parking.parkingStrategy.ParkingStrategyType;
import com.parking.parkingspot.ParkingSpot;

public class ParkingSpotManager {

	private static ParkingSpotManager parkingSpotManager;
	private ParkingSpotFindStrategy parkingStrategy;
	private static ParkingStrategyMapping parkingStrategyMapping;

	Map<Integer, ParkingFloor> floorMapping;

	private ParkingSpotManager() {

	}

	public static ParkingSpotManager getInstance() {
		if (parkingSpotManager == null) {
			synchronized (ParkingSpotManager.class) {
				if (parkingSpotManager == null) {
					parkingSpotManager = new ParkingSpotManager();
					parkingStrategyMapping = new ParkingStrategyMapping();
				}
			}

		}
		return parkingSpotManager;
	}

	public void intializeParkingFloor(int count) {

		this.floorMapping = new ConcurrentHashMap<>();
		for (int i = 1; i <= count; i++) {
			ParkingFloor parkingFloor = new ParkingFloor(i);
			parkingFloor.intializeParkingFloor(10, 10);
			this.floorMapping.put(i, parkingFloor);

		}

	}

	public ParkingSpot getParkingSpots(VehicleType vehicleType, ParkingSpotFindStrategy parkingStrategy)
			throws NoParkingSpotAvailabeException, NoVehicleTypeFoundException {
		List<ParkingFloor> floors = new ArrayList<>(this.floorMapping.values());
		ParkingSpot parkingSpot = null;
		if (parkingStrategy != null) {
			parkingSpot = parkingStrategy.findParkingSpot(floors, vehicleType);
			if (parkingSpot != null)
				return parkingSpot;
		}
		parkingSpot = this.parkingStrategyMapping.getParkingStrategy(ParkingStrategyType.Near).findParkingSpot(floors,
				vehicleType);
		if (parkingSpot == null)
			throw new NoParkingSpotAvailabeException("No Parking Spot Avvailable For the VehicleType" + vehicleType);

		return parkingSpot;

	}

	public boolean bookParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle) {

		ParkingFloor parkingFloor = this.floorMapping.get(parkingSpot.getFloorId());
		try {
			Map<String, ParkingSpot> map = parkingFloor.getParkingSpots(vehicle.getVehicleType());
			ParkingSpot parkingspot = map.getOrDefault(parkingSpot.getParkingSpotId(), null);
			if (parkingspot == null)
				return false;

			synchronized (parkingspot) {
				if (parkingspot.isEmpty()) {
					parkingspot.setEmpty(false);
					parkingspot.setVehicleId(vehicle.getVehicleId());
					synchronized (parkingFloor) {
						if (vehicle.getVehicleType().equals(VehicleType.FOUR_WHEELER)) {
							parkingFloor.setFourWheelerBookedCount(parkingFloor.getFourWheelerBookedCount() + 1);
						} else {
							parkingFloor.setTwoWheelerBookedCount(parkingFloor.getTwoWheelerBookedCount() + 1);
						}
					}
					generateTicket(parkingspot);

					return true;

				}
			}

		} catch (NoVehicleTypeFoundException e) {

			e.printStackTrace();
		}
		return false;

	}

	private void generateTicket(ParkingSpot parkingspot) {

	}

	public boolean unParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle) {

		ParkingFloor parkingFloor = this.floorMapping.get(parkingSpot.getFloorId());
		try {
			Map<String, ParkingSpot> map = parkingFloor.getParkingSpots(vehicle.getVehicleType());
			ParkingSpot parkingspot = map.getOrDefault(parkingSpot.getParkingSpotId(), null);
			if (parkingspot == null)
				return false;
			synchronized (parkingspot) {
				if (!parkingspot.isEmpty()) {
					parkingspot.setEmpty(true);
					parkingspot.setVehicleId(null);
					synchronized (parkingFloor) {
						if (vehicle.getVehicleType().equals(VehicleType.FOUR_WHEELER)) {
							parkingFloor.setFourWheelerBookedCount(parkingFloor.getFourWheelerBookedCount() > 0
									? parkingFloor.getFourWheelerBookedCount() - 1
									: 0);
						} else {
							parkingFloor.setTwoWheelerBookedCount(parkingFloor.getTwoWheelerBookedCount() > 0
									? parkingFloor.getTwoWheelerBookedCount() - 1
									: 0);
						}
					}

					return true;

				}
			}

		} catch (NoVehicleTypeFoundException e) {

			e.printStackTrace();
		}
		return false;

	}

}
