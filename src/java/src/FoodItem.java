/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;

/**
 *
 * @author coola
 */
public class FoodItem   implements Serializable {
    
    private int foodItemID;
    private String foodName;
    private int organic;
    private int irishSourced;
    private String foodItemPic;
    private String foodClass;
    private String foodType;

    public FoodItem(int foodItemID, String foodName, int organic, int irishSourced, String foodItemPic, String foodClass, String foodType) {
        this.foodItemID = foodItemID;
        this.foodName = foodName;
        this.organic = organic;
        this.irishSourced = irishSourced;
        this.foodItemPic = foodItemPic;
        this.foodClass = foodClass;
        this.foodType = foodType;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getOrganic() {
        return organic;
    }

    public void setOrganic(int organic) {
        this.organic = organic;
    }

    public int getIrishSourced() {
        return irishSourced;
    }

    public void setIrishSourced(int irishSourced) {
        this.irishSourced = irishSourced;
    }

    public String getFoodItemPic() {
        return foodItemPic;
    }

    public void setFoodItemPic(String foodItemPic) {
        this.foodItemPic = foodItemPic;
    }

    public String getFoodClass() {
        return foodClass;
    }

    public void setFoodClass(String foodClass) {
        this.foodClass = foodClass;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    
}
