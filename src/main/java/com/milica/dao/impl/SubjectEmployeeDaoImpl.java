package com.milica.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.milica.dao.SubjectEmployeeDao;
import com.milica.entities.Employee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;

/**
 *  
 * @author Milica
 * DAO sloj koji se koristi za pristup tabeli "subject_employee" u bazi podataka
 */
@Repository
public class SubjectEmployeeDaoImpl implements SubjectEmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SubjectEmployeeDaoImpl() {}

    public SubjectEmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public boolean addSubjectEmployee(SubjectEmployee pair) {
        SubjectEmployee currentPair = currentPair(pair);

        if (currentPair == null) {
            sessionFactory.getCurrentSession().save(pair);
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Subject> getSubjectsForEmployee(Employee employee) {
        List<SubjectEmployee> tempSubjects = sessionFactory.getCurrentSession()
            .createCriteria(SubjectEmployee.class)
            .add(Restrictions.eq("employeeId", employee))
            .list();

        List<Subject> toRet = new ArrayList<>();

        for (SubjectEmployee pair : tempSubjects) {
            toRet.add(pair.getSubjectId());
        }

        return toRet;
    }

    private SubjectEmployee currentPair(SubjectEmployee pair) {
        SubjectEmployee currentPair = (SubjectEmployee) sessionFactory.getCurrentSession()
            .createCriteria(SubjectEmployee.class)
            .add(Restrictions.eq("employeeId", pair.getEmployeeId()))
            .add(Restrictions.eq("subjectId", pair.getSubjectId()))
            .uniqueResult();
        return currentPair;
    }
}
