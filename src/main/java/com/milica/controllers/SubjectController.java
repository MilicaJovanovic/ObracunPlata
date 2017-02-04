package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.SubjectDao;
import com.milica.entities.Subject;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectDao subjectDao;
	
	@RequestMapping(value="/addsubject", method=RequestMethod.GET)
	public boolean addSubject(Subject subject) {
		return subjectDao.addSubject(subject);
	}
	
	@RequestMapping(value="/editsubject", method=RequestMethod.GET)
	public boolean editSubject(Subject subject) {
		return subjectDao.editSubject(subject);
	}
	
	@RequestMapping(value="/deletesubject", method=RequestMethod.GET)
	public boolean deleteSubject(Subject subject) {
		return subjectDao.deleteSubject(subject);
	}
	
	@RequestMapping(value="/getsubjectbyid", method=RequestMethod.GET)
	public Subject getSubjectById(int id) {
		return subjectDao.getSubjectById(id);
	}
	
	@RequestMapping(value="/getsubjects", method=RequestMethod.GET)
	public List<Subject> getSubjects() {
		return subjectDao.getSubjects();
	}
	
	@RequestMapping(value="/getcountsubjects", method=RequestMethod.GET)
	public int getCountSubjects() {
		return subjectDao.getCountSubjects();
	}
}
