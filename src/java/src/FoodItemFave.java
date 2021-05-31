/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author aisli
 */
public class FoodItemFave {
    private int userIDFaveItems;
    private int foodIDFaveItems;
    
    public FoodItemFave(){
        userIDFaveItems = 0;
        foodIDFaveItems = 0;
    }
    
    public FoodItemFave(int userIDFaveItems, int foodIDFaveItems){
        this.userIDFaveItems = userIDFaveItems;
        this.foodIDFaveItems = foodIDFaveItems;
    }
    
     public int getUserIDFaveItems() {
        return userIDFaveItems;
    }

    public void setUserIDFaveItems(int userIDFaveItems) {
        this.userIDFaveItems= userIDFaveItems;
    }
     public int getFoodIDFaveItems() {
        return foodIDFaveItems;
    }

    public void setFoodIDFaveItems(int foodIDFaveItems) {
        this.foodIDFaveItems= foodIDFaveItems;
    }
  
}
