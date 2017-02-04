package com.milica.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.SubjectDao;
import com.milica.entities.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class SubjectControllerTest {

	@Autowired
	private SubjectDao subjectDao;
	
	private Subject subject;
	
	@Before
	public void setUp() {
		subject = new Subject();
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
	}
	
	@Test
	@Transactional
	public void testAddSubject() {
		boolean result = subjectDao.addSubject(subject);
		
		assertTrue(result);
	}
	
}
