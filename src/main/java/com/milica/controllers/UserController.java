package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.UserDao;
import com.milica.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}
	
	@RequestMapping(value="/edituser", method=RequestMethod.GET)
	public boolean editUser(User user) {
		return userDao.editUser(user);
	}
	
	@RequestMapping(value="/deleteuser", method=RequestMethod.GET)
	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}
	
	@RequestMapping(value="/getuserbyid", method=RequestMethod.GET)
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	@RequestMapping(value="/getusers", method=RequestMethod.GET)
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	@RequestMapping(value="/getcountusers", method=RequestMethod.GET)
	public int getCountUsers() {
		return userDao.getCountUsers();
	}
}
