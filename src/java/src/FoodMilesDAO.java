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
public class FoodMilesDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public List<FoodMiles> getFM(int fID) {
        List<FoodMiles> fMiles = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from foodMiles");
            while (rs.next()) {

                int journeyID = rs.getInt("journeyID");
                int journeyLegID = rs.getInt("journeyLegID");

                FoodMiles fm = new FoodMiles(journeyID, journeyLegID);
                fMiles.add(fm);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return fMiles;
    }

    public void addFoodMiles(int uID, int cN, int cS) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO userScores(userIDScore,cartNumber,carbonScore) VALUES(?,?,?)");
            pstmt.setInt(1, uID);
            pstmt.setInt(2, cN);
            pstmt.setInt(3, cS);
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
                Logger.getLogger(FoodMilesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void deleteCart(int uID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("Delete from cart where userCartID = "+uID);
            
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
                Logger.getLogger(FoodMilesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    

    public int createUniqueID(int userID) {

        int uniqueID = 1;
        List<Integer> cID = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodMilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cartNumber FROM userScores where userIDScore = " + userID);
            while (rs.next()) {

                int cartID = rs.getInt("cartNumber");
                cID.add(cartID);
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
                Logger.getLogger(FoodMilesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        uniqueID = Collections.max(cID) + 1;

        return uniqueID;
    }

}
