/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cécile
 */
public class Accused {
    int age;
    String sex;
    String race; 

    public Accused() {
    }   
    
    public Accused(int age, String sex, String race){
        this.age = age;
        this.sex=sex;
        this.race=race;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getRace() {
        return race;
    }
    
    public String toString(){
        String stringList = new String();
        String raceFull = new String();
        stringList = "Accused : \n";
        stringList += "" + age + " years old \n";
        switch (race){
            //case = W :
        }
        stringList += raceFull + "\n";
        
        return stringList;
    }
    
}
