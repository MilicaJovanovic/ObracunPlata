package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.SubjectDao;
import com.milica.entities.Subject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/** 
 *
 * @author Milica
 * DAO sloj koji se koristi za pristup tabeli "subject" u bazi podataka
 */
@Repository
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SubjectDaoImpl() {
    }

    public SubjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public boolean addSubject(Subject subject) {
        Subject currentSubject = currentSubject(subject);

        if (currentSubject == null) {
            sessionFactory.getCurrentSession().save(subject);
            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean editSubject(Subject subject) {
        Subject currentSubject = currentSubject(subject);

        if (currentSubject == null) {
            return false;
        }

        sessionFactory.getCurrentSession().update(subject);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteSubject(Subject subject) {
        Subject currentSubject = currentSubject(subject);

        if (currentSubject == null) {
            return false;
        }

        sessionFactory.getCurrentSession().delete(currentSubject);
        return true;
    }

    @Override
    @Transactional
    public Subject getSubjectById(int id) {
        Subject currentSubject = (Subject) sessionFactory.getCurrentSession()
            .createCriteria(Subject.class)
            .add(Restrictions.eq("subjectId", id))
            .uniqueResult();
        return currentSubject;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Subject> getSubjects() {
        return sessionFactory.getCurrentSession()
            .createCriteria(Subject.class)
            .list();
    }

    @Override
    @Transactional
    public int getCountSubjects() {
        List<Subject> allSubjects = getSubjects();

        if (allSubjects == null) {
            return 0;
        }
        return allSubjects.size();
    }

    private Subject currentSubject(Subject subject) {
        Subject currentSubject = (Subject) sessionFactory.getCurrentSession()
            .createCriteria(Subject.class)
            .add(Restrictions.eq("name", subject.getName()))
            .add(Restrictions.eq("code", subject.getCode()))
            .uniqueResult();
        return currentSubject;
    }
}
