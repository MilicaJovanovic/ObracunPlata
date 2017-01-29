/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Milica
 */
@Entity
@Table(name="subject_mark")
public class SubjectMark {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "subject_mark_id")
    private int subjectMarkId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "value")
    private double value;
    
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne
    private Subject subjectId;

    public SubjectMark(int id, String name, double value) {
        this.subjectMarkId = id;
        this.name = name;
        this.value = value;
    }

    public int getSubjectMarkId() {
        return subjectMarkId;
    }

    public void setSubjectMarkId(int subjectMarkId) {
        this.subjectMarkId = subjectMarkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SubjectMark{" + "id=" + subjectMarkId + ", name=" + name + ", value=" + value + '}';
    }
}
