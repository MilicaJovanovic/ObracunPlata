package com.milica.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.MDitaDao;
import com.milica.entities.MDita;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/ObracunPlata-servlet.xml"})
public class MDitaControllerTest {

	@Autowired
	private MDitaDao mditaDao;
	
	private MDita mdita;
	
	@Before
	public void setUp() {
		mdita = new MDita();
		mdita.setBrojReci(2500);
		mdita.setBrojObjekataUcenja(50);
		mdita.setAssesment(50);
		mdita.setMultipleChoice(50);
		mdita.setQuestionsAndAnswers(50);
		mdita.setJavaGrader(1);
		mdita.setForum(20);
		mdita.setNoticeboard(20);
		mdita.setNotebook(20);
		mdita.setChat(20);
		mdita.setSubmitFiles(20);
		mdita.setSharedResources(20);
		mdita.setPictureGallery(200);
		mdita.setVideo(20);
		mdita.setAudio(20);
	}
	
	@Test
	@Transactional
	public void testAddMDita() {
		boolean result = mditaDao.addMDita(mdita);
		
		assertTrue(result);
	}
	
}
