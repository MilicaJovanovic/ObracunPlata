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
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subjectId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "semester")
    private String semester;
    
    @Column(name = "code")
    private String code;
   
    @Column(name = "class_number")
    private int classNumber;
    
    @Column(name = "group_exercise_number")
    private int groupExerciseNumber;
    
    @Column(name = "individual_exercise_number")
    private int individualExcerciseNumber;
    
    @Column(name = "espb")
    private int espb;
    
    @Column(name = "groups_number")
    private int groupsNumber;
    
    @Column(name = "change_percetnage")
    private double changePersentage;
    
    @Column(name = "proc1")
    private double proc1;
    
    @Column(name = "proc2")
    private double proc2;
    
    @Column(name = "proc3")
    private double proc3;
    
    @Column(name = "proc4")
    private double proc4;
    
    @Column(name = "proc5")
    private double proc5;
    
    @Column(name = "proc6")
    private double proc6;
    
    @Column(name = "proc7")
    private double proc7;
    
    @Column(name = "proc8")
    private double proc8;
    
    @Column(name = "proc9")
    private double proc9;
    
    @Column(name = "proc10")
    private double proc10;
    
    @Column(name = "proc11")
    private double proc11;
    
    @Column(name = "proc12")
    private double proc12;
    
    @Column(name = "proc13")
    private double proc13;
    
    @Column(name = "proc14")
    private double proc14;
    
    @Column(name = "proc15")
    private double proc15;
    
    @Column(name = "words_number")
    private double wordsNumber;
    
    @Column(name = "fee")
    private double fee;
    
    @Column(name = "fpm")
    private double fpm;
    
    @Column(name = "fob")
    private double fob;
    
    @Column(name = "fin1")
    private double fin1;
    
    @Column(name = "fin2")
    private double fin2;
    
    @Column(name = "fmm")
    private double fmm;
    
    @Column(name = "fkv")
    private double fkv;
    
    @OneToMany(mappedBy="subjectId", cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SubjectMark> subjectMarkList;

    @JoinColumn(name="employee_id", referencedColumnName="employee_id")
    @ManyToOne
    private Employee employeeId;
    
    @JoinColumn(name = "part_time_employee_id", referencedColumnName = "part_time_employee_id")
    @ManyToOne
    private PartTimeEmployee partTimeEmployeeId;

    public Subject(int id, String name, String location, String type, String semester, String code, int classNumber, int groupExerciseNumber, int individualExcerciseNumber, int espb, int groupsNumber, double changePersentage, double proc1, double proc2, double proc3, double proc4, double proc5, double proc6, double proc7, double proc8, double proc9, double proc10, double proc11, double proc12, double proc13, double proc14, double proc15, double wordsNumber, double fee, double fpm, double fob, double fin1, double fin2, double fmm, double fkv, List<SubjectMark> subjectMarkList) {
        this.subjectId = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.semester = semester;
        this.code = code;
        this.classNumber = classNumber;
        this.groupExerciseNumber = groupExerciseNumber;
        this.individualExcerciseNumber = individualExcerciseNumber;
        this.espb = espb;
        this.groupsNumber = groupsNumber;
        this.changePersentage = changePersentage;
        this.proc1 = proc1;
        this.proc2 = proc2;
        this.proc3 = proc3;
        this.proc4 = proc4;
        this.proc5 = proc5;
        this.proc6 = proc6;
        this.proc7 = proc7;
        this.proc8 = proc8;
        this.proc9 = proc9;
        this.proc10 = proc10;
        this.proc11 = proc11;
        this.proc12 = proc12;
        this.proc13 = proc13;
        this.proc14 = proc14;
        this.proc15 = proc15;
        this.wordsNumber = wordsNumber;
        this.fee = fee;
        this.fpm = fpm;
        this.fob = fob;
        this.fin1 = fin1;
        this.fin2 = fin2;
        this.fmm = fmm;
        this.fkv = fkv;
        this.subjectMarkList = subjectMarkList;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public double getGroupExerciseNumber() {
        return groupExerciseNumber;
    }

    public void setGroupExerciseNumber(int groupExerciseNumber) {
        this.groupExerciseNumber = groupExerciseNumber;
    }

    public double getIndividualExcerciseNumber() {
        return individualExcerciseNumber;
    }

    public void setIndividualExcerciseNumber(int individualExcerciseNumber) {
        this.individualExcerciseNumber = individualExcerciseNumber;
    }

    public double getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public double getGroupsNumber() {
        return groupsNumber;
    }

    public void setGroupsNumber(int groupsNumber) {
        this.groupsNumber = groupsNumber;
    }

    public double getChangePersentage() {
        return changePersentage;
    }

    public void setChangePersentage(double changePersentage) {
        this.changePersentage = changePersentage;
    }

    public double getProc1() {
        return proc1;
    }

    public void setProc1(double proc1) {
        this.proc1 = proc1;
    }

    public double getProc2() {
        return proc2;
    }

    public void setProc2(double proc2) {
        this.proc2 = proc2;
    }

    public double getProc3() {
        return proc3;
    }

    public void setProc3(double proc3) {
        this.proc3 = proc3;
    }

    public double getProc4() {
        return proc4;
    }

    public void setProc4(double proc4) {
        this.proc4 = proc4;
    }

    public double getProc5() {
        return proc5;
    }

    public void setProc5(double proc5) {
        this.proc5 = proc5;
    }

    public double getProc6() {
        return proc6;
    }

    public void setProc6(double proc6) {
        this.proc6 = proc6;
    }

    public double getProc7() {
        return proc7;
    }

    public void setProc7(double proc7) {
        this.proc7 = proc7;
    }

    public double getProc8() {
        return proc8;
    }

    public void setProc8(double proc8) {
        this.proc8 = proc8;
    }

    public double getProc9() {
        return proc9;
    }

    public void setProc9(double proc9) {
        this.proc9 = proc9;
    }

    public double getProc10() {
        return proc10;
    }

    public void setProc10(double proc10) {
        this.proc10 = proc10;
    }

    public double getProc11() {
        return proc11;
    }

    public void setProc11(double proc11) {
        this.proc11 = proc11;
    }

    public double getProc12() {
        return proc12;
    }

    public void setProc12(double proc12) {
        this.proc12 = proc12;
    }

    public double getProc13() {
        return proc13;
    }

    public void setProc13(double proc13) {
        this.proc13 = proc13;
    }

    public double getProc14() {
        return proc14;
    }

    public void setProc14(double proc14) {
        this.proc14 = proc14;
    }

    public double getProc15() {
        return proc15;
    }

    public void setProc15(double proc15) {
        this.proc15 = proc15;
    }

    public double getWordsNumber() {
        return wordsNumber;
    }

    public void setWordsNumber(double wordsNumber) {
        this.wordsNumber = wordsNumber;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFpm() {
        return fpm;
    }

    public void setFpm(double fpm) {
        this.fpm = fpm;
    }

    public double getFob() {
        return fob;
    }

    public void setFob(double fob) {
        this.fob = fob;
    }

    public double getFin1() {
        return fin1;
    }

    public void setFin1(double fin1) {
        this.fin1 = fin1;
    }

    public double getFin2() {
        return fin2;
    }

    public void setFin2(double fin2) {
        this.fin2 = fin2;
    }

    public double getFmm() {
        return fmm;
    }

    public void setFmm(double fmm) {
        this.fmm = fmm;
    }

    public double getFkv() {
        return fkv;
    }

    public void setFkv(double fkv) {
        this.fkv = fkv;
    }

    public List<SubjectMark> getSubjectMarkList() {
        return subjectMarkList;
    }

    public void setSubjectMarkList(List<SubjectMark> subjectMarkList) {
        this.subjectMarkList = subjectMarkList;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + subjectId + ", name=" + name + ", location=" + location + ", type=" + type + ", semester=" + semester + ", code=" + code + ", classNumber=" + classNumber + ", groupExerciseNumber=" + groupExerciseNumber + ", individualExcerciseNumber=" + individualExcerciseNumber + ", espb=" + espb + ", groupsNumber=" + groupsNumber + ", changePersentage=" + changePersentage + ", proc1=" + proc1 + ", proc2=" + proc2 + ", proc3=" + proc3 + ", proc4=" + proc4 + ", proc5=" + proc5 + ", proc6=" + proc6 + ", proc7=" + proc7 + ", proc8=" + proc8 + ", proc9=" + proc9 + ", proc10=" + proc10 + ", proc11=" + proc11 + ", proc12=" + proc12 + ", proc13=" + proc13 + ", proc14=" + proc14 + ", proc15=" + proc15 + ", wordsNumber=" + wordsNumber + ", fee=" + fee + ", fpm=" + fpm + ", fob=" + fob + ", fin1=" + fin1 + ", fin2=" + fin2 + ", fmm=" + fmm + ", fkv=" + fkv + ", subjectMarkList=" + subjectMarkList + '}';
    }
}
