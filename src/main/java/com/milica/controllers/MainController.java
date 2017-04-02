package com.milica.controllers;

import com.milica.dao.EmployeeDao;
import com.milica.dao.PartTimeEmployeeDao;
import com.milica.dao.SubjectDao;
import com.milica.dao.SubjectEmployeeDao;
import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.dto.Person;
import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.services.CalculatePayment;
import com.milica.services.DataUpdate;
import com.milica.services.PairTransporterEmployee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private PartTimeEmployeeDao partTimeEmployeeDao;
    @Autowired
    private SubjectEmployeeDao subjectEmployeeDao;
    @Autowired
    private SubjectPartTimeEmployeeDao subjectPartTimeEmployeeDao;
    
    private final CalculatePayment calculatePayment = new CalculatePayment();
	
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
        List<PartTimeEmployee> partTimeEmployeeList = partTimeEmployeeDao.getPartTimeEmployees();
        List<Employee> employeeList = employeeDao.getAllEmployees();
        List<Person> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            Person person = new Person();
            person.setName(employee.getName());
            person.setLastname(employee.getLastname());
            person.setFaculty(employee.getFaculty());
            person.setEmploymentType("Radni odnos");
            employees.add(person);
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
            Person person = new Person();
            person.setName(partTimeEmployee.getName());
            person.setLastname(partTimeEmployee.getLastname());
            person.setFaculty(partTimeEmployee.getFaculty());
            person.setEmploymentType("Honorarni odnos");
            person.setSalaryNeto(2000);
            person.setAuthorFeeNeto(0);
            employees.add(person);
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    } 
    
    @RequestMapping(value = "/currentPayment", method = RequestMethod.GET)
    public ModelAndView showCurrentPayment(ModelAndView model) {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        List<PartTimeEmployee> partTimeEmployeeList = partTimeEmployeeDao.getPartTimeEmployees();
        List<Person> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            List<Subject> subjectList = subjectEmployeeDao.getSubjectsForEmployee(employee);
            for (int i = 0; i < subjectList.size(); i++) {
                System.err.println("Employee: " +  subjectList.get(i).toString());
            }
            Person person = new Person();
            person.setName(employee.getName());
            person.setLastname(employee.getLastname());
            person.setFaculty(employee.getFaculty());
            person.setEmploymentType("Radni odnos");
            person.setSalaryNeto(calculatePayment.employeeNetoBasicPayment(employee, "Prolecni semestar", subjectList));
            person.setAuthorFeeNeto(calculatePayment.empoyeeNetoAuthorFee(employee, "Prolecni semestar", subjectList));
            employees.add(person);
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
            List<Subject> subjectList = subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(partTimeEmployee);
            for (int i = 0; i < subjectList.size(); i++) {
                System.err.println("PartTime employee: " + subjectList.get(i).toString());
            }
            Person person = new Person();
            person.setName(partTimeEmployee.getName());
            person.setLastname(partTimeEmployee.getLastname());
            person.setFaculty(partTimeEmployee.getFaculty());
            person.setEmploymentType("Honorarni odnos");
            person.setSalaryNeto(calculatePayment.partTimeEmpoyeeBasicPayment(partTimeEmployee, "Prolecni semestar", subjectList));
            person.setAuthorFeeNeto(0);
            employees.add(person);
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    }
    
    @RequestMapping(value = "/grossPayment", method = RequestMethod.GET)
    public ModelAndView showGrossPayment(ModelAndView model) {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        List<PartTimeEmployee> partTimeEmployeeList = partTimeEmployeeDao.getPartTimeEmployees();
        List<Person> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            List<Subject> subjectList = subjectEmployeeDao.getSubjectsForEmployee(employee);
            Person person = new Person();
            person.setName(employee.getName());
            person.setLastname(employee.getLastname());
            person.setFaculty(employee.getFaculty());
            person.setEmploymentType("Radni odnos");
            person.setSalaryGross(calculatePayment.employeeGrossBasicPayment(employee, "Prolecni semestar", subjectList));
            person.setAuthorFeeGross(calculatePayment.empoyeeGrossAuthorFee(employee, "Prolecni semestar", subjectList));
            employees.add(person);
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
            List<Subject> subjectList = subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(partTimeEmployee);
            Person person = new Person();
            person.setName(partTimeEmployee.getName());
            person.setLastname(partTimeEmployee.getLastname());
            person.setFaculty(partTimeEmployee.getFaculty());
            person.setEmploymentType("Honorarni odnos");
            person.setSalaryGross(calculatePayment.partTimeEmployeeGrossBasicPayment(partTimeEmployee, "Prolecni semestar", subjectList));
            person.setAuthorFeeGross(0);
            employees.add(person);
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistory(ModelMap model) {
        return "history";
    }
    
    @RequestMapping(value="/dataUpdate/update", method=RequestMethod.GET)
    public String handlePost(ModelMap m) throws Exception {
        DataUpdate dataUpdate = new DataUpdate();
        dataUpdate.getDataFromIsum();
        List<Employee> employees = dataUpdate.returnEmployeeList();
        List<Subject> subjects = dataUpdate.returnSubjectEmplyeeList();
        List<PartTimeEmployee> partEmployees = dataUpdate.returnPartTimeEmployeeList();
        List<Subject> partSubjects = dataUpdate.returnSubjectEmployeePartTimeList();
        List<PairTransporterEmployee> transporters = dataUpdate.returnTransporterList();
        
        for (Employee employee : employees) {
            employeeDao.addEmployee(employee);
            System.out.println("Upisan je employee");
        }
        for (PartTimeEmployee part : partEmployees) {
            partTimeEmployeeDao.addPartTimeEmployee(part);
            System.out.println("Upisan je part time employee");
        }
        for (Subject subject : subjects) {
            subjectDao.addSubject(subject);
        }
        for (Subject subject : partSubjects) {
            subjectDao.addSubject(subject);
        }
        
        return "dataUpdate";
    }
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
            ModelAndView adminPage = new ModelAndView();

            adminPage.addObject("message", "Admin stranica");
            adminPage.setViewName("index");

            return adminPage;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		
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
    
}
