/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coola
 */
public class CountryDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public void addNewStartCountry(String scID, String scN, InputStream inputStream) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO startCountry(startCountryID,startCountryName,startCountryFlag) VALUES(?,?,?)");
            pstmt.setString(1, scID);
            pstmt.setString(2, scN);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column 
                pstmt.setBlob(3, inputStream);
            }
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
                Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addNewEndCountry(String scID, String scN, InputStream inputStream) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO endCountry(endCountryID,endCountryName,endCountryFlag) VALUES(?,?,?)");
            
            pstmt.setString(1, scID);
            pstmt.setString(2, scN);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column 
                pstmt.setBlob(3, inputStream);
            }
            
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
                Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Country> getStartCountries() throws IOException{
        List<Country> countries = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from startCountry");
            while (rs.next()) {

                String startCountryID = rs.getString("startCountryID");
                String startCountryName = rs.getString("startCountryName");
                
                Blob blob = rs.getBlob("startCountryFlag");
                ByteArrayOutputStream outputStream;
                String base64Image;
                try (InputStream inputStream = blob.getBinaryStream()) {
                    outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }   byte[] imageBytes = outputStream.toByteArray();
                    base64Image = Base64.getEncoder().encodeToString(imageBytes);
                }
                outputStream.close();
           

                Country c = new Country(startCountryID, startCountryName, base64Image);
                countries.add(c);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return countries;
    }
    
    public List<EndCountry> getEndCountries() throws IOException{
        List<EndCountry> countries = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password);
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from endCountry");
            while (rs.next()) {

                String endCountryID = rs.getString("endCountryID");
                String endCountryName = rs.getString("endCountryName");
                
                
                Blob blob = rs.getBlob("endCountryFlag");
                ByteArrayOutputStream outputStream;
                String base64Image;
                try (InputStream inputStream = blob.getBinaryStream()) {
                    outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }   byte[] imageBytes = outputStream.toByteArray();
                    base64Image = Base64.getEncoder().encodeToString(imageBytes);
                }
                outputStream.close();
           

                EndCountry c = new EndCountry(endCountryID, endCountryName, base64Image);
                countries.add(c);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return countries;
    }

}
