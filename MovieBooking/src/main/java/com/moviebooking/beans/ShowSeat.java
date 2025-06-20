package com.moviebooking.beans;

public class ShowSeat {

	private String showId;
	private String seatId;
	private SeatType seatType;
	private SeatStatus seatStatus;
	public ShowSeat(String showId, String seatId, SeatType seatType, SeatStatus seatStatus) {
		super();
		this.showId = showId;
		this.seatId = seatId;
		this.seatType = seatType;
		this.seatStatus = seatStatus;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public SeatStatus getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

}
