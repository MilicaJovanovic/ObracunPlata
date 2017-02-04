package com.milica.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectPartTimeEmployee;

/**
 * DAO sloj koji se koristi za pristup tabeli "subject_part_time_employee" u bazi podataka
 * @author Milica
 */
@Repository
public class SubjectPartTimeEmployeeDaoImpl implements SubjectPartTimeEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean addSubjectPartTimeEmployee(SubjectPartTimeEmployee pair) {
		SubjectPartTimeEmployee currentPair = currentPair(pair);
		
		if (currentPair == null) {
			sessionFactory.getCurrentSession().save(pair);
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Subject> getSubjectsForPartTimeEmployee(PartTimeEmployee employee) {
		List<SubjectPartTimeEmployee> tempSubjects = sessionFactory.getCurrentSession()
				.createCriteria(SubjectPartTimeEmployee.class)
				.add(Restrictions.eq("partTimeEmployeeId", employee))
				.list();
		
		List<Subject> toRet = new ArrayList<>();
		
		for (SubjectPartTimeEmployee pair : tempSubjects) {
			toRet.add(pair.getSubjectId());
		}
		
		return toRet;
	}

	private SubjectPartTimeEmployee currentPair(SubjectPartTimeEmployee pair) {
		SubjectPartTimeEmployee currentPair = (SubjectPartTimeEmployee) sessionFactory.getCurrentSession()
				.createCriteria(SubjectPartTimeEmployee.class)
				.add(Restrictions.eq("partTimeEmployeeId", pair.getPartTimeEmployeeId()))
				.add(Restrictions.eq("subjectId", pair.getSubjectId()))
				.uniqueResult();
		return currentPair;
	}
	
}
