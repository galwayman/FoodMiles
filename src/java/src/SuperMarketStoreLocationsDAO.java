/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author murph
 */
public class SuperMarketStoreLocationsDAO {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public void storeLocation(String superMarketName, double longitude, double latitude, int superMarketLocationID) {

    }

    public List<SuperMarketStoreLocations> getStoreLocations() throws IOException {
        List<SuperMarketStoreLocations> locations = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT superMarketName, longitude, latitude, superMarketLocationID\n"
                    + "FROM  superMarketLocations \n"
                    + "INNER JOIN superMarket ON superMarketLocations.superMarketID = superMarket.superMarketID\n"
                    + "GROUP BY superMarketLocationID\n");//This is the sql statement, you need to join on supermarketlocations supermarketID

//                String superMarketName = rs.getString("Lidl");
//                double longitude = rs.getDouble("53.278781");
//                double latitude = rs.getDouble("-9.05008");
//                int superMarketLocationID = rs.getInt('1');
            while (rs.next()) {
                String superMarketName = rs.getString("superMarketName");
                double longitude = rs.getDouble("longitude");
                double latitude = rs.getDouble("latitude");
                int superMarketLocationID = rs.getInt("superMarketLocationID");

                SuperMarketStoreLocations s = new SuperMarketStoreLocations(superMarketName, longitude, latitude, superMarketLocationID);
                locations.add(s);

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
