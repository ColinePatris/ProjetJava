package Controller;

import Model.Arrest;
import View.DetailsView;
import java.util.ArrayList;

public class DetailsCtrl {
    String image;
    Arrest arrest;
    DetailsView details;
    ArrayList arrestList;

    public DetailsCtrl() {
        details = new DetailsView();
    }

    public DetailsView getDetails() {
        return details;
    }
}