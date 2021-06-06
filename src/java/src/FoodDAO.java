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
import javax.servlet.http.HttpSession;
import servlets.getSuperMarkets;

/**
 *
 * @author coola
 */
public class FoodDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public List<FoodItem> getFaveItems(int uID) {

        List<FoodItem> faveItems = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from foodItem where foodItemID in (select foodItemIDFaveItems from faveItems where userIDFaveItems ="+uID+")");

            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");

                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");

                Blob blob = rs.getBlob("foodItemPic");
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
                FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                faveItems.add(f);
            }
        } catch (SQLException ex) {
        } catch (IOException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return faveItems;
    }
     //Add item to favourites - aisli
    public void addItemToFavourites(int uID, int fID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
           //sql not working
            pstmt = con.prepareStatement("INSERT INTO faveItems(userIDFaveItems, foodItemIDFaveItems) VALUES(?,?)");
            pstmt.setInt(1, uID);
            pstmt.setInt(2, fID);
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
                Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
      public void deleteItemFromFavourites(int uID, int fID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("DELETE FROM faveItems WHERE userIDFaveItems = ? AND foodItemIDFaveItems = ?");
            pstmt.setInt(1, uID);
            pstmt.setInt(2, fID);
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
                Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
     public FoodItem getSCItem(String id) {

        FoodItem fi = null;
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from foodItem where foodItemID = "+id);

            while (rs.next()) {

                int foodItemID = rs.getInt("foodItemID");
                String foodName = rs.getString("foodName");
                int organic = rs.getInt("organic");
                int irishSourced = rs.getInt("irishSourced");

                String foodClass = rs.getString("foodClass");
                String foodType = rs.getString("foodType");

                Blob blob = rs.getBlob("foodItemPic");
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
                FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                fi = f;
            }
        } catch (SQLException ex) {
        } catch (IOException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return fi;
    }

    public List<FoodItem> getAllFoodItems() throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem;");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }
    
    public List<FoodItem> getSuperMarketItems(String sm) throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where foodItemID in (select fID from superMarketItems where smID = "+sm+");");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }
    
    public List<FoodItem> getSuperMarketItemsFruit(String sm) throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where foodClass = 'fruit' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }
    
    public List<FoodItem> getSuperMarketItemsVeg(String sm) throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where foodClass = 'Vegetable' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }
    
    public List<FoodItem> getSuperMarketItemsMeat(String sm) throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where foodClass = 'Meat' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }
    
    public List<FoodItem> getSuperMarketItemsDairy(String sm) throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where foodClass = 'Dairy' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }
    
    public List<FoodItem> getSuperMarketItemsFish(String sm) throws IOException {
        List<FoodItem> foodItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password)) {
                System.out.println("connection = " + connection.toString());
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from foodItem where foodClass = 'Fish' and foodItemID in (select fID from superMarketItems where smID = "+sm+");");
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
                    FoodItem f = new FoodItem(foodItemID, foodName, organic, irishSourced, base64Image, foodClass, foodType);
                    foodItems.add(f);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return foodItems;
    }

    public void addItemToStore(String sm, String fd) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO superMarketItems(smID, fID) VALUES(?,?)");
            pstmt.setString(1, sm);
            pstmt.setString(2, fd);
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
                Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void addCountryToFood(int jID, int iID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO foodMiles(journeyID, itemID) VALUES(?,?)");
            pstmt.setInt(1, jID);
            pstmt.setInt(2, iID);
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
                Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void createNewFoodItem(int id, String fnA, int oA, int isA, InputStream inputStream, String fcA, String ftA, Double isW) throws FileNotFoundException {

        com.mysql.jdbc.Connection conn = null;	// connection to the database 

        try {
            // connects to the database 
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbURL, username, password);

            // constructs SQL statement 
            String sql = ("INSERT INTO foodItem(foodItemID, foodName, organic, irishSourced, foodItemPic, foodClass, foodType, foodWeight) VALUES(?,?,?,?,?,?,?,?)");
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, fnA);
            statement.setInt(3, oA);
            statement.setInt(4, isA);
            statement.setString(6, fcA);
            statement.setString(7, ftA);
            statement.setDouble(8, isW);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column 
                statement.setBlob(5, inputStream);
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

    public int getUniqueFoodIDAdmin() {

        int uniqueID = 0;
        List<Integer> uID = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT foodItemID FROM foodItem");
            while (rs.next()) {

                int userID = rs.getInt("foodItemID");
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
                Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        uniqueID = Collections.max(uID) + 1;

        return uniqueID;
    }

    public List<FoodCountry> getFoodCountryStart(int fID) throws IOException {
        List<FoodCountry> fCountry = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select foodMiles.journeyID,startCountry.startCountryID,startCountry.startCountryName,startCountry.startCountryFlag\n"
                    + "FROM travelLegs\n"
                    + "INNER JOIN deliveryType ON travelLegs.transportUsed=deliveryType.deliveryID\n"
                    + "inner join totalJourney on travelLegs.legID = totalJourney.journeyLegID\n"
                    + "inner join foodMiles on totalJourney.journeyID = foodMiles.journeyID\n"
                    + "inner join foodItem on foodMiles.itemID = foodItem.foodItemID\n"
                    + "inner join startCountry on travelLegs.startCountry = startCountry.startCountryID\n"
                    + "where foodItem.foodItemID = " + fID + " and totalJourney.journeyStart =1\n"
                    + ";");
            while (rs.next()) {

                int journeyID = rs.getInt("foodMiles.journeyID");
                String sID = rs.getString("startCountry.startCountryID");
                String sName = rs.getString("startCountry.startCountryName");
//                String sFlag = rs.getString("startCountry.startCountryFlag");

                Blob blob = rs.getBlob("startCountry.startCountryFlag");
                ByteArrayOutputStream outputStream;
                String base64Image;
                try (InputStream inputStream = blob.getBinaryStream()) {
                    outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    base64Image = Base64.getEncoder().encodeToString(imageBytes);
                }
                outputStream.close();
                FoodCountry fc = new FoodCountry(journeyID, sID, sName, base64Image);
                fCountry.add(fc);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return fCountry;
    }

    public List<FoodJourneyCountry> getFoodCountryJourneys() throws IOException {
        List<FoodJourneyCountry> fCountryAdd = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            try (Connection connection = DriverManager.getConnection(dbURL, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from travelLegs inner join "
                        + "totalJourney on travelLegs.legID = totalJourney.journeyLegID "
                        + "inner join startCountry on startCountry.startCountryID = travelLegs.startCountry;");
                while (rs.next()) {
                    
                    int legID = rs.getInt("travelLegs.legID");
                    String sID = rs.getString("travelLegs.startCountry");
                    String eID = rs.getString("travelLegs.endCountry");
                    int dist = rs.getInt("travelLegs.distanceTravelled");
                    int transport = rs.getInt("travelLegs.transportUsed");
                    int journeyID = rs.getInt("travelLegs.journeyID");
                    int journeyLegID = rs.getInt("totalJourney.journeyLegID");
                    int journeyStart = rs.getInt("totalJourney.journeyStart");
                    String startCountryID = rs.getString("startCountry.startCountryID");
                    String startCountryName = rs.getString("startCountry.startCountryName");
                    Blob blob = rs.getBlob("startCountry.startCountryFlag");
                    ByteArrayOutputStream outputStream;
                    String base64Image;
                    try (InputStream inputStream = blob.getBinaryStream()) {
                        outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    }
                    outputStream.close();
                    FoodJourneyCountry fc = new FoodJourneyCountry(legID, sID,  eID,   dist, transport,  journeyID,
                                                                   journeyLegID,   journeyStart,  startCountryID,
                                                                   startCountryName,   base64Image);
                    fCountryAdd.add(fc);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        return fCountryAdd;
    }

}
