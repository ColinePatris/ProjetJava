package View;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

public class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(
       JList<?> list,           // the list
       Object value,            // value to display
       int index,               // cell index
       boolean isSelected,      // is the cell selected
       boolean cellHasFocus)    // does the cell have focus
    {
        JPanel p = (JPanel) value;
        Color c = UIManager.getColor("Panel.background");
        
        if (isSelected) {
             p.setBackground(Color.WHITE);
         } else {
             p.setBackground(c);
         }
        
        return p;   
    }
    
}
