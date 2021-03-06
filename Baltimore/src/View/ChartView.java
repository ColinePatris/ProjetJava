package View;

import Controller.ChartCtrl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Cécile
 */
public class ChartView extends javax.swing.JPanel {

    /**
     * Creates new form ChartView
     */

    static PieDataset pieDataset;
    static CategoryDataset barDataset;
    static CategoryDataset horizontalBarDataset;

    public ChartView() {
    }
        
    public ChartView(PieDataset pieDataset, CategoryDataset barDataset, CategoryDataset horizontalBarDataset) {
//        initComponents();
        
        setLayout (new BorderLayout());
        this.setSize(800,600);
        this.setBorder(BorderFactory.createLineBorder(Color.black));  
        this.setVisible(true);
        
        setView(pieDataset,barDataset,horizontalBarDataset);
        
//
//        this.pieDataset = pieDataset;
//        this.barDataset = barDataset;
//        this.horizontalBarDataset = horizontalBarDataset;
//
//        JPanel ChartContainer = new JPanel();
//        ChartContainer.setLayout (new BorderLayout());
//        
//        this.add(ChartContainer,BorderLayout.PAGE_START);
//        
//        JPanel test = createPiePanel();
//        ChartContainer.add(test, BorderLayout.LINE_START);
//        test.setPreferredSize(new Dimension(350, 400));
//        test.setVisible(true);
//        
//        JPanel test2 = createBarPanel();
//        ChartContainer.add(test2, BorderLayout.LINE_END);
//        test2.setPreferredSize(new Dimension(540, 400));
//        test2.setVisible(true);
//        
//        JPanel test3 = createHorizontalBarPanel();
//        ChartContainer.add(test3, BorderLayout.PAGE_END);
//        test3.setPreferredSize(new Dimension(400, 360));
//        test3.setVisible(true);
        
    }
   
    public void setView(PieDataset pieDataset, CategoryDataset barDataset, CategoryDataset horizontalBarDataset){
        
        this.removeAll();
        
        this.pieDataset = pieDataset;
        this.barDataset = barDataset;
        this.horizontalBarDataset = horizontalBarDataset;

        JPanel ChartContainer = new JPanel();
        this.updateUI();
        ChartContainer.setLayout (new BorderLayout());
        
        this.add(ChartContainer,BorderLayout.PAGE_START);
        
        JPanel test = createPiePanel();
        ChartContainer.add(test, BorderLayout.LINE_START);
        test.setPreferredSize(new Dimension(350, 400));
        test.setVisible(true);
        
        JPanel test2 = createBarPanel();
        ChartContainer.add(test2, BorderLayout.LINE_END);
        test2.setPreferredSize(new Dimension(540, 400));
        test2.setVisible(true);
        
        JPanel test3 = createHorizontalBarPanel();
        ChartContainer.add(test3, BorderLayout.PAGE_END);
        test3.setPreferredSize(new Dimension(400, 360));
        test3.setVisible(true);
        
        this.repaint();
    }
    
     private static JFreeChart createPieChart( PieDataset dataset )
   {
      JFreeChart pieChart = ChartFactory.createPieChart(      
         "Gender repartition",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return pieChart;
   }
     
     private static JFreeChart createBarChart( CategoryDataset dataset )
   {
      JFreeChart barChart = ChartFactory.createBarChart(      
         "Age repartition",  // chart title 
         "Age",            
         "Accused",            
         dataset,          
         PlotOrientation.VERTICAL,           
         true, true, false);

      return barChart;
   }
     
      private static JFreeChart createHorizontalBarChart( CategoryDataset dataset )
   {
      JFreeChart horizontalBarChart = ChartFactory.createBarChart(      
         "Race repartition",  // chart title 
         "Race",            
         "Accused",            
         dataset,          
         PlotOrientation.HORIZONTAL,           
         true, false, false);

      return horizontalBarChart;
   }

    public static JPanel createPiePanel( )
   {
      JFreeChart pieChart = createPieChart(pieDataset);
      return new ChartPanel( pieChart ); 
   }
     public static JPanel createBarPanel( )
   {
      JFreeChart barChart = createBarChart(barDataset);
      return new ChartPanel( barChart ); 
   }
     public static JPanel createHorizontalBarPanel( )
   {
      JFreeChart horizontalBarChart = createHorizontalBarChart(horizontalBarDataset);
      return new ChartPanel( horizontalBarChart ); 
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
            .addGap(0, 369, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
