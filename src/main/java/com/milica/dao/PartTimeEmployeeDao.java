package com.milica.dao;

import java.util.List;
import com.milica.entities.PartTimeEmployee;

/**
 *
 * @author Milica
 * Interfejs sadrzi metode koje se koriste za komunikacija sa bazom podataka
 */
public interface PartTimeEmployeeDao {
	public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee);
	public boolean editPartTimeEmployee(PartTimeEmployee partTimeEmployee);
	public boolean deletePartTimeEmployee(PartTimeEmployee partTimeEmployee);
	public PartTimeEmployee getPartTimeEmployeeById(int id);
        public List<PartTimeEmployee> getPartTimeEmployees();
        public int getCountPartTimeEmployees();
    
}
