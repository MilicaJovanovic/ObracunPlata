package com.milica.services;

import com.milica.dao.SubjectEmployeeDao;
import com.milica.dao.SubjectPartTimeEmployeeDao;
import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Milica
 */
public class CalculatePayment {
    
    @Autowired
    private SubjectEmployeeDao subjectEmployeeDao;
    
    @Autowired
    private SubjectPartTimeEmployeeDao subjectPartTimeEmployeeDao;
    
    public double employeeNetoBasicPayment(Employee employee, String semester, List<Subject> subjectList) {
        double basicPayment = calculateReferencePayment(employee.getTeachingPosition()) * Double.parseDouble(employee.getKbp()) * Double.parseDouble(employee.getKro()) * Double.parseDouble(employee.getKt()) * Double.parseDouble(employee.getKpr()) + employee.getSpecialAddValue() + employee.getFunctionsAddValue();
        double basicPaymentMoney = basicPayment * 100;
        
        double subjectPaymentAutumn = 0;
        double subjectPaymentSpring = 0;
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getSemester().equals("Jesenji")) {
                subjectPaymentAutumn = subjectPaymentAutumn + subjectPayment(employee, subjectList.get(i));
            } else if (subjectList.get(i).getSemester().equals("Prolecni")) {
                subjectPaymentSpring = subjectPaymentSpring + subjectPayment(employee, subjectList.get(i));
            } 
        }
        
        double payment = 0;
        if (semester.equals("Jesenji")) {
            payment = basicPaymentMoney * 6 + subjectPaymentAutumn * 15;
        } else if (semester.equals("Prolecni")) {
            payment = basicPaymentMoney * 6 + subjectPaymentSpring * 15;
        }
        return payment;
    }
    
    public double employeeGrossBasicPayment(Employee employee, String semester, List<Subject> subjectList) {
        double grossPayment = employeeNetoBasicPayment(employee, semester, subjectList) * 1.6452;
        return grossPayment;
    }
    
    public double empoyeeNetoAuthorFee(Employee employee, String semester, List<Subject> subjectList) {
        double subjectFeeSum = 0;
        for (int i = 0; i < subjectList.size(); i++) {
            subjectFeeSum = subjectFeeSum + subjectAuthorFee(subjectList.get(i), employee);
        }
        
        double fee = subjectFeeSum * 1.3145;
        return fee;
    }
    
    public double empoyeeGrossAuthorFee(Employee employee, String semester, List<Subject> subjectList) {
        double grossPayment = empoyeeNetoAuthorFee(employee, semester, subjectList) * 1.3145;
        return grossPayment;
    }
    
    public double partTimeEmpoyeeBasicPayment(PartTimeEmployee partTimeEmployee, String semester, List<Subject> subjectList) {
        double subjectPaymentAutumn = 0;
        double subjectPaymentSpring = 0;
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getSemester().equals("Jesenji")) {
                subjectPaymentAutumn = subjectPaymentAutumn + subjectPaymentPartTime(partTimeEmployee, subjectList.get(i));
            } else if (subjectList.get(i).getSemester().equals("Prolecni")) {
                subjectPaymentSpring = subjectPaymentSpring + subjectPaymentPartTime(partTimeEmployee, subjectList.get(i));
            } 
        }
        
        if (semester.equals("Jesenji")) {
            return subjectPaymentAutumn;
        } else if (semester.equals("Prolecni")) {
            return subjectPaymentSpring;
        } else 
            return 0;
    }
    
    public double partTimeEmployeeGrossBasicPayment(PartTimeEmployee partTimeEmployee, String semester, List<Subject> subjectList) {
        double grossPayment = partTimeEmpoyeeBasicPayment(partTimeEmployee, semester, subjectList) * 1.6452;
        return grossPayment;
    }
    
    public double subjectPayment(Employee employee, Subject subject) {
        double classType;
        switch (subject.getType()) {
            case "Klasicno":  
                classType = 1;
                break;
            case "Hibridno":
                classType = 0.9;
                break;
            case "Onlajn":
                classType = 0.2;
                break;
            default:
                classType = 0;
                break;
        }
        
        double teachingPossition;
        switch (employee.getTeachingPosition()) {
            case "Demonstrator":  
                teachingPossition = 10;
                break;
            case "Saradnik":
                teachingPossition = 10;
                break;
            case "Asistent":
                teachingPossition = 10;
                break;
            case "Predavač":
                teachingPossition = 10;
                break;
            case "Viši predavač":
                teachingPossition = 10;
                break;
            case "Docent":
                teachingPossition = 10;
                break;
            case "Vanr. profesor":
                teachingPossition = 11.5;
                break;
            case "Red. profesor":
                teachingPossition = 13;
                break;
            default:
                teachingPossition = 0;
                break;
        }
        
        double classSum = (subject.getGroupExerciseNumber() + subject.getIndividualExcerciseNumber()) + subject.getGroupsNumber();
        
        double payment = 0;
        payment = Double.parseDouble(employee.getKpr()) * Double.parseDouble(employee.getKt()) * classType * subject.getClassNumber() * teachingPossition * 1 * classSum * 9;
        double paymentMoney = payment * 100;
        return paymentMoney;
    }
    
    public double calculateReferencePayment(String teachingPosition) {
        double refPayment = 0;
        switch (teachingPosition) {
            case "Demonstrator":  
                refPayment = 0;
                break;
            case "Saradnik":
                refPayment = 140;
                break;
            case "Asistent":
                refPayment = 160;
                break;
            case "Predavač":
                refPayment = 180;
                break;
            case "Viši predavač":
                refPayment = 200;
                break;
            case "Docent":
                refPayment = 200;
                break;
            case "Vanr. profesor":
                refPayment = 230;
                break;
            case "Red. profesor":
                refPayment = 280;
                break;
            default:
                refPayment = 0;
                break;
        }
        
         return refPayment;
    }
    
    public double subjectAuthorFee(Subject subject, Employee employee) {
        double factorsSum = 2 * Double.parseDouble(employee.getKt()) * subject.getFob() * subject.getFin1() * subject.getFin2() * subject.getFmm() * subject.getFkv();
        
        double basicAuthorFee;
        if (subject.getClassNumber() >= 3) {
            basicAuthorFee = 900;
        } else if (subject.getClassNumber() >= 2) {
            basicAuthorFee = 600;
        } else {
            basicAuthorFee = 0;
        }
        
        double authorFeeAfterFactors = factorsSum * basicAuthorFee;
        
        double finalFee = (authorFeeAfterFactors - basicAuthorFee) * 100;
        return finalFee;
    }
    
    public double subjectPaymentPartTime(PartTimeEmployee partTimeEmployee, Subject subject) {
        double classType;
        switch (subject.getType()) {
            case "Klasicno":  
                classType = 1;
                break;
            case "Hibridno":
                classType = 0.9;
                break;
            case "Onlajn":
                classType = 0.2;
                break;
            default:
                classType = 0;
                break;
        }
        
        double teachingPossition;
        switch (partTimeEmployee.getTeachingPosition()) {
            case "Demonstrator":  
                teachingPossition = 10;
                break;
            case "Saradnik":
                teachingPossition = 10;
                break;
            case "Asistent":
                teachingPossition = 10;
                break;
            case "Predavač":
                teachingPossition = 10;
                break;
            case "Viši predavač":
                teachingPossition = 10;
                break;
            case "Docent":
                teachingPossition = 10;
                break;
            case "Vanr. profesor":
                teachingPossition = 11.5;
                break;
            case "Red. profesor":
                teachingPossition = 13;
                break;
            default:
                teachingPossition = 0;
                break;
        }
        
        double classSum = (subject.getGroupExerciseNumber() + subject.getIndividualExcerciseNumber()) + subject.getGroupsNumber();
        
        double firstDependence = 0;
        if (subject.getLocation().equals("Beograd")) {
            if (partTimeEmployee.getTeachingPosition().equals("Red. profesor") || partTimeEmployee.getTeachingPosition().equals("Vanr.profesor") || partTimeEmployee.getTeachingPosition().equals("Docent")) {
                firstDependence = subject.getClassNumber() * 12 + 7 * classSum;
            } else if (partTimeEmployee.getTeachingPosition().equals("Doktor nauka") || partTimeEmployee.getTeachingPosition().equals("Predavač") || partTimeEmployee.getTeachingPosition().equals("Asistent") || partTimeEmployee.getTeachingPosition().equals(("Saradnik"))) {
                firstDependence = subject.getClassNumber() * 9 + 7 * classSum;
            } else
                firstDependence = (subject.getClassNumber() + classSum) * 6;
        } else if (subject.getLocation().equals("Niš")) {
            if (partTimeEmployee.getTeachingPosition().equals("Red. profesor") || partTimeEmployee.getTeachingPosition().equals("Vanr.profesor") || partTimeEmployee.getTeachingPosition().equals("Docent")) {
                firstDependence = subject.getClassNumber() * 15 + 7 * classSum;
            } else if (partTimeEmployee.getTeachingPosition().equals("Doktor nauka")) {
                firstDependence = subject.getClassNumber() * 12 + 12 * classSum;
            } else if (partTimeEmployee.getTeachingPosition().equals("Predavač") || partTimeEmployee.getTeachingPosition().equals("Asistent") || partTimeEmployee.getTeachingPosition().equals(("Saradnik"))) {
                firstDependence = subject.getClassNumber() * 12 + 7 * classSum;
            } else
                firstDependence = subject.getClassNumber() * 6 + 6 * classSum;
        } else
            firstDependence = 0;
        
        double payment = 0;
        payment = classType * Double.parseDouble(partTimeEmployee.getKt()) * 15 * firstDependence;
        double paymentMoney = payment * 100;
        return paymentMoney;
    }
}
