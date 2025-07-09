package com.flightmanagement;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.flightmanagement.beans.Booking;
import com.flightmanagement.beans.Flight;
import com.flightmanagement.beans.FlightStatus;
import com.flightmanagement.beans.Route;
import com.flightmanagement.beans.RouteSegment;
import com.flightmanagement.beans.Trip;
import com.flightmanagement.beans.TripSegment;
import com.flightmanagement.flightservice.BookingService;
import com.flightmanagement.flightservice.FlightManagementService;
import com.flightmanagement.flightservice.TripManagementService;

@SpringBootApplication
public class FlightManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner onRun() {
		return args -> {
		
		        // Step 1: Create Flight
		        Flight flight = new Flight("FL001", "Indigo 6E", "Domestic", LocalDate.now(), FlightStatus.ACTIVE);
		        FlightManagementService.getInstance().addFlight(flight);
		        RouteSegment seg1 = new RouteSegment("R001", "RS001", "Delhi", "Jaipur", LocalDate.now(),
		                LocalTime.of(9, 30), LocalTime.of(8, 0), 1);
		        RouteSegment seg2 = new RouteSegment("R001", "RS002", "Jaipur", "Udaipur", LocalDate.now(),
		                LocalTime.of(11, 0), LocalTime.of(9, 45), 2);
		        RouteSegment seg3 = new RouteSegment("R001", "RS003", "Udaipur", "Mumbai", LocalDate.now(),
		                LocalTime.of(13, 0), LocalTime.of(11, 15), 3);

		        // Step 2: Create Route and RouteSegments
		        Route route = new Route("R001", "Delhi", "Mumbai", 1500, LocalTime.of(8, 0), LocalDate.now(),Arrays.asList(seg1, seg2, seg3));
		       
		        route.setRouteSegments(Arrays.asList(seg1, seg2, seg3));
		        TripManagementService.getInstance().getRouteMapping().put("R001", route);

		        // Step 3: Create Trip and TripSegments
		        TripSegment tSeg1 = new TripSegment("TS001", "T001", "Delhi", "Jaipur", 10,
		                LocalTime.of(9, 30), LocalTime.of(8, 0), 1);
		        TripSegment tSeg2 = new TripSegment("TS002", "T001", "Jaipur", "Udaipur", 10,
		                LocalTime.of(11, 0), LocalTime.of(9, 45), 2);
		        TripSegment tSeg3 = new TripSegment("TS003", "T001", "Udaipur", "Mumbai", 10,
		                LocalTime.of(13, 0), LocalTime.of(11, 15), 3);

		        Trip trip = new Trip("T001", "FL001", "R001", LocalTime.of(8, 0), LocalDate.now(),
		                Arrays.asList(tSeg1, tSeg2, tSeg3));
		        TripManagementService.getInstance().getTripMapping().put("T001", trip);

		        // Step 4: Book Ticket
		        String userId = "U1001";
		        boolean isBooked = BookingService.getInstance().bookTicket(
		                "T001", "Delhi", "Udaipur", 2, userId
		        );

		        if (isBooked) {
		            System.out.println("Booking successful for user " + userId);
		        } else {
		            System.out.println("Booking failed for user " + userId);
		        }

		        // Step 5: View bookings for user
		        List<Booking> bookings = BookingService.getInstance().getBookingsByUser(userId);
		};
	}

}
