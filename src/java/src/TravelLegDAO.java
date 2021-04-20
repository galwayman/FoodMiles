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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coola
 */
public class TravelLegDAO {
    
        String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";
    
    public int createUniqueTravelLegID(){
        
        int uniqueID = 0;
       List<Integer> uID = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TravelLegDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT legID FROM travelLegs");
            while (rs.next()) {

                int legID = rs.getInt("legID");
                uID.add(legID);
            }

        } catch (SQLException ex) {

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        uniqueID = Collections.max(uID) +1;
                
        return uniqueID;
    }
    
     public void addNewLeg(JourneyLeg jl) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO travelLegs(legID,startCountry,endCountry,distanceTravelled,transportUsed) VALUES(?,?,?,?,?)");
            pstmt.setInt(1, jl.getLegID());
            pstmt.setString(2, jl.getStartCountry());
            pstmt.setString(3, jl.getEndCountry());
            pstmt.setInt(4, jl.getDistanceTravelled());
            pstmt.setInt(5, jl.getTransportUsed());
              pstmt.execute();
        } catch (SQLException ex) {

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
