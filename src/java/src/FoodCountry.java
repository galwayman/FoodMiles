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
public class FoodCountry {

    int journeyID;
    String foodCountryID;
    String foodCountryName;
    String foodCountryPhoto;

    public FoodCountry() {
        foodCountryID = "";
        foodCountryName = "";
        foodCountryPhoto = "";
        journeyID = 0;
    }

    public FoodCountry(int journeyID, String foodCountryID, String foodCountryName, String footCountryPhoto) {
        this.foodCountryID = foodCountryID;
        this.foodCountryName = foodCountryName;
        this.foodCountryPhoto = footCountryPhoto;
        this.journeyID = journeyID;
    }

    public String getFoodCountryID() {
        return foodCountryID;
    }

    public void setFoodCountryID(String foodCountryID) {
        this.foodCountryID = foodCountryID;
    }

    public String getFoodCountryName() {
        return foodCountryName;
    }

    public void setFoodCountryName(String foodCountryName) {
        this.foodCountryName = foodCountryName;
    }

    public String getFoodCountryPhoto() {
        return foodCountryPhoto;
    }

    public void setFoodCountryPhoto(String foodCountryPhoto) {
        this.foodCountryPhoto = foodCountryPhoto;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setjourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

}
