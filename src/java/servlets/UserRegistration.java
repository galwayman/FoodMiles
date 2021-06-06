/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.User;
import src.UserDAO;

/**
 *
 * @author coola
 */
public class UserRegistration extends HttpServlet {

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

        UserDAO newUser = new UserDAO();

        int userID = newUser.createUniqueID();
        String userNameReg = request.getParameter("userNameReg");
        String userEmailReg = request.getParameter("userEmailReg");
        String userPasswordReg = request.getParameter("userPasswordReg");
        String passwordQuestion = request.getParameter("passwordQuestion");
        int premium = 0;
        int admin = 0;
        int testUserName;
        int testUserEmail;
        int profilePic = 0;

        testUserName = newUser.checkForUserName(userNameReg);
        testUserEmail = newUser.checkForUserEmail(userEmailReg);

        
        User n = new User(userID, userNameReg, userEmailReg, userPasswordReg, premium, admin, profilePic,passwordQuestion);
        HttpSession session = request.getSession();
        if (testUserName == 1) {

            if (testUserEmail == 1) {
                newUser.addNew(n);

                session.setAttribute("uLog", n);
                response.sendRedirect("index.jsp");
            } else {

                
            response.sendRedirect("UserReg/userReg.jsp?message=hello");

            }
        } else {
            response.sendRedirect("UserReg/userReg.jsp?message=hello");
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
