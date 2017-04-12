package com.milica.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "subject_part_time_employee"
 * @author Milica
 */
@Entity
@Table(name="subject_part_time_employee")
public class SubjectPartTimeEmployee implements Serializable {

    private int subjectEmployeePartTimeId;
    private PartTimeEmployee partTimeEmployeeId;
    private Subject subjectId;

    @Id
    @GeneratedValue
    @Column(name="subject_part_time_employee_id")
    public int getSubjectEmployeePartTimeId() {
            return subjectEmployeePartTimeId;
    }
    public void setSubjectEmployeePartTimeId(int subjectEmployeePartTimeId) {
            this.subjectEmployeePartTimeId = subjectEmployeePartTimeId;
    }

    @JoinColumn(name="part_time_employee_id", referencedColumnName="part_time_employee_id")
    @ManyToOne
    public PartTimeEmployee getPartTimeEmployeeId() {
            return partTimeEmployeeId;
    }
    public void setPartTimeEmployeeId(PartTimeEmployee partTimeEmployeeId) {
            this.partTimeEmployeeId = partTimeEmployeeId;
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
            return "SubjectPartTimeEmployee [subjectEmployeePartTimeId=" + subjectEmployeePartTimeId
                            + ", partTimeEmployeeId=" + partTimeEmployeeId + ", subjectId=" + subjectId + "]";
    }
}
