package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.EmployeeDao;
import com.milica.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO sloj koji se koristi za pristup tabeli "employee" u bazi podataka
 * @author Milica
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl() {}

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public boolean addEmployee(Employee employee) {
        Employee currentEmployee = currentEmployee(employee);

        if (currentEmployee == null) {
                sessionFactory.getCurrentSession().save(employee);
                return true;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean editEmployee(Employee employee) {
        Employee currentEmployee = currentEmployee(employee);

        if (currentEmployee == null) {
                return false;
        }

        sessionFactory.getCurrentSession().update(employee);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteEmployee(Employee employee) {
        Employee currentEmployee = currentEmployee(employee);

        if (currentEmployee == null) {
                return false;
        }

        sessionFactory.getCurrentSession().delete(currentEmployee);
        return true;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Employee currentEmployee = (Employee) sessionFactory.getCurrentSession()
                        .createCriteria(Employee.class)
                        .add(Restrictions.eq("employeeId", id))
                        .uniqueResult();
        return currentEmployee;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession()
            .createCriteria(Employee.class)
            .list();
    }

    @Override
    @Transactional
    public int getCountEmployees() {
        List<Employee> allEmployees = getAllEmployees();

        if (allEmployees == null) {
            return 0;
        }
        return allEmployees.size();
    }

    private Employee currentEmployee(Employee employee) {
        Employee currentEmployee = (Employee) sessionFactory.getCurrentSession()
            .createCriteria(Employee.class)
            .add(Restrictions.eq("employeeId", employee.getEmployeeId()))
            .uniqueResult();
        return currentEmployee;
    }
}
