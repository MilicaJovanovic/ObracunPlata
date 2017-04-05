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
import com.milica.entities.SubjectEmployee;
import com.milica.entities.SubjectPartTimeEmployee;
import com.milica.services.CalculatePayment;
import com.milica.services.DataUpdate;
import com.milica.services.PdfGenerator;
import com.milica.services.PairTransporterEmployee;
import com.milica.services.PairTransporterPartTimeEmployee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.TransientObjectException;
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
//        List<Employee> employeeList = employeeDao.getAllEmployees();
//        List<PartTimeEmployee> partTimeEmployeeList = partTimeEmployeeDao.getPartTimeEmployees();
//        List<Person> employees = new ArrayList<>();
//        for (Employee employee : employeeList) {
//            List<Subject> subjectList = subjectEmployeeDao.getSubjectsForEmployee(employee);
//            Person person = new Person();
//            person.setName(employee.getName());
//            person.setLastname(employee.getLastname());
//            person.setFaculty(employee.getFaculty());
//            person.setEmploymentType("Radni odnos");
//            person.setSalaryNeto(calculatePayment.employeeNetoBasicPayment(employee, "Prolecni semestar", subjectList));
//            person.setAuthorFeeNeto(calculatePayment.empoyeeNetoAuthorFee(employee, "Prolecni semestar", subjectList));
//            employees.add(person);
//        }
//        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
//            List<Subject> subjectList = subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(partTimeEmployee);
//            Person person = new Person();
//            person.setName(partTimeEmployee.getName());
//            person.setLastname(partTimeEmployee.getLastname());
//            person.setFaculty(partTimeEmployee.getFaculty());
//            person.setEmploymentType("Honorarni odnos");
//            person.setSalaryNeto(calculatePayment.partTimeEmpoyeeBasicPayment(partTimeEmployee, "Jesenji semestar", subjectList));
//            person.setAuthorFeeNeto(0);
//            employees.add(person);
//        }
        
        List<Person> employees = generateCurrentPayment();
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
    public String doUpdate(ModelMap m) throws Exception {
        DataUpdate dataUpdate = new DataUpdate();
        dataUpdate.getDataFromIsum();
        List<PairTransporterEmployee> employees = dataUpdate.returnEmployeeList();
        List<Subject> subjects = dataUpdate.returnSubjectEmplyeeList();
        List<PairTransporterPartTimeEmployee> partEmployees = dataUpdate.returnPartTimeEmployeeList();
        List<Subject> partSubjects = dataUpdate.returnSubjectEmployeePartTimeList();
        List<PairTransporterEmployee> transporters = dataUpdate.returnTransporterList();
        
        saveEmployees(employees, partEmployees);
        saveSubjects(subjects, partSubjects);
        savePairsForEmployees(employees);
        savePairsForPartTimeEmployees(partEmployees);
//        for (PartTimeEmployee partTimeEmployee : partEmployees) {
//            List<Subject> partTimeEmployeeSubjects = partTimeEmployee.getSubjectList();
//            for (Subject partEmplSubject : partTimeEmployeeSubjects) {
//                SubjectPartTimeEmployee pair = new SubjectPartTimeEmployee();
//                pair.setPartTimeEmployeeId(partTimeEmployee);
//                pair.setSubjectId(partEmplSubject);
//                subjectPartTimeEmployeeDao.addSubjectPartTimeEmployee(pair);
//            }
//        }
        
        return "dataUpdate";
    }
    
    private void saveEmployees(List<PairTransporterEmployee> employees,
            List<PairTransporterPartTimeEmployee> partEmployees) {
        for (PairTransporterEmployee transporter : employees) {
            Employee employee = transporter.getEmployee();
            employeeDao.addEmployee(employee);
        }
        for (PairTransporterPartTimeEmployee transporter : partEmployees) {
            PartTimeEmployee employee = transporter.getEmployee();
            partTimeEmployeeDao.addPartTimeEmployee(employee);
        }
    }
    
    private void saveSubjects(List<Subject> subjects, List<Subject> partSubjects) {
        for (Subject subject : subjects) {
            subjectDao.addSubject(subject);
        }
        for (Subject subject : partSubjects) {
            subjectDao.addSubject(subject);
        }
    }
    
    private void savePairsForEmployees(List<PairTransporterEmployee> transporters) {
        for (PairTransporterEmployee transporter : transporters) {
            List<Subject> employeeSubjects = transporter.getSubjects();
            for (Subject emplSubject : employeeSubjects) {
                SubjectEmployee pair = new SubjectEmployee();
                pair.setEmployeeId(transporter.getEmployee());
                pair.setSubjectId(emplSubject);
                Subject existingSubject = subjectDao.getSubjectById(emplSubject.getSubjectId());
                if (existingSubject != null) {
                    subjectEmployeeDao.addSubjectEmployee(pair);
                }
            }
        }
    }
    
    private void savePairsForPartTimeEmployees(List<PairTransporterPartTimeEmployee> transporters) {
        for (PairTransporterPartTimeEmployee transporter : transporters) {
            List<Subject> employeeSubjects = transporter.getSubjects();
            for (Subject emplSubject : employeeSubjects) {
                SubjectPartTimeEmployee pair = new SubjectPartTimeEmployee();
                pair.setPartTimeEmployeeId(transporter.getEmployee());
                pair.setSubjectId(emplSubject);
                Subject existingSubject = subjectDao.getSubjectById(emplSubject.getSubjectId());
                if (existingSubject != null) {
                    subjectPartTimeEmployeeDao.addSubjectPartTimeEmployee(pair);
                }
            }
        }
    }
    
    private List<Person> generateCurrentPayment() {
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
            person.setSalaryNeto(calculatePayment.employeeNetoBasicPayment(employee, "Prolecni semestar", subjectList));
            person.setAuthorFeeNeto(calculatePayment.empoyeeNetoAuthorFee(employee, "Prolecni semestar", subjectList));
            employees.add(person);
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
            List<Subject> subjectList = subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(partTimeEmployee);
            Person person = new Person();
            person.setName(partTimeEmployee.getName());
            person.setLastname(partTimeEmployee.getLastname());
            person.setFaculty(partTimeEmployee.getFaculty());
            person.setEmploymentType("Honorarni odnos");
            person.setSalaryNeto(calculatePayment.partTimeEmpoyeeBasicPayment(partTimeEmployee, "Jesenji semestar", subjectList));
            person.setAuthorFeeNeto(0);
            employees.add(person);
        }
        
        return employees;
    }
    
    @RequestMapping(value="/currentPayment/pay", method=RequestMethod.GET)
    public String doPay(ModelMap m) throws Exception {
        List<Person> employees = generateCurrentPayment();
        PdfGenerator.generatePdf(employees);
        for(Person person: employees) {
            PdfGenerator.generateSeparatePdf(person);
        }
        
        return "currentPayment";
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
