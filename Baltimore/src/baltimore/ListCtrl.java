/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltimore;

import Model.ListElement;
import View.ListView;
import View.MyCellRenderer;
import java.awt.Dimension;

/**
 *
 * @author Cécile
 */
public class ListCtrl{
//    ArrayList arrestList = new <Arrest> ArrayList();
    public ListView List = new ListView();
    private ListElement[] elementsList;

    public ListCtrl() {
        this.elementsList = new ListElement[10];
        elementsList[0] = new ListElement();
        elementsList[1] = new ListElement();
        elementsList[2] = new ListElement();
        elementsList[3] = new ListElement();
        elementsList[4] = new ListElement();
        elementsList[5] = new ListElement();
        elementsList[6] = new ListElement();
        elementsList[7] = new ListElement();
        elementsList[8] = new ListElement();
        elementsList[9] = new ListElement();
//        this.arrestList = arrestList;
        List.setPreferredSize(new Dimension(300, 700));
        List.jason.setListData(elementsList);
        List.jason.setCellRenderer(new MyCellRenderer());
        List.setVisible(true);
    }

}
