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
public class EndCountry {

    String endCountryID;
    String endCountryName;
    String endCountryFlag;

    public EndCountry(String endCountryID, String endCountryName, String endCountryFlag) {
        this.endCountryID = endCountryID;
        this.endCountryName = endCountryName;
        this.endCountryFlag = endCountryFlag;
    }

   
    public EndCountry() {
        endCountryID = "";
        endCountryName = "";
    }

    public EndCountry(String endCountryID, String endCountryName) {
        this.endCountryID = endCountryID;
        this.endCountryName = endCountryName;
    }

    public String getEndCountryID() {
        return endCountryID;
    }

    public void setEndCountryID(String endCountryID) {
        this.endCountryID = endCountryID;
    }

    public String getEndCountryName() {
        return endCountryName;
    }

    public void setEndCountryName(String endCountryName) {
        this.endCountryName = endCountryName;
    }
 public String getEndCountryFlag() {
        return endCountryFlag;
    }

    public void setEndCountryFlag(String endCountryFlag) {
        this.endCountryFlag = endCountryFlag;
    }

}
