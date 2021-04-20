/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coola
 */
public class UserDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public void addNew(User u) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("INSERT INTO user(userID,userName,userEmail,userPassword,premium,admin,profilePic) VALUES(?,?,?,?,?,?,?)");
            pstmt.setInt(1, u.getUserID());
            pstmt.setString(2, u.getUserName());
            pstmt.setString(3, u.getUserEmail());
            pstmt.setString(4, u.getUserPassword());
            pstmt.setInt(5, u.getPremium());
            pstmt.setInt(6, u.getAdmin());
            pstmt.setInt(7, u.getProfilePic());
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
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int createUniqueID(){
        
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
            ResultSet rs = stmt.executeQuery("SELECT userID FROM user");
            while (rs.next()) {

                int userID = rs.getInt("userID");
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
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        uniqueID = Collections.max(uID) +1;
                
        return uniqueID;
    }
    
    
    public int checkForUserName(String userName){
        
        int uniqueUserName = 1;
        String test;
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
            ResultSet rs = stmt.executeQuery("SELECT userName FROM user where userName = '" + userName + "'");
            if (rs.next()) {
                test = rs.getString("userName");
                if (userName.equals(test)) //this part does not happen even if it should
            {uniqueUserName =0;
           }
                else{
                    uniqueUserName =1;
                }

                
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
       
        return uniqueUserName;
    }
    
    
     public int checkForUserEmail(String userEmail){
        
        int uniqueUserEmail = 1;
        String test;
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
            ResultSet rs = stmt.executeQuery("SELECT userEmail FROM user where userEmail = '"+userEmail+"'");
            if (rs.next()) {
                test = rs.getString("userEmail");
                if (userEmail.equals(test)) //this part does not happen even if it should
            {uniqueUserEmail =0;
           }
                else{
                    uniqueUserEmail =1;
                }

                
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
       
        return uniqueUserEmail;
    }
    
   

//    public void delete(int id) {
//        Connection con = null;
//        Statement stmt = null;
//        try {
//
//            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
//            stmt = (Statement) con.createStatement();
//            stmt.execute("DELETE FROM emp WHERE empId=" + String.valueOf(id));
//        } catch (SQLException ex) {
//
//        } finally {
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    public void update(User u) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            pstmt = con.prepareStatement("UPDATE user SET userName=?, userEmail=?,profilePic=? WHERE userID=? ");
            pstmt.setString(1, u.getUserName());
            pstmt.setString(2, u.getUserEmail());
            pstmt.setInt(3, u.getProfilePic());
            pstmt.setInt(4, u.getUserID());
            pstmt.executeUpdate();
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
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public User getUser(String userEmail, String userPassword) {
        User u = null;
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM user where userEmail = '" + userEmail + "'");
            while (rs.next()) {

                int userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String uEmail = rs.getString("userEmail");
                String uPassword = rs.getString("userPassword");
                int uPrem = rs.getInt("premium");
                int uAdmin = rs.getInt("admin");
                int uPic = rs.getInt("profilePic");

                u = new User(userID, userName, uEmail, uPassword, uPrem, uAdmin, uPic);

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
        return u;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");

            while (rs.next()) {

                int userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String userEmail = rs.getString("userEmail");
                String userPassword = rs.getString("userPassword");
                int uPrem = rs.getInt("premium");
                int uAdmin = rs.getInt("admin");
                int uPic = rs.getInt("profilePic");

                User u = new User(userID, userName, userEmail, userPassword, uPrem, uAdmin,uPic);
                users.add(u);
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
        return users;
    }

}
