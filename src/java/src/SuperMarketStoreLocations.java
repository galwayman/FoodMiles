/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;

/**
 *
 * @author murph
 */
public class SuperMarketStoreLocations implements Serializable{
   private String superMarketName;
   private double longitude;
   private double latitude;
   private int superMarketLocationID;

   public SuperMarketStoreLocations(){
        superMarketName = "";
        longitude = 0.0;
        latitude = 0.0;
        superMarketLocationID = 0;
    }
    
    public SuperMarketStoreLocations(String superMarketName, double longitude, double latitude, int superMarketLocationID){
        this.superMarketName= superMarketName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.superMarketLocationID = superMarketLocationID;
    }
    
     public String getSuperMarketName(){
        return superMarketName;
    }
    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
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
 
    public int getSuperMarketLocationID(){
        return superMarketLocationID;
    }

    public void setSuperMarketLocationID(int superMarketLocationID) {
        this.superMarketLocationID = superMarketLocationID;
    }
    
}