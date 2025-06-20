package com.moviebooking.beans;

public class Theater {
	private String theaterId;
	private String theaterName;
	private String cityId;
	private TheaterStatus status;

	public Theater(String theaterId, String theaterName, String cityId, TheaterStatus status) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.cityId = cityId;
		this.status = status;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public TheaterStatus getStatus() {
		return status;
	}

	public void setStatus(TheaterStatus status) {
		this.status = status;
	}

}
