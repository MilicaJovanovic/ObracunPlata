/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.MDitaDao;
import com.milica.entities.MDita;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
public class MDitaDaoImpl implements MDitaDao {
    @Autowired
    private SessionFactory sessionFactory;

    public MDitaDaoImpl() {}

    public MDitaDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<MDita> getMDitas() {
        List<MDita> results = (List<MDita>)
        sessionFactory.getCurrentSession().createCriteria(MDita.class).list();
        return results;
    }

    @Override
    public MDita getMDitaById(int id) {
        MDita mDita = (MDita) sessionFactory.getCurrentSession().createCriteria(MDita.class).add(Restrictions.eq("id", id)).uniqueResult();
        return mDita;
    }

    @Override
    public void editMDita(MDita mDita) {
        sessionFactory.getCurrentSession().saveOrUpdate(mDita);
    }

    @Override
    public MDita addMDita(MDita mDita) {
        return (MDita)sessionFactory.getCurrentSession().merge(mDita);
    }

    @Override
    public int getCountMDitas() {
        Number result = (Number) sessionFactory.getCurrentSession().createSQLQuery("select count(*) from mdita").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deleteMDita(MDita mDita) {
        sessionFactory.getCurrentSession().delete(mDita);
    }
}
