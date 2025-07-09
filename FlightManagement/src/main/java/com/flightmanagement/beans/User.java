package com.flightmanagement.beans;

public class User {

	private String userId;
	private String userName;
	private String emailId;
	private UserType userType;

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

	public User(String userId, String userName, String emailId, UserType userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.userType = userType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
