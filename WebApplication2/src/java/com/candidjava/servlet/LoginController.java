package com.candidjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String un = request.getParameter("uname");
        String pwd = request.getParameter("pass");
        if (un.equals("candidjava")) {
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            out.print("Welcome, " + un);
            HttpSession session = request.getSession(true); // reuse existing
//            chain.doFilter(req, res);  											// session if exist
            // or create one
            session.setAttribute("user", un);
            session.setMaxInactiveInterval(30); // 30 seconds
            response.sendRedirect("home.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        } // TODO Auto-generated method stub

    }
}
