/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltimore;

import Model.Arrest;
import java.util.ArrayList;

/**
 *
 * @author Cécile
 */
public class ListCtrl {
    ArrayList arrestList = new <Arrest> ArrayList();

    public ListCtrl(ArrayList arrestList) {
        this.arrestList = arrestList;
    }

}
