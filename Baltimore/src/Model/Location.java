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
    
    Double longitude;
    Double latitude;
    String district;
    String cityBlock;
    String arrestLocation;

    public Location(Double longitude, Double latitude, String district, String cityBlock, String arrestLocation) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.district = district;
        this.cityBlock = cityBlock;
        this.arrestLocation = arrestLocation;
    }

    public Location(String district, String cityBlock, String arrestLocation) {
        this.district = district;
        this.cityBlock = cityBlock;
        this.arrestLocation = arrestLocation;
    }
    
    

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getDistrict() {
        return district;
    }

    public String getCityBlock() {
        return cityBlock;
    }

    public String getArrestLocation() {
        return arrestLocation;
    }

    public String toString(){
        String stringList = district + "\n";
        stringList += cityBlock + "\n";
        stringList += arrestLocation + "\n";
        stringList += latitude.toString() + "\n";
        stringList += longitude.toString() + "\n";
        return stringList;
    }
    
}
