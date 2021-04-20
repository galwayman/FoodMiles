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
public class UserScores {

    int userIDScore;
    int cartNumber;
    int carbonScore;

    public UserScores(int userIDScore, int cartNumber, int carbonScore) {
        this.userIDScore = userIDScore;
        this.cartNumber = cartNumber;
        this.carbonScore = carbonScore;
    }

    public int getUserIDScore() {
        return userIDScore;
    }

    public void setUserIDScore(int userIDScore) {
        this.userIDScore = userIDScore;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public int getCarbonScore() {
        return carbonScore;
    }

    public void setCarbonScore(int carbonScore) {
        this.carbonScore = carbonScore;
    }

    
}
