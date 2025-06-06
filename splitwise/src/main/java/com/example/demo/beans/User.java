package com.example.demo.beans;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class User {

	private String userId;
	private String userName;
	private Map<String, Double> balanceMap;
	private double amountOwns;
	private Date createdOn;
	private final ReentrantLock lock = new ReentrantLock();

	public User(String userId, String userName, Map<String, Double> balanceMap, double amountOwns, Date createdOn) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.balanceMap = balanceMap;
		this.amountOwns = amountOwns;
		this.createdOn = createdOn;
	}

	public User() {

	}

	public ReentrantLock getLock() {
		return lock;
	}

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

	public Map<String, Double> getBalanceMap() {
		return balanceMap;
	}

	public void setBalanceMap(Map<String, Double> balanceMap) {
		this.balanceMap = balanceMap;
	}

	public double getAmountOwns() {
		return amountOwns;
	}

	public void setAmountOwns(double amountOwns) {
		this.amountOwns = amountOwns;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
