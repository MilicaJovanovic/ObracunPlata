/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.controllers;

/**
 *
 * @author Milica
 */
import com.milica.services.ExcelGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
//        model.addAttribute("poruka", "Dobro dosli na sistem za obracun plata zaposlenih na Univerzitetu Metropolitan!");
        return "index";
    }
    
    @RequestMapping(value = "/dataUpdate", method = RequestMethod.GET)
    public String showUpdate(ModelMap model) {
        return "dataUpdate";
    } 
    
    @RequestMapping(value = "/currentPayment", method = RequestMethod.GET)
    public String showCurrentPayment(ModelMap model) {
        return "currentPayment";
    }
    
    @RequestMapping(value = "/grossPayment", method = RequestMethod.GET)
    public String showGrossPayment(ModelMap model) {
        return "grossPayment";
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistory(ModelMap model) {
        return "history";
    }
    
//    @RequestMapping(value = "dataUpdate/doUpdate", method = RequestMethod.GET)
//    public String doUpdate(ModelMap model) throws Exception {
//        System.out.println("Kliknuto dugme");
//        ExcelGenerator.createSheets();
//        return "dataUpdate";
//    }
    
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String handlePost(ModelMap m) throws Exception {
        System.out.println("Kliknuto dugme");
        ExcelGenerator.createSheets();
        return "history";
    }
}
