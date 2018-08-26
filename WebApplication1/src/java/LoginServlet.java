
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (password.equals("admin123")) {
            out.print("Welcome, " + name);
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect("login.html"); // No logged-in user found, so redirect to login page.
        }
        } else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        
        
        out.close();
        
        
    }

}
