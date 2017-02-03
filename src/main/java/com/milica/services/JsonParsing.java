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
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Milica
 */
public class JsonParsing {
    
    @Autowired
    private SubjectDao subjectDao;
    
    @Autowired
    SubjectMarkDao subjectMarkDao;
    
    @Autowired
    PartTimeEmployeeDao partTimeEmployeeDao;
    
    @Autowired
    EmployeeDao employeeDao;
    
    public Subject subjectFromNode(JSONObject jsonNodeClass) {
        List<SubjectMark> subjectMarkList = new ArrayList<SubjectMark>();
//        if (jsonNodeClass.get("ocenePredmeta") != null && !jsonNodeClass.get("ocenePredmeta").equals("") && !jsonNodeClass.get("ocenePredmeta").equals("null")) {
//            JSONArray jsonNodeAllMarks = (JSONArray) jsonNodeClass.get("ocenePredmeta");
////        for (JsonNode jsonNodeMark : jsonNodeAllMarks) {
//            for (int i = 0; i < jsonNodeAllMarks.length(); i++) {
//              JSONObject jsonNodeMark = jsonNodeAllMarks.getJSONObject(i);
//              SubjectMark subjectMark = new SubjectMark(Integer.parseInt(fixText(jsonNodeMark.get("id").toString())), fixText(jsonNodeMark.get("rbr").toString()), Double.parseDouble(fixText(jsonNodeMark.get("ocena").toString())));
//              subjectMarkList.add(subjectMark);
////              subjectMarkDao.addSubjectMark(subjectMark);
//            }
//        }
        int id = 0;
        String name = "";
        String location = "";
        String type = "";
        String semester = "";
        String code = "";
        int classNumber = 0;
        int groupExcerciseNumber = 0;
        int individualExcerciseNumber = 0;
        int espb = 0;
        int groupsNumber = 0;
        double changePercentage = 0;
        double proc1 = 0;
        double proc2 = 0;
        double proc3 = 0;
        double proc4 = 0;
        double proc5 = 0;
        double proc6 = 0;
        double proc7 = 0;
        double proc8 = 0;
        double proc9 = 0;
        double proc10 = 0;
        double proc11 = 0;
        double proc12 = 0;
        double proc13 = 0;
        double proc14 = 0;
        double proc15 = 0;
        double numberOfWords = 0;
        double fee = 0;
        double fpm = 0;
        double fob = 0;
        double fin1 = 0;
        double fin2 = 0;
        double fmm = 0;
        double fkv = 0;
        
        id = Integer.parseInt(fixText(jsonNodeClass.get("id").toString()));
        name =  fixText(jsonNodeClass.get("name").toString());
        location = fixText(jsonNodeClass.get("location").toString());
        type = fixText(jsonNodeClass.get("type").toString());
        semester = fixText(jsonNodeClass.get("semester").toString());
//        code = fixText(jsonNodeClass.get("code").toString());
        classNumber = Integer.parseInt(fixText(jsonNodeClass.get("classNumber").toString()));
        groupExcerciseNumber = Integer.parseInt(fixText(jsonNodeClass.get("groupExcerciseNumber").toString()));
        individualExcerciseNumber = Integer.parseInt(fixText(jsonNodeClass.get("individualExcerciseNumber").toString()));
        espb = Integer.parseInt(fixText(jsonNodeClass.get("espb").toString()));
        groupsNumber = Integer.parseInt(fixText(jsonNodeClass.get("groupsNumber").toString()));
        changePercentage = Double.parseDouble(fixText(jsonNodeClass.get("changePercentage").toString()));
        proc1 = Double.parseDouble(fixText(jsonNodeClass.get("proc1").toString()));
        proc2 = Double.parseDouble(fixText(jsonNodeClass.get("proc2").toString()));
        proc3 = Double.parseDouble(fixText(jsonNodeClass.get("proc3").toString()));
        proc4 = Double.parseDouble(fixText(jsonNodeClass.get("proc4").toString()));
        proc5 = Double.parseDouble(fixText(jsonNodeClass.get("proc5").toString()));
        proc6 = Double.parseDouble(fixText(jsonNodeClass.get("proc6").toString()));
        proc7 = Double.parseDouble(fixText(jsonNodeClass.get("proc7").toString()));
        proc8 = Double.parseDouble(fixText(jsonNodeClass.get("proc8").toString()));
        proc9 = Double.parseDouble(fixText(jsonNodeClass.get("proc9").toString()));
        proc10 = Double.parseDouble(fixText(jsonNodeClass.get("proc10").toString()));
        proc11 = Double.parseDouble(fixText(jsonNodeClass.get("proc11").toString()));
        proc12 = Double.parseDouble(fixText(jsonNodeClass.get("proc12").toString()));
        proc13 = Double.parseDouble(fixText(jsonNodeClass.get("proc13").toString()));
        proc14 = Double.parseDouble(fixText(jsonNodeClass.get("proc14").toString()));
        proc15 = Double.parseDouble(fixText(jsonNodeClass.get("proc15").toString()));
        numberOfWords = Double.parseDouble(fixText(jsonNodeClass.get("numberOfWords").toString()));
        fee = Double.parseDouble(fixText(jsonNodeClass.get("fee").toString()));
        fpm = Double.parseDouble(fixText(jsonNodeClass.get("fpm").toString()));
        fob = Double.parseDouble(fixText(jsonNodeClass.get("fob").toString()));
        fin1 = Double.parseDouble(fixText(jsonNodeClass.get("fin1").toString()));
        fin2 = Double.parseDouble(fixText(jsonNodeClass.get("fin2").toString()));
        fmm = Double.parseDouble(fixText(jsonNodeClass.get("fmm").toString()));
        fkv = Double.parseDouble(fixText(jsonNodeClass.get("fkv").toString()));
                
                
        Subject subject = new Subject(id, name, location, type, semester, code,
            classNumber, groupExcerciseNumber, individualExcerciseNumber,
            espb, groupsNumber, changePercentage, proc1, proc2, proc3, proc4, proc5,
            proc6, proc7, proc8, proc9, proc10, proc11, proc12, proc13, proc14, proc15,
            numberOfWords, fee, fpm, fob, fin1, fin2, fmm, fkv);
        System.out.println(subject.toString());
//        subjectDao.addSubject(subject);
        return subject;
    }
    
