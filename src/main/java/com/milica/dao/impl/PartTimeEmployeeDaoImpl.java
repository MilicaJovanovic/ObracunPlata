/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.PartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
public class PartTimeEmployeeDaoImpl implements PartTimeEmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public PartTimeEmployeeDaoImpl() {}

    public PartTimeEmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<PartTimeEmployee> getPartTimeEmployees() {
        List<PartTimeEmployee> results = (List<PartTimeEmployee>)
        sessionFactory.getCurrentSession().createCriteria(PartTimeEmployee.class).list();
        return results;
    }

    @Override
    public PartTimeEmployee getPartTimeEmployeeById(int id) {
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) sessionFactory.getCurrentSession().createCriteria(PartTimeEmployee.class).add(Restrictions.eq("id", id)).uniqueResult();
        return partTimeEmployee;
    }

    @Override
    public void editPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        sessionFactory.getCurrentSession().saveOrUpdate(partTimeEmployee);
    }

    @Override
    public PartTimeEmployee addPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        return (PartTimeEmployee)sessionFactory.getCurrentSession().merge(partTimeEmployee);
    }

    @Override
    public int getCountPartTimeEmployees() {
        Number result = (Number) sessionFactory.getCurrentSession().createSQLQuery("select count(*) from part_time_employee").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deletePartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        sessionFactory.getCurrentSession().delete(partTimeEmployee);
    }
}
