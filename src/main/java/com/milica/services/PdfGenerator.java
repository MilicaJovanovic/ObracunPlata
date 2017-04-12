package com.milica.services;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.milica.dto.Person;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.mail.MessagingException;

/**
 *
 * @author Milica
 */
public class PdfGenerator {
    private static final Font CAT_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
    private static final Font SUB_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);

    public static void generatePdf(java.util.List<Person> employees, String semester) throws MessagingException {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(date);
        String file = "c:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/izvestaji/ObracunPlataIzvestaj" + today + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document, employees, semester);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
        }
    }
    
    private static void addMetaData(Document document) {
        document.addTitle("Obracun plata");
        document.addAuthor("Milica Jovanovic");
        document.addCreator("Milica JOvanovic");
    }

    private static void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Izvestaj o obracunu plata", CAT_FONT));

        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Izvestaj je kreirao/la: " + System.getProperty("user.name"), SUB_FONT));
        
        addEmptyLine(preface, 3);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(date);
        preface.add(new Paragraph("Izvestaj je kreiran na dan: " + today, SUB_FONT));

        document.add(preface);
        document.newPage();
    }

    private static void addContent(Document document, java.util.List<Person> employees, String semester) throws DocumentException {
        Anchor anchor = new Anchor("Izvestaj", CAT_FONT);
        anchor.setName("Izvestaj");

        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Spisak zaposlenih", SUB_FONT);
        addEmptyLine(subPara, 2);
        Section subCatPart = catPart.addSection(subPara);

        createTable(subCatPart, employees, semester);

        document.add(catPart);
    }

    private static void createTable(Section subCatPart, java.util.List<Person> employees, String semester) throws BadElementException {
        PdfPTable table = new PdfPTable(6);

        table.setWidthPercentage(100);

        PdfPCell c1 = new PdfPCell(new Phrase("Ime"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Prezime"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Tip zaposlenja"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Fakultet"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Osnovna zarada"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Autorski honorar"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        for (Person person : employees) {
            table.addCell(person.getName());
            table.addCell(person.getLastname());
            table.addCell(person.getEmploymentType());
            table.addCell(person.getFaculty());
            if (semester.equals("A")) {
                table.addCell(person.getSalaryNetoA() + "");
                table.addCell(person.getAuthorFeeNetoA() + "");   
            } else {
                table.addCell(person.getSalaryNetoS() + "");
                table.addCell(person.getAuthorFeeNetoS() + "");   
            }
            
        }
        
        subCatPart.add(table);
    }
    
    public static void generateSeparatePdf(Person person, String semester) throws MessagingException {
        String SEPARATE_FILE = "c:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/obracuni/" + person.getName() + person.getLastname() + ".pdf";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(SEPARATE_FILE));
            document.open();
            addSeparateMetaData(document);
            addSeparateTitlePage(document);
            addSeparateContent(document, person, semester);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("GRESKA PRI GENERISANJU FAJLOVA");
            e.printStackTrace();
        }
    }
    
    private static void addSeparateMetaData(Document document) {
        document.addTitle("Obracun plata");
        document.addAuthor("Milica Jovanovic");
        document.addCreator("Milica JOvanovic");
    }

    private static void addSeparateTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Obracun za isplatu plate", CAT_FONT));
        
        addEmptyLine(preface, 3);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(date);
        preface.add(new Paragraph("Isplata plata izvrsena je na dan: " + today, SUB_FONT));
        
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Izvestaj je kreirao/la: " + System.getProperty("user.name"), SUB_FONT));

        document.add(preface);
        document.newPage();
    }

    private static void addSeparateContent(Document document, Person person, String semester) throws DocumentException {
        Anchor anchor = new Anchor("Obracun", CAT_FONT);
        anchor.setName("Obracun");

        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Obracun o isplacenoj plati", SUB_FONT);
        addEmptyLine(subPara, 2);
        
        subPara.add(new Paragraph("Ime i prezime: " + person.getName() + " " + person.getLastname(), SUB_FONT));
        subPara.add(new Paragraph("Tip zaposlenja: " + person.getEmploymentType(), SUB_FONT));
        subPara.add(new Paragraph("Fakutet: " + person.getFaculty(), SUB_FONT));
        String semesterPayment = "";
        if (semester.equals("A")) {
            subPara.add(new Paragraph("Isplacena osnovna zarada: " + person.getSalaryNetoA(), SUB_FONT));
            subPara.add(new Paragraph("Isplacen autorski honorar: " + person.getAuthorFeeNetoA(), SUB_FONT));
            semesterPayment = "jesenji semestar";
        } else {
            subPara.add(new Paragraph("Isplacena osnovna zarada: " + person.getSalaryNetoS(), SUB_FONT));
            subPara.add(new Paragraph("Isplacen autorski honorar: " + person.getAuthorFeeNetoS(), SUB_FONT)); 
            semesterPayment = "prolecni semestar";
        }
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(date);
        subPara.add(new Paragraph("Datum isplate: " + today, SUB_FONT));
        subPara.add("Isplata za semestar: " + semesterPayment);
        
        
        Section subCatPart = catPart.addSection(subPara);

        document.add(catPart);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
