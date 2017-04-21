/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Accused;
import Model.Arrest;
import Model.ListElement;
import Model.Location;
import View.ListView;
import View.MainView;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cécile
 */
public class MainCtrl {
    
    static ArrayList arrestList = new <Arrest> ArrayList();
    static Accused accused;
    static Location loc;
    static Arrest arrest;
    static JSONParser parser = new JSONParser();
    static MainView mView;
    static ChartCtrl chartCtrl;
    static DetailsCtrl detailsCtrl;
    static ListCtrl listCtrl;

    public static void main(String[] args) {
        parseJSON();        
        mView = new MainView();
        
        chartCtrl = new ChartCtrl(arrestList);
        mView.add(chartCtrl.getChart(),BorderLayout.CENTER);
        
        listCtrl = new ListCtrl(arrestList);
        mView.add(listCtrl.getList(),BorderLayout.LINE_END);
        
        detailsCtrl = new DetailsCtrl();
        mView.add(detailsCtrl.getDetails(),BorderLayout.PAGE_END);
        
        JList jason = listCtrl.getList().getJason();
        
        jason.addListSelectionListener(new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  
                    if(jason.getSelectedValue() != null){
                  ListElement listEl = (ListElement) jason.getSelectedValue();
                  Arrest selectedArrest = listEl.getArrest();

                  detailsCtrl.getDetails().setInfo(selectedArrest);
                    }
                }
            }
        });
        

        
        mView.setVisible(true);
    }

    public static void parseJSON(){

         try {

            Object obj = parser.parse(new FileReader("data.json"));

            JSONArray jsonArray = (JSONArray) obj;
//            System.out.println(jsonArray);

            Iterator <JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                
                
                JSONObject it = (JSONObject) iterator.next();
//                System.out.println((String) it.get("arrest"));
                
                //Accused
                int age = (int) Integer.parseInt((String) it.get("age"));
                String sex = (String) it.get("sex");
                String race = (String) it.get("race");
                
                accused = new Accused(age, sex, race);

//              System.out.println(accused.getAge());
                
                //Location
                JSONObject location = (JSONObject) it.get("location_1");
                if (location != null){
                    Double longitude = (Double) Double.parseDouble((String) location.get("longitude"));
                    Double latitude = (Double) Double.parseDouble((String) location.get("latitude"));
                    
                    String district = (String) it.get("district");
                    String arrestLocation = (String) it.get("arrestlocation");
                    String cityBlock = (String) it.get("incident1");// Est-ce que c'est bien incident1 ?
                
                    loc = new Location(longitude, latitude, district, cityBlock, arrestLocation);
                }else{
                    String district = (String) it.get("district");
                    String arrestLocation = (String) it.get("arrestlocation");
                    String cityBlock = (String) it.get("incident1");// Est-ce que c'est bien incident1 ?

                    loc = new Location(district, cityBlock, arrestLocation);
                }

                //Arrest  
                String date = (String) it.get("arrestdate");// Changer en String pour simplifier
                String time = (String) it.get("arresttime");
                String charge = (String) it.get("chargedescription");
                
                arrest = new Arrest(accused, loc, date, time, charge);
                arrestList.add(arrest);
                
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
  
    
}
