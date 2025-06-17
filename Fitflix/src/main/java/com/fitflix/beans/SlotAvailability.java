package com.fitflix.beans;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SlotAvailability {

	private String slotAvailabilityId;
	private String slotId;
	private LocalDate date;
	private int bookingCount;
	@Id
	private String id;

	public SlotAvailability(String slotAvailabilityId, String slotId, LocalDate date, int bookingCount) {
		super();
		this.slotAvailabilityId = slotAvailabilityId;
		this.slotId = slotId;
		this.date = date;
		this.bookingCount = bookingCount;
	}

	public String getSlotAvailabilityId() {
		return slotAvailabilityId;
	}

	public void setSlotAvailabilityId(String slotAvailabilityId) {
		this.slotAvailabilityId = slotAvailabilityId;
	}

	public int getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(int bookingCount) {
		this.bookingCount = bookingCount;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getBooking() {
		return bookingCount;
	}

	public void setBooking(int booking) {
		this.bookingCount = booking;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
