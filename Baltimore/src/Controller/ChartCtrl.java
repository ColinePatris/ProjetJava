package Controller;

import Model.Accused;
import Model.Arrest;
import View.ChartView;
import java.util.ArrayList;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ChartCtrl {
    public ChartView Chart;

    public ChartCtrl(ArrayList arrestList) {
        Chart = new ChartView(createPieDataset(arrestList), createBarDataset(arrestList), createHorizontalBarDataset(arrestList));
        Chart.setVisible(true);        
    }
    
    public void setFilter(ArrayList CarrestList){
        Chart.setView(createPieDataset(CarrestList), createBarDataset(CarrestList), createHorizontalBarDataset(CarrestList));
    }
    
    public void setChart(ArrayList arrestList){
        Chart = new ChartView(createPieDataset(arrestList), createBarDataset(arrestList), createHorizontalBarDataset(arrestList));
        Chart.setVisible(true);
    }
    
     public PieDataset createPieDataset(ArrayList arrestList){
       int women = 0, men = 0;
       String sex;
       Arrest arrest = new Arrest();
       Accused accused = new Accused();

       for(int i=0; i < arrestList.size(); i++){
            arrest = (Arrest) arrestList.get(i);
            accused = arrest.getAccused();
            arrest = (Arrest) arrestList.get(i);
            System.out.print(arrest.getLocation().getDistrict());
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
     
      public CategoryDataset createBarDataset(ArrayList arrestList)
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

      public CategoryDataset createHorizontalBarDataset(ArrayList arrestList)
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