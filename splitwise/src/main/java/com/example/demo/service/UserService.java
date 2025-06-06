package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.beans.User;
import com.example.demo.exceptions.NoUserAvailable;

public class UserService {
	private static UserService userService;
	private Map<String, User> userMapService;

	private UserService() {
		userMapService = new ConcurrentHashMap<>();

	}

	public static UserService getInstance() {
		if (userService == null) {
			synchronized (UserService.class) {
				if (userService == null) {
					userService = new UserService();
				}
			}
		}

		return userService;
	}

	public User getUser(String string) throws NoUserAvailable {
		if (userMapService.containsKey(string)) {
			return userMapService.get(string);
		}

		throw new NoUserAvailable("User Not Available for the given UserId:  " + string);
	}

	public Map<String, String> createUser(User user) {
		User newUser = new User(user.getUserId(), user.getUserName(), new ConcurrentHashMap<>(), user.getAmountOwns(),
				new Date());
		this.userMapService.put(user.getUserId(), newUser);
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put(user.getUserName(), "User is Created in SplitWise");
		return resultMap;
	}

}
