package com.flightmanagement.beans;

import java.time.LocalDate;

public class Flight {

	private String flightId;
	private String flightName;
	private String flightType;
	private LocalDate createdOn;
	private FlightStatus status;
	public String getFlightId() {
		return flightId;
	}
	public Flight(String flightId, String flightName, String flightType, LocalDate createdOn, FlightStatus status) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightType = flightType;
		this.createdOn = createdOn;
		this.status = status;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public FlightStatus getStatus() {
		return status;
	}
	public void setStatus(FlightStatus status) {
		this.status = status;
	}

}
