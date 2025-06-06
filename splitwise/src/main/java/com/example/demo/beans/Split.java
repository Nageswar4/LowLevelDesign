package com.example.demo.beans;

public class Split {
	private String userId;
	private double amount;
	private double percentage;

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Split(String userId, double amount, double percentage) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.percentage = percentage;
	}
}
