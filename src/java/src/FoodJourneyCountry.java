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
public class FoodJourneyCountry {
    
    int legID;
    String startCountry;
    String endCountry;
    int distanceTravelled;
    int transportUsed;
    int journeyID;
    int journeyLegID;
    int journeyStart;
    String startCountryName;
    String startCountryFlag;
    String startCountryID;
    
    public FoodJourneyCountry(int legID, String startCountry, String endCountry, int distanceTravelled, 
                              int transportUsed, int journeyID, int journeyLegID, int journeyStart,String startCountryID, String startCountryName, String startCountryFlag) {
        this.legID = legID;
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        this.distanceTravelled = distanceTravelled;
        this.transportUsed = transportUsed;
        this.journeyID = journeyID;
        this.journeyLegID = journeyLegID;
        this.journeyStart = journeyStart;
        this.startCountryName = startCountryName;
        this.startCountryFlag = startCountryFlag;
        this.startCountryID = startCountryID;
    }

    public String getStartCountryID() {
        return startCountryID;
    }

    public void setStartCountryID(String startCountryID) {
        this.startCountryID = startCountryID;
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

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public int getJourneyLegID() {
        return journeyLegID;
    }

    public void setJourneyLegID(int journeyLegID) {
        this.journeyLegID = journeyLegID;
    }

    public int getJourneyStart() {
        return journeyStart;
    }

    public void setJourneyStart(int journeyStart) {
        this.journeyStart = journeyStart;
    }

    public String getStartCountryName() {
        return startCountryName;
    }

    public void setStartCountryName(String startCountryName) {
        this.startCountryName = startCountryName;
    }

    public String getStartCountryFlag() {
        return startCountryFlag;
    }

    public void setStartCountryFlag(String startCountryFlag) {
        this.startCountryFlag = startCountryFlag;
    }
    
    
    
    
}
