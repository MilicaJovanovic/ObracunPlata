/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Milica
 */
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;
    
    @Column(name = "semester_number")
    private int semesterNumber;
    
    @Column(name = "subjects_in_spring_semester")
    private int subjectsInSpringSemester;
    
    @Column(name = "subjects_in_autumn_semester")
    private int subjectsInAutumnSemester;
    
    @Column(name = "special_add_value")
    private int specialAddValue;
    
    @Column(name = "functionas_add_value")
    private int functionsAddValue;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "faculty")
    private String faculty;
    
    @Column(name = "bank_account")
    private String bankAccount;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "teaching_position")
    private String teachingPosition;
    
    @Column(name = "eployment_percentage")
    private String employmentPercentage;
    
    @Column(name = "subject_number")
    private String subjectNumber;
    
    @Column(name = "kbp")
    private String kbp;
    
    @Column(name = "kro")
    private String kro;
    
    @Column(name = "kt")
    private String kt;
    
    @Column(name = "kpr")
    private String kpr;
    
//    @Column(name = "subject_list")
//    @JoinColumn(name = "subject_employeeId", referencedColumnName = "subject_employeeId")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private List<Subject> subjectList;
    
    @OneToMany(mappedBy="employeeId", cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subject> subjectList;
    
    @Column(name = "isum_hours_autumn")
    private double isumHoursAutumn;
    
    @Column(name = "isum_hours_spring")
    private double isumHoursSpring;
    
    @Column(name = "isum_money_autumn")
    private double isumMoneyAutumn;
    
    @Column(name = "isum_money_spring")
    private double isumMoneySpring;

    public Employee(int employeeId, int semesterNumber, int subjectsInSpringSemester, int subjectsInAutumnSemester, int specialAddValue, int functionsAddValue, String name, String lastname, String faculty, String bankAccount, String email, String teachingPosition, String employmentPercentage, String subjectNumber, String kbp, String kro, String kt, String kpr, List<Subject> subjectList, double isumHoursAutumn, double isumHoursSpring, double isumMoneyAutumn, double isumMoneySpring) {
        this.employeeId = employeeId;
        this.semesterNumber = semesterNumber;
        this.subjectsInSpringSemester = subjectsInSpringSemester;
        this.subjectsInAutumnSemester = subjectsInAutumnSemester;
        this.specialAddValue = specialAddValue;
        this.functionsAddValue = functionsAddValue;
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.bankAccount = bankAccount;
        this.email = email;
        this.teachingPosition = teachingPosition;
        this.employmentPercentage = employmentPercentage;
        this.subjectNumber = subjectNumber;
        this.kbp = kbp;
        this.kro = kro;
        this.kt = kt;
        this.kpr = kpr;
        this.subjectList = subjectList;
        this.isumHoursAutumn = isumHoursAutumn;
        this.isumHoursSpring = isumHoursSpring;
        this.isumMoneyAutumn = isumMoneyAutumn;
        this.isumMoneySpring = isumMoneySpring;
    }

    public int getId() {
        return employeeId;
    }

    public void setId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getSubjectsInSpringSemester() {
        return subjectsInSpringSemester;
    }

    public void setSubjectsInSpringSemester(int subjectsInSpringSemester) {
        this.subjectsInSpringSemester = subjectsInSpringSemester;
    }

    public int getSubjectsInAutumnSemester() {
        return subjectsInAutumnSemester;
    }

    public void setSubjectsInAutumnSemester(int subjectsInAutumnSemester) {
        this.subjectsInAutumnSemester = subjectsInAutumnSemester;
    }

    public int getSpecialAddValue() {
        return specialAddValue;
    }

    public void setSpecialAddValue(int specialAddValue) {
        this.specialAddValue = specialAddValue;
    }

    public int getFunctionsAddValue() {
        return functionsAddValue;
    }

    public void setFunctionsAddValue(int functionsAddValue) {
        this.functionsAddValue = functionsAddValue;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeachingPosition() {
        return teachingPosition;
    }

    public void setTeachingPosition(String teachingPosition) {
        this.teachingPosition = teachingPosition;
    }

    public String getEmploymentPercentage() {
        return employmentPercentage;
    }

    public void setEmploymentPercentage(String employmentPercentage) {
        this.employmentPercentage = employmentPercentage;
    }

    public String getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(String subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public String getKbp() {
        return kbp;
    }

    public void setKbp(String kbp) {
        this.kbp = kbp;
    }

    public String getKro() {
        return kro;
    }

    public void setKro(String kro) {
        this.kro = kro;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    public String getKpr() {
        return kpr;
    }

    public void setKpr(String kpr) {
        this.kpr = kpr;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public double getIsumHoursAutumn() {
        return isumHoursAutumn;
    }

    public void setIsumHoursAutumn(double isumHoursAutumn) {
        this.isumHoursAutumn = isumHoursAutumn;
    }

    public double getIsumHoursSpring() {
        return isumHoursSpring;
    }

    public void setIsumHoursSpring(double isumHoursSpring) {
        this.isumHoursSpring = isumHoursSpring;
    }

    public double getIsumMoneyAutumn() {
        return isumMoneyAutumn;
    }

    public void setIsumMoneyAutumn(double isumMoneyAutumn) {
        this.isumMoneyAutumn = isumMoneyAutumn;
    }

    public double getIsumMoneySpring() {
        return isumMoneySpring;
    }

    public void setIsumMoneySpring(double isumMoneySpring) {
        this.isumMoneySpring = isumMoneySpring;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", semesterNumber=" + semesterNumber + ", subjectsInSpringSemester=" + subjectsInSpringSemester + ", subjectsInAutumnSemester=" + subjectsInAutumnSemester + ", specialAddValue=" + specialAddValue + ", functionsAddValue=" + functionsAddValue + ", name=" + name + ", lastname=" + lastname + ", faculty=" + faculty + ", bankAccount=" + bankAccount + ", email=" + email + ", teachingPosition=" + teachingPosition + ", employmentPercentage=" + employmentPercentage + ", subjectNumber=" + subjectNumber + ", kbp=" + kbp + ", kro=" + kro + ", kt=" + kt + ", kpr=" + kpr + ", subjectList=" + subjectList + ", isumHoursAutumn=" + isumHoursAutumn + ", isumHoursSpring=" + isumHoursSpring + ", isumMoneyAutumn=" + isumMoneyAutumn + ", isumMoneySpring=" + isumMoneySpring + '}';
    }
}
