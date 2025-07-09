package com.flightmanagement.flightservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.flightmanagement.beans.Trip;
import com.flightmanagement.beans.TripSegment;
import com.flightmanagement.beans.*;

public class BookingService {

	private static BookingService bookingService;
	private Map<String, Booking> bookingMap;
	private Map<String, List<Booking>> userBookings;
	Random random = new Random();

	private BookingService() {
		bookingMap = new ConcurrentHashMap<>();
		userBookings = new ConcurrentHashMap<>();
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

	public boolean bookTicket(String tripId, String startLocation, String endLocation, int numberOfSeats,
			String userId) {
		TripManagementService tripService = TripManagementService.getInstance();
		Trip trip = tripService.getTrip(tripId);

		if (trip == null) {
			System.out.println("Trip not found");
			return false;
		}
		synchronized (trip) {

			List<TripSegment> segments = trip.getTripSegments();
			segments.sort(Comparator.comparingInt(TripSegment::getSequenceNo));

			int sourceIndex = -1, destIndex = -1;

			for (int i = 0; i < segments.size(); i++) {
				if (segments.get(i).getStartlocation().equalsIgnoreCase(startLocation)) {
					sourceIndex = i;
				}
				if (segments.get(i).getDestination().equalsIgnoreCase(endLocation)) {
					destIndex = i;
					break;
				}
			}

			if (sourceIndex == -1 || destIndex == -1 || sourceIndex >= destIndex) {
				System.out.println("Invalid segment selection.");
				return false;
			}

			for (int i = sourceIndex; i < destIndex; i++) {
				TripSegment seg = segments.get(i);
				if (seg.getNoOfSeatsAvailable() < numberOfSeats) {
					System.out.println("Not enough seats available between: " + seg.getStartlocation() + " and "
							+ seg.getDestination());
					return false;
				}
			}

			for (int i = sourceIndex; i < destIndex; i++) {
				TripSegment seg = segments.get(i);
				seg.setNoOfSeatsAvailable(seg.getNoOfSeatsAvailable() - numberOfSeats);
			}

			String bookingId = random.toString();

			Booking booking = new Booking(bookingId, trip.getFlightId(), tripId, startLocation, endLocation,
					LocalDate.now(), BookingStatus.BOOKED, numberOfSeats);

			this.bookingMap.put(bookingId, booking);
			this.userBookings.computeIfAbsent(userId, k -> new ArrayList<>()).add(booking);
			System.out.println("Booking confirmed for Trip: " + tripId);
			return true;
		}
	}

	public List<Booking> getBookingsByUser(String userId) {
		return this.userBookings.getOrDefault(userId, null);
	}

}
