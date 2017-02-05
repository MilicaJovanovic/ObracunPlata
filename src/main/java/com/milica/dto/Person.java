/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private double salaryNeto;
    private double authorFeeNeto;
    private double salaryGross;
    private double authorFeeGross;
    
    public Person() {}

    public Person(String name, String lastname, String faculty, String employmentType, double salaryNeto, double authorFeeNeto) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryNeto = salaryNeto;
        this.authorFeeNeto = authorFeeNeto;
    }
    
    public Person(double salaryGross, double authorFeeGross, String name, String lastname, String faculty, String employmentType) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryGross = salaryGross;
        this.authorFeeGross = authorFeeGross;
    }
    
    public Person(String name, String lastname, String faculty, String employmentType, double salaryNeto) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryNeto = salaryNeto;
    }
    
    public Person(double salaryGross, String name, String lastname, String faculty, String employmentType) {
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.employmentType = employmentType;
        this.salaryGross = salaryGross;
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

    public double getSalaryNeto() {
        return salaryNeto;
    }

    public void setSalaryNeto(double salaryNeto) {
        this.salaryNeto = salaryNeto;
    }

    public double getAuthorFeeNeto() {
        return authorFeeNeto;
    }

    public void setAuthorFeeNeto(double authorFeeNeto) {
        this.authorFeeNeto = authorFeeNeto;
    }

    public double getSalaryGross() {
        return salaryGross;
    }

    public void setSalaryGross(double salaryGross) {
        this.salaryGross = salaryGross;
    }

    public double getAuthorFeeGross() {
        return authorFeeGross;
    }

    public void setAuthorFeeGross(double authorFeeGross) {
        this.authorFeeGross = authorFeeGross;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastname=" + lastname + ", faculty=" + faculty + ", employmentType=" + employmentType + ", salaryNeto=" + salaryNeto + ", authorFeeNeto=" + authorFeeNeto + ", salaryGross=" + salaryGross + ", authorFeeGross=" + authorFeeGross + '}';
    }
}
