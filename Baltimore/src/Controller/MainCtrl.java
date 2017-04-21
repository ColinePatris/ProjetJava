package Controller;

import Model.Accused;
import Model.Arrest;
import Model.ListElement;
import Model.Location;
import View.MainView;
import java.awt.BorderLayout;
import java.awt.Button;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        Button next = detailsCtrl.getDetails().getNext();
        Button previous = detailsCtrl.getDetails().getPrevious();
        
        jason.addListSelectionListener((ListSelectionEvent arg0) -> {
            if (!arg0.getValueIsAdjusting()) {
                
                if(jason.getSelectedValue() != null){
                    ListElement listEl = (ListElement) jason.getSelectedValue();
                    Arrest selectedArrest = listEl.getArrest();
                    
                    detailsCtrl.getDetails().setInfo(selectedArrest);
                }
            }
        });
        
        next.addActionListener((java.awt.event.ActionEvent evt) -> {
            listCtrl.getList().getJason().setSelectedIndex(listCtrl.getList().getJason().getSelectedIndex()+1);
        });
        
        previous.addActionListener((java.awt.event.ActionEvent evt) -> {
            listCtrl.getList().getJason().setSelectedIndex(listCtrl.getList().getJason().getSelectedIndex()-1);
        });
        
        mView.setVisible(true);
    }
    
    public static void parseJSON(){

         try {

            Object obj = parser.parse(new FileReader("data.json"));

            JSONArray jsonArray = (JSONArray) obj;

            Iterator <JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                
                
                JSONObject it = (JSONObject) iterator.next();
                
                //Accused
                int age = (int) Integer.parseInt((String) it.get("age"));
                String sex = (String) it.get("sex");
                String race = (String) it.get("race");
                
                accused = new Accused(age, sex, race);

                
                //Location
                JSONObject location = (JSONObject) it.get("location_1");
                if (location != null){
                    Double longitude = (Double) Double.parseDouble((String) location.get("longitude"));
                    Double latitude = (Double) Double.parseDouble((String) location.get("latitude"));
                    
                    String district = (String) it.get("district");
                    String arrestLocation = (String) it.get("arrestlocation");
                    String cityBlock = (String) it.get("name1");
                
                    loc = new Location(longitude, latitude, district, cityBlock, arrestLocation);
                }else{
                    String district = (String) it.get("district");
                    String arrestLocation = (String) it.get("arrestlocation");
                    String cityBlock = (String) it.get("name1");

                    loc = new Location(district, cityBlock, arrestLocation);
                }

                //Arrest  
                String date = (String) it.get("arrestdate");
                String time = (String) it.get("arresttime");
                String charge = (String) it.get("chargedescription");
                
                arrest = new Arrest(accused, loc, date, time, charge);
                arrestList.add(arrest);                
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }
}