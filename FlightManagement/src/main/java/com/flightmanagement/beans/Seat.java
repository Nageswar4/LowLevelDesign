package com.flightmanagement.beans;

public class Seat {
	private String seatId;
	private SeatStatus status;
	private String flightId;

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public Seat(String seatId, SeatStatus status, String flightId) {
		super();
		this.seatId = seatId;
		this.status = status;
		this.flightId = flightId;
	}

}
