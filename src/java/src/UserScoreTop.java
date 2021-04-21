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
public class UserScoreTop {
    
    String userName;
    int average;
    int position;
    
    public UserScoreTop(){
        userName = "";
        average = 0;
        position = 0;
    }

    public UserScoreTop(String userName, int average,int position) {
        this.userName = userName;
        this.average = average;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
    
    
    
}
