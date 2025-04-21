package com.blog.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

import com.blog.db.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
        	
            Connection con = DBConnection.getConnection();
            
            PreparedStatement ps = con.prepareStatement(
            		
                "INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            int rows = ps.executeUpdate();

            if (rows > 0) {
            	
                response.sendRedirect("login.jsp?success=registered");
            } else {
                response.sendRedirect("register.jsp?error=failed");
            }


        } catch (Exception e) {
        	
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=exception");
        }
    }
}
