/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import java.util.List;
import com.milica.entities.Subject;

/**
 *
 * @author Milica
 */
public interface SubjectDao {
    public List<Subject> getSubjects();
    public Subject getSubjectById(int id);
    public void editSubject(Subject subject);
    public Subject addSubject(Subject subject);
    public int getCountSubjects();
    public void deleteSubject(Subject subject);
}
