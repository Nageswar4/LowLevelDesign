package com.moviebooking.beans;

import java.time.LocalDate;
import java.util.List;

public class Booking {

	private String bookingId;
	private String showId;
	private List<String> seatId;
	private LocalDate bookingDate;
	private BookingStatus bookingStatus;
	private double amount;
	private String userId;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Booking(String bookingId, String showId, List<String> seatId, LocalDate bookingDate,
			BookingStatus bookingStatus, double amount, String userId) {
		super();
		this.bookingId = bookingId;
		this.showId = showId;
		this.seatId = seatId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.amount = amount;
		this.userId = userId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public List<String> getSeatId() {
		return seatId;
	}

	public void setSeatId(List<String> seatId) {
		this.seatId = seatId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Booking(String bookingId, String showId, List<String> seatId, LocalDate bookingDate,
			BookingStatus bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.showId = showId;
		this.seatId = seatId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
