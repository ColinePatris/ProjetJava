/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltimore;

import Model.Arrest;
import View.DetailsView;
import View.MainView;
import java.awt.BorderLayout;

/**
 *
 * @author Cécile
 */
public class DetailsCtrl {
    String image;
    Arrest arrest;
    DetailsView Details;

    public DetailsCtrl() {
        
        Details = new DetailsView();
    
    }
}
