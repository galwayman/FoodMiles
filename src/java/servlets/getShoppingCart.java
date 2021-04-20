/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.DisplayCart;
import src.User;

/**
 *
 * @author coola
 */
public class getShoppingCart extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String dbURL = "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb5473";
        String username = "mydb5473o";
        String password = "mydb5473o";

        List<DisplayCart> scItems = new ArrayList<>();
        DisplayCart dc = null;
        Connection con = null;
        Statement stmt = null;
        int totalScore = 0;

        User u = (User) request.getSession().getAttribute("uLog");
        int id = u.getUserID();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT foodItem.foodName,foodItem.foodItemID, cart.foodQTY, cart.foodCarbon\n" + "FROM foodItem\n" + "INNER JOIN cart ON foodItem.foodItemID=cart.foodItemID\n"
                    + "where userCartID = (Select userID from user where userID = " + id + ");");
            while (rs.next()) {

                int foodQTY = rs.getInt("foodQTY");
                String foodName = rs.getString("foodName");
                
                int foodCarbon = rs.getInt("foodCarbon");
                int foodItemID = rs.getInt("foodItemID");

                totalScore += foodCarbon * foodQTY;
                dc = new DisplayCart(foodName,foodQTY, foodCarbon,foodItemID);
                scItems.add(dc);
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
                Logger.getLogger(getShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("scItems", scItems);
        session.setAttribute("totalScore", totalScore);
        response.sendRedirect("ViewShoppingCart/viewShoppingCart.jsp");

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
