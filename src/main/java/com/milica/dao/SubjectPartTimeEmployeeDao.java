package com.milica.dao;

import java.util.List;

import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectPartTimeEmployee;

/**
 * 
 * @author Milica
 * Interfejs sadrzi metode koje se koriste za komunikacija sa bazom podataka
 */
public interface SubjectPartTimeEmployeeDao {

	public boolean addSubjectPartTimeEmployee(SubjectPartTimeEmployee pair);
	public List<Subject> getSubjectsForPartTimeEmployee(PartTimeEmployee employee);
	
}
