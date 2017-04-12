package com.milica.dao;

import java.util.List;
import com.milica.entities.Employee;

/**
 *
 * @author Milica
 * Interfejs sadrzi metode koje se koriste za komunikacija sa bazom podataka
 */
public interface EmployeeDao {
	
    public boolean addEmployee(Employee employee);
    public boolean editEmployee(Employee employee);
    public boolean deleteEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();	
    public int getCountEmployees();
    
}
