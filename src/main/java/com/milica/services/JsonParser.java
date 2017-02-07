package com.milica.services;

import com.milica.dao.EmployeeDao;
import com.milica.dao.PartTimeEmployeeDao;
import com.milica.dao.SubjectDao;
import com.milica.dao.SubjectEmployeeDao;
import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;
import com.milica.entities.SubjectPartTimeEmployee;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 *
 * @author Milica
 */
@Configurable
public class JsonParser {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    PartTimeEmployeeDao partTimeEmployeeDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SubjectEmployeeDao subjectEmployeeDao;

    @Autowired
    SubjectPartTimeEmployeeDao subjectPartTimeEmployeeDao;

    public Subject subjectFromNode(JSONObject jsonNodeClass) {
        String name = fixText(jsonNodeClass.get("name").toString());
        String location = fixText(jsonNodeClass.get("location").toString());
        String type = fixText(jsonNodeClass.get("type").toString());
        String semester = fixText(jsonNodeClass.get("semester").toString());
//        String code = fixText(jsonNodeClass.get("code").toString());
        String code = "";
        int classNumber = Integer.parseInt(fixText(jsonNodeClass.get("classNumber").toString()));
        int groupExcerciseNumber = Integer.parseInt(fixText(jsonNodeClass.get("groupExcerciseNumber").toString()));
        int individualExcerciseNumber = Integer.parseInt(fixText(jsonNodeClass.get("individualExcerciseNumber").toString()));
        int espb = Integer.parseInt(fixText(jsonNodeClass.get("espb").toString()));
        int groupsNumber = Integer.parseInt(fixText(jsonNodeClass.get("groupsNumber").toString()));
        double numberOfWords = Double.parseDouble(fixText(jsonNodeClass.get("numberOfWords").toString()));
        double fpm = Double.parseDouble(fixText(jsonNodeClass.get("fpm").toString()));
        double fob = Double.parseDouble(fixText(jsonNodeClass.get("fob").toString()));
        double fin1 = Double.parseDouble(fixText(jsonNodeClass.get("fin1").toString()));
        double fin2 = Double.parseDouble(fixText(jsonNodeClass.get("fin2").toString()));
        double fmm = Double.parseDouble(fixText(jsonNodeClass.get("fmm").toString()));
        double fkv = Double.parseDouble(fixText(jsonNodeClass.get("fkv").toString()));

        Subject subject = new Subject();
        subject.setName(name);
        subject.setLocation(location);
        subject.setType(type);
        subject.setSemester(semester);
        subject.setCode(code);
        subject.setClassNumber(classNumber);
        subject.setGroupExerciseNumber(groupExcerciseNumber);
        subject.setIndividualExcerciseNumber(individualExcerciseNumber);
        subject.setEspb(espb);
        subject.setGroupsNumber(groupsNumber);
        subject.setWordsNumber(numberOfWords);
        subject.setFpm(fpm);
        subject.setFob(fob);
        subject.setFin1(fin1);
        subject.setFin2(fin2);
        subject.setFmm(fmm);
        subject.setFkv(fkv);

        return subject;
    }

