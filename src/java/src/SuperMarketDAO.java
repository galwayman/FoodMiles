/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlets.getSuperMarkets;

/**
 *
 * @author coola
 */
public class SuperMarketDAO {
    
    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
            String username = "mydb5473o";
            String password = "mydb5473o";
    
    public List<SuperMarket> getAllSuperMarkets() throws IOException {
        List<SuperMarket> supermarkets = new ArrayList<>();

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            try (Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from superMarket");
                System.out.println("rs = " + rs.toString());
                while (rs.next()) {
                    
                    String superMarketName = rs.getString("superMarketName");
                    int superMarketID = rs.getInt("superMarketID");
                    Blob blob = rs.getBlob("superMarketImage");
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    
                    byte[] imageBytes = outputStream.toByteArray();
                    
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    
                    inputStream.close();
                    outputStream.close();
                    SuperMarket sm = new SuperMarket(superMarketID, superMarketName, base64Image);
                    
                    supermarkets.add(sm);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return supermarkets;
    }
    
    
    public void createNewFoodItem(int id,String smA, InputStream inputStream) throws FileNotFoundException {

//        String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
//            String username = "mydb5473o";
//            String password = "mydb5473o";
       com.mysql.jdbc.Connection conn = null;	// connection to the database 

        try {
            // connects to the database 
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password);

            // constructs SQL statement 
            String sql = ("INSERT INTO superMarket(superMarketID, superMarketName,superMarketImage) VALUES(?,?,?)");
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, smA);
           

            

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column 
                statement.setBlob(3, inputStream);
            }

            // sends the statement to the database server 
            statement.executeUpdate();

        } catch (SQLException ex) {
        } finally {
            if (conn != null) {
                // closes the database connection 
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
    
    public int getUniqueSMIDAdmin(){
        
        int uniqueID = 0;
       List<Integer> uID = new ArrayList<>();
        
        java.sql.Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuperMarketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT superMarketID FROM superMarket");
            while (rs.next()) {

                int userID = rs.getInt("superMarketID");
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
                Logger.getLogger(SuperMarketDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        uniqueID = Collections.max(uID) +1;
                
        return uniqueID;
    }
    public List<FoodItem> getIrishFoodItemsFish(String sm) throws IOException {
        List<FoodItem> irishFoods = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            try (Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where irishSourced = 1 and foodClass = 'Fish' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
            System.out.println("rs = " + rs.toString());
            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");
                Blob blob = rs.getBlob("foodItemPic");
                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();
                FoodItem f = new FoodItem(foodItemID, foodName, organic,irishSourced,base64Image, foodClass, foodType);

                irishFoods.add(f);
            }
            }
            } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return irishFoods;
    }
      public List<FoodItem> getIrishFoodItemsDairy(String sm) throws IOException {
        List<FoodItem> irishFoods = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            try (Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where irishSourced = 1 and foodClass = 'Dairy' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
            System.out.println("rs = " + rs.toString());
            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");
                Blob blob = rs.getBlob("foodItemPic");
                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();
                FoodItem f = new FoodItem(foodItemID, foodName, organic,irishSourced,base64Image, foodClass, foodType);

                irishFoods.add(f);
            }
            }
            } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return irishFoods;
    }
       public List<FoodItem> getIrishFoodItemsFruit(String sm) throws IOException {
        List<FoodItem> irishFoods = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            try (Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where irishSourced = 1 and foodClass = 'Fruit' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
            System.out.println("rs = " + rs.toString());
            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");
                Blob blob = rs.getBlob("foodItemPic");
                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();
                FoodItem f = new FoodItem(foodItemID, foodName, organic,irishSourced,base64Image, foodClass, foodType);

                irishFoods.add(f);
            }
            }
            } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return irishFoods;
    }
            
 public List<FoodItem> getIrishFoodItemsVegetables(String sm) throws IOException {
        List<FoodItem> irishFoods = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            try (Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where irishSourced = 1 and foodClass = 'Vegetables' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
            System.out.println("rs = " + rs.toString());
            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");
                Blob blob = rs.getBlob("foodItemPic");
                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();
                FoodItem f = new FoodItem(foodItemID, foodName, organic,irishSourced,base64Image, foodClass, foodType);

                irishFoods.add(f);
            }
            }
            } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return irishFoods;
    }
 public List<FoodItem> getIrishFoodItemsMeat(String sm) throws IOException {
        List<FoodItem> irishFoods = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

            try (Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where irishSourced = 1 and foodClass = 'Meat' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
            System.out.println("rs = " + rs.toString());
            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");
                Blob blob = rs.getBlob("foodItemPic");
                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();
                FoodItem f = new FoodItem(foodItemID, foodName, organic,irishSourced,base64Image, foodClass, foodType);

                irishFoods.add(f);
            }
            }
            } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        
        return irishFoods;
    }
    
}


