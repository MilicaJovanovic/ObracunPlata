/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import java.util.List;
import com.milica.entities.Employee;

/**
 *
 * @author Milica
 */
public interface EmployeeDao {
    public List<Employee> getEmployees();
    public Employee getEmployeeById(int id);
    public void editEmployee(Employee employee);
    public Employee addEmployee(Employee employee);
    public int getCountEmployees();
    public void deleteEmployee(Employee employee);
}