    public Employee employeeFromNode(JSONObject jsonNodePerson) {
        int subjectsInSpringSemester = 0;
        int subjectsInAutumnSemester = 0;
        List<Subject> subjectList = new ArrayList<Subject>();
//        JSONArray jsonNodeAllClasses = jsonNodePerson.get("classes");
        JSONArray jsonNodeAllClasses = (JSONArray) jsonNodePerson.get("classes");
//        for (JSONObject jsonNodeClass : jsonNodeAllClasses) {
          for (int i = 0; i < jsonNodeAllClasses.length(); i++) {
            JSONObject jsonNodeClass = jsonNodeAllClasses.getJSONObject(i);
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
//        if (jsonNodePerson.get("functions") != null && !jsonNodePerson.get("functions").equals("") && !jsonNodePerson.get("functions").equals("null")) {
//            JSONArray jsonNodeFunctions = (JSONArray) jsonNodePerson.get("functions");
//            for (int i = 0; i < jsonNodeAllClasses.length(); i++) {
//                JSONObject function = jsonNodeAllClasses.getJSONObject(i);
//    //        for (JsonNode function : jsonNodeFunctions) {
//                if (fixText(function.get("title").toString()).equals("Specijalni dodatak")) {
//                        specialAddValue = Integer.parseInt(fixText(function.get("value").toString()));
//                } else if (fixText(function.get("title").toString()).equals("Rektor")) {
//                        functionsSumValue =  functionsSumValue + 2400;
//                } else if (fixText(function.get("title").toString()).equals("Dekan FIT")) {
//                        functionsSumValue =  functionsSumValue + 540;
//                } else if (fixText(function.get("title").toString()).equals("Dekan FDU")) {
//                        functionsSumValue =  functionsSumValue + 450;
//                } else if (fixText(function.get("title").toString()).equals("Dekan FAM")) {
//                        functionsSumValue =  functionsSumValue + 450;
//                } else if (fixText(function.get("title").toString()).equals("Rukovodilac ISUM projekta")) {
//                        functionsSumValue =  functionsSumValue + 200;
//                } else if (fixText(function.get("title").toString()).equals("Direktor centra")) {
//                        functionsSumValue =  functionsSumValue + 150;
//                } else if (fixText(function.get("title").toString()).equals("Predsednik komisije za kvalitet")) {
//                    functionsSumValue =  functionsSumValue + 100;
//                } else if (fixText(function.get("title").toString()).equals("Organizator izlozbi i pomocnik VD dekana")) {
//                    functionsSumValue =  functionsSumValue + 300;
//                } 
//            }
//        }
        

        double isumHoursJ = 0;
        double isumHoursP = 0;
        double isumMoneyJ = 0;
        double isumMoneyP = 0;
//        if (jsonNodePerson.get("isumFunctions") != null && !jsonNodePerson.get("isumFunctions").equals("") && !jsonNodePerson.get("isumFunctions").equals("null")) {
//            JSONArray jsonNodeIsumFunctions = (JSONArray) jsonNodePerson.get("isumFunctions");
////          for (JsonNode function : jsonNodeIsumFunctions) {
//            for (int i = 0; i < jsonNodeAllClasses.length(); i++) {
//                JSONObject function = jsonNodeAllClasses.getJSONObject(i);
//                if (fixText(function.get("title").toString()).equals("Angažovanje na ISUM projektu, jesenji semestar")) {
//                    isumHoursJ = Double.parseDouble(fixText(function.get("numberofhours").toString()));
//                    isumMoneyJ = Double.parseDouble(fixText(function.get("priceperhour").toString()));
//                } else if (fixText(function.get("title").toString()).equals("Angažovanje na ISUM projektu, prolećni semestar")) {
//                    isumHoursP = Double.parseDouble(fixText(function.get("numberofhours").toString()));
//                    isumMoneyP = Double.parseDouble(fixText(function.get("priceperhour").toString()));
//                }
//            }
//        }

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
//        employeeDao.addEmployee(employee);
        System.out.println(employee.toString());
        return employee;
    }

    public PartTimeEmployee partTimeEmployeeFromNode(JSONObject jsonNodePerson) {
        List<Subject> subjectList = new ArrayList<Subject>();
        JSONArray jsonNodeAllClasses = (JSONArray) jsonNodePerson.get("classes");
        int subjectsInSpringSemester = 0;
        int subjectsInAutumnSemester = 0;
//        for (JsonNode jsonNodeClass : jsonNodeAllClasses) {
        for (int i = 0; i < jsonNodeAllClasses.length(); i++) {
            JSONObject jsonNodeClass = jsonNodeAllClasses.getJSONObject(i);
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
//        partTimeEmployeeDao.addPartTimeEmployee(partTimeEmployee);
        System.out.println(partTimeEmployee.toString());
        return partTimeEmployee;
    }

    public static String fixText(String received) {
      return received.replaceAll("\"", "");
    }    
}
