package com.flightmanagement.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class RouteSegment {

	private String routeId;
	private String routeSegmentId;
	private String startLocation;
	private String destinationLocation;
	private LocalDate departureDate;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private int sequenceOrder;
	
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getRouteSegmentId() {
		return routeSegmentId;
	}
	public void setRouteSegmentId(String routeSegmentId) {
		this.routeSegmentId = routeSegmentId;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public RouteSegment(String routeId, String routeSegmentId, String startLocation, String destinationLocation,
			LocalDate departureDate, LocalTime arrivalTime, LocalTime departureTime, int sequenceOrder) {
		super();
		this.routeId = routeId;
		this.routeSegmentId = routeSegmentId;
		this.startLocation = startLocation;
		this.destinationLocation = destinationLocation;
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.sequenceOrder = sequenceOrder;
	}
	
	public int getSequenceOrder() {
		return sequenceOrder;
	}
	public void setSequenceOrder(int sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}

}
