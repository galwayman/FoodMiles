/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import src.FoodDAO;

/**
 *
 * @author coola
 */

@MultipartConfig//Very Important****************
public class AddNewFoodItemAdmin extends HttpServlet {

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

       FoodDAO fd = new FoodDAO();
        int id =fd.getUniqueFoodIDAdmin();

        // gets values of text fields 
        String fnA = request.getParameter("foodNameAdmin");
        int oA = Integer.parseInt(request.getParameter("organicAdmin"));
        int isA = Integer.parseInt(request.getParameter("irishSourcedAdmin"));
        
        String fcA = request.getParameter("foodClassAdmin");
        String ftA = request.getParameter("foodTypeAdmin");
        double isW = Double.parseDouble(request.getParameter("foodWeightAdmin"));

        
        InputStream inputStream = null;	// input stream of the upload file 

        // obtains the upload file part in this multipart request 
        Part filePart = request.getPart("foodImageAdmin");
        if (filePart != null) {
            // prints out some information for debugging 
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file 
            inputStream = filePart.getInputStream();
        }
        
        
        fd.createNewFoodItem(id,fnA,oA,isA,inputStream,fcA,ftA,isW);

         RequestDispatcher dispatcher = request.getRequestDispatcher("getFoodItemsAdmin");
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
