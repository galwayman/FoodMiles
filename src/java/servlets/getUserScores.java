/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.User;
import src.UserScores;

/**
 *
 * @author coola
 */
@WebServlet(name = "getUserScores", urlPatterns
        = {
            "/getUserScores"
        })
public class getUserScores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userID = request.getParameter("userID");
                User u = (User) request.getSession().getAttribute("uLog");
        int id = u.getUserID();
        List<UserScores> uScores = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        List<UserScores> averageUserScore = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSuperMarkets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
            String username = "mydb5473o";
            String password = "mydb5473o";

            Connection connection = (Connection) DriverManager.getConnection(dbURL, username, password);
            System.out.println("connection = " + connection.toString());
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from userScores where userIDScore in (select userID from user where userID ="+id+")");
            System.out.println("rs = " + rs.toString());

            while (rs.next()) {

                int userIDScore = rs.getInt("userIDScore");

                int cartNumber = rs.getInt("cartNumber");
                int carbonScore = rs.getInt("carbonScore");

                UserScores ud = new UserScores(userIDScore, cartNumber, carbonScore);
                high.add(carbonScore);
                uScores.add(ud);
            }
            ResultSet rs1 = statement.executeQuery("select * from userScores");
            System.out.println("rs1 = " + rs.toString());

            while (rs1.next()) {

                int userIDScore = rs1.getInt("userIDScore");

                int cartNumber = rs1.getInt("cartNumber");
                int carbonScore = rs1.getInt("carbonScore");

                UserScores avg = new UserScores(userIDScore, cartNumber, carbonScore);
                

                averageUserScore.add(avg);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        double sum = 0;
        for (int i = 0; i < averageUserScore.size(); i++) {
            sum += averageUserScore.get(i).getCarbonScore();
        }
        
        double avg = sum/averageUserScore.size();
        
        int highScore = Collections.max(high) +1;        
        HttpSession session = request.getSession();
        session.setAttribute("uScores", uScores);
        session.setAttribute("avg", avg);
        session.setAttribute("highScore", highScore);

        RequestDispatcher dispatcher = request.getRequestDispatcher("UserScores/userScores.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
