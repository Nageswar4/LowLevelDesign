package com.example.demo.beans;

import java.util.List;

public class Group {

	private String groupId;
	private String groupName;
	private List<String> userId;
	private List<String> expenseIds;

	public Group(String groupId, String groupName, List<String> userId, List<String> expenseIds) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.userId = userId;
		this.expenseIds = expenseIds;
	}

	public Group() {

	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<String> getUserId() {
		return userId;
	}

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public List<String> getExpenseIds() {
		return expenseIds;
	}

	public void setExpenseIds(List<String> expenseIds) {
		this.expenseIds = expenseIds;
	}

	public void addUserId(String userId2) {
		this.userId.add(userId2);
	}

	public void addExpenseId(String expenseId) {
		this.expenseIds.add(expenseId);
	}

	public void removeExpenseId(String expenseId) {
		this.expenseIds.remove(expenseId);
	}

	public void removeUserId(String userId2) {
		this.userId.remove(userId2);
	}

}
