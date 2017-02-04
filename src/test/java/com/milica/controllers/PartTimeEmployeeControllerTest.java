package com.milica.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.PartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class PartTimeEmployeeControllerTest {

	@Autowired
	private PartTimeEmployeeDao partTimeEmployeeDao;
	
	private PartTimeEmployee employee;
	
	@Before
	public void setUp() {
		employee = new PartTimeEmployee();
		employee.setName("Milica");
		employee.setLastname("Jovanovic");
		employee.setSubjectsInSpringSemester(0);
		employee.setSubjectsInAutumnSemester(20);
		employee.setFaculty("FIT");
		employee.setBankAccount("111222333");
		employee.setEmail("dusan.com");
		employee.setTeachingPosition("profesor");
		employee.setEmploymentPercentage("90");
		employee.setSubjectNumber("3");
		employee.setKt("1.3");
	}
	
	@Test
	@Transactional
	public void testAddPartTimeEmployee() {
		boolean result = partTimeEmployeeDao.addPartTimeEmployee(employee);
		
		assertTrue(result);
	}
	
}
