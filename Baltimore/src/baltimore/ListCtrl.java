/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltimore;

import Model.ListElement;
import View.ListView;
import java.awt.Dimension;

/**
 *
 * @author Cécile
 */
public class ListCtrl{
//    ArrayList arrestList = new <Arrest> ArrayList();
    public ListView List = new ListView();
    private ListElement[] elementsList;
    ListView listv = new ListView();

    public ListCtrl() {
        this.elementsList = new ListElement[5];
        elementsList[0] = new ListElement();
        elementsList[1] = new ListElement();
        elementsList[2] = new ListElement();
        elementsList[3] = new ListElement();
        elementsList[4] = new ListElement();
//        this.arrestList = arrestList;
        List.setPreferredSize(new Dimension(300, 700));
        listv.jason.setListData(elementsList);
        listv.setVisible(true);
    }

}
