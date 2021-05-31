/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coola
 */
public class CartDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public void addNewItem(Cart c) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO cart(userCartID, foodItemID, foodQTY,foodCarbon) VALUES(?,?,?,?)");
            pstmt.setInt(1, c.getUserCartID());
            pstmt.setInt(2, c.getFoodItemID());
            pstmt.setInt(3, c.getFoodQTY());
            pstmt.setDouble(4, c.getFoodCarbon());
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkItem(int id, int foodID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("delete from cart where userCartID ='"+id+"' and foodItemID ='"+foodID+"'");
            
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public double foodCarbon(int fi,int ji) {

        List<Double> allCarbon = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT travelLegs.distanceTravelled, deliveryType.carbon, foodItem.foodWeight \n"
                    + "FROM travelLegs\n"
                    + "INNER JOIN deliveryType ON travelLegs.transportUsed=deliveryType.deliveryID\n"
                    + "inner join totalJourney on travelLegs.legID = totalJourney.journeyLegID\n"
                    + "inner join foodMiles on totalJourney.journeyID = foodMiles.journeyID\n"
                    + "inner join foodItem on foodMiles.itemID = foodItem.foodItemID\n"
                    + "inner join startCountry on travelLegs.startCountry = startCountry.startCountryID\n"
                    + "where foodItem.foodItemID = "+fi+" and foodMiles.journeyID ="+ji+";");
            while (rs.next()) {

                int dt = rs.getInt("travelLegs.distanceTravelled");
                double dty = rs.getDouble("deliveryType.carbon");
                double wt = rs.getDouble("foodItem.foodWeight");
                double calc = dt * dty * wt;
                allCarbon.add(calc);
            }

        } catch (SQLException ex) {

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        double carbon = 0;
        for (double i : allCarbon) {
            carbon = carbon + i;
        }

        return carbon;
    }
    
        public void deleteItem(int foodItemID, int userCartID) {
        Connection con = null;
        Statement stmt = null;
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = (Statement) con.createStatement();
            stmt.execute("DELETE FROM cart WHERE foodItemID='" +foodItemID+"' and '"+ userCartID+"'");
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
