/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author coola
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserScoresDAO {

    String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
    String username = "mydb5473o";
    String password = "mydb5473o";

    public List<UserScoreTop> getBestScores() {
        List<UserScoreTop> scores = new ArrayList<>();
        int position = 1;
        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT userName as name, ROUND(SUM(userScores.carbonScore)/count(userScores.carbonScore),0) AS average\n"
                    + "FROM userScores \n"
                    + "INNER JOIN user ON userScores.userIDScore = user.userID\n"
                    + "GROUP BY userIDScore\n"
                    + "ORDER BY average\n"
                    + "LIMIT 2;");

            while (rs.next()) {

                String userName = rs.getString("name");
                int average = rs.getInt("average");
                

                UserScoreTop u = new UserScoreTop(userName, average, position);
                scores.add(u);
                position +=1;
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
        return scores;
    }
    
    public double getAverageCarbonScore(){
        double average = 0;
        
        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select avg(carbonScore) as Average from userScores;");

            while (rs.next()) {

                 average = rs.getInt("Average");
    
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
        return average;
    }

}
