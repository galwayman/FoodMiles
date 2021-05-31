/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlets.getSuperMarkets;
/**
 *
 * @author aisli
 */
public class AddStoreLocationDAO {
    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";
    
    
    
    public void addLocation(double lo, double la, int smID, int smlID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password);
           // con = DriverManager.getConnection(dbURL, username, password);
           // pstmt = con.prepareStatement("INSERT INTO superMarketLocations(longitude, latitude, superMarketID, superMarketIDLocations) VALUES(?,?,?,?)");
            String sql = ("INSERT INTO superMarketLocations(longitude, latitude, superMarketID, superMarketLocationID) VALUES(?,?,?,?)");
            pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, lo);
            pstmt.setDouble(2, la);
            pstmt.setInt(3, smID);
            pstmt.setInt(4, smlID);
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
                Logger.getLogger(AddStoreLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
   
   
    public int getUniqueSMLID(){
        
        int uniqueID = 0;
       List<Integer> uID = new ArrayList<>();
        
        java.sql.Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStoreLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT superMarketLocationID FROM superMarketLocations");
            while (rs.next()) {

                int userID = rs.getInt("superMarketLocationID");
                uID.add(userID);
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
                Logger.getLogger(AddStoreLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        uniqueID = Collections.max(uID) +1;
                
        return uniqueID;
    }
    
    
    public List<SuperMarketStoreLocations> getStoreLocations() {
        List<SuperMarketStoreLocations> locations = new ArrayList<>();

        //Not relevant to this int position = 1;
        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT superMarketName, longitude, latitude, superMarketLocationID\n"
                    + "FROM  superMarketLocations \n"
                    + "INNER JOIN superMarket ON superMarketLocations.superMarketID = superMarket.superMarketID\n"
                    + "GROUP BY superMarketLocationID\n");//This is the sql statement, you need to join on supermarketlocations supermarketID

            while (rs.next()) {

                String superMarketName = rs.getString("superMarketName");
                double longitude = rs.getDouble("longitude");
                double latitude = rs.getDouble("latitude");
                int superMarketLocationID = rs.getInt("superMarketLocationID");
                // longitude, latitude, superMarketLocationID these three need to be got so rs.getInt, rs.getDouble

                SuperMarketStoreLocations s = new SuperMarketStoreLocations(superMarketName, longitude, latitude, superMarketLocationID);
                locations.add(s);
                //position += 1; not relevant to this, this was a way of arranging who was the best average score
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

            }
        }
        return locations;
    }
}
