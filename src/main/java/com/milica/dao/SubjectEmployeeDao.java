package com.milica.dao;

import java.util.List;

import com.milica.entities.Employee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;

/**
 * 
 * @author Milica
 */
public interface SubjectEmployeeDao {

	public boolean addSubjectEmployee(SubjectEmployee pair);
	public List<Subject> getSubjectsForEmployee(Employee employee);
	
}
