/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Cart;
import src.CartDAO;
import src.User;

/**
 *
 * @author coola
 */
public class UpdateCart extends HttpServlet {

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
        Cart c = new Cart();
        c.setUserCartID(Integer.parseInt(request.getParameter("addUserIDCart")));
        c.setFoodItemID(Integer.parseInt(request.getParameter("addFoodItemIDCart")));
        c.setFoodQTY(Integer.parseInt(request.getParameter("addFoodQTYCart")));
//        int id =Integer.parseInt(request.getParameter("addUserIDCart"));
        int fID = Integer.parseInt(request.getParameter("addFoodItemIDCart"));
        int jID = Integer.parseInt(request.getParameter("addJourney").trim());
        String direction = request.getParameter("selectFIDirection");
        int id = 0;
        
        if (direction.equalsIgnoreCase("shoppingCart")) {
            User u = (User) request.getSession().getAttribute("uLog");
             id = u.getUserID();
        } else if (direction.equalsIgnoreCase("home")) {
             id = Integer.parseInt(request.getParameter("addUserIDCart"));
        }

//        User u = (User) request.getSession().getAttribute("uLog");
//        int id = u.getUserID();

//        String direction = request.getParameter("selectFIDirection");
        CartDAO cA = new CartDAO();

//        int jID = 9999;
        c.setFoodCarbon((int) cA.foodCarbon(fID, jID));

        cA.checkItem(id, fID);

        cA.addNewItem(c);

        if (direction.equalsIgnoreCase("shoppingCart")) {
            response.sendRedirect("getShoppingCart");
        } else if (direction.equalsIgnoreCase("home")) {
            response.sendRedirect("index.jsp");
        }

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
