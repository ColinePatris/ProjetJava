/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Cécile
 */
public class Arrest {
    
    private Accused accused;
    private Location location;
    private String date;
    private String time;
    private String charge;

    public Arrest() {
    }
    
    public Arrest(Accused accused, Location location, String  date, String  time, String charge) {
        this.accused = accused;
        this.location = location;
        this.date = date;
        this.time = time;
        this.charge = charge;
    }

    public Accused getAccused() {
        return accused;
    }

    public Location getLocation() {
        return location;
    }

    public String  getDate() {
        return date;
    }

    public String  getTime() {
        return time;
    }

    public String getCharge() {
        return charge;
    }
    
    public String toString(){
        String stringList = new String();
        stringList = accused.toString() + "\n";
        stringList += location.toString() + "\n";
        stringList += date + "\n";
        stringList += time + "\n";
        stringList += charge + "\n";
        return stringList;
    }
    
}
