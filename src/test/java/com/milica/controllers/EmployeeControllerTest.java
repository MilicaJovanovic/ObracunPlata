package com.milica.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.EmployeeDao;
import com.milica.entities.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class EmployeeControllerTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	private Employee employee;
	
	@Before
	public void setUp() {
		employee = new Employee();
		employee.setName("Milica");
		employee.setLastname("Jovanovic");
		employee.setSubjectsInSpringSemester(0);
		employee.setSubjectsInAutumnSemester(20);
		employee.setSemesterNumber(1);
		employee.setSpecialAddValue(50);
		employee.setFunctionsAddValue(100);
		employee.setFaculty("FIT");
		employee.setBankAccount("111222333");
		employee.setEmail("dusan.com");
		employee.setTeachingPosition("profesor");
		employee.setEmploymentPercentage("90");
		employee.setSubjectNumber("3");
		employee.setKbp("1.1");
		employee.setKro("1.2");
		employee.setKt("1.3");
		employee.setKpr("0.9");
		employee.setIsumHoursAutumn(11);
		employee.setIsumHoursSpring(16);
		employee.setIsumMoneyAutumn(2.16);
		employee.setIsumMoneySpring(2.16);
	}
	
	@Test
	@Transactional
	public void testAddEmployee() {
		boolean result = employeeDao.addEmployee(employee);
		
		assertTrue(result);
	}
	
}
