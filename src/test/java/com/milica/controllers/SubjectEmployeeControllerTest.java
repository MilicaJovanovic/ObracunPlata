package com.milica.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.EmployeeDao;
import com.milica.dao.SubjectDao;
import com.milica.dao.SubjectEmployeeDao;
import com.milica.entities.Employee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class SubjectEmployeeControllerTest {

	@Autowired
	private SubjectEmployeeDao subjectEmployeeDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	private SubjectEmployee pair;
	private Subject subject;
	private Employee employee;
	
	@Before
	public void setUp() {
		subject = createSubject();
		employee = createEmployee();
		
		pair = new SubjectEmployee();
		pair.setEmployeeId(employee);
		pair.setSubjectId(subject);
	}
	
	@Test
	@Transactional
	public void testAddPair() {
		subjectDao.addSubject(subject);
		employeeDao.addEmployee(employee);
		boolean result = subjectEmployeeDao.addSubjectEmployee(pair);
		
		assertTrue(result);
	}
	
	private Subject createSubject() {
		Subject subject = new Subject();
		subject.setName("Demo predmet");
		subject.setLocation("Lokacija");
		subject.setType("Vrsta predmeta");
		subject.setSemester("Jesenji");
		subject.setCode("CS101");
		subject.setClassNumber(2);
		subject.setGroupExerciseNumber(2);
		subject.setIndividualExcerciseNumber(2);
		subject.setEspb(8);
		subject.setGroupsNumber(2);
		subject.setWordsNumber(20);
		subject.setFpm(1);
		subject.setFob(1);
		subject.setFin1(1);
		subject.setFin2(1);
		subject.setFmm(2);
		subject.setFkv(2);
		
		return subject;
	}
	
	private Employee createEmployee() {
		Employee employee = new Employee();
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
		
		return employee;
	}
	
}
