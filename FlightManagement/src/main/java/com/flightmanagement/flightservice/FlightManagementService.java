package com.flightmanagement.flightservice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flightmanagement.beans.Flight;

public class FlightManagementService {

	private static FlightManagementService flightService;

	private Map<String, Flight> flightMapping;

	private FlightManagementService() {
this.flightMapping=new ConcurrentHashMap<>();
	}

	public static FlightManagementService getInstance() {
		if (flightService == null) {
			synchronized (FlightManagementService.class) {
				if (flightService == null) {
					flightService = new FlightManagementService();
				}
			}
		}
		return flightService;
	}

	public Flight getFlight(String flightId) {
		return this.flightMapping.getOrDefault(flightId, null);
	}

	public void addFlight(Flight flight) {
		this.flightMapping.put(flight.getFlightId(), flight);
	}
}
