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
@Table(name="part_time_employee")
public class PartTimeEmployee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "part_time_employee_id")
    private int partTimeEmployeeId;
    
    @Column(name = "subjects_in_spring_semester")
    private int subjectsInSpringSemester;
    
    @Column(name = "subjects_in_autumn_semester")
    private int  subjectsInAutumnSemester;
    
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
    
    @Column(name = "employment_percentage")
    private String employmentPercentage;
    
    @Column(name = "subject_number")
    private String subjectNumber;
    
    @Column(name = "kt")
    private String kt;

//    @Column(name = "subject_list")
//    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private List<Subject> subjectList;
    
    @OneToMany(mappedBy="partTimeEmployeeId", cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subject> subjectList;

    public PartTimeEmployee(int id, int subjectsInSpringSemester, int subjectsInAutumnSemester, String name, String lastname, String faculty, String bankAccount, String email, String teachingPosition, String employmentPercentage, String subjectNumber, String kt, List<Subject> subjectList) {
        this.partTimeEmployeeId = id;
        this.subjectsInSpringSemester = subjectsInSpringSemester;
        this.subjectsInAutumnSemester = subjectsInAutumnSemester;
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.bankAccount = bankAccount;
        this.email = email;
        this.teachingPosition = teachingPosition;
        this.employmentPercentage = employmentPercentage;
        this.subjectNumber = subjectNumber;
        this.kt = kt;
        this.subjectList = subjectList;
    }

    public int getPartTimeEmployeeId() {
        return partTimeEmployeeId;
    }

    public void setPartTimeEmployeeId(int partTimeEmployeeId) {
        this.partTimeEmployeeId = partTimeEmployeeId;
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

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" + "id=" + partTimeEmployeeId + ", subjectsInSpringSemester=" + subjectsInSpringSemester + ", subjectsInAutumnSemester=" + subjectsInAutumnSemester + ", name=" + name + ", lastname=" + lastname + ", faculty=" + faculty + ", bankAccount=" + bankAccount + ", email=" + email + ", teachingPosition=" + teachingPosition + ", employmentPercentage=" + employmentPercentage + ", subjectNumber=" + subjectNumber + ", kt=" + kt + ", subjectList=" + subjectList + '}';
    }
}
