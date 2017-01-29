/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import java.util.List;
import com.milica.entities.MDita;

/**
 *
 * @author Milica
 */
public interface MDitaDao {
    public List<MDita> getMDitas();
    public MDita getMDitaById(int id);
    public void editMDita(MDita mDita);
    public MDita addMDita(MDita mDita);
    public int getCountMDitas();
    public void deleteMDita(MDita mDita);
}
