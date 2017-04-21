/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Arrest;
import Model.ListElement;
import View.ListView;
import View.MyCellRenderer;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author Cécile
 */
public class ListCtrl{
//    ArrayList arrestList = new <Arrest> ArrayList();
    private ListView List = new ListView();
    private ListElement[] elementsList;
    
    private ArrayList arrestList;

    public ListCtrl(ArrayList arrestList) {
        
        this.arrestList = arrestList;
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

}
