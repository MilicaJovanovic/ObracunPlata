package com.milica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milica.dao.MDitaDao;
import com.milica.entities.MDita;

@Controller
@RequestMapping("/mdita")
public class MDitaController {

	@Autowired
	private MDitaDao mditaDao;
	
	@RequestMapping(value="/addmdita", method=RequestMethod.GET)
	public boolean addMDita(MDita mDita) {
		return mditaDao.addMDita(mDita);
	}
	
	@RequestMapping(value="/editmdita", method=RequestMethod.GET)
	public boolean editMDita(MDita mDita) {
		return mditaDao.editMDita(mDita);
	}

	@RequestMapping(value="/deletemdita", method=RequestMethod.GET)
	public boolean deleteMDita(MDita mDita) {
		return mditaDao.deleteMDita(mDita);
	}
	
	@RequestMapping(value="/getmditabyid", method=RequestMethod.GET)
	public MDita getMDitaById(int id) {
		return mditaDao.getMDitaById(id);
	}
	
	@RequestMapping(value="/getmditas", method=RequestMethod.GET)
	public List<MDita> getMDitas() {
		return mditaDao.getMDitas();
	}
	
	@RequestMapping(value="/getcountmditas", method=RequestMethod.GET)
	public int getCountMDitas() {
		return mditaDao.getCountMDitas();
	}
}
