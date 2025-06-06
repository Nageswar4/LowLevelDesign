package com.example.demo.beans;

import java.util.List;

public class Expense {
	private String expenseId;
	private String description;
	private String userPaid;
	private List<Split> splits;
	private SplitType splitType;
	private double amount;
	private String groupId;

	public double getAmount() {
		return amount;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Expense(String expenseId, String description, String userPaid, List<Split> splits, SplitType spitType,
			double amount) {
		super();
		this.expenseId = expenseId;
		this.description = description;
		this.userPaid = userPaid;
		this.splits = splits;
		this.splitType = spitType;
		this.amount = amount;
	}

	public Expense() {

	}

	public String getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserPaid() {
		return userPaid;
	}

	public void setUserPaid(String userPaid) {
		this.userPaid = userPaid;
	}

	public List<Split> getSplits() {
		return splits;
	}

	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}

	public SplitType getSplitType() {
		return splitType;
	}

	public void setSpitType(SplitType spitType) {
		this.splitType = spitType;
	}
}
