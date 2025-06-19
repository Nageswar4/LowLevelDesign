package com.parking.beans;

import java.time.LocalDateTime;

public class Ticket {

	private String ticketId;
	private String parkingSpotId;
	private String vehicleId;
	private LocalDateTime dateTime;
	public String getTicketId() {
		return ticketId;
	}
	public Ticket(String ticketId, String parkingSpotId, String vehicleId, LocalDateTime dateTime) {
		super();
		this.ticketId = ticketId;
		this.parkingSpotId = parkingSpotId;
		this.vehicleId = vehicleId;
		this.dateTime = dateTime;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getParkingSpotId() {
		return parkingSpotId;
	}
	public void setParkingSpotId(String parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
