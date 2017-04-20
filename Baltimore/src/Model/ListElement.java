/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    
    public ListElement(){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(280, 65));
        sex.setText("Sex: M");
        age.setText("Age: 24");
        race.setText("Race: B");
        charge.setText("Charge: FAILURE TO APPEAR");
        
        accusedInfo.setLayout(layout);
        accusedInfo.setOpaque(false);
        accusedInfo.add(sex);
        accusedInfo.add(age);
        accusedInfo.add(race);
        this.add(accusedInfo);
        this.add(charge);
    }
    
}
