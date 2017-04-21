/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Coline
 */
public class ListElement extends JPanel {
    FlowLayout layout = new FlowLayout();
    BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
    
    JLabel sex = new JLabel();
    JLabel age = new JLabel();
    JLabel race = new JLabel();
    JLabel charge = new JLabel();
    
    JPanel accusedInfo = new JPanel();
    
    Accused accused;
    Arrest arrest;
    
    public ListElement(Arrest arrest){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(280, 65));
        
        this.arrest = arrest;
        this.accused = arrest.getAccused();
        
        sex.setText("Sex : " + accused.getSex());
        age.setText("Age : " + String.valueOf(accused.getAge()));
        race.setText("Race : " + accused.getRace());
        charge.setText("Charge : " + arrest.getCharge());
        
        accusedInfo.setLayout(layout);
        accusedInfo.setOpaque(false);
        accusedInfo.add(sex);
        accusedInfo.add(age);
        accusedInfo.add(race);
        this.add(accusedInfo);
        this.add(charge);
    }

    public Arrest getArrest() {
        return arrest;
    }

    
}
