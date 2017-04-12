package com.milica.dao;

import java.util.List;
import com.milica.entities.Subject;

/**
 *
 * @author Milica
 * Interfejs sadrzi metode koje se koriste za komunikacija sa bazom podataka
 */
public interface SubjectDao {

	public boolean addSubject(Subject subject);
	public boolean editSubject(Subject subject);
	public boolean deleteSubject(Subject subject);
	public Subject getSubjectById(int id);
        public List<Subject> getSubjects();
        public int getCountSubjects();
    
}
