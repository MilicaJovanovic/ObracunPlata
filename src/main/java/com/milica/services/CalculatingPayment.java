/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import java.util.List;

/**
 *
 * @author Milica
 */
public class CalculatingPayment {
    public static double empoyeeNetoBasicPayment(Employee employee, String semester) {
        double basicPayment = calculateReferencePayment(employee.getTeachingPosition()) * Double.parseDouble(employee.getKbp()) * Double.parseDouble(employee.getKro()) * Double.parseDouble(employee.getKt()) * Double.parseDouble(employee.getKpr()) + employee.getSpecialAddValue() + employee.getFunctionsAddValue();
        double basicPaymentMoney = basicPayment * 100;
        
        double subjectPaymentAutumn = 0;
        double subjectPaymentSpring = 0;
        List<Subject> subjectList = employee.getSubjectList();
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
    
    public static double employeeGrossBasicPayment(Employee employee, String semester) {
        double grossPayment = empoyeeNetoBasicPayment(employee, semester) * 1.6452;
        return grossPayment;
    }
    
    public static double empoyeeNetoAuthorFee(Employee employee, String semester) {
        double subjectFeeSum = 0;
        List<Subject> subjectList = employee.getSubjectList();
        for (int i = 0; i < subjectList.size(); i++) {
            subjectFeeSum = subjectFeeSum + subjectAuthorFee(subjectList.get(i), employee);
        }
        
        double fee = subjectFeeSum * 1.3145;
        return fee;
    }
    
    public static double empoyeeGrossAuthorFee(Employee employee, String semester) {
        double grossPayment = empoyeeNetoAuthorFee(employee, semester) * 1.3145;
        return grossPayment;
    }
    
    public double partTimeEmpoyeeBasicPayment(PartTimeEmployee partTimeEmployee, String semester) {
        double subjectPaymentAutumn = 0;
        double subjectPaymentSpring = 0;
        List<Subject> subjectList = partTimeEmployee.getSubjectList();
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
    
    public static double subjectPayment(Employee employee, Subject subject) {
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
    
    public static double calculateReferencePayment(String teachingPosition) {
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
    
    public static double subjectAuthorFee(Subject subject, Employee employee) {
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
    
    public static double subjectPaymentPartTime(PartTimeEmployee partTimeEmployee, Subject subject) {
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
        
        double payment = 0;
        payment = classType * Double.parseDouble(partTimeEmployee.getKt()) * 15;
        double paymentMoney = payment * 100;
        return paymentMoney;
    }
}
