/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.SubjectDao;
import com.milica.entities.Subject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
public class SubjectDaoImpl implements SubjectDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SubjectDaoImpl() {}

    public SubjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Subject> getSubjects() {
        List<Subject> results = (List<Subject>)
        sessionFactory.getCurrentSession().createCriteria(Subject.class).list();
        return results;
    }

    @Override
    public Subject getSubjectById(int id) {
        Subject subject = (Subject) sessionFactory.getCurrentSession().createCriteria(Subject.class).add(Restrictions.eq("id", id)).uniqueResult();
        return subject;
    }

    @Override
    public void editSubject(Subject subject) {
        sessionFactory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    public Subject addSubject(Subject subject) {
        return (Subject)sessionFactory.getCurrentSession().merge(subject);
    }

    @Override
    public int getCountSubjects() {
        Number result = (Number) sessionFactory.getCurrentSession().createSQLQuery("select count(*) from subject").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deleteSubject(Subject subject) {
        sessionFactory.getCurrentSession().delete(subject);
    }
}
