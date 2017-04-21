/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Accused;
import Model.Arrest;
import Model.Location;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author Cécile
 */
public class DetailsView extends javax.swing.JPanel {

    /**
     * Creates new form DetailsView
     */
    JPanel imgContainer = new JPanel();
    JPanel centerDetails = new JPanel();
    JPanel rightDetails = new JPanel();
    
    Arrest arrest = new Arrest();
    Accused accused = new Accused();
    Location location = new Location();
    private final JLabel sex;
    private final JLabel age;
    private final JLabel race;
    private final JLabel charge;
    private final JLabel arrDate;
    private final JLabel arrTime;
    private final JLabel lat;
    private final JLabel lng;
    private final JLabel dist;
    private final JLabel cBlock;
    private final JLabel arrLoc;
    
    public DetailsView() {
        initComponents();
//        this.arrest = arrest;
        
        setLayout (new BorderLayout());
        
        Button next = new Button ("Next >>");
        Button back = new Button ("<< Back");
        add(next, BorderLayout.LINE_END);
        add(back, BorderLayout.LINE_START);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel detailsContainer = new JPanel();
        detailsContainer.setPreferredSize(new Dimension(1000, 200));
        add(detailsContainer, BorderLayout.CENTER);
        
        imgContainer.setPreferredSize(new Dimension(200, 190));
//        imgContainer.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        imgContainer.setBackground(Color.white);
        detailsContainer.add(imgContainer, BorderLayout.LINE_START);
          
        centerDetails.setPreferredSize(new Dimension(400, 190));
//        centerDetails.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        centerDetails.setBackground(Color.white);
        detailsContainer.add(centerDetails, BorderLayout.CENTER);
        
        rightDetails.setPreferredSize(new Dimension(400, 190));
//        rightDetails.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        rightDetails.setBackground(Color.white);
        detailsContainer.add(rightDetails, BorderLayout.LINE_END);
        
//        setInfo();
        
        Box centerBox = Box.createVerticalBox();
        centerDetails.setLayout(new BorderLayout());
        centerDetails.add(centerBox, BorderLayout.CENTER);
        
        JLabel acc= new JLabel();
        acc.setText("ACCUSED");
        acc.setFont(new Font("", Font.BOLD, 18));
        acc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centerBox.add(acc);
        
        sex = new JLabel();
        sex.setText("Sex : " + accused.getSex());
        sex.setFont(new Font("", Font.PLAIN, 16));
        sex.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        centerBox.add(sex);
        
        age = new JLabel();
        age.setText("Age : " + String.valueOf(accused.getAge()));
        age.setFont(new Font("", Font.PLAIN, 16));
        age.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        centerBox.add(age);
        
        race = new JLabel();
        race.setText("Race : " + accused.getRace());
        race.setFont(new Font("", Font.PLAIN, 16));
        race.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        centerBox.add(race);
        
        JLabel arr= new JLabel();
        arr.setText("ARREST");
        arr.setFont(new Font("", Font.BOLD, 18));
        arr.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centerBox.add(arr);
        
        charge = new JLabel();
        charge.setText("Charge : " + arrest.getCharge());
        charge.setFont(new Font("", Font.PLAIN, 16));
        charge.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        centerBox.add(charge);
        
        arrDate = new JLabel();
        arrDate.setText("Date : " + arrest.getDate());
        arrDate.setFont(new Font("", Font.PLAIN, 16));
        arrDate.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        centerBox.add(arrDate);
        
        arrTime = new JLabel();
        arrTime.setText("Time" + arrest.getTime());
        arrTime.setFont(new Font("", Font.PLAIN, 16));
        arrTime.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        centerBox.add(arrTime);
        
        Box rightBox = Box.createVerticalBox();
        rightDetails.setLayout(new BorderLayout());
        rightDetails.add(rightBox, BorderLayout.CENTER);
        
        JLabel loc= new JLabel();
        loc.setText("LOCATION");
        loc.setFont(new Font("", Font.BOLD, 18));
        loc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        rightBox.add(loc);
        
        lat = new JLabel();
        lat.setText("Latitude : " + String.valueOf(location.getLatitude()));
        lat.setFont(new Font("", Font.PLAIN, 16));
        lat.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        rightBox.add(lat);
        
         lng = new JLabel();
        lng.setText("Longitute : " + String.valueOf(location.getLongitude()));
        lng.setFont(new Font("", Font.PLAIN, 16));
        lng.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        rightBox.add(lng);
        
        dist = new JLabel();
        dist.setText("District : " + location.getDistrict());
        dist.setFont(new Font("", Font.PLAIN, 16));
        dist.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        rightBox.add(dist);
        
        cBlock = new JLabel();
        cBlock.setText("CityBlock : " + location.getCityBlock());
        cBlock.setFont(new Font("", Font.PLAIN, 16));
        cBlock.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        rightBox.add(cBlock);
        
        arrLoc = new JLabel();
        arrLoc.setText("Address : :" + location.getArrestLocation());
        arrLoc.setFont(new Font("", Font.PLAIN, 16));
        arrLoc.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        rightBox.add(arrLoc);
        
        
    }
    
        
    public void setInfo(Arrest arrest){
        
        accused = arrest.getAccused();
        location = arrest.getLocation();

        sex.setText("Sex : " + accused.getSex());

        age.setText("Age : " + String.valueOf(accused.getAge()));

        race.setText("Race : " + accused.getRace());

        charge.setText("Charge : " + arrest.getCharge());

        arrDate.setText("Date : " + arrest.getDate());

;
        arrTime.setText("Time" + arrest.getTime());

        lat.setText("Latitude : " + String.valueOf(location.getLatitude()));

        lng.setText("Longitute : " + String.valueOf(location.getLongitude()));

        dist.setText("District : " + location.getDistrict());

        cBlock.setText("CityBlock : " + location.getCityBlock());
   
        arrLoc.setText("Address : :" + location.getArrestLocation());
  
    }
    
//    
//    public void setInfo(Arrest arrest){
//        
//        accused = arrest.getAccused();
//        location = arrest.getLocation();
//        
//        Box centerBox = Box.createVerticalBox();
//        centerDetails.setLayout(new BorderLayout());
//        centerDetails.add(centerBox, BorderLayout.CENTER);
//        
//        JLabel acc= new JLabel();
//        acc.setText("ACCUSED");
//        acc.setFont(new Font("", Font.BOLD, 18));
//        acc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//        centerBox.add(acc);
//        
//        JLabel sex = new JLabel();
//        sex.setText("Sex : " + accused.getSex());
//        sex.setFont(new Font("", Font.PLAIN, 16));
//        sex.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        centerBox.add(sex);
//        
//        JLabel age = new JLabel();
//        age.setText("Age : " + String.valueOf(accused.getAge()));
//        age.setFont(new Font("", Font.PLAIN, 16));
//        age.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        centerBox.add(age);
//        
//        JLabel race = new JLabel();
//        race.setText("Race : " + accused.getRace());
//        race.setFont(new Font("", Font.PLAIN, 16));
//        race.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        centerBox.add(race);
//        
//        JLabel arr= new JLabel();
//        arr.setText("ARREST");
//        arr.setFont(new Font("", Font.BOLD, 18));
//        arr.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//        centerBox.add(arr);
//        
//        JLabel charge = new JLabel();
//        charge.setText("Charge : " + arrest.getCharge());
//        charge.setFont(new Font("", Font.PLAIN, 16));
//        charge.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        centerBox.add(charge);
//        
//        JLabel arrDate = new JLabel();
//        arrDate.setText("Date : " + arrest.getDate());
//        arrDate.setFont(new Font("", Font.PLAIN, 16));
//        arrDate.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        centerBox.add(arrDate);
//        
//        JLabel arrTime = new JLabel();
//        arrTime.setText("Time" + arrest.getTime());
//        arrTime.setFont(new Font("", Font.PLAIN, 16));
//        arrTime.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        centerBox.add(arrTime);
//        
//        Box rightBox = Box.createVerticalBox();
//        rightDetails.setLayout(new BorderLayout());
//        rightDetails.add(rightBox, BorderLayout.CENTER);
//        
//        JLabel loc= new JLabel();
//        loc.setText("LOCATION");
//        loc.setFont(new Font("", Font.BOLD, 18));
//        loc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//        rightBox.add(loc);
//        
//        JLabel lat = new JLabel();
//        lat.setText("Latitude : " + String.valueOf(location.getLatitude()));
//        lat.setFont(new Font("", Font.PLAIN, 16));
//        lat.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        rightBox.add(lat);
//        
//        JLabel lng = new JLabel();
//        lng.setText("Longitute : " + String.valueOf(location.getLongitude()));
//        lng.setFont(new Font("", Font.PLAIN, 16));
//        lng.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        rightBox.add(lng);
//        
//        JLabel dist = new JLabel();
//        dist.setText("District : " + location.getDistrict());
//        dist.setFont(new Font("", Font.PLAIN, 16));
//        dist.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        rightBox.add(dist);
//        
//        JLabel cBlock = new JLabel();
//        cBlock.setText("CityBlock : " + location.getCityBlock());
//        cBlock.setFont(new Font("", Font.PLAIN, 16));
//        cBlock.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        rightBox.add(cBlock);
//        
//        JLabel arrLoc = new JLabel();
//        arrLoc.setText("Address : :" + location.getArrestLocation());
//        arrLoc.setFont(new Font("", Font.PLAIN, 16));
//        arrLoc.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//        rightBox.add(arrLoc);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
