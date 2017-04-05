package com.milica.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "employee"
 * @author Milica
 */
@Entity
@Table(name="employee")
public class Employee {
	
	private int employeeId;
	private int semesterNumber;
	private int subjectsInSpringSemester;
	private int subjectsInAutumnSemester;
	private int specialAddValue;
	private int functionsAddValue;
	private String name;
	private String lastname;
	private String faculty;
	private String bankAccount;
	private String email;
	private String teachingPosition;
	private String employmentPercentage;
	private String subjectNumber;
	private String kbp;
	private String kro;
	private String kt;
	private String kpr;
	private double isumHoursAutumn;
	private double isumHoursSpring;
	private double isumMoneySpring;
	private double isumMoneyAutumn;
        
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name="semester_number")
	public int getSemesterNumber() {
		return semesterNumber;
	}
	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}
	
	@Column(name="subjects_in_spring_semester")
	public int getSubjectsInSpringSemester() {
		return subjectsInSpringSemester;
	}
	public void setSubjectsInSpringSemester(int subjectsInSpringSemester) {
		this.subjectsInSpringSemester = subjectsInSpringSemester;
	}
	
	@Column(name="subjects_in_autumn_semester")
	public int getSubjectsInAutumnSemester() {
		return subjectsInAutumnSemester;
	}
	public void setSubjectsInAutumnSemester(int subjectsInAutumnSemester) {
		this.subjectsInAutumnSemester = subjectsInAutumnSemester;
	}
	
	@Column(name="special_add_value")
	public int getSpecialAddValue() {
		return specialAddValue;
	}
	public void setSpecialAddValue(int specialAddValue) {
		this.specialAddValue = specialAddValue;
	}
	
	@Column(name="functions_add_value")
	public int getFunctionsAddValue() {
		return functionsAddValue;
	}
	public void setFunctionsAddValue(int functionsAddValue) {
		this.functionsAddValue = functionsAddValue;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name="faculty")
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	@Column(name="bank_account")
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="teaching_position")
	public String getTeachingPosition() {
		return teachingPosition;
	}
	public void setTeachingPosition(String teachingPosition) {
		this.teachingPosition = teachingPosition;
	}
	
	@Column(name="employment_percentage")
	public String getEmploymentPercentage() {
		return employmentPercentage;
	}
	public void setEmploymentPercentage(String employmentPercentage) {
		this.employmentPercentage = employmentPercentage;
	}
	
	@Column(name="subject_number")
	public String getSubjectNumber() {
		return subjectNumber;
	}
	public void setSubjectNumber(String subjectNumber) {
		this.subjectNumber = subjectNumber;
	}
	
	@Column(name="kbp")
	public String getKbp() {
		return kbp;
	}
	public void setKbp(String kbp) {
		this.kbp = kbp;
	}
	
	@Column(name="kro")
	public String getKro() {
		return kro;
	}
	public void setKro(String kro) {
		this.kro = kro;
	}
	
	@Column(name="kt")
	public String getKt() {
		return kt;
	}
	public void setKt(String kt) {
		this.kt = kt;
	}
	
	@Column(name="kpr")
	public String getKpr() {
		return kpr;
	}
	public void setKpr(String kpr) {
		this.kpr = kpr;
	}
	
	@Column(name="isum_hours_autumn")
	public double getIsumHoursAutumn() {
		return isumHoursAutumn;
	}
	public void setIsumHoursAutumn(double isumHoursAutumn) {
		this.isumHoursAutumn = isumHoursAutumn;
	}
	
	@Column(name="isum_hours_spring")
	public double getIsumHoursSpring() {
		return isumHoursSpring;
	}
	public void setIsumHoursSpring(double isumHoursSpring) {
		this.isumHoursSpring = isumHoursSpring;
	}
	
	@Column(name="isum_money_spring")
	public double getIsumMoneySpring() {
		return isumMoneySpring;
	}
	public void setIsumMoneySpring(double isumMoneySpring) {
		this.isumMoneySpring = isumMoneySpring;
	}
	
	@Column(name="isum_money_autumn")
	public double getIsumMoneyAutumn() {
		return isumMoneyAutumn;
	}
	public void setIsumMoneyAutumn(double isumMoneyAutumn) {
		this.isumMoneyAutumn = isumMoneyAutumn;
	}
	
	@Override
	public String toString() {
		return "Employee [employee_id=" + employeeId + ", semesterNumber=" + semesterNumber
				+ ", subjectsInSpringSemester=" + subjectsInSpringSemester + ", subjectsInAutumnSemester="
				+ subjectsInAutumnSemester + ", specialAddValue=" + specialAddValue + ", functionsAddValue="
				+ functionsAddValue + ", name=" + name + ", lastname=" + lastname + ", faculty=" + faculty
				+ ", bankAccount=" + bankAccount + ", email=" + email + ", teachingPosition=" + teachingPosition
				+ ", employmentPercentage=" + employmentPercentage + ", subjectNumber=" + subjectNumber + ", kbp=" + kbp
				+ ", kro=" + kro + ", kt=" + kt + ", kpr=" + kpr + ", isumHoursAutumn=" + isumHoursAutumn
				+ ", isumHoursSpring=" + isumHoursSpring + ", isumMoneySpring=" + isumMoneySpring + ", isumMoneyAutumn="
				+ isumMoneyAutumn + "]";
	}
}
