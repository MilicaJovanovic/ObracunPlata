/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

import java.io.IOException;
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
    public static void getDataFromIsum() throws IOException {
        System.err.println("Poziva se metoda");
         HttpClient httpclient = new DefaultHttpClient();
         HttpPost httppost = new HttpPost(Const.ISUM_SERVICE);
 
         HttpResponse response = httpclient.execute(httppost);
         
         String json = EntityUtils.toString(response.getEntity());
         
 //        System.out.println("MOJ STRING " + json);
         
         JSONArray temp = new JSONArray(json);
         
         for (int i = 0; i < temp.length(); i++) {
             JSONObject obj = temp.getJSONObject(i);
 //            System.out.println("Moj json " + obj);
             JsonParser jsonParser = new JsonParser();
             if (obj.get("employmentType").equals("Radni odnos")) {
                 jsonParser.employeeFromNode(obj);
             } else if (obj.get("employmentType").equals("Honorarni odnos")) {
                 jsonParser.partTimeEmployeeFromNode(obj);
              }
         }
    }
}
