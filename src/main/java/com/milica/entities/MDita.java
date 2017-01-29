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
import javax.persistence.Table;

/**
 *
 * @author Milica
 */
@Entity
@Table(name="mdita")
public class MDita {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "broj_reci")
    private double brojReci;
    
    @Column(name = "broj_objekata_ucenja")
    private double brojObjekataUcenja;
    
    @Column(name = "assesment")
    private double assesment;
    
    @Column(name = "multiple_choice")
    private double multipleChoice;
    
    @Column(name = "question_and_answers")
    private double questionsAndAnswers;
    
    @Column(name = "java_grader")
    private double javaGrader;
    
    @Column(name = "forum")
    private double forum;
    
    @Column(name = "noticeboard")
    private double noticeboard;
    
    @Column(name = "notebook")
    private double notebook;
    
    @Column(name = "chat")
    private double chat;
    
    @Column(name = "submit_files")
    private double submitFiles;
    
    @Column(name = "shared_resources")
    private double sharedResources;
    
    @Column(name = "picture_gallery")
    private double pictureGallery;
    
    @Column(name = "video")
    private double video;
    
    @Column(name = "audio")
    private double audio;

    public MDita(int id, double brojReci, double brojObjekataUcenja, double assesment, double multipleChoice, double questionsAndAnswers, double javaGrader, double forum, double noticeboard, double notebook, double chat, double submitFiles, double sharedResources, double pictureGallery, double video, double audio) {
        this.id = id;
        this.brojReci = brojReci;
        this.brojObjekataUcenja = brojObjekataUcenja;
        this.assesment = assesment;
        this.multipleChoice = multipleChoice;
        this.questionsAndAnswers = questionsAndAnswers;
        this.javaGrader = javaGrader;
        this.forum = forum;
        this.noticeboard = noticeboard;
        this.notebook = notebook;
        this.chat = chat;
        this.submitFiles = submitFiles;
        this.sharedResources = sharedResources;
        this.pictureGallery = pictureGallery;
        this.video = video;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBrojReci() {
        return brojReci;
    }

    public void setBrojReci(double brojReci) {
        this.brojReci = brojReci;
    }

    public double getBrojObjekataUcenja() {
        return brojObjekataUcenja;
    }

    public void setBrojObjekataUcenja(double brojObjekataUcenja) {
        this.brojObjekataUcenja = brojObjekataUcenja;
    }

    public double getAssesment() {
        return assesment;
    }

    public void setAssesment(double assesment) {
        this.assesment = assesment;
    }

    public double getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(double multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public double getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(double questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public double getJavaGrader() {
        return javaGrader;
    }

    public void setJavaGrader(double javaGrader) {
        this.javaGrader = javaGrader;
    }

    public double getForum() {
        return forum;
    }

    public void setForum(double forum) {
        this.forum = forum;
    }

    public double getNoticeboard() {
        return noticeboard;
    }

    public void setNoticeboard(double noticeboard) {
        this.noticeboard = noticeboard;
    }

    public double getNotebook() {
        return notebook;
    }

    public void setNotebook(double notebook) {
        this.notebook = notebook;
    }

    public double getChat() {
        return chat;
    }

    public void setChat(double chat) {
        this.chat = chat;
    }

    public double getSubmitFiles() {
        return submitFiles;
    }

    public void setSubmitFiles(double submitFiles) {
        this.submitFiles = submitFiles;
    }

    public double getSharedResources() {
        return sharedResources;
    }

    public void setSharedResources(double sharedResources) {
        this.sharedResources = sharedResources;
    }

    public double getPictureGallery() {
        return pictureGallery;
    }

    public void setPictureGallery(double pictureGallery) {
        this.pictureGallery = pictureGallery;
    }

    public double getVideo() {
        return video;
    }

    public void setVideo(double video) {
        this.video = video;
    }

    public double getAudio() {
        return audio;
    }

    public void setAudio(double audio) {
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "MDita{" + "id=" + id + ", brojReci=" + brojReci + ", brojObjekataUcenja=" + brojObjekataUcenja + ", assesment=" + assesment + ", multipleChoice=" + multipleChoice + ", questionsAndAnswers=" + questionsAndAnswers + ", javaGrader=" + javaGrader + ", forum=" + forum + ", noticeboard=" + noticeboard + ", notebook=" + notebook + ", chat=" + chat + ", submitFiles=" + submitFiles + ", sharedResources=" + sharedResources + ", pictureGallery=" + pictureGallery + ", video=" + video + ", audio=" + audio + '}';
    }
}
