/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cécile
 */
public class Location {
    
    String district;
    String cityBlock;
    String arrestLocation;

    public Location(String district, String cityBlock, String arrestLocation) {
        this.district = district;
        this.cityBlock = cityBlock;
        this.arrestLocation = arrestLocation;
    }
    
}
