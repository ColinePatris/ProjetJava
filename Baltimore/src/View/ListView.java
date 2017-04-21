package View;

import Model.Arrest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListView extends javax.swing.JPanel {

    private JList jason = new JList();
    private Arrest selectedArrest = new Arrest();
        
    public ListView() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);
        
        JPanel filters = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jason);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        filters.setLayout(layout);
        JComboBox sexfilter = new JComboBox();
        JComboBox agefilter = new JComboBox();
        
        filters.add(sexfilter);
        filters.add(agefilter);
        filters.setBackground(Color.yellow);
        filters.setPreferredSize(new Dimension(300, 150));
        scrollPane.setPreferredSize(new Dimension(290, 600));
        this.add(filters);
        this.add(scrollPane);
    }

    public JList getJason() {
        return jason;
    }
    
    public Arrest getSelectedArrest() {
        return selectedArrest;
    }

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
