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
public class FoodMiles {
    
    private int journeyID;
    private int itemID;
    
    public FoodMiles() {
        journeyID = 0;
        itemID = 0;
    }

    public FoodMiles(int journeyID, int itemID) {
        this.journeyID = journeyID;
        this.itemID = itemID;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    

}
