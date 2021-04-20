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
import src.FoodDAO;
import src.FoodItem;
import src.FoodMiles;

/**
 *
 * @author coola
 */
@WebServlet(name = "getSuperMarketItems", urlPatterns
        = {
            "/getSuperMarketItems"
        })
public class getSuperMarketItems extends HttpServlet {

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

        List<FoodItem> foodItemsFruit;
        List<FoodItem> foodItemsVeg;
        List<FoodItem> foodItemsMeat;
        List<FoodItem> foodItemsDairy;
        List<FoodItem> foodItemsFish;
        
        
        
        String sm = request.getParameter("superMarket");
        
        FoodDAO fA = new FoodDAO();
        
        foodItemsFruit = fA.getSuperMarketItemsFruit(sm);
        foodItemsVeg = fA.getSuperMarketItemsVeg(sm);
        foodItemsMeat = fA.getSuperMarketItemsMeat(sm);
        foodItemsDairy = fA.getSuperMarketItemsDairy(sm);
        foodItemsFish = fA.getSuperMarketItemsFish(sm);

        
        HttpSession session = request.getSession();
        session.setAttribute("foodItemsFruit", foodItemsFruit);
        session.setAttribute("foodItemsVeg", foodItemsVeg);
        session.setAttribute("foodItemsMeat", foodItemsMeat);
        session.setAttribute("foodItemsDairy", foodItemsDairy);
        session.setAttribute("foodItemsFish", foodItemsFish);

        RequestDispatcher dispatcher = request.getRequestDispatcher("SelectFoodType/selectFoodType.jsp");
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
