package com.milica.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.UserDao;
import com.milica.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class UserControllerTest {

	@Autowired
	private UserDao userDao;
	
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
		user.setUsername("milicajovanovic");
		user.setPassword("123");
		user.setEnabled(1);
	}
	
	@Test
	@Transactional
	public void testAddUser() {
		boolean result = userDao.addUser(user);
		
		assertTrue(result);
	}
	
}
