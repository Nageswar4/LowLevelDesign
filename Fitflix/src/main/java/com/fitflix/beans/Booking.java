package com.fitflix.beans;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	private String bookingId;
	private String slotId;
	private String slotAvailabilityId;
	private LocalDate createdOn;
	private String userId;
	private LocalDate bookingOn;
	private BookingStatus bookingStatus;
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Booking(String bookingId, String slotId, String slotAvailabilityId, LocalDate createdOn, String userId,
			LocalDate bookingOn, BookingStatus bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.slotId = slotId;
		this.slotAvailabilityId = slotAvailabilityId;
		this.createdOn = createdOn;
		this.userId = userId;
		this.bookingOn = bookingOn;
		this.bookingStatus = bookingStatus;
	}

	public String getSlotAvailabilityId() {
		return slotAvailabilityId;
	}

	public void setSlotAvailabilityId(String slotAvailabilityId) {
		this.slotAvailabilityId = slotAvailabilityId;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getBookingOn() {
		return bookingOn;
	}

	public void setBookingOn(LocalDate bookingOn) {
		this.bookingOn = bookingOn;
	}

}
