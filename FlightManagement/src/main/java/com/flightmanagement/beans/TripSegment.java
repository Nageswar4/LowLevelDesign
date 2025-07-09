package com.flightmanagement.beans;

import java.time.LocalTime;

public class TripSegment {

	private String tripSegmentId;
	private String tripId;
	private String startlocation;
	private String destination;
	private int noOfSeatsAvailable;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private int sequenceNo;

	public TripSegment(String tripSegmentId, String tripId, String startlocation, String destination,
			int noOfSeatsAvailable, LocalTime arrivalTime, LocalTime departureTime, int sequenceNo) {
		super();
		this.tripSegmentId = tripSegmentId;
		this.tripId = tripId;
		this.startlocation = startlocation;
		this.destination = destination;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.sequenceNo = sequenceNo;
	}

	public String getTripSegmentId() {
		return tripSegmentId;
	}

	public void setTripSegmentId(String tripSegmentId) {
		this.tripSegmentId = tripSegmentId;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getStartlocation() {
		return startlocation;
	}

	public void setStartlocation(String startlocation) {
		this.startlocation = startlocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
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

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
}
