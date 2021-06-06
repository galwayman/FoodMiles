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
import src.SuperMarketDAO;

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

        List<FoodItem> foodItems = new ArrayList<>();
        List<FoodItem> irishItemsFish;
        List<FoodItem> irishItemsMeat;
        List<FoodItem> irishItemsFruit;
        List<FoodItem> irishItemsVegetables;
        List<FoodItem> irishItemsDairy;
        
        String sm = request.getParameter("superMarket");
        
         SuperMarketDAO irish = new SuperMarketDAO();
        irishItemsFish = irish.getIrishFoodItemsFish(sm);
        irishItemsMeat = irish.getIrishFoodItemsMeat(sm);
        irishItemsFruit = irish.getIrishFoodItemsFruit(sm);
        irishItemsVegetables = irish.getIrishFoodItemsVegetables(sm);
        irishItemsDairy = irish.getIrishFoodItemsDairy(sm);
        
       
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
            
            
            ResultSet rs = statement.executeQuery("select * from foodItem where foodItemID in (select fID from superMarketItems where smID = ?);");
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

                foodItems.add(f);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }

        List<FoodItem> foodItemsFruit;
        List<FoodItem> foodItemsVegetables;
        List<FoodItem> foodItemsMeat;
        List<FoodItem> foodItemsDairy;
        List<FoodItem> foodItemsFish;
        
        
        
        String s = request.getParameter("superMarket");
        
        FoodDAO fA = new FoodDAO();
        
        foodItemsFruit = fA.getSuperMarketItemsFruit(sm);
        foodItemsVegetables = fA.getSuperMarketItemsVeg(sm);
        foodItemsMeat = fA.getSuperMarketItemsMeat(sm);
        foodItemsDairy = fA.getSuperMarketItemsDairy(sm);
        foodItemsFish = fA.getSuperMarketItemsFish(sm);

        
        HttpSession session = request.getSession();
        session.setAttribute("foodItemsFruit", foodItemsFruit);
        session.setAttribute("foodItemsVegetables", foodItemsVegetables);
        session.setAttribute("foodItemsMeat", foodItemsMeat);
        session.setAttribute("foodItemsDairy", foodItemsDairy);
        session.setAttribute("foodItemsFish", foodItemsFish);
        session.setAttribute("irishFoodItemsFish", irishItemsFish);
        session.setAttribute("irishFoodItemsMeat", irishItemsMeat);
        session.setAttribute("irishItemsFruit", irishItemsFruit);
        session.setAttribute("irishItemsVegetables", irishItemsVegetables);
        session.setAttribute("irishItemsDairy", irishItemsDairy);

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
