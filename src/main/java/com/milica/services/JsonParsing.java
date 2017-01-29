/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.milica.dao.EmployeeDao;
import com.milica.dao.PartTimeEmployeeDao;
import com.milica.dao.SubjectDao;
import com.milica.dao.SubjectMarkDao;
import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectMark;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Milica
 */
public class JsonParsing {
    @Autowired
    SubjectDao subjectDao;
    
    @Autowired
    SubjectMarkDao subjectMarkDao;
    
    @Autowired
    PartTimeEmployeeDao partTimeEmployeeDao;
    
    @Autowired
    EmployeeDao employeeDao;
    
    public Subject subjectFromNode(JsonNode jsonNodeClass) {     
        List<SubjectMark> subjectMarkList = new ArrayList<SubjectMark>();
        JsonNode jsonNodeAllMarks = jsonNodeClass.get("ocenePredmeta");
        for (JsonNode jsonNodeMark : jsonNodeAllMarks) {
          SubjectMark subjectMark = new SubjectMark(Integer.parseInt(fixText(jsonNodeMark.get("id").toString())), fixText(jsonNodeMark.get("rbr").toString()), Double.parseDouble(fixText(jsonNodeMark.get("ocena").toString())));
          subjectMarkList.add(subjectMark);
          subjectMarkDao.addSubjectMark(subjectMark);
        }
            
        Subject subject = new Subject(Integer.parseInt(fixText(jsonNodeClass.get("id").toString())), 
            fixText(jsonNodeClass.get("name").toString()),
            fixText(jsonNodeClass.get("location").toString()), 
            fixText(jsonNodeClass.get("type").toString()),
            fixText(jsonNodeClass.get("semester").toString()), 
            fixText(jsonNodeClass.get("code").toString()), 
            Integer.parseInt(fixText(jsonNodeClass.get("classNumber").toString())),
            Integer.parseInt(fixText(jsonNodeClass.get("groupExcerciseNumber").toString())), 
            Integer.parseInt(fixText(jsonNodeClass.get("individualExcerciseNumber").toString())),
            Integer.parseInt(fixText(jsonNodeClass.get("espb").toString())), 
            Integer.parseInt(fixText(jsonNodeClass.get("groupsNumber").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("changePercentage").toString())), 
            Double.parseDouble(fixText(jsonNodeClass.get("proc1").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc2").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc3").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc4").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc5").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc6").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc7").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc8").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc9").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc10").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc11").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc12").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc13").toString())), Double.parseDouble(fixText(jsonNodeClass.get("proc14").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("proc15").toString())), 
            Double.parseDouble(fixText(jsonNodeClass.get("numberOfWords").toString())), 
            Double.parseDouble(fixText(jsonNodeClass.get("fee").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("fpm").toString())), 
            Double.parseDouble(fixText(jsonNodeClass.get("fob").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("fin1").toString())), 
            Double.parseDouble(fixText(jsonNodeClass.get("fin2").toString())),
            Double.parseDouble(fixText(jsonNodeClass.get("fmm").toString())), 
            Double.parseDouble(fixText(jsonNodeClass.get("fkv").toString())), subjectMarkList);
        subjectDao.addSubject(subject);
        return subject;
    }
    
    public Employee employeeFromNode(JsonNode jsonNodePerson) {
        int subjectsInSpringSemester = 0;
        int subjectsInAutumnSemester = 0;
        List<Subject> subjectList = new ArrayList<Subject>();
        JsonNode jsonNodeAllClasses = jsonNodePerson.get("classes");
        for (JsonNode jsonNodeClass : jsonNodeAllClasses) {
            if (jsonNodeClass.get("fpm") != null && jsonNodeClass.get("fob") != null && jsonNodeClass.get("fin1") != null && jsonNodeClass.get("fin2") != null && jsonNodeClass.get("fmm") != null && jsonNodeClass.get("fkv") != null) {
                try {
                    Subject subject = subjectFromNode(jsonNodeClass);
                    subjectList.add(subject);
                    if (subject.getSemester().equals("J")) {
                        subjectsInAutumnSemester++;
                    } else if (subject.getSemester().equals("P")) {
                        subjectsInSpringSemester++;
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        int semesterNumber = 0;
        if ( (subjectsInSpringSemester > 0 && subjectsInAutumnSemester == 0) || (subjectsInAutumnSemester > 0 && subjectsInSpringSemester == 0)) {
            semesterNumber = 1;
        } else {
            semesterNumber = 2;
        }

        int functionsSumValue = 0;
        int specialAddValue = 0;
        JsonNode jsonNodeFunctions = jsonNodePerson.get("functions");
        for (JsonNode function : jsonNodeFunctions) {
            if (fixText(function.get("title").toString()).equals("Specijalni dodatak")) {
                    specialAddValue = Integer.parseInt(fixText(function.get("value").toString()));
            } else if (fixText(function.get("title").toString()).equals("Rektor")) {
                    functionsSumValue =  functionsSumValue + 2400;
            } else if (fixText(function.get("title").toString()).equals("Dekan FIT")) {
                    functionsSumValue =  functionsSumValue + 540;
            } else if (fixText(function.get("title").toString()).equals("Dekan FDU")) {
                    functionsSumValue =  functionsSumValue + 450;
            } else if (fixText(function.get("title").toString()).equals("Dekan FAM")) {
                    functionsSumValue =  functionsSumValue + 450;
            } else if (fixText(function.get("title").toString()).equals("Rukovodilac ISUM projekta")) {
                    functionsSumValue =  functionsSumValue + 200;
            } else if (fixText(function.get("title").toString()).equals("Direktor centra")) {
                    functionsSumValue =  functionsSumValue + 150;
            } else if (fixText(function.get("title").toString()).equals("Predsednik komisije za kvalitet")) {
                functionsSumValue =  functionsSumValue + 100;
            } else if (fixText(function.get("title").toString()).equals("Organizator izlozbi i pomocnik VD dekana")) {
                functionsSumValue =  functionsSumValue + 300;
            } 
        }

        double isumHoursJ = 0;
        double isumHoursP = 0;
        double isumMoneyJ = 0;
        double isumMoneyP = 0;
        JsonNode jsonNodeIsumFunctions = jsonNodePerson.get("isumFunctions");
        for (JsonNode function : jsonNodeIsumFunctions) {
            if (fixText(function.get("title").toString()).equals("Angažovanje na ISUM projektu, jesenji semestar")) {
                isumHoursJ = Double.parseDouble(fixText(function.get("numberofhours").toString()));
                isumMoneyJ = Double.parseDouble(fixText(function.get("priceperhour").toString()));
            } else if (fixText(function.get("title").toString()).equals("Angažovanje na ISUM projektu, prolećni semestar")) {
                isumHoursP = Double.parseDouble(fixText(function.get("numberofhours").toString()));
                isumMoneyP = Double.parseDouble(fixText(function.get("priceperhour").toString()));
            }
        }

        Employee employee = new Employee(Integer.parseInt(fixText(jsonNodePerson.get("id").toString())), 
            semesterNumber, subjectsInSpringSemester, specialAddValue, functionsSumValue, subjectsInAutumnSemester, 
            fixText(jsonNodePerson.get("name").toString()),
            fixText(jsonNodePerson.get("lastname").toString()), 
            fixText(jsonNodePerson.get("faculty").toString()),
            fixText(jsonNodePerson.get("bankAccount").toString()), 
            fixText(jsonNodePerson.get("name").toString()).toLowerCase() + "." + 
            fixText(jsonNodePerson.get("lastname").toString()).toLowerCase() + "@metropolitan.ac.rs",
            fixText(jsonNodePerson.get("teachingPosition").toString()), 
            fixText(jsonNodePerson.get("employmentPercentage").toString()),
            fixText(jsonNodePerson.get("subjectNumber").toString()), 
            fixText(jsonNodePerson.get("kbp").toString()),
            fixText(jsonNodePerson.get("kro").toString()), 
            fixText(jsonNodePerson.get("kt").toString()),
            fixText(jsonNodePerson.get("kpr").toString()), 
            subjectList, isumHoursJ, isumHoursP, isumMoneyJ, isumMoneyP);
        employeeDao.addEmployee(employee);
        return employee;
    }

    public PartTimeEmployee partTimeEmployeeFromNode(JsonNode jsonNodePerson) {
        List<Subject> subjectList = new ArrayList<Subject>();
        JsonNode jsonNodeAllClasses = jsonNodePerson.get("classes");
        int subjectsInSpringSemester = 0;
        int subjectsInAutumnSemester = 0;
        for (JsonNode jsonNodeClass : jsonNodeAllClasses) {
            if (jsonNodeClass.get("fpm") != null && jsonNodeClass.get("fob") != null &&
            jsonNodeClass.get("fin1") != null && jsonNodeClass.get("fin2") != null &&
            jsonNodeClass.get("fmm") != null && jsonNodeClass.get("fkv") != null) {
                try {
                    Subject subject = subjectFromNode(jsonNodeClass);
                    if (subject.getSemester().equals("J")) {
                        subjectsInAutumnSemester++;
                    } else if (subject.getSemester().equals("P")) {
                        subjectsInSpringSemester++;
                    }
                    subjectList.add(subject);
                } catch(Exception e) {

                }
            }
        }

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(Integer.parseInt(jsonNodePerson.get("id").toString()),    
            subjectsInSpringSemester, subjectsInAutumnSemester, 
            fixText(jsonNodePerson.get("name").toString()),
            fixText(jsonNodePerson.get("lastname").toString()), 
            fixText(jsonNodePerson.get("faculty").toString()),
            fixText(jsonNodePerson.get("bankAccount").toString()), 
            fixText(jsonNodePerson.get("name").toString()).toLowerCase() + "." + 
            fixText(jsonNodePerson.get("lastname").toString()).toLowerCase() + "@metropolitan.ac.rs",
            fixText(jsonNodePerson.get("teachingPosition").toString()), 
            fixText(jsonNodePerson.get("employmentPercentage").toString()),
            fixText(jsonNodePerson.get("subjectNumber").toString()), 
            fixText(jsonNodePerson.get("kt").toString()), subjectList);
        partTimeEmployeeDao.addPartTimeEmployee(partTimeEmployee);
        return partTimeEmployee;
    }

    public static String fixText(String received) {
      return received.replaceAll("\"", "");
    }    
}
