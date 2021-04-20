/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.FoodDAO;
import src.JourneyDAO;
import src.TotalJourney;

/**
 *
 * @author coola
 */
public class createNewJourney extends HttpServlet {

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
        
        JourneyDAO jA = new JourneyDAO();
        List<TotalJourney> tj = new ArrayList<>();

        HttpSession session = request.getSession();
        String[] checkedJourneys = (String[]) session.getAttribute("countryForFoodJourney");
        
        int uid = jA.createUniqueJourneyID();
        int foodID = Integer.parseInt(request.getParameter("sfi").trim());
        int startCountryTest = Integer.parseInt(request.getParameter("sj").trim());
        int start = 0;
        for (String c : checkedJourneys) {
            int journeyLegID = Integer.parseInt(c.trim());
            
            if(journeyLegID == startCountryTest){
                start = 1;
            }
            else{
                start = 0;
            }
            TotalJourney j = new TotalJourney(uid,journeyLegID,start);
            tj.add(j);
        }

        
        jA.addNewJourney(tj);
        
        FoodDAO fA = new FoodDAO();
        fA.addCountryToFood(uid,foodID);
        
        
        response.sendRedirect("adminHomePage.jsp");
        
        
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
