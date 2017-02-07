/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

import com.milica.entities.Employee;
import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Milica
 */
public class DataUpdate {

    private List<Employee> employeeList;
    private List<Subject> subjectEmployeeList;
    private List<PartTimeEmployee> partTimeEmployeeList;
    private List<Subject> subjectEmployeePartTimeList;
    private List<PairTransporterEmployee> transporters;
    
    public void getDataFromIsum() throws IOException {
        employeeList = new ArrayList<>();
        subjectEmployeeList = new ArrayList<>();
        partTimeEmployeeList = new ArrayList<>();
        subjectEmployeePartTimeList = new ArrayList<>();
        transporters = new ArrayList<>();
        System.err.println("Poziva se metoda");
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(Const.ISUM_SERVICE);

        HttpResponse response = httpclient.execute(httppost);

        String json = EntityUtils.toString(response.getEntity());

        JSONArray temp = new JSONArray(json);

        for (int i = 0; i < temp.length(); i++) {
            JSONObject obj = temp.getJSONObject(i);
            JsonParser jsonParser = new JsonParser();
            if (obj.get("employmentType").equals("Radni odnos")) {
                Employee createdEmployee = jsonParser.employeeFromNode(obj);
                employeeList.add(createdEmployee);
                subjectEmployeeList.addAll(jsonParser.returnSubjectEmployee());
            } else if (obj.get("employmentType").equals("Honorarni odnos")) {
                PartTimeEmployee createdPartTimeEmployee = jsonParser.partTimeEmployeeFromNode(obj);
                partTimeEmployeeList.add(createdPartTimeEmployee);
                subjectEmployeePartTimeList.addAll(jsonParser.returnSujbectListPartTime());
            }
        }
    }
    
    public List<Employee> returnEmployeeList() {
        return employeeList;
    }
    public List<Subject> returnSubjectEmplyeeList() {
        return subjectEmployeeList;
    }
    public List<PartTimeEmployee> returnPartTimeEmployeeList() {
        return partTimeEmployeeList;
    }
    public List<Subject> returnSubjectEmployeePartTimeList() {
        return subjectEmployeePartTimeList;
    }
    public List<PairTransporterEmployee> returnTransporterList() {
        return transporters;
    }
}
