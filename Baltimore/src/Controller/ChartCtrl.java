/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Accused;
import Model.Arrest;
import View.ChartView;
import View.MainView;
import java.awt.BorderLayout;
import java.util.ArrayList;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Cécile
 */
public class ChartCtrl {
    static ArrayList arrestList = new <Arrest> ArrayList();
    private ChartView Chart;

    public ChartCtrl(ArrayList arrestList) {
        this.arrestList = arrestList;

        Chart = new ChartView(createPieDataset(), createBarDataset(), createHorizontalBarDataset());
        Chart.setVisible(true);
//        mView.add(Chart,BorderLayout.CENTER);
        
    }
     
     private static PieDataset createPieDataset(){
         
       int women = 0, men = 0;
       String sex;
       Arrest arrest = new Arrest();
       Accused accused = new Accused();

       for(int i=0; i < arrestList.size(); i++){
            arrest = (Arrest) arrestList.get(i);
            accused = arrest.getAccused();
            sex = accused.getSex();
          
            if(sex.equals("M")){
                men++;
            }else if(sex.equals("F")){
                women++;
            }
       }
       DefaultPieDataset dataset = new DefaultPieDataset( );
       dataset.setValue( "Female" , new Double( women ) ); 
       dataset.setValue( "Male" , new Double( men ) );  

       return dataset;   
     }
     
      private CategoryDataset createBarDataset( )
   {
       int menAge[] = new int[5];
       int womenAge[] = new int[5];
       int j = 0;
       int age;
       String sex;
       Arrest arrest = new Arrest();
       Accused accused = new Accused();
       
       for(int i=0; i < arrestList.size(); i++){
            arrest = (Arrest) arrestList.get(i);
            accused = arrest.getAccused();
            age = accused.getAge();
            sex= accused.getSex();
            
            if(age > 15 && age <= 25){
                j = 0;
            }else if (age > 25 && age <= 35){
                j = 1;
            }else if (age > 35 && age <=50){
                j = 2;
            }else if (age > 50 && age <= 65){
                j=3;
            }else if (age >65){
                j=4;
            }
          
            if(sex.equals("M")){
                menAge[j]++;
            }else if(sex.equals("F")){
                womenAge[j]++;
            }

       }
       
      
      final String female = "Female";        
      final String male = "Male";                
      final String first = "15-25 yo";        
      final String second = "26-35 yo";        
      final String third = "35-50 yo";        
      final String fourth = "51-65 yo";
      final String above = "Above 65 yo";   
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( womenAge[0] , female , first );        
      dataset.addValue( womenAge[1]  , female , second );        
      dataset.addValue( womenAge[2]  , female , third ); 
      dataset.addValue( womenAge[3]  , female , fourth );  
      dataset.addValue( womenAge[4]  , female , above ); 

      dataset.addValue( menAge[0]  , male , first );        
      dataset.addValue( menAge[1] , male , second );       
      dataset.addValue( menAge[2] , male , third );        
      dataset.addValue( menAge[3] , male , fourth);
      dataset.addValue( menAge[4] , male , above );

      return dataset; 
   }

      private CategoryDataset createHorizontalBarDataset( )
   {
       int raceArray[] = new int[5];
       int j = 0;
       String race;
 
       Arrest arrest = new Arrest();
       Accused accused = new Accused();
       
       for(int i=0; i < arrestList.size(); i++){
            arrest = (Arrest) arrestList.get(i);
            accused = arrest.getAccused();
            race = accused.getRace();
                     
            if(race.equals("A")){
                j = 0;
            }else if(race.equals("B")){
                j = 1;
            }else if(race.equals("W")){
                j = 2;
            }else if(race.equals("I")){
                j = 3;
            }else if(race.equals("U")){
                j = 4;
            }
            raceArray[j]++;

       }
      
      final String acc = "Accused";                       
      final String first = "Asian";        
      final String second = "Black";        
      final String third = "White";        
      final String fourth = "Indian";
      final String last = "Unknown";   
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      dataset.addValue( raceArray[0] , acc , first );        
      dataset.addValue( raceArray[1]  , acc , second );        
      dataset.addValue( raceArray[2]  , acc , third ); 
      dataset.addValue( raceArray[3]  , acc , fourth );  
      dataset.addValue( raceArray[4] , acc, last ); 

      return dataset; 
   }

    public ChartView getChart() {
        return Chart;
    }
     
}
