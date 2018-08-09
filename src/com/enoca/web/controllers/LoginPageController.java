package com.enoca.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enoca.web.dao.User;
import com.enoca.web.service.UserService;

@Controller
public class LoginPageController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/loginPage")
	public String showLoginPage() {
		return "loginPage";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String verifyLogin(@RequestParam String userEmail,@RequestParam String userPassword,HttpSession session,Model model) {
		User loginedUser = userService.loginUser(userEmail, userPassword);
		if(loginedUser == null) {
			return "redirect:/loginPage";
		}
		session.setAttribute("loggedUser", loginedUser);
		return "redirect:/mainPage";
	}
	
	
	
	
}
