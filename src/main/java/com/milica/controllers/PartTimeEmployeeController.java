package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.PartTimeEmployeeDao;
import com.milica.entities.PartTimeEmployee;

/**
 * Klasa sadrzi sve metode vezane za rad sa entitetom PartTimeEmployee
 * @author Milica
 */
@Controller
@RequestMapping("/parttimeemployee")
public class PartTimeEmployeeController {

    @Autowired
    private PartTimeEmployeeDao partTimeEmployeeDao;

    @RequestMapping(value="/addparttimeemployee", method=RequestMethod.POST)
    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
            return partTimeEmployeeDao.addPartTimeEmployee(partTimeEmployee);
    }

    @RequestMapping(value="/editparttimeemployee", method=RequestMethod.POST)
    public boolean editPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
            return partTimeEmployeeDao.editPartTimeEmployee(partTimeEmployee);
    }

    @RequestMapping(value="/deleteparttimeemployee", method=RequestMethod.POST)
    public boolean deletePartTimeEmployee(PartTimeEmployee partTimeEmployee) {
            return partTimeEmployeeDao.deletePartTimeEmployee(partTimeEmployee);
    }

    @RequestMapping(value="/getparttimeemployeebyid", method=RequestMethod.POST)
    public PartTimeEmployee getPartTimeEmployeeById(int id) {
            return partTimeEmployeeDao.getPartTimeEmployeeById(id);
    }

    @RequestMapping(value="/getparttimeemployees", method=RequestMethod.POST)
    public List<PartTimeEmployee> getPartTimeEmployees() {
            return partTimeEmployeeDao.getPartTimeEmployees();
    }

    @RequestMapping(value="/getcountparttimeemployees", method=RequestMethod.POST)
    public int getCountPartTimeEmployees() {
            return partTimeEmployeeDao.getCountPartTimeEmployees();
    }
}
