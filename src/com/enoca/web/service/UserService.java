package com.enoca.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public List<User> getAllUser(){
		return userDAO.getUsers();
	}
	
	
	//Eğer Kullanıcı emaili ve sifresi doğruysa o kullanıcı yanlış ise null;
	public User loginUser(String email, String password) {
		try {
			return userDAO.loginUser(email, password);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
