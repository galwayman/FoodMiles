/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coola
 */
public class DeliveryDAO {
    
        String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";
    
    public List<DeliveryType> getDeliveryTypes(){
        List<DeliveryType> dt = new ArrayList<>();
        
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from deliveryType");
            while (rs.next()) {

                int deliveryID = rs.getInt("deliveryID");
                String deliveryName = rs.getString("deliveryName");
                int carbon = rs.getInt("carbon");
           

                DeliveryType d = new DeliveryType(deliveryID, deliveryName,carbon);
                dt.add(d);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        
        return dt;
    }
    
    
   
    
}
