/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;

/**
 *
 * @author aisli
 */
public class AddStoreLocation implements Serializable {
    private double longitude;
    private double latitude;
    private int superMarketID;
    private int superMarketLocationID;
    
    public AddStoreLocation(){
        longitude = 0.0;
        latitude = 0.0;
        superMarketID = 0;
        superMarketLocationID = 0;
    }
    
    public AddStoreLocation(double longitude, double latitude, int superMarketID, int superMarketLocationID){
        this.longitude = longitude;
        this.latitude = latitude;
        this.superMarketID = superMarketID;
        this.superMarketLocationID = superMarketLocationID;
    }
    public double getLongitude(){
        return longitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    
    public double getLatitude(){
        return latitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
            
    public int getSuperMarketID(){
        return superMarketID;
    }

    public void setSuperMarketID(int superMarketID) {
        this.superMarketID = superMarketID;
    }
    
    public int getSuperMarketLocationID(){
        return superMarketLocationID;
    }

    public void setSuperMarketLocationID(int superMarketLocationID) {
        this.superMarketLocationID = superMarketLocationID;
    }
    
}
