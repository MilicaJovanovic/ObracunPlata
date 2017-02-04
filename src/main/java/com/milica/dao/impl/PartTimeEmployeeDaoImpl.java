package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.PartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO sloj koji se koristi za pristup tabeli "part_time_employee" u bazi podataka
 * @author Milica
 */
public class PartTimeEmployeeDaoImpl implements PartTimeEmployeeDao {
    
	@Autowired
    private SessionFactory sessionFactory;

    public PartTimeEmployeeDaoImpl() {}

    public PartTimeEmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@Transactional
	public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
		PartTimeEmployee currentEmployee = currentEmployee(partTimeEmployee);
		
		if (currentEmployee == null) {
			sessionFactory.getCurrentSession().save(partTimeEmployee);
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean editPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
		PartTimeEmployee currentEmployee = currentEmployee(partTimeEmployee);
		
		if (currentEmployee == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(partTimeEmployee);
		return true;
	}

	@Override
	@Transactional
	public boolean deletePartTimeEmployee(PartTimeEmployee partTimeEmployee) {
		PartTimeEmployee currentEmployee = currentEmployee(partTimeEmployee);
		
		if (currentEmployee == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(currentEmployee);
		return true;
	}

	@Override
	@Transactional
	public PartTimeEmployee getPartTimeEmployeeById(int id) {
		PartTimeEmployee currentEmployee = (PartTimeEmployee) sessionFactory.getCurrentSession()
				.createCriteria(PartTimeEmployee.class)
				.add(Restrictions.eq("partTimeEmployeeId", id))
				.uniqueResult();
		return currentEmployee;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PartTimeEmployee> getPartTimeEmployees() {
		return sessionFactory.getCurrentSession()
				.createCriteria(PartTimeEmployee.class)
				.list();
	}

	@Override
	@Transactional
	public int getCountPartTimeEmployees() {
		List<PartTimeEmployee> allEmployees = getPartTimeEmployees();
		
		if (allEmployees == null) {
			return 0;
		}
		return allEmployees.size();
	}
    
	private PartTimeEmployee currentEmployee(PartTimeEmployee employee) {
		PartTimeEmployee currentEmployee = (PartTimeEmployee) sessionFactory.getCurrentSession()
				.createCriteria(PartTimeEmployee.class)
				.add(Restrictions.eq("partTimeEmployeeId", employee.getPartTimeEmployeeId()))
				.uniqueResult();
		return currentEmployee;
	}
	
}
