package com.fitflix.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.fitflix.beans.Booking;
import com.fitflix.beans.BookingStatus;
import com.fitflix.beans.Center;
import com.fitflix.beans.Slot;
import com.fitflix.beans.SlotAvailability;

public class CenterService {

	private static CenterService centerService = null;
	Map<String, Center> centerMappings;
	Map<String, Slot> slotMappings;
	Map<String, SlotAvailability> slotAvailabilityMappings;
	Map<Integer, String> locationName = new HashMap<>();
	Map<Integer, String> centerName = new HashMap<>();

	private CenterService() {
		centerMappings = new ConcurrentHashMap<>();
		slotMappings = new ConcurrentHashMap<>();
		slotAvailabilityMappings = new ConcurrentHashMap<>();
		locationName.put(1, "Bangalore");
		locationName.put(2, "Hyderabad");
		centerName.put(1, "Bellandur");
		centerName.put(2, "Koramangala");
		centerName.put(3, "Electroncity");
		centerName.put(4, "WhiteField");
	}

	public static CenterService getInstance() {
		if (centerService == null) {
			synchronized (CenterService.class) {
				if (centerService == null) {
					centerService = new CenterService();
				}
			}
		}
		return centerService;
	}

	public void addCenter(Center center) {
		this.centerMappings.put(center.getCenterId(), center);
	}

	public void addSlot(Slot center) {
		this.slotMappings.put(center.getSlotId(), center);
	}

	public void addSlotAvailability(SlotAvailability availability) {
		this.slotAvailabilityMappings.put(availability.getSlotAvailabilityId(), availability);
	}

	public Collection<SlotAvailability> slotAvailability() {

		return this.slotAvailabilityMappings.values();

	}

	public Map<String, String> slotBooking(String slotAvailabilityId, String userId, LocalDate bookingOn) {
		Map<String, String> resultMap = new HashMap<>();

		SlotAvailability slotAvailability = this.slotAvailabilityMappings.get(slotAvailabilityId);
		if (slotAvailability == null) {
			resultMap.put("status", "FAILURE");
			resultMap.put("message", "SlotAvailability not found");
			return resultMap;
		}

		Slot slot = this.slotMappings.get(slotAvailability.getSlotId());
		if (slot == null) {
			resultMap.put("status", "FAILURE");
			resultMap.put("message", "Slot not found");
			return resultMap;
		}

		synchronized (slotAvailability) {
			int bookingCount = slotAvailability.getBookingCount();
			if (slot.getMaxCount() > bookingCount) {
				slotAvailability.setBooking(bookingCount + 1);

				BookingService.getInstance()
						.addBooking(new Booking(UUID.randomUUID().toString(), slotAvailability.getSlotId(),
								slotAvailability.getSlotAvailabilityId(), LocalDate.now(), userId, bookingOn,
								BookingStatus.CONFIRMED));

				resultMap.put("status", "SUCCESS");
				resultMap.put("message", "Booking is done for user " + userId);
				resultMap.put(slotAvailabilityId, "Booking is done for user " + userId);
			} else {
				resultMap.put("status", "FAILURE");
				resultMap.put("message", "Slot is full for user " + userId);
				resultMap.put(slotAvailabilityId, "Slot is full for user " + userId);
			}
		}
		return resultMap;

	}

	public Map<String, String> cancelBooking(String slotAvailabilityId, String userId, LocalDate bookingOn) {
		Map<String, String> resultMap = new HashMap<>();

		SlotAvailability slotAvailability = this.slotAvailabilityMappings.get(slotAvailabilityId);
		if (slotAvailability == null) {
			resultMap.put("status", "FAILURE");
			resultMap.put("message", "SlotAvailability not found");
			resultMap.put(slotAvailabilityId, "SlotAvailability not found");
			return resultMap;
		}
		synchronized (slotAvailability) {
			int bookingCount = slotAvailability.getBookingCount();
			if (bookingCount > 0) {
				// Decrement booking count
				slotAvailability.setBooking(bookingCount - 1);

				// Remove booking for that user, slotAvailability, and date
				boolean removed = BookingService.getInstance().removeBooking(slotAvailability.getSlotAvailabilityId(),
						userId, bookingOn);

				if (removed) {
					resultMap.put("status", "SUCCESS");
					resultMap.put("message", "Booking cancelled for user " + userId);
					resultMap.put(slotAvailabilityId, "Booking cancelled for user " + userId);
				} else {
					// Rollback the decrement if no booking was actually found
					slotAvailability.setBooking(bookingCount);
					resultMap.put("status", "FAILURE");
					resultMap.put("message", "No booking found to cancel for user " + userId);
					resultMap.put(slotAvailabilityId, "No booking found to cancel for user " + userId);
				}
			} else {
				resultMap.put("status", "FAILURE");
				resultMap.put("message", "No booking exists to cancel");
				resultMap.put(slotAvailabilityId, "No booking exists to cancel " + userId);
			}
		}

		return resultMap;
	}

}
