/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.FoodDAO;
import src.FoodItem;
import src.SuperMarket;
import src.SuperMarketDAO;

/**
 *
 * @author coola
 */
public class AddFoodToSuperMarket extends HttpServlet {

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
        
        String s = request.getParameter("selectSuperMarketForFood");
        String f = request.getParameter("selectFoodItemToBeAdded");
        
//        int superM = Integer.parseInt(s);
//        int foodI = Integer.parseInt(f);

//int superM = 3;
//        int foodI = 1;
//        
       
        SuperMarketDAO sm = new SuperMarketDAO();
        FoodDAO fd = new FoodDAO();
      
        fd.addItemToStore(s, f);
        
        List<SuperMarket> superMarketAddAdmin;
        superMarketAddAdmin = sm.getAllSuperMarkets();
        List<FoodItem> foodItemsAdmin;
        foodItemsAdmin = fd.getAllFoodItems();
    
        HttpSession session = request.getSession();
        session.setAttribute("testSM", s);
        session.setAttribute("testFD", f);
        session.setAttribute("superMarketAddAdmin", superMarketAddAdmin);
        session.setAttribute("foodItemsAdmin", foodItemsAdmin);

        RequestDispatcher dispatcher = request.getRequestDispatcher("AddItemToSuperMarket/addItemToSuperMarket.jsp");
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
