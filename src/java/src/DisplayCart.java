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
public class DisplayCart {
    
    String foodName;
    int foodQTY;
    double foodCarbon;
    int foodItemID;
    public DisplayCart(){
        foodName ="";
        foodQTY =0;
        foodCarbon =0;
        foodItemID=0;
    }
    public DisplayCart(String foodName, int foodQTY,double foodCarbon,int foodItemID) {
        this.foodName = foodName;
        this.foodQTY = foodQTY;
        this.foodCarbon=foodCarbon;
        this.foodItemID=foodItemID;
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

    public int getFoodQTY() {
        return foodQTY;
    }

    public void setFoodQTY(int foodQTY) {
        this.foodQTY = foodQTY;
    }

    public double getFoodCarbon() {
        return foodCarbon;
    }

    public void setFoodCarbon(double foodCarbon) {
        this.foodCarbon = foodCarbon;
    }
    
    
    
}
