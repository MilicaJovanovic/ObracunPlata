/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.EmployeeDao;
import com.milica.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl() {}

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Employee> getEmployees() {
        List<Employee> results = (List<Employee>)
        sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
        return results;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
        return employee;
    }

    @Override
    public void editEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return (Employee)sessionFactory.getCurrentSession().merge(employee);
    }

    @Override
    public int getCountEmployees() {
        Number result = (Number) sessionFactory.getCurrentSession().createSQLQuery("select count(*) from employee").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }
}
