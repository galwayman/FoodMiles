/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import src.Country;
import src.CountryDAO;
import src.EndCountry;

/**
 *
 * @author coola
 */
@MultipartConfig
public class AddNewStartCountry extends HttpServlet {

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

        String scID = request.getParameter("startCountryName") + "Start";
        String scN = request.getParameter("startCountryName");
        String ecID = request.getParameter("startCountryName") + "End";
        String ecN = request.getParameter("startCountryName");

        InputStream inputStream = null;
        InputStream inputStreamEnd = null;	// input stream of the upload file 

        // obtains the upload file part in this multipart request 
        Part filePart = request.getPart("startCountryImageAdmin");
        Part filePart1 = request.getPart("startCountryImageAdmin");
        if (filePart != null) {
            // prints out some information for debugging 
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file 
            inputStream = filePart.getInputStream();
        }
        if (filePart1 != null) {
            // prints out some information for debugging 
            System.out.println(filePart1.getName());
            System.out.println(filePart1.getSize());
            System.out.println(filePart1.getContentType());

            // obtains input stream of the upload file 
            inputStreamEnd = filePart1.getInputStream();
        }

        CountryDAO cA = new CountryDAO();
        cA.addNewStartCountry(scID, scN, inputStream);
        cA.addNewEndCountry(ecID, ecN, inputStreamEnd);

        response.sendRedirect("getCountries");
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
