/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.User;
import src.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import src.User;

/**
 *
 * @author coola
 */
@WebServlet(name = "loginDirect", urlPatterns
        = {
            "/loginDirect"
        })
public class loginDirect extends HttpServlet {

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

        String uE = request.getParameter("userEmailLogin");
        String uP = request.getParameter("userPasswordLogin");

        UserDAO us = new UserDAO();

        User uLog = us.getUser(uE, uP);
        int admin1 = uLog.getAdmin();
        int testEmail = us.checkForUserEmail(uE);
        

        if (testEmail == 0) {
int testPass = us.checkPassword(uP,uE);
            if (testPass == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("uLog", uLog);

                if (admin1 == 0) {
                    response.sendRedirect("index.jsp");
                } else if (admin1 == 1) {
                    response.sendRedirect("adminHomePage.jsp");
                }
            } else if (testPass == 1) {
                response.sendRedirect("Login Page/login.jsp");
            }

        } else if (testEmail == 1) {
            response.sendRedirect("Login Page/login.jsp");
        }

//        HttpSession session = request.getSession();
//        session.setAttribute("uLog", uLog);
//
//        if (admin1 == 0) {
//            response.sendRedirect("index.jsp");
//        } else if (admin1 == 1) {
//            response.sendRedirect("adminHomePage.jsp");
//        }

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
