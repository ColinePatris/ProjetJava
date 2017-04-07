/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltimore;

import Model.Accused;
import Model.Arrest;
import Model.Location;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

    Accused accused;
    Location loc;
    Arrest arrest;
    JSONParser parser = new JSONParser();

    public MainCtrl() {
        parseJSON();
    }

    public void parseJSON(){
        
        int test =0;
        
         try {

            Object obj = parser.parse(new FileReader("data.json"));

            JSONArray jsonArray = (JSONArray) obj;
//            System.out.println(jsonArray);

            Iterator <JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                
                test++;
                
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
                String charge = (String) it.get("charge");
                
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
    
    public ArrayList getArrestList(){
        return arrestList;
    }
    
    
}
