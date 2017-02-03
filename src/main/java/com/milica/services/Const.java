/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

/**
 *
 * @author Milica
 */
public class Const {
    public static final String IZVESTAJ_FILE = "izvestaj.xlsx";

    public static final String CURRENT_FILE = "C:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/current.xlsx";
    public static final String SIMPLE_CURRENT_FILE = "simple_current.xlsx";
    public static final String TEMPLATE_FILE = "C:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/template.xlsx";
    public static final String SIMPLE_TEMPLATE_FILE = "simple_template.xlsx";

    public static final String ISUM_SERVICE = "https://isum.metropolitan.ac.rs/rest/listaprofesora/mock";
    // public static final String ISUM_SERVICE = "http://192.168.64.128:8080/core/rest/listaprofesora/real";

    public static final String USER_SERVICE = "https://isum.metropolitan.ac.rs/rest/userservice/";
    //public static final String USER_SERVICE = "http://192.168.200.147:8080/coreFinansije/rest/userservice/";

    public static final String SKOLSKA_GODINA = "2016-2017";
    public static final String TRENUTNI_SEMESTAR =  "J";

    public static final String FIT = "FIT";
    public static final String FAM = "FAM";
    public static final String FDU = "FDU";

    public static final String FAKULTET_INFORMACIONIH_TEHNOLOGIJA = "Fakultet informacionih tehnologija";
    public static final String FAKULTET_DIGITALNIH_UMETNOSTI = "Fakultet digitalnih umetnosti";
    public static final String FAKULTET_ZA_MENADZMENT = "Fakultet za menadžment";

    public static final String RO = "RO";
    public static final String HO = "HO";

    public static final String OZ = "OZ";
    public static final String AH = "AH";


    public static final String OSNOVNA_ZARADA = "Osnovna zarada";
    public static final String AUTORSKI_HONORAR = "Autorski honorar";

    public static final String RADNI_ODNOS = "Radni odnos";
    public static final String HONORARNI_ODNOS = "Honorarni odnos";
    public static final String HONORARNO_ANGAZOVANJE = "Honorarno angažovanje";


    public static final String ISPLATE = "isplate";
    public static final String MDITA = "mDita/statistikaProfesori/";

    public static final String PLATA_JESENJI = "G3";
    public static final String PLATA_PROLECNI = "G4";
    public static final String PLATA_HONORARCI_JESENJI = "G3";
    public static final String PLATA_HONORARCI_PROLECNI = "G4";

    public static final String PLATA_JESENJI_AUTORSKI_HONORAR = "H3";
    public static final String PLATA_PROLECNI_AUTORSKI_HONORAR = "H4";
    public static final String PLATA_HONORARCI_JESENJI_AUTORSKI_HONORAR = "H3";
    public static final String PLATA_HONORARCI_PROLECNI_AUTORSKI_HONORAR = "H4";

    public static final String PROCENAT_PLATA_JESENJI = "J3";
    public static final String PROCENAT_PLATA_PROLECNI = "J4";
    public static final String PROCENAT_PLATA_JESENJI_AUTORSKI_HONORAR = "K3";
    public static final String PROCENAT_PLATA_PROLECNI_AUTORSKI_HONORAR = "K4";

    public static final String SEMESTAR_JESENJI = "J",
                                                            SEMESTAR_PROLECNI = "P";

    public static final String SEMESTAR_JESENJI_TEKST = "Jesenji semestar",
                                                       SEMESTAR_PROLECNI_TEKST = "Prolećni semestar";

    public static final String[] LISTA_SKOLSKIH_GODINA = {"2014-2015", "2015-2016", "2016-2017"};


    public static final String[][] VALIDNE_VREDNOSTI = {{"Zvanje", "Ostali"}, {"Zvanje", "Asistent"},
    {"Zvanje", "Predavač"}, {"Zvanje", "Docent"}, {"Zvanje", "Vanr. profesor"}, {"Zvanje", "Red. profesor"},
    {"KBP", "0.5"}, {"KBP", "0.75"}, {"KBP", "1.0"}, {"KT", "1.0"}, {"KT", "1.10"}, {"KT", "1.20"},
    {"KPR", "0.9"}, {"KPR", "1"}, {"KPR", "1.10"}};
}