    List<Subject> subjectListEmployee;
    List<SubjectEmployee> partList;
    int subjectsInSpringSemesterEmployee = 0;
    int subjectsInAutumnSemesterEmployee = 0;
    public Employee employeeFromNode(JSONObject jsonNodePerson) {
        subjectListEmployee = new ArrayList<>();
        partList = new ArrayList<>();
        JSONArray jsonNodeAllClasses = (JSONArray) jsonNodePerson.get("classes");
        for (int i = 0; i < jsonNodeAllClasses.length(); i++) {
            JSONObject jsonNodeClass = jsonNodeAllClasses.getJSONObject(i);
            if (jsonNodeClass.get("fpm") != null && jsonNodeClass.get("fob") != null && jsonNodeClass.get("fin1") != null && jsonNodeClass.get("fin2") != null && jsonNodeClass.get("fmm") != null && jsonNodeClass.get("fkv") != null) {
                try {
                    Subject subject = subjectFromNode(jsonNodeClass);
                    subjectListEmployee.add(subject);
                    if (subject.getSemester().equals("J")) {
                        subjectsInAutumnSemesterEmployee++;
                    } else if (subject.getSemester().equals("P")) {
                        subjectsInSpringSemesterEmployee++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        int semesterNumber;
        if ((subjectsInSpringSemesterEmployee > 0 && subjectsInAutumnSemesterEmployee == 0) 
                || (subjectsInAutumnSemesterEmployee > 0 && subjectsInSpringSemesterEmployee == 0)) {
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
//                switch (fixText(function.get("title").toString())) {
//                    case "Specijalni dodatak":
//                        specialAddValue = Integer.parseInt(fixText(function.get("value").toString()));
//                        break;
//                    case "Rektor":
//                        functionsSumValue =  functionsSumValue + 2400;
//                        break;
//                    case "Dekan FIT":
//                        functionsSumValue =  functionsSumValue + 540;
//                        break;
//                    case "Dekan FDU":
//                        functionsSumValue =  functionsSumValue + 450;
//                        break;
//                    case "Dekan FAM":
//                        functionsSumValue =  functionsSumValue + 450;
//                        break;
//                    case "Rukovodilac ISUM projekta":
//                        functionsSumValue =  functionsSumValue + 200;
//                        break;
//                    case "Direktor centra":
//                        functionsSumValue =  functionsSumValue + 150;
//                        break;
//                    case "Predsednik komisije za kvalitet":
//                        functionsSumValue =  functionsSumValue + 100;
//                        break;
//                    case "Organizator izlozbi i pomocnik VD dekana": 
//                        functionsSumValue =  functionsSumValue + 300;
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }

        double isumHoursJ = 0;
        double isumHoursP = 0;
        double isumMoneyJ = 0;
        double isumMoneyP = 0;
//        if (jsonNodePerson.get("isumFunctions") != null && !jsonNodePerson.get("isumFunctions").equals("") && !jsonNodePerson.get("isumFunctions").equals("null")) {
//            JSONArray jsonNodeIsumFunctions = (JSONArray) jsonNodePerson.get("isumFunctions");
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

        Employee employee = new Employee();
        employee.setSemesterNumber(semesterNumber);
        employee.setSubjectsInSpringSemester(subjectsInSpringSemesterEmployee);
        employee.setSubjectsInAutumnSemester(subjectsInAutumnSemesterEmployee);
        employee.setSpecialAddValue(specialAddValue);
        employee.setFunctionsAddValue(functionsSumValue);
        employee.setName(fixText(jsonNodePerson.get("name").toString()));
        employee.setLastname(fixText(jsonNodePerson.get("lastname").toString()));
        employee.setFaculty(fixText(jsonNodePerson.get("faculty").toString()));
        employee.setBankAccount(fixText(jsonNodePerson.get("bankAccount").toString()));
        employee.setEmail(fixText(jsonNodePerson.get("name").toString()).toLowerCase() + "." + fixText(jsonNodePerson.get("lastname").toString()).toLowerCase() + "@metropolitan.ac.rs");
        employee.setTeachingPosition(fixText(jsonNodePerson.get("teachingPosition").toString()));
        employee.setEmploymentPercentage(fixText(jsonNodePerson.get("employmentPercentage").toString()));
        employee.setSubjectNumber(fixText(jsonNodePerson.get("subjectNumber").toString()));
        employee.setKbp(fixText(jsonNodePerson.get("kbp").toString()));
        employee.setKro(fixText(jsonNodePerson.get("kro").toString()));
        employee.setKt(fixText(jsonNodePerson.get("kt").toString()));
        employee.setKpr(fixText(jsonNodePerson.get("kpr").toString()));
        employee.setIsumHoursAutumn(isumHoursJ);
        employee.setIsumHoursSpring(isumHoursP);
        employee.setIsumMoneyAutumn(isumMoneyJ);
        employee.setIsumMoneySpring(isumMoneyP);

        for (Subject subject : subjectListEmployee) {
            SubjectEmployee pair = new SubjectEmployee();
            pair.setEmployeeId(employee);
            pair.setSubjectId(subject);
            partList.add(pair);
        }
        
        return employee;
    }
    public List<Subject> returnSubjectEmployee() {
        return subjectListEmployee;
    }
    public List<SubjectEmployee> returnPairList() {
        return partList;
    }

    List<Subject> subjectListPartTime;
    List<SubjectPartTimeEmployee> partListPart;
    int subjectsInSpringSemesterPartTime = 0;
    int subjectsInAutumnSemesterPartTime = 0;
    public PartTimeEmployee partTimeEmployeeFromNode(JSONObject jsonNodePerson) {
        subjectListPartTime = new ArrayList<>();
        partListPart = new ArrayList<>();
        JSONArray jsonNodeAllClasses = (JSONArray) jsonNodePerson.get("classes");
        for (int i = 0; i < jsonNodeAllClasses.length(); i++) {
            JSONObject jsonNodeClass = jsonNodeAllClasses.getJSONObject(i);
            if (jsonNodeClass.get("fpm") != null && jsonNodeClass.get("fob") != null
                    && jsonNodeClass.get("fin1") != null && jsonNodeClass.get("fin2") != null
                    && jsonNodeClass.get("fmm") != null && jsonNodeClass.get("fkv") != null) {
                try {
                    Subject subject = subjectFromNode(jsonNodeClass);
                    subjectListPartTime.add(subject);
                    if (subject.getSemester().equals("J")) {
                        subjectsInAutumnSemesterPartTime++;
                    } else if (subject.getSemester().equals("P")) {
                        subjectsInSpringSemesterPartTime++;
                    }
                } catch (Exception e) {

                }
            }
        }

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setSubjectsInAutumnSemester(subjectsInAutumnSemesterPartTime);
        partTimeEmployee.setSubjectsInSpringSemester(subjectsInSpringSemesterPartTime);
        partTimeEmployee.setName(fixText(jsonNodePerson.get("name").toString()));
        partTimeEmployee.setLastname(fixText(jsonNodePerson.get("lastname").toString()));
        partTimeEmployee.setFaculty(fixText(jsonNodePerson.get("faculty").toString()));
        partTimeEmployee.setBankAccount(fixText(jsonNodePerson.get("bankAccount").toString()));
        partTimeEmployee.setEmail(fixText(jsonNodePerson.get("name").toString()).toLowerCase() + "." + fixText(jsonNodePerson.get("lastname").toString()).toLowerCase() + "@metropolitan.ac.rs");
        partTimeEmployee.setTeachingPosition(fixText(jsonNodePerson.get("teachingPosition").toString()));
        partTimeEmployee.setEmploymentPercentage(fixText(jsonNodePerson.get("employmentPercentage").toString()));
        partTimeEmployee.setSubjectNumber(fixText(jsonNodePerson.get("subjectNumber").toString()));
        partTimeEmployee.setKt(fixText(jsonNodePerson.get("kt").toString()));

        for (Subject subject : subjectListPartTime) {
            SubjectPartTimeEmployee pair = new SubjectPartTimeEmployee();
            pair.setPartTimeEmployeeId(partTimeEmployee);
            pair.setSubjectId(subject);
            partListPart.add(pair);
        }
        
        return partTimeEmployee;
    }
    public List<Subject> returnSujbectListPartTime() {
        return subjectListPartTime;
    }
    public List<SubjectPartTimeEmployee> returnPairListPart() {
        return partListPart;
    }

    public static String fixText(String received) {
        return received.replaceAll("\"", "");
    }
}
