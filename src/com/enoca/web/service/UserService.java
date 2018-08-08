package com.enoca.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.web.dao.User;
import com.enoca.web.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public boolean createUser(User createdUser) {
		return userDAO.createUser(createdUser);
	}
	
	
	
	
}
