package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectPartTimeEmployee;

/**
 * Klasa sadrzi sve metode vezane za rad sa entitetom SubjectPartTimeEmployee
 * @author Milica
 */ 
@Controller
@RequestMapping("/subjectparttimeemployee")
public class SubjectPartTimeEmployeeController {

    @Autowired
    private SubjectPartTimeEmployeeDao subjectPartTimeEmployeeDao;

    @RequestMapping(value="/addsubjectparttimeemployee", method=RequestMethod.GET)
    public boolean addSubjectPartTimeEmployee(SubjectPartTimeEmployee pair) {
            return subjectPartTimeEmployeeDao.addSubjectPartTimeEmployee(pair);
    }

    @RequestMapping(value="/getsubjectsforparttimeemployee", method=RequestMethod.GET)
    public List<Subject> getSubjectsForPartTimeEmployee(PartTimeEmployee employee) {
            return subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(employee);
    }
}
