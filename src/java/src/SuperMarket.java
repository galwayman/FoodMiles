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
public class SuperMarket  implements Serializable {
    
    private int superMarketID;
    private String superMarketName;
    private String superMarketImage;

    public SuperMarket(int superMarketID, String superMarketName, String superMarketImage) {
        this.superMarketID = superMarketID;
        this.superMarketName = superMarketName;
        this.superMarketImage = superMarketImage;
    }

    public int getSuperMarketID() {
        return superMarketID;
    }

    public void setSuperMarketID(int superMarketID) {
        this.superMarketID = superMarketID;
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public String getSuperMarketImage() {
        return superMarketImage;
    }

    public void setSuperMarketImage(String superMarketImage) {
        this.superMarketImage = superMarketImage;
    }

 
   
}
