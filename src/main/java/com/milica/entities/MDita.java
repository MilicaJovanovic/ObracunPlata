package com.milica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "mdita"
 * @author Milica
 */
@Entity
@Table(name="mdita")
public class MDita {
    
    private int mditaId;
    private double brojReci;
    private double brojObjekataUcenja;
    private double assesment;
    private double multipleChoice;
    private double questionsAndAnswers;
    private double javaGrader;
    private double forum;
    private double noticeboard;
    private double notebook;
    private double chat;
    private double submitFiles;   
    private double sharedResources;
    private double pictureGallery;
    private double video;
    private double audio;

    @Id
    @GeneratedValue()
    @Column(name="mditaId")
    public int getMditaId() {
        return mditaId;
    }
    public void setMditaId(int mditaId) {
        this.mditaId = mditaId;
    }

    @Column(name="broj_reci")
    public double getBrojReci() {
        return brojReci;
    }
    public void setBrojReci(double brojReci) {
        this.brojReci = brojReci;
    }

    @Column(name = "broj_objekata_ucenja")
    public double getBrojObjekataUcenja() {
        return brojObjekataUcenja;
    }
    public void setBrojObjekataUcenja(double brojObjekataUcenja) {
        this.brojObjekataUcenja = brojObjekataUcenja;
    }

    @Column(name = "assesment")
    public double getAssesment() {
        return assesment;
    }
    public void setAssesment(double assesment) {
        this.assesment = assesment;
    }

    @Column(name = "multiple_choice")
    public double getMultipleChoice() {
        return multipleChoice;
    }
    public void setMultipleChoice(double multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    @Column(name = "question_and_answers")
    public double getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }
    public void setQuestionsAndAnswers(double questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    @Column(name = "java_grader")
    public double getJavaGrader() {
        return javaGrader;
    }
    public void setJavaGrader(double javaGrader) {
        this.javaGrader = javaGrader;
    }

    @Column(name = "forum")
    public double getForum() {
        return forum;
    }
    public void setForum(double forum) {
        this.forum = forum;
    }

    @Column(name = "noticeboard")
    public double getNoticeboard() {
        return noticeboard;
    }
    public void setNoticeboard(double noticeboard) {
        this.noticeboard = noticeboard;
    }

    @Column(name = "notebook")
    public double getNotebook() {
        return notebook;
    }
    public void setNotebook(double notebook) {
        this.notebook = notebook;
    }

    @Column(name = "chat")
    public double getChat() {
        return chat;
    }
    public void setChat(double chat) {
        this.chat = chat;
    }

    @Column(name = "submit_files")
    public double getSubmitFiles() {
        return submitFiles;
    }
    public void setSubmitFiles(double submitFiles) {
        this.submitFiles = submitFiles;
    }

    @Column(name = "shared_resources")
    public double getSharedResources() {
        return sharedResources;
    }
    public void setSharedResources(double sharedResources) {
        this.sharedResources = sharedResources;
    }

    @Column(name = "picture_gallery")
    public double getPictureGallery() {
        return pictureGallery;
    }
    public void setPictureGallery(double pictureGallery) {
        this.pictureGallery = pictureGallery;
    }

    @Column(name = "video")
    public double getVideo() {
        return video;
    }
    public void setVideo(double video) {
        this.video = video;
    }

    @Column(name = "audio")
    public double getAudio() {
        return audio;
    }
    public void setAudio(double audio) {
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "MDita{" + "id=" + mditaId + ", brojReci=" + brojReci + ", brojObjekataUcenja=" + brojObjekataUcenja + ", assesment=" + assesment + ", multipleChoice=" + multipleChoice + ", questionsAndAnswers=" + questionsAndAnswers + ", javaGrader=" + javaGrader + ", forum=" + forum + ", noticeboard=" + noticeboard + ", notebook=" + notebook + ", chat=" + chat + ", submitFiles=" + submitFiles + ", sharedResources=" + sharedResources + ", pictureGallery=" + pictureGallery + ", video=" + video + ", audio=" + audio + '}';
    }
}
