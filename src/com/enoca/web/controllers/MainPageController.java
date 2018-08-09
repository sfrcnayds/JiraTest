package com.enoca.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enoca.web.service.UserService;

@Controller
public class MainPageController {
	@Autowired
	private UserService userService;

	@RequestMapping("/mainPage")
	public String showMainPage(Model model) {
		model.addAttribute("users", userService.getAllUser());
		return "mainPage";
	}
}
