package com.parking.parkingStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingStrategyMapping {

	private Map<ParkingStrategyType, ParkingSpotFindStrategy> strategyMapping;

	public ParkingStrategyMapping() {
		this.strategyMapping = new HashMap<>();
		this.strategyMapping.put(ParkingStrategyType.Near, new NearestParkingStrategy());
		this.strategyMapping.put(ParkingStrategyType.Far, new FarestParkingStrategy());
	}

	public ParkingSpotFindStrategy getParkingStrategy(ParkingStrategyType parkingStrategyType) {
		return this.strategyMapping.getOrDefault(parkingStrategyType, null);
	}

}
