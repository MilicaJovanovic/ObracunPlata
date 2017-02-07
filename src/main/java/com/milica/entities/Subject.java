package com.milica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "subject"
 *
 * @author Milica
 */
@Entity
@Table(name = "subject")
public class Subject {

    private int subjectId;
    private String name;
    private String location;
    private String type;
    private String semester;
    private String code;
    private int classNumber;
    private int groupExerciseNumber;
    private int individualExcerciseNumber;
    private int espb;
    private int groupsNumber;
    private double wordsNumber;
    private double fpm;
    private double fob;
    private double fin1;
    private double fin2;
    private double fmm;
    private double fkv;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "class_number")
    public double getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Column(name = "group_exercise_number")
    public double getGroupExerciseNumber() {
        return groupExerciseNumber;
    }

    public void setGroupExerciseNumber(int groupExerciseNumber) {
        this.groupExerciseNumber = groupExerciseNumber;
    }

    @Column(name = "individual_exercise_number")
    public double getIndividualExcerciseNumber() {
        return individualExcerciseNumber;
    }

    public void setIndividualExcerciseNumber(int individualExcerciseNumber) {
        this.individualExcerciseNumber = individualExcerciseNumber;
    }

    @Column(name = "espb")
    public double getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    @Column(name = "groups_number")
    public double getGroupsNumber() {
        return groupsNumber;
    }

    public void setGroupsNumber(int groupsNumber) {
        this.groupsNumber = groupsNumber;
    }

    @Column(name = "words_number")
    public double getWordsNumber() {
        return wordsNumber;
    }

    public void setWordsNumber(double wordsNumber) {
        this.wordsNumber = wordsNumber;
    }

    @Column(name = "fpm")
    public double getFpm() {
        return fpm;
    }

    public void setFpm(double fpm) {
        this.fpm = fpm;
    }

    @Column(name = "fob")
    public double getFob() {
        return fob;
    }

    public void setFob(double fob) {
        this.fob = fob;
    }

    @Column(name = "fin1")
    public double getFin1() {
        return fin1;
    }

    public void setFin1(double fin1) {
        this.fin1 = fin1;
    }

    @Column(name = "fin2")
    public double getFin2() {
        return fin2;
    }

    public void setFin2(double fin2) {
        this.fin2 = fin2;
    }

    @Column(name = "fmm")
    public double getFmm() {
        return fmm;
    }

    public void setFmm(double fmm) {
        this.fmm = fmm;
    }

    @Column(name = "fkv")
    public double getFkv() {
        return fkv;
    }

    public void setFkv(double fkv) {
        this.fkv = fkv;
    }

    @Override
    public String toString() {
        return "Subject [subjectId=" + subjectId + ", name=" + name + ", location=" + location + ", type=" + type
                + ", semester=" + semester + ", code=" + code + ", classNumber=" + classNumber
                + ", groupExerciseNumber=" + groupExerciseNumber + ", individualExcerciseNumber="
                + individualExcerciseNumber + ", espb=" + espb + ", groupsNumber=" + groupsNumber + ", wordsNumber="
                + wordsNumber + ", fpm=" + fpm + ", fob=" + fob + ", fin1=" + fin1 + ", fin2=" + fin2 + ", fmm=" + fmm
                + ", fkv=" + fkv + "]";
    }
}
