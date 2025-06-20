package com.moviebooking.beans;

public class City {

	private String cityId;
	private String cityName;
	private String pinCode;

	public City(String cityId, String cityName, String pinCode) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.pinCode = pinCode;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
