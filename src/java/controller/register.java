/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author FPT
 */
public class register extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String studentCode = request.getParameter("student_code");
        String studentName = request.getParameter("student_name");
        String dobStr = request.getParameter("dob");

        boolean validStudentCode = false;
        if (studentCode != null && studentCode.startsWith("ICT") && studentCode.length() <= 9) {
            validStudentCode = true;
        }

        boolean validStudentName = false;
        if (studentName != null && studentName.length() >= 6 && studentName.length() <= 32) {
            validStudentName = true;
        }

        boolean validDobAndAge = false;
        if (dobStr != null) {
            LocalDate dob = LocalDate.parse(dobStr);
            Period age = Period.between(dob, LocalDate.now());
            if (age.getYears() >= 18) {
                validDobAndAge = true;
            }
        }
        if (validStudentCode && validStudentName && validDobAndAge) {
            out.println("<p>Student registered successful.</p>");
        } else {
            if (!validStudentCode) {
                out.println("<p>Student Code must begin with \"FPT\" and contains maximum 9 characters</p>");
            }
            if (!validStudentName) {
                out.println("<p>Student Name must contain 6 to 32 characters</p>");
            }
            if (!validDobAndAge) {
                out.println("<p>Student must be 18-year-old or older.</p>");
            }
        }
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
