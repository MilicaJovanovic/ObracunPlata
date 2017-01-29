/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import java.util.List;
import com.milica.entities.SubjectMark;

/**
 *
 * @author Milica
 */
public interface SubjectMarkDao {
    public List<SubjectMark> getSubjectMarks();
    public SubjectMark getSubjectMarkById(int id);
    public void editSubjectMark(SubjectMark user);
    public SubjectMark addSubjectMark(SubjectMark subjectMark);
    public int getCountSubjectMarks();
    public void deleteSubjectMark(SubjectMark subjectMark);
}
