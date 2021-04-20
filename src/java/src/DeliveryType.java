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
public class DeliveryType {
    
    private int deliveryID;
    private String deliveryName;
    private int carbon;
    
    public DeliveryType(){
        deliveryID = 0;
        deliveryName ="";
        carbon =0;
    }

    public DeliveryType(int deliveryID, String deliveryName, int carbon) {
        this.deliveryID = deliveryID;
        this.deliveryName = deliveryName;
        this.carbon = carbon;
    }
    
    

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public int getCarbon() {
        return carbon;
    }

    public void setCarbon(int carbon) {
        this.carbon = carbon;
    }
    
    
    
}
