/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Milica
 */
public class ExcelGenerator {
    public static void emptyWorkbook(Workbook workbook) {
        while(workbook.getNumberOfSheets() != 0) {
            workbook.removeSheetAt(workbook.getNumberOfSheets() - 1);
        }
    }
    
    public static String fixText(String received) {
      return received.replaceAll("\"", "");
    }  
    
//    public void createSheets() throws Exception {
//        Promise<WSResponse> response = WS.url(Const.ISUM_SERVICE).setHeader("Content-Type","application/json").post("");
//        WSResponse respon = response.get(36000000);
//
//        XSSFWorkbook workbookTemplate = new XSSFWorkbook(new File(Const.TEMPLATE_FILE));
//
//        FileInputStream fileInputStream = new FileInputStream(new File(Const.CURRENT_FILE));
//        XSSFWorkbook workbookCurrent = new XSSFWorkbook(fileInputStream);
//
//        emptyWorkbook(workbookCurrent);
//
//        Sheet first = null;
//        Sheet second = null;
//
//        for (JsonNode jsonNodePerson : respon.asJson()) {
//            String type = fixText(jsonNodePerson.get("employmentType").toString());
//
//            String faculty = "";
//            if (fixText(jsonNodePerson.get("faculty").toString()).equals(Const.FAKULTET_INFORMACIONIH_TEHNOLOGIJA)) {
//                faculty = Const.FIT;
//            } else if (fixText(jsonNodePerson.get("faculty").toString()).equals(Const.FAKULTET_DIGITALNIH_UMETNOSTI)) {
//                faculty = Const.FDU;
//            } else if (fixText(jsonNodePerson.get("faculty").toString()).equals(Const.FAKULTET_ZA_MENADZMENT)) {
//                faculty = Const.FAM;
//            }
//
//            JsonNode jsonNodeAllClasses = jsonNodePerson.get("classes");
//            if (type.equals(Const.RADNI_ODNOS)) {
//                Employee employee = JsonParsing.employeeFromNode(jsonNodePerson);
//                String lastname = employee.getLastname();
//                if (employee.getLastname().length() > 10) {
//                  lastname = employee.getLastname().substring(0, 10);
//                }
//                String name = employee.getName().substring(0, 1);
//                if (employee.getTeachingPosition().equals("Redovni profesor") || employee.getTeachingPosition().equals("Vanredni profesor") || employee.getTeachingPosition().equals("Docent")) {
//                  first = workbookTemplate.cloneSheet(3);
//                  workbookTemplate.setSheetName(workbookTemplate.getSheetIndex(first),  employee.getId() + "^" + faculty + "^RO^N^" + employee.getName() + " " + employee.getLastname());
//                  fillEmployeeSheet(first, employee);
//                } else {
//                    first = workbookTemplate.cloneSheet(4);
//                    workbookTemplate.setSheetName(workbookTemplate.getSheetIndex(first), employee.getId() + "^" + faculty + "^RO^S^" + employee.getName() + " " + employee.getLastname());
//                    fillEmployeeSheetCoworkers(first, employee);
//                }
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookTemplate);
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookCurrent);
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookTemplate);
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookCurrent);
//            } else if (type.equals(Const.HONORARNI_ODNOS)) {
//                PartTimeEmployee partTimeEmployee = JsonParsing.partTimeEmployeeFromNode(jsonNodePerson);
//                String lastname = partTimeEmployee.getLastname();
//                if (partTimeEmployee.getLastname().length() > 10) {
//                  lastname = partTimeEmployee.getLastname().substring(0, 10);
//                }
//                String name = partTimeEmployee.getName().substring(0, 1);
//                if (partTimeEmployee.getTeachingPosition().equals("Redovni profesor") || partTimeEmployee.getTeachingPosition().equals("Vanredni profesor") || partTimeEmployee.getTeachingPosition().equals("Docent")) {
//                  first = workbookTemplate.cloneSheet(5);
//                  workbookTemplate.setSheetName(workbookTemplate.getSheetIndex(first),  partTimeEmployee.getId() + "^" + faculty + "^HO^N^" + partTimeEmployee.getName() + " " + partTimeEmployee.getLastname());
//                  fillPartTimeEmployeeSheet(first, partTimeEmployee);
//                } else {
//                    first = workbookTemplate.cloneSheet(6);
//                    workbookTemplate.setSheetName(workbookTemplate.getSheetIndex(first), partTimeEmployee.getId() + "^" + faculty + "^HO^S^" + partTimeEmployee.getName() + " " + partTimeEmployee.getLastname());
//                    fillPartTimeEmployeeSheetCoworkers(first, partTimeEmployee);
//                }
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookTemplate);
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookCurrent);
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookTemplate);
//                XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookCurrent);
//               
//            }
//        }
//
//        workbookTemplate.removeSheetAt(6);
//        workbookTemplate.removeSheetAt(5);
//        workbookTemplate.removeSheetAt(4);
//        workbookTemplate.removeSheetAt(3);
//        workbookTemplate.removeSheetAt(0);
//
//        fileInputStream.close();
//        FileOutputStream fileOutputStream = new FileOutputStream(new File(Const.CURRENT_FILE));
//        workbookTemplate.write(fileOutputStream);
//        fileOutputStream.close();
//    }
}
