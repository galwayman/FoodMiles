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
public class Country {
    
    String startCountryID;
    String startCountryName;
    String startCountryFlag;    
    public Country(){
        startCountryID = "";
        startCountryName = "";
    }
    
    public Country(String startCountryID, String startCountryName) {
        this.startCountryID = startCountryID;
        this.startCountryName = startCountryName;
    }

    public Country(String startCountryID, String startCountryName, String startCountryFlag) {
        this.startCountryID = startCountryID;
        this.startCountryName = startCountryName;
        this.startCountryFlag = startCountryFlag;
    }

    public String getStartCountryFlag() {
        return startCountryFlag;
    }

    public void setStartCountryFlag(String startCountryFlag) {
        this.startCountryFlag = startCountryFlag;
    }
    
    

    

    public String getStartCountryID() {
        return startCountryID;
    }

    public void setStartCountryID(String startCountryID) {
        this.startCountryID = startCountryID;
    }

    public String getStartCountryName() {
        return startCountryName;
    }

    public void setStartCountryName(String startCountryName) {
        this.startCountryName = startCountryName;
    }
    
    
    
}
