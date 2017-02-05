package com.milica.controllers;

import com.milica.dao.EmployeeDao;
import com.milica.dto.Person;
import com.milica.entities.Employee;
import com.milica.services.DataUpdate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
/**
 *
 * @author Milica
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private EmployeeDao employeeDao;
	
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        return "login";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(ModelMap model) {
        return "index";
    }
    
    @RequestMapping(value = "/dataUpdate", method = RequestMethod.GET)
    public ModelAndView showUpdate(ModelAndView model) {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        List<Person> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
            Person person = new Person();
            person.setName(employee.getName());
            person.setLastname(employee.getLastname());
            person.setFaculty(employee.getFaculty());
            person.setEmploymentType("Radni odnos");
            employees.add(person);
        }
        for (Person person : employees) {
            System.out.println(person.toString());
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    } 
    
    @RequestMapping(value = "/currentPayment", method = RequestMethod.GET)
    public ModelAndView showCurrentPayment(ModelAndView model) {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        List<Person> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
            Person person = new Person();
            person.setName(employee.getName());
            person.setLastname(employee.getLastname());
            person.setFaculty(employee.getFaculty());
            person.setEmploymentType("Radni odnos");
            person.setSalaryNeto(150000);
            person.setAuthorFeeNeto(2000);
            employees.add(person);
        }
        for (Person person : employees) {
            System.out.println(person.toString());
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    }
    
    @RequestMapping(value = "/grossPayment", method = RequestMethod.GET)
    public ModelAndView showGrossPayment(ModelAndView model) {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        List<Person> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
            Person person = new Person();
            person.setName(employee.getName());
            person.setLastname(employee.getLastname());
            person.setFaculty(employee.getFaculty());
            person.setEmploymentType("Radni odnos");
            person.setSalaryGross(60000);
            person.setAuthorFeeGross(4000);
            employees.add(person);
        }
        for (Person person : employees) {
            System.out.println(person.toString());
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistory(ModelMap model) {
        return "history";
    }
    
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String handlePost(ModelMap m) throws Exception {
        DataUpdate.getDataFromIsum();
        return "history";
    }
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView showAdminPage() {
		ModelAndView adminPage = new ModelAndView();
		
		adminPage.addObject("message", "Admin stranica");
		adminPage.setViewName("index");
		
		return adminPage;
	}
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, 
    		@RequestParam(value = "logout", required = false) String logout) {
		
        ModelAndView loginPage = new ModelAndView();
        if (error != null) {
            loginPage.addObject("error", "Podaci koje ste uneli nisu ispravni!");
        }
        if (logout != null) {
            loginPage.addObject("msg", "Odjava uspesna!");
        }
        loginPage.setViewName("login");
        
        return loginPage;
    }
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
		ModelAndView unauthorisedPage = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            unauthorisedPage.addObject("username", userDetail.getUsername());
        }
        unauthorisedPage.setViewName("403");
        
        return unauthorisedPage;
	}
    
}
