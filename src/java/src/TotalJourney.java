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
public class TotalJourney {
    
    
    int journeyID;
    int journeyLegID;
    int journeyStart;
    
    public TotalJourney(){
        journeyID =0;
        journeyLegID = 0;
        journeyStart = 0;
    }

    public TotalJourney(int journeyID, int journeyLegID,int journeyStart) {
        this.journeyID = journeyID;
        this.journeyLegID = journeyLegID;
        this.journeyStart = journeyStart;
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
    
    
    
    
}
