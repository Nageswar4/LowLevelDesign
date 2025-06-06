package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.beans.Expense;
import com.example.demo.beans.Group;

public class GroupService {
	private static GroupService groupService;
	private Map<String, Group> mappingGroup;

	private GroupService() {
		this.mappingGroup = new ConcurrentHashMap<>();
	}

	public static GroupService getInstance() {
		if (groupService == null) {
			synchronized (GroupService.class) {
				if (groupService == null) {
					groupService = new GroupService();
				}
			}
		}
		return groupService;
	}

	public void createGroup(String groupId, String groupName, List<String> userIds) {
		Group group = new Group(groupId, groupName, userIds, new ArrayList<>());
		this.mappingGroup.put(groupId, group);
		return;
	}

	public void addUser(String groupId, String userId) {
		Group group = this.mappingGroup.getOrDefault(groupId, null);
		if (group != null) {
			group.addUserId(userId);

		}
	}

	public void addExpense(Expense expense) {
		Group group = this.mappingGroup.getOrDefault(expense.getGroupId(), null);
		if (group != null) {
			group.addExpenseId(expense.getExpenseId());

		}
	}

	public Group getGroup(String groupId) {
		return mappingGroup.get(groupId);
	}

}
