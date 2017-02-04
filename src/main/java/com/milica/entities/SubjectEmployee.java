package com.milica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "subject_employee"
 * @author Milica
 */
@Entity
@Table(name="subject_employee")
public class SubjectEmployee {

	private int subjectEmployeeId;
	private Employee employeeId;
	private Subject subjectId;
	
	@Id
	@GeneratedValue
	@Column(name="subject_employee_id")
	public int getSubjectEmployeeId() {
		return subjectEmployeeId;
	}
	public void setSubjectEmployeeId(int subjectEmployeeId) {
		this.subjectEmployeeId = subjectEmployeeId;
	}
	
	@JoinColumn(name="employee_id", referencedColumnName="employee_id")
	@ManyToOne
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	
	@JoinColumn(name="subject_id", referencedColumnName="subject_id")
	@ManyToOne
	public Subject getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}
	
	@Override
	public String toString() {
		return "SubjectEmployee [subjectEmployeeId=" + subjectEmployeeId + ", employeeId=" + employeeId + ", subjectId="
				+ subjectId + "]";
	}
	
}
