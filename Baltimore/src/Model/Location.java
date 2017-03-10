/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Cécile
 */
public class Location {
    
    Double Longitude;
    Double Latitude;
    String district;
    String cityBlock;
    String arrestLocation;

    public Location(Double Longitude, Double Latitude, String district, String cityBlock, String arrestLocation) {
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.district = district;
        this.cityBlock = cityBlock;
        this.arrestLocation = arrestLocation;
    }

    
    
}
