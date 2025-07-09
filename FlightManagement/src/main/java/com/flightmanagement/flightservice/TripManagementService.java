package com.flightmanagement.flightservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.flightmanagement.beans.*;

import com.flightmanagement.beans.Route;
import com.flightmanagement.beans.Trip;

public class TripManagementService {

	private static TripManagementService tripService;

	private Map<String, Trip> tripMapping;
	private Map<String, Route> routeMapping;

	private TripManagementService() {
		this.tripMapping = new ConcurrentHashMap<>();
		this.routeMapping = new ConcurrentHashMap<>();

	}

	public static TripManagementService getInstance() {
		if (tripService == null) {
			synchronized (TripManagementService.class) {
				if (tripService == null) {
					tripService = new TripManagementService();
				}
			}
		}

		return tripService;
	}

	public List<Trip> findTrips(String source, String destination, LocalDate date) {
		List<Trip> matchingTrips = new ArrayList<>();

		for (Route route : routeMapping.values()) {
			List<RouteSegment> segments = getRouteSegmentsByRouteId(route.getRouteId());

			Map<Integer, String> sequenceMap = segments.stream()
					.collect(Collectors.toMap(RouteSegment::getSequenceOrder, RouteSegment::getStartLocation));

			Integer sourceSeq = null;
			Integer destSeq = null;

			for (RouteSegment seg : segments) {
				if (seg.getStartLocation().equalsIgnoreCase(source)) {
					sourceSeq = seg.getSequenceOrder();
				}
				if (seg.getDestinationLocation().equalsIgnoreCase(destination)) {
					destSeq = seg.getSequenceOrder();
				}
			}
			if (sourceSeq != null && destSeq != null && sourceSeq < destSeq) {

				for (Trip trip : tripMapping.values()) {
					if (trip.getRouteId().equals(route.getRouteId()) && trip.getStartDate().equals(date)) {
						matchingTrips.add(trip);
					}
				}
			}
		}

		return matchingTrips;
	}

	public List<RouteSegment> getRouteSegmentsByRouteId(String routeId) {

		return this.routeMapping.get(routeId).getRouteSegments();
	}

	public Map<String, Trip> getTripMapping() {
		return tripMapping;
	}

	public void setTripMapping(Map<String, Trip> tripMapping) {
		this.tripMapping = tripMapping;
	}

	public Map<String, Route> getRouteMapping() {
		return routeMapping;
	}

	public void setRouteMapping(Map<String, Route> routeMapping) {
		this.routeMapping = routeMapping;
	}

	public Trip getTrip(String tripId) {
		return this.tripMapping.getOrDefault(tripId, null);
	}

}
