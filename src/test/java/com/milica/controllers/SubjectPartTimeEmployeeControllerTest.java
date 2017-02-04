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
import com.milica.dao.SubjectDao;
import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectPartTimeEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class SubjectPartTimeEmployeeControllerTest {

	@Autowired
	private SubjectPartTimeEmployeeDao subjectPartTimeEmployeeDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private PartTimeEmployeeDao partTimeEmployeeDao;
	
	private SubjectPartTimeEmployee pair;
	private Subject subject;
	private PartTimeEmployee employee;
	
	@Before
	public void setUp() {
		subject = createSubject();
		employee = createPartTimeEmployee();
		
		pair = new SubjectPartTimeEmployee();
		pair.setPartTimeEmployeeId(employee);
		pair.setSubjectId(subject);
	}
	
	@Test
	@Transactional
	public void testAddPair() {
		subjectDao.addSubject(subject);
		partTimeEmployeeDao.addPartTimeEmployee(employee);
		boolean result = subjectPartTimeEmployeeDao.addSubjectPartTimeEmployee(pair);
		
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
	
	private PartTimeEmployee createPartTimeEmployee() {
		PartTimeEmployee employee = new PartTimeEmployee();
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
		
		return employee;
	}
}
