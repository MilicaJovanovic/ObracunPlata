package com.milica.dao;

import java.util.List;

import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectPartTimeEmployee;

/**
 * 
 * @author Milica
 */
public interface SubjectPartTimeEmployeeDao {

	public boolean addSubjectPartTimeEmployee(SubjectPartTimeEmployee pair);
	public List<Subject> getSubjectsForPartTimeEmployee(PartTimeEmployee employee);
	
}
