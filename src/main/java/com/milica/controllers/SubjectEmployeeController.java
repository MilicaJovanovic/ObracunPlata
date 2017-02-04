package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.SubjectEmployeeDao;
import com.milica.entities.Employee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;

@Controller
@RequestMapping("/subjectemployee")
public class SubjectEmployeeController {

	@Autowired
	private SubjectEmployeeDao subjectEmployeeDao;
	
	@RequestMapping(value="/addsubjectemployee", method=RequestMethod.GET)
	public boolean addSubjectEmployee(SubjectEmployee pair) {
		return subjectEmployeeDao.addSubjectEmployee(pair);
	}
	
	@RequestMapping(value="/getsubjectsforemployee", method=RequestMethod.GET)
	public List<Subject> getSubjectsForEmployee(Employee employee) {
		return subjectEmployeeDao.getSubjectsForEmployee(employee);
	}
	
}
