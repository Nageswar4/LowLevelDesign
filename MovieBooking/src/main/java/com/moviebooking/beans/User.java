package com.moviebooking.beans;

public class User {
	private String userId;
	private String userName;
	private String location;
	private UserStatus userStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public User(String userId, String userName, String location) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.location = location;
		this.userStatus = UserStatus.ACTIVE;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

}
