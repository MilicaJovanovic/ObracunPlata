package com.milica.controllers;

import com.milica.dao.EmailFlagDao;
import com.milica.dao.EmployeeDao;
import com.milica.dao.PartTimeEmployeeDao;
import com.milica.dao.SubjectDao;
import com.milica.dao.SubjectEmployeeDao;
import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.dto.Person;
import com.milica.entities.EmailFlag;
import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;
import com.milica.entities.SubjectPartTimeEmployee;
import com.milica.services.CalculatePayment;
import com.milica.services.DataUpdate;
import com.milica.services.EmailSender;
import com.milica.services.PdfGenerator;
import com.milica.dto.PairTransporterEmployee;
import com.milica.dto.PairTransporterPartTimeEmployee;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Klasa sadrzi sve metode vezane za povezivanje JSP strana i Java klasa
 * Vecina metoda izvrsava se onda kada softver prepozna putanju koja je navedena uz metodu
 * Ostale metode koriste se za upis u bazu i dobijanje potrebnih podataka
 * @author Milica
 */
@Controller
@RequestMapping("/")
@Scope("session")
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
    @Autowired
    private EmailFlagDao emailFlagDao;
    
    private final CalculatePayment calculatePayment = new CalculatePayment();
    
    @RequestMapping(method = RequestMethod.GET)
    public String startApp(ModelMap model) {
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
            employees.add(person);
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
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

        return "redirect:/dataUpdate";
    }
    
    @RequestMapping(value = "/currentPayment", method = RequestMethod.GET)
    public ModelAndView showCurrentPayment(ModelAndView model, HttpServletRequest request) {
        List<Person> employees = generateCurrentPayment();
        
        EmailFlag flag = emailFlagDao.getEmailFlagById(1);
        if (flag.getFlag() == 1) {
            sendMails(employees);
        }
        
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    }
    
    @RequestMapping(value="/currentPayment/pay", method=RequestMethod.GET)
    public String doPay(ModelMap m) throws Exception {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(date);
        String month = today.substring(3, 4);
        String semester = "";
        switch (month) {
            case "09":
            case "10":
            case "11":
            case "12":
            case "01":
            case "02":
                semester = "A";
                break;
            case "03":
            case "04":
            case "05":
            case "06":
            case "07":
            case "08":
                semester = "S";
                break;
        }
        
        List<Person> employees = generateCurrentPayment();
        PdfGenerator.generatePdf(employees, semester);
  
        generatePdfs(employees, semester);
        
        ModelAndView page = new ModelAndView("currentPayment");
        page.addObject("employees", employees);
        
        return "redirect:/currentPayment";
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
            person.setSalaryGrossS(calculatePayment.employeeGrossBasicPayment(employee, "S", subjectList));
            person.setAuthorFeeGrossS(calculatePayment.empoyeeGrossAuthorFee(employee, "S", subjectList));
            person.setSalaryGrossA(calculatePayment.employeeGrossBasicPayment(employee, "A", subjectList));
            person.setAuthorFeeGrossA(calculatePayment.empoyeeGrossAuthorFee(employee, "A", subjectList));
            employees.add(person);
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
            List<Subject> subjectList = subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(partTimeEmployee);
            Person person = new Person();
            person.setName(partTimeEmployee.getName());
            person.setLastname(partTimeEmployee.getLastname());
            person.setFaculty(partTimeEmployee.getFaculty());
            person.setEmploymentType("Honorarni odnos");
            person.setSalaryGrossA(calculatePayment.partTimeEmployeeGrossBasicPayment(partTimeEmployee, "A", subjectList));
            person.setAuthorFeeGrossA(0);
            person.setSalaryGrossS(calculatePayment.partTimeEmployeeGrossBasicPayment(partTimeEmployee, "S", subjectList));
            person.setAuthorFeeGrossS(0);
            employees.add(person);
        }
        model.addObject("employees", employees);
        model.addObject("employee", new Person());
        return model;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView showHistory(ModelAndView model) {
        final File folder = new File("c:/Users/Dusan Nesic/Documents/git/ObracunPlata/src/main/resources/izvestaji");
        List<String> files = listFilesForFolder(folder);
        
        model.addObject("files", files);
        model.addObject("file", new String());

        return model;
    }
    
    @RequestMapping(value = "/history/download/{fileName:.+}", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
        int BUFFER_SIZE = 4096;
        
        String filePath = "c:/Users/Dusan Nesic/Documents/git/ObracunPlata/src/main/resources/izvestaji/" + fileName;
        ServletContext context = request.getServletContext();
             
        File downloadFile = new File(filePath);
        OutputStream outStream;
        try (FileInputStream inputStream = new FileInputStream(downloadFile)) {
            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }   System.out.println("MIME type: " + mimeType);
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"",
                    downloadFile.getName());
            response.setHeader(headerKey, headerValue);
            outStream = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
        outStream.close();
    }
    
    public List listFilesForFolder(final File folder) {
        List<String> files = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry.getName());
            }
        }
        return files;
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
            person.setSalaryNetoA(calculatePayment.employeeNetoBasicPayment(employee, "A", subjectList));
            person.setAuthorFeeNetoA(calculatePayment.empoyeeNetoAuthorFee(employee, "A", subjectList));
            person.setSalaryNetoS(calculatePayment.employeeNetoBasicPayment(employee, "S", subjectList));
            person.setAuthorFeeNetoS(calculatePayment.empoyeeNetoAuthorFee(employee, "S", subjectList));
            employees.add(person);
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployeeList) {
            List<Subject> subjectList = subjectPartTimeEmployeeDao.getSubjectsForPartTimeEmployee(partTimeEmployee);
            Person person = new Person();
            person.setName(partTimeEmployee.getName());
            person.setLastname(partTimeEmployee.getLastname());
            person.setFaculty(partTimeEmployee.getFaculty());
            person.setEmploymentType("Honorarni odnos");
            person.setSalaryNetoA(calculatePayment.partTimeEmpoyeeBasicPayment(partTimeEmployee, "A", subjectList));
            person.setAuthorFeeNetoA(0);
            person.setSalaryNetoS(calculatePayment.partTimeEmpoyeeBasicPayment(partTimeEmployee, "S", subjectList));
            person.setAuthorFeeNetoS(0);
            employees.add(person);
        }
        
        return employees;
    }
    
    
    
    private void sendMails(List<Person> employees) {
        try {
            EmailSender.sendMail("Postovani,\nU prilogu se nalazi obracun o isplati Vase zarade.\nS postovanjem,\nFinansijska sluzba", employees);
        } catch ( MessagingException e) {
        }
        
        emailFlagDao.setUngenerated();
    }
    
    private void generatePdfs(List<Person> employees, String semester) {
        try {
            for(Person person: employees) {
                PdfGenerator.generateSeparatePdf(person, semester);
            }
        } catch (MessagingException e) {
        }
        
        emailFlagDao.setGenerated();
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
