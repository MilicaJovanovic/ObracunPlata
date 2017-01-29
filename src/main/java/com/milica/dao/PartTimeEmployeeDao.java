/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import java.util.List;
import com.milica.entities.PartTimeEmployee;

/**
 *
 * @author Milica
 */
public interface PartTimeEmployeeDao {
    public List<PartTimeEmployee> getPartTimeEmployees();
    public PartTimeEmployee getPartTimeEmployeeById(int id);
    public void editPartTimeEmployee(PartTimeEmployee partTimeEmployee);
    public PartTimeEmployee addPartTimeEmployee(PartTimeEmployee partTimeEmployee);
    public int getCountPartTimeEmployees();
    public void deletePartTimeEmployee(PartTimeEmployee partTimeEmployee);
}
