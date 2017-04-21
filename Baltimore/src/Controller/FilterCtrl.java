package Controller;

import Model.Accused;
import Model.Arrest;
import Model.Location;
import View.FilterView;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Cécile
 */
public class FilterCtrl {
  //  ArrayList arrestList;
    static ArrayList LarrestList;
    ArrayList CarrestList;
    FilterView filter ;
    Arrest arrest;
    Accused accused;
    Location location;
    
    public FilterCtrl() {
        //this.arrestList = arrestList;
        filter = new FilterView();
    }
    
    public ArrayList chartFilter(String district, ArrayList arrestList){
        
        this.CarrestList = new ArrayList();
        
        for(int i = 0; i < arrestList.size() ; i++){
            CarrestList.add(arrestList.get(i));
        }
        
        if("All".equals(district)){
            return CarrestList;
        }else{
        for(int i = 0; i< CarrestList.size(); i++){
                arrest = (Arrest) CarrestList.get(i);
                location = arrest.getLocation();
                
                if( location.getDistrict().equals(district) == false){
                    CarrestList.remove(i);
                    i = i-1;
                }
            }
        return CarrestList;
        }
    }
    
    public ArrayList filter(String sex, String age, String race, ArrayList arrestList){
        
        this.LarrestList = new ArrayList();
        
        for(int i = 0; i < arrestList.size() ; i++){
            LarrestList.add(arrestList.get(i));
        }
        
        filterAge(age);
        filterSex(sex);
        filterRace(race);
  
        return LarrestList;
    }
    
    public void filterAge(String selection){
        int down;
        int up;
        
        switch (selection) {
            case "15-25":
                down = 15;
                up = 25;
                break;
            case "26-35":
                down = 26;
                up = 35;
                break;
            case "36-50":
                down = 36;
                up = 50;
                break;
            case "51-65":
                down = 51;
                up = 65;
                break;
            case "65+":
                down = 65;
                up = 100;
                break;
            default:
                down = 0;
                up = 100;
                break;
        }

        for(int i = 0; i< LarrestList.size(); i++){
                arrest = (Arrest) LarrestList.get(i);
                accused = arrest.getAccused();

                if((accused.getAge() >= down && accused.getAge() < up) == false){
                    LarrestList.remove(i);
                    i = i-1;
                }
        }
    }
    
    public void filterSex(String selection){
        
        if(selection.equals("Male")){
            for(int i = 0; i< LarrestList.size(); i++){
                arrest = (Arrest) LarrestList.get(i);
                accused = arrest.getAccused();
                
                if(accused.getSex().equals("F")){
                    LarrestList.remove(i);
                    i = i-1;
                }
            }
        }else if(selection.equals("Female")){
            for(int i = 0; i< LarrestList.size(); i++){
                arrest = (Arrest) LarrestList.get(i);
                accused = arrest.getAccused();
                
                if(accused.getSex().equals("M")){
                    LarrestList.remove(i);
                    i = i-1;
                }
            }
        }else{
            
        }
    }
    
    public void filterRace(String selection){
        String race = "";
        Boolean filter = true;
        
        if(selection.equals("Asian")){
            race ="A";
        }else if(selection.equals("White")){
            race ="W";
        }else if(selection.equals("Black")){
            race ="B";
        }else if(selection.equals("Indian")){
            race ="I";
        }else if(selection.equals("Unknown")){
            race ="U";
        }else{
            filter = false;
        }
        
        if(filter == true){
            for(int i = 0; i< LarrestList.size(); i++){
                arrest = (Arrest) LarrestList.get(i);
                accused = arrest.getAccused();
                
                if(accused.getRace().equals(race) == false){
                    LarrestList.remove(i);
                    i = i-1;
                }
            }
        }
    }

    public FilterView getFilter() {
        return filter;
    }
    
}
