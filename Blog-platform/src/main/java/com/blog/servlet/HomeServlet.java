package com.blog.servlet;

import com.blog.dao.BlogDao;
import com.blog.db.DBConnection;
import com.blog.model.Blog;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/blogs_home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BlogDao dao = new BlogDao(DBConnection.getConnection());
            List<Blog> blogList = dao.getAllBlogs();

            req.setAttribute("blogs", blogList);
            req.getRequestDispatcher("blogs_home.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            
            req.setAttribute("error", "Unable to load blogs. Please try again later.");
            req.getRequestDispatcher("blogs_home.jsp").forward(req, resp);
        }
    }
}
