/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.Country;
import src.CountryDAO;
import src.DeliveryDAO;
import src.DeliveryType;
import src.EndCountry;
import src.JourneyLeg;
import src.TravelLegDAO;

/**
 *
 * @author coola
 */
public class AddNewLeg extends HttpServlet {

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

        TravelLegDAO tl = new TravelLegDAO();
        int ui = tl.createUniqueTravelLegID();

        JourneyLeg jl = new JourneyLeg();
        jl.setLegID(ui);

        jl.setStartCountry(request.getParameter("startC"));
        jl.setEndCountry(request.getParameter("endC"));
        jl.setDistanceTravelled(Integer.parseInt(request.getParameter("dt")));
        jl.setTransportUsed(Integer.parseInt(request.getParameter("tu").trim()));

        tl.addNewLeg(jl);

        CountryDAO cA = new CountryDAO();
        DeliveryDAO dA = new DeliveryDAO();

        List<Country> startCountriesJourney = cA.getStartCountries();
        List<EndCountry> endCountriesJourney = cA.getEndCountries();
        List<DeliveryType> deliveryTypeJourney = dA.getDeliveryTypes();

        HttpSession session = request.getSession();
        session.setAttribute("startCountriesJourney", startCountriesJourney);
        session.setAttribute("endCountriesJourney", endCountriesJourney);
        session.setAttribute("deliveryTypeJourney", deliveryTypeJourney);

//        response.sendRedirect("getTravelLegDetails");
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
