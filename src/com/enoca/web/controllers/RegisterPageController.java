package com.enoca.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enoca.web.dao.User;
import com.enoca.web.service.UserService;

@Controller
public class RegisterPageController {
	@Autowired
	private UserService userService;

	@RequestMapping("/registerPage")
	public ModelAndView showRegisterPage() {
		return new ModelAndView("registerPage", "command", new User());
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView createUser( User user) {
		user.setPassword(String.valueOf(user.getPassword().hashCode()));
		userService.createUser(user);
		return showRegisterPage();
	}
}
