package com.blog.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blog.db.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String redirectParam = request.getParameter("redirect");

        try (Connection conn = DBConnection.getConnection()) {
        	
            PreparedStatement ps = conn.prepareStatement(
                "SELECT id, name, email FROM users WHERE email = ? AND password = ?"
            );
            
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                HttpSession session = request.getSession();
                session.setAttribute("userId", id);
                session.setAttribute("username", name);
                session.setAttribute("email", email);

              
                if (redirectParam != null && !redirectParam.trim().isEmpty()) {
                	
                    response.sendRedirect(redirectParam);
                } else {
                    response.sendRedirect("blogs_home");
                }

            } else {
              
                response.sendRedirect("login.jsp?error=invalid" + (redirectParam != null ? "&redirect=" + redirectParam : ""));
                    
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=exception" + 
                (redirectParam != null ? "&redirect=" + redirectParam : ""));
        }
    }
}
