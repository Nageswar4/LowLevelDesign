package com.flightmanagement.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Route {

	private String routeId;
	private String startLocation;
	private String destination;
	private int distance;
	private LocalTime startTime;
	private LocalDate startDate;

	public List<RouteSegment> getRouteSegments() {
		return routeSegments;
	}

	public void setRouteSegments(List<RouteSegment> routeSegments) {
		this.routeSegments = routeSegments;
	}

	private List<RouteSegment> routeSegments;

	public Route(String routeId, String startLocation, String destination, int distance, LocalTime startTime,
			LocalDate startDate, List<RouteSegment> routeSegments) {
		super();
		this.routeId = routeId;
		this.startLocation = startLocation;
		this.destination = destination;
		this.distance = distance;
		this.startTime = startTime;
		this.startDate = startDate;
		this.routeSegments = routeSegments;
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

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
