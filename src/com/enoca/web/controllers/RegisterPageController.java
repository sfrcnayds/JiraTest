package com.enoca.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return showRegisterPage();
		}

		user.setPassword(String.valueOf(user.getPassword().hashCode()));
		userService.createUser(user);
		return showRegisterPage();
	}
}
