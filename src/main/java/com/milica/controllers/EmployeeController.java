package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.EmployeeDao;
import com.milica.entities.Employee;

/**
 * Klasa sadrzi sve metode vezane za rad sa entitetom Employee
 * @author Milica
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/addemployee", method=RequestMethod.GET)
    public boolean addEmployee(Employee employee) {
            return employeeDao.addEmployee(employee);
    }

    @RequestMapping(value="/editemployee", method=RequestMethod.GET)
    public boolean editEmployee(Employee employee) {
            return employeeDao.editEmployee(employee);
    }

    @RequestMapping(value="/deleteemployee", method=RequestMethod.GET)
    public boolean deleteEmployee(Employee employee) {
            return employeeDao.deleteEmployee(employee);
    }

    @RequestMapping(value="/getemployeebyid", method=RequestMethod.GET)
    public Employee getEmployeeById(int id) {
            return employeeDao.getEmployeeById(id);
    }

    @RequestMapping(value="/getallemployees", method=RequestMethod.GET)
    public List<Employee> getAllEmployees() {
            return employeeDao.getAllEmployees();
    }

    @RequestMapping(value="/getcountemployees", method=RequestMethod.GET)
    public int getCountEmployees() {
            return employeeDao.getCountEmployees();
    }
}
