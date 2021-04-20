/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author coola
 */
public class JourneyLeg {
    
    
    
    int legID;
    String startCountry;
    String endCountry;
    int distanceTravelled;
    int transportUsed;
    
    public JourneyLeg(){
        legID=0;
        startCountry ="";
        endCountry ="";
        distanceTravelled =0;
        transportUsed =0;
    }

    public JourneyLeg(int legID, String startCountry, String endCountry, int distanceTravelled, int transportUsed) {
        this.legID = legID;
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        this.distanceTravelled = distanceTravelled;
        this.transportUsed = transportUsed;
    }

    public int getLegID() {
        return legID;
    }

    public void setLegID(int legID) {
        this.legID = legID;
    }

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public String getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public int getTransportUsed() {
        return transportUsed;
    }

    public void setTransportUsed(int transportUsed) {
        this.transportUsed = transportUsed;
    }
    
    
}
