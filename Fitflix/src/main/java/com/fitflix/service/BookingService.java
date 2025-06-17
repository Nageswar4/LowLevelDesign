package com.fitflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fitflix.beans.*;

public class BookingService {
	private static BookingService bookingService = null;
	Map<String, Booking> bookingMappings;

	private BookingService() {
		this.bookingMappings = new ConcurrentHashMap<>();
	}

	public static BookingService getInstance() {
		if (bookingService == null) {
			synchronized (BookingService.class) {
				if (bookingService == null) {
					bookingService = new BookingService();
				}
			}
		}
		return bookingService;
	}

	public void addBooking(Booking booking) {
		this.bookingMappings.put(booking.getBookingId(), booking);
	}

	public Booking getBooking(String id) {
		return this.bookingMappings.getOrDefault(id, null);
	}

	public List<Booking> getAllookings() {
		return (List<Booking>) this.bookingMappings.values();
	}

	public boolean removeBooking(String slotAvailabilityId, String userId, LocalDate bookingOn) {
		for (Booking booking : this.bookingMappings.values()) {
			if (booking.getSlotAvailabilityId().equals(slotAvailabilityId) && booking.getUserId().equals(userId)
					&& booking.getBookingOn().equals(bookingOn)) {
				booking.setBookingStatus(BookingStatus.CANCELLED);
				// this.bookingMappings.remove(booking.getBookingId());
				return true;
			}
		}
		return false;
	}
}
