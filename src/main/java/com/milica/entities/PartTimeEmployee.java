package com.milica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "part_time_employee"
 * @author Milica
 */
@Entity
@Table(name="part_time_employee")
public class PartTimeEmployee {
    
    private int partTimeEmployeeId;
    private int subjectsInSpringSemester;
    private int  subjectsInAutumnSemester;
    private String name;
    private String lastname;
    private String faculty;
    private String bankAccount;
    private String email;
    private String teachingPosition;
    private String employmentPercentage;
    private String subjectNumber;
    private String kt;

    @Id
    @GeneratedValue()
    @Column(name = "part_time_employee_id")
    public int getPartTimeEmployeeId() {
        return partTimeEmployeeId;
    }
    public void setPartTimeEmployeeId(int partTimeEmployeeId) {
        this.partTimeEmployeeId = partTimeEmployeeId;
    }

    @Column(name = "subjects_in_spring_semester")
    public int getSubjectsInSpringSemester() {
        return subjectsInSpringSemester;
    }
    public void setSubjectsInSpringSemester(int subjectsInSpringSemester) {
        this.subjectsInSpringSemester = subjectsInSpringSemester;
    }

    @Column(name = "subjects_in_autumn_semester")
    public int getSubjectsInAutumnSemester() {
        return subjectsInAutumnSemester;
    }
    public void setSubjectsInAutumnSemester(int subjectsInAutumnSemester) {
        this.subjectsInAutumnSemester = subjectsInAutumnSemester;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "faculty")
    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    @Column(name = "bank_account")
    public String getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "teaching_position")
    public String getTeachingPosition() {
        return teachingPosition;
    }
    public void setTeachingPosition(String teachingPosition) {
        this.teachingPosition = teachingPosition;
    }

    @Column(name = "employment_percentage")
    public String getEmploymentPercentage() {
        return employmentPercentage;
    }
    public void setEmploymentPercentage(String employmentPercentage) {
        this.employmentPercentage = employmentPercentage;
    }

    @Column(name = "subject_number")
    public String getSubjectNumber() {
        return subjectNumber;
    }
    public void setSubjectNumber(String subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    @Column(name = "kt")
    public String getKt() {
        return kt;
    }
    public void setKt(String kt) {
        this.kt = kt;
    }
    
	@Override
	public String toString() {
		return "PartTimeEmployee [partTimeEmployeeId=" + partTimeEmployeeId + ", subjectsInSpringSemester="
				+ subjectsInSpringSemester + ", subjectsInAutumnSemester=" + subjectsInAutumnSemester + ", name=" + name
				+ ", lastname=" + lastname + ", faculty=" + faculty + ", bankAccount=" + bankAccount + ", email="
				+ email + ", teachingPosition=" + teachingPosition + ", employmentPercentage=" + employmentPercentage
				+ ", subjectNumber=" + subjectNumber + ", kt=" + kt + "]";
	}

}
