package com.milica.dao;

import java.util.List;
import com.milica.entities.MDita;

/**
 *
 * @author Milica
 */
public interface MDitaDao {
	public boolean addMDita(MDita mDita);
	public boolean editMDita(MDita mDita);
	public boolean deleteMDita(MDita mDita);
	public MDita getMDitaById(int id);
        public List<MDita> getMDitas();
        public int getCountMDitas();
    
}
