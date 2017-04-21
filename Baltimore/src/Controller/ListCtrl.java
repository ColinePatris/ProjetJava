package Controller;

import Model.Arrest;
import Model.ListElement;
import View.ListView;
import View.MyCellRenderer;
import java.awt.Dimension;
import java.util.ArrayList;

public class ListCtrl{
    private ListView List = new ListView();
    private ListElement[] elementsList;
    
    public ListCtrl(ArrayList arrestList) {
        
        this.elementsList = new ListElement[arrestList.size()];
         for(int i=0; i < arrestList.size(); i++){
             elementsList[i] = new ListElement((Arrest) arrestList.get(i));
        }

        List.setPreferredSize(new Dimension(300, 700));
        List.getJason().setListData(elementsList);
        List.getJason().setCellRenderer(new MyCellRenderer());
        
        List.setVisible(true);
        
    }

    public ListView getList() {
        return List;
    }
    
    public void setList(ArrayList LarrestList){
        this.elementsList = new ListElement[LarrestList.size()];
         for(int i=0; i < LarrestList.size(); i++){
             elementsList[i] = new ListElement((Arrest) LarrestList.get(i));
        }
         
        List.getJason().setListData(elementsList);
    }

}
