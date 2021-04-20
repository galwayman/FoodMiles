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
public class JourneyDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";
    
    public int createUniqueJourneyID(){
        
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
            ResultSet rs = stmt.executeQuery("SELECT journeyID FROM totalJourney");
            while (rs.next()) {

                int journeyID = rs.getInt("journeyID");
                uID.add(journeyID);
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
                Logger.getLogger(JourneyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        uniqueID = Collections.max(uID) +1;
                
        return uniqueID;
    }

    public List<JourneyLeg> getJourneyLegs() {
        List<JourneyLeg> allJ = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from travelLegs");
            while (rs.next()) {

                int legID = rs.getInt("legID");
                String startCountry = rs.getString("startCountry");
                String endCountry = rs.getString("endCountry");
                int distanceTravelled = rs.getInt("distanceTravelled");
                int transportUsed = rs.getInt("transportUsed");

                JourneyLeg jl = new JourneyLeg(legID, startCountry, endCountry, distanceTravelled, transportUsed);
                allJ.add(jl);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return allJ;
    }

    public void addNewJourney(List<TotalJourney> tj) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(dbURL, username, password);
            for (int count = 0; count < tj.size(); count++) {
                pstmt = con.prepareStatement("INSERT INTO totalJourney(journeyID,journeyLegID,journeyStart) VALUES(?,?,?)");
                pstmt.setInt(1, tj.get(count).getJourneyID());
                pstmt.setInt(2, tj.get(count).getJourneyLegID());
                pstmt.setInt(3, tj.get(count).getJourneyStart());

                pstmt.execute();
            }

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
                Logger.getLogger(JourneyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

}
