package com.milica.dto;

/**
 *
 * @author Milica
 */
public class Person {
    private String name;
    private String lastname;
    private String faculty;
    private String employmentType;
    private double salaryNetoA;
    private double authorFeeNetoA;
    private double salaryGrossA;
    private double authorFeeGrossA;
    private double salaryNetoS;
    private double authorFeeNetoS;
    private double salaryGrossS;
    private double authorFeeGrossS;
    
    public Person() {}

    public Person(String name, String lastname, String faculty, String employmentType, double salaryNetoA, double authorFeeNetoA, double salaryNetoS, double authorFeeNetoS) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryNetoA = salaryNetoA;
        this.authorFeeNetoA = authorFeeNetoA;
        this.salaryNetoS = salaryNetoS;
        this.authorFeeNetoS = authorFeeNetoS;
    }
    
    public Person(double salaryGrossA, double authorFeeGrossA, double salaryGrossS, double authorFeeGrossS, String name, String lastname, String faculty, String employmentType) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryGrossA = salaryGrossA;
        this.authorFeeGrossA = authorFeeGrossA;
        this.salaryGrossS = salaryGrossS;
        this.authorFeeGrossS = authorFeeGrossS;
    }
    
    public Person(String name, String lastname, String faculty, String employmentType, double salaryNetoA) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryNetoA = salaryNetoA;
    }
    
    public Person(double salaryGrossA, String name, String lastname, String faculty, String employmentType) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryGrossA = salaryGrossA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public double getSalaryNetoA() {
        return salaryNetoA;
    }

    public void setSalaryNetoA(double salaryNetoA) {
        this.salaryNetoA = salaryNetoA;
    }

    public double getAuthorFeeNetoA() {
        return authorFeeNetoA;
    }

    public void setAuthorFeeNetoA(double authorFeeNetoA) {
        this.authorFeeNetoA = authorFeeNetoA;
    }

    public double getSalaryGrossA() {
        return salaryGrossA;
    }

    public void setSalaryGrossA(double salaryGrossA) {
        this.salaryGrossA = salaryGrossA;
    }

    public double getAuthorFeeGrossA() {
        return authorFeeGrossA;
    }

    public void setAuthorFeeGrossA(double authorFeeGrossA) {
        this.authorFeeGrossA = authorFeeGrossA;
    }

    public double getSalaryNetoS() {
        return salaryNetoS;
    }

    public void setSalaryNetoS(double salaryNetoS) {
        this.salaryNetoS = salaryNetoS;
    }

    public double getAuthorFeeNetoS() {
        return authorFeeNetoS;
    }

    public void setAuthorFeeNetoS(double authorFeeNetoS) {
        this.authorFeeNetoS = authorFeeNetoS;
    }

    public double getSalaryGrossS() {
        return salaryGrossS;
    }

    public void setSalaryGrossS(double salaryGrossS) {
        this.salaryGrossS = salaryGrossS;
    }

    public double getAuthorFeeGrossS() {
        return authorFeeGrossS;
    }

    public void setAuthorFeeGrossS(double authorFeeGrossS) {
        this.authorFeeGrossS = authorFeeGrossS;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastname=" + lastname + ", faculty=" + faculty + ", employmentType=" + employmentType + ", salaryNetoA=" + salaryNetoA + ", authorFeeNetoA=" + authorFeeNetoA + ", salaryGrossA=" + salaryGrossA + ", authorFeeGrossA=" + authorFeeGrossA + ", salaryNetoS=" + salaryNetoS + ", authorFeeNetoS=" + authorFeeNetoS + ", salaryGrossS=" + salaryGrossS + ", authorFeeGrossS=" + authorFeeGrossS + '}';
    }
}
