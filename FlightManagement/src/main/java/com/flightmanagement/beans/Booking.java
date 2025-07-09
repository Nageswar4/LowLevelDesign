package com.flightmanagement.beans;

import java.time.LocalDate;

public class Booking {

	private String bookingId;
	private String flightId;
	private String tripId;
	private String startLocation;
	private String destination;
	private LocalDate createdOn;
	private BookingStatus status;
	private int noOfseats;

	public String getBookingId() {
		return bookingId;
	}

	public Booking(String bookingId, String flightId, String tripId, String startLocation, String destination,
			LocalDate createdOn, BookingStatus status, int seats) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.tripId = tripId;
		this.startLocation = startLocation;
		this.destination = destination;
		this.createdOn = createdOn;
		this.status = status;
		this.noOfseats = seats;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
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

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public int getNoOfseats() {
		return noOfseats;
	}

	public void setNoOfseats(int noOfseats) {
		this.noOfseats = noOfseats;
	}
}
