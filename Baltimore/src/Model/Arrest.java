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
    
    Accused accused;
    Location location;
    Date date;
    Time time;
    String charge;

    public Arrest(Accused accused, Location location, Date date, Time time, String charge) {
        this.accused = accused;
        this.location = location;
        this.date = date;
        this.time = time;
        this.charge = charge;
    }
    
}
