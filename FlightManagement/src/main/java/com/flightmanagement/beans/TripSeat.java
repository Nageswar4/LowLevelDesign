package com.flightmanagement.beans;

public class TripSeat {
	private String tripSeatId;
	private String tripId;
	private String seatId;
	private TripSeatStatus status;

	public String getTripSeatId() {
		return tripSeatId;
	}

	public void setTripSeatId(String tripSeatId) {
		this.tripSeatId = tripSeatId;
	}

	public String getTripId() {
		return tripId;
	}

	public TripSeat(String tripSeatId, String tripId, String seatId, TripSeatStatus status) {
		super();
		this.tripSeatId = tripSeatId;
		this.tripId = tripId;
		this.seatId = seatId;
		this.status = status;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public TripSeatStatus getStatus() {
		return status;
	}

	public void setStatus(TripSeatStatus status) {
		this.status = status;
	}

}
