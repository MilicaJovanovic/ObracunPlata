/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.SubjectMarkDao;
import com.milica.entities.SubjectMark;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
public class SubjectMarkDaoImpl implements SubjectMarkDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SubjectMarkDaoImpl() {}

    public SubjectMarkDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<SubjectMark> getSubjectMarks() {
        List<SubjectMark> results = (List<SubjectMark>)
        sessionFactory.getCurrentSession().createCriteria(SubjectMark.class).list();
        return results;
    }

    @Override
    public SubjectMark getSubjectMarkById(int id) {
        SubjectMark subjectMark = (SubjectMark) sessionFactory.getCurrentSession().createCriteria(SubjectMark.class).add(Restrictions.eq("id", id)).uniqueResult();
        return subjectMark;
    }

    @Override
    public void editSubjectMark(SubjectMark subjectMark) {
        sessionFactory.getCurrentSession().saveOrUpdate(subjectMark);
    }

    @Override
    public SubjectMark addSubjectMark(SubjectMark subjectMark) {
        return (SubjectMark)sessionFactory.getCurrentSession().merge(subjectMark);
    }

    @Override
    public int getCountSubjectMarks() {
        Number result = (Number) sessionFactory.getCurrentSession().createSQLQuery("select count(*) from subject_mark").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deleteSubjectMark(SubjectMark subjectMark) {
        sessionFactory.getCurrentSession().delete(subjectMark);
    }
}
