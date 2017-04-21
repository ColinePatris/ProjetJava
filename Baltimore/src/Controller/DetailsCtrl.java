/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Arrest;
import View.DetailsView;
import View.MainView;
import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author Cécile
 */
public class DetailsCtrl {
    String image;
    Arrest arrest;
    DetailsView details;
    ArrayList arrestList;

    public DetailsCtrl() {
//        this.arrestList = arrestList;
        details = new DetailsView();
    }

    public DetailsView getDetails() {
        return details;
    }
    
    
}
