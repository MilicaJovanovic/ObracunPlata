package com.milica.services;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.milica.dto.Person;
import java.io.FileNotFoundException;

/**
 *
 * @author Milica
 */
public class PdfGenerator {
    private static final String FILE = "c:/temp/ObracunPlataIzvestaj.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public static void generatePdf(java.util.List<Person> employees) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document, employees);
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
        preface.add(new Paragraph("Izvestaj o obracunu plata", catFont));

        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Izvestaj je kreirao/la: " + System.getProperty("user.name"), subFont));
        
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Izvestaj je kreiran na dan: " + new Date(), subFont));

        document.add(preface);
        document.newPage();
    }

    private static void addContent(Document document, java.util.List<Person> employees) throws DocumentException {
        Anchor anchor = new Anchor("Izvestaj", catFont);
        anchor.setName("Izvestaj");

        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Spisak zaposlenih", subFont);
        addEmptyLine(subPara, 2);
        Section subCatPart = catPart.addSection(subPara);

        createTable(subCatPart, employees);

        document.add(catPart);
    }

    private static void createTable(Section subCatPart, java.util.List<Person> employees) throws BadElementException {
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
            table.addCell(person.getSalaryNeto() + "");
            table.addCell(person.getAuthorFeeNeto() + "");   
        }
        
        subCatPart.add(table);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
