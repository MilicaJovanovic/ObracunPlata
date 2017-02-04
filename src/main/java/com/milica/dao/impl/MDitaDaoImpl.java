package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.MDitaDao;
import com.milica.entities.MDita;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO sloj koji se koristi za pristup tabeli "mdita" u bazi podataka
 * @author Milica
 */
@Repository
public class MDitaDaoImpl implements MDitaDao {
	
    @Autowired
    private SessionFactory sessionFactory;

    public MDitaDaoImpl() {}

    public MDitaDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@Transactional
	public boolean addMDita(MDita mDita) {
		MDita currentMdita = currentMDita(mDita);
		
		if (currentMdita == null) {
			sessionFactory.getCurrentSession().save(mDita);
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean editMDita(MDita mDita) {
		MDita currentMdita = currentMDita(mDita);
		
		if (currentMdita== null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(mDita);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteMDita(MDita mDita) {
		MDita currentMdita = currentMDita(mDita);
		
		if (currentMdita == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(currentMdita);
		return true;
	}

	@Override
	@Transactional
	public MDita getMDitaById(int id) {
		MDita currentMdita = (MDita) sessionFactory.getCurrentSession()
				.createCriteria(MDita.class)
				.add(Restrictions.eq("mditaId", id))
				.uniqueResult();
		return currentMdita;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<MDita> getMDitas() {
		return sessionFactory.getCurrentSession()
				.createCriteria(MDita.class)
				.list();
	}

	@Override
	@Transactional
	public int getCountMDitas() {
		List<MDita> allMditas = getMDitas();
		
		if (allMditas == null) {
			return 0;
		}
		return allMditas.size();
	}
    
	private MDita currentMDita(MDita mDita) {
		MDita currentMDita = (MDita) sessionFactory.getCurrentSession()
				.createCriteria(MDita.class)
				.add(Restrictions.eq("mditaId", mDita.getMditaId()))
				.uniqueResult();
		return currentMDita;
	}
    
}
