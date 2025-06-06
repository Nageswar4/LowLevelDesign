package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.User;
import com.example.demo.exceptions.NoUserAvailable;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@RequestMapping("/user")
	public User getUser() {
		try {
			return UserService.getInstance().getUser("U1");
		} catch (NoUserAvailable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
