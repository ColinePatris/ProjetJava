/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.crypto.Cipher; //librairie native pour cryptage des données

/**
 *
 * @author Coline
 */
public class ListElement extends javax.swing.JPanel {
    FlowLayout layout = new FlowLayout();
    JLabel sex = new JLabel();
    JLabel age = new JLabel();
    JLabel race = new JLabel();
    JLabel date = new JLabel();
    JLabel time = new JLabel();
    JLabel district = new JLabel();
    JLabel locationName = new JLabel();
    JLabel charge = new JLabel();
    
    public ListElement(){
        this.setBackground(Color.yellow);
        sex.setText("Sex: M");
        age.setText("Age: 24");
        race.setText("Race: B");
        date.setText("Date: 04/05/2018");
        time.setText("Time: 14:35");
        district.setText("District: Southern");
        locationName.setText("Location: Hampton");
        charge.setText("Charge: FAILURE TO APPEAR");
        
        this.setLayout(layout);
        this.add(sex);
        this.add(age);
        this.add(race);
        this.add(date);
        this.add(time);
        this.add(district);
        this.add(locationName);
        this.add(charge);
        
    }
    
}
