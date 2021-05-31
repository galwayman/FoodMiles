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
public class Cart {
    
    int userCartID;
    int foodItemID;
    int foodQTY;
    double foodCarbon;
    
    public Cart(){
        userCartID =0;
        
        foodQTY = 0;
        foodCarbon=0;
        foodItemID =0;
    }

    public Cart(int userCartID,  int foodQTY,double foodCarbon,int foodItemID) {
        this.userCartID = userCartID;
        this.foodItemID = foodItemID;
        this.foodQTY = foodQTY;
        this.foodCarbon=foodCarbon;
    }

    public double getFoodCarbon() {
        return foodCarbon;
    }

    public void setFoodCarbon(double foodCarbon) {
        this.foodCarbon = foodCarbon;
    }

    public int getUserCartID() {
        return userCartID;
    }

    public void setUserCartID(int userCartID) {
        this.userCartID = userCartID;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getFoodQTY() {
        return foodQTY;
    }

    public void setFoodQTY(int foodQTY) {
        this.foodQTY = foodQTY;
    }
    
    
    
}
