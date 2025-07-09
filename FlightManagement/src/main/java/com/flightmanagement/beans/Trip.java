package com.flightmanagement.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Trip {

	private String tripId;
	private String flightId;
	private String routeId;
	private LocalTime startTime;
	private LocalDate startDate;
	private List<TripSegment> tripSegments;

	public Trip(String tripId, String flightId, String routeId, LocalTime startTime, LocalDate startDate,
			List<TripSegment> tripSegments) {
		super();
		this.tripId = tripId;
		this.flightId = flightId;
		this.routeId = routeId;
		this.startTime = startTime;
		this.startDate = startDate;
		this.tripSegments = tripSegments;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<TripSegment> getTripSegments() {
		return tripSegments;
	}

	public void setTripSegments(List<TripSegment> tripSegments) {
		this.tripSegments = tripSegments;
	}

}
