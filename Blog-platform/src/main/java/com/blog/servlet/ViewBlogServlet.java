package com.blog.servlet;

import com.blog.dao.BlogDao;
import com.blog.db.DBConnection;
import com.blog.model.Blog;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/viewBlog")
public class ViewBlogServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        try {
        	
            String idParam = req.getParameter("id");

            if (idParam == null || idParam.trim().isEmpty()) {
            	
                resp.sendRedirect("blogs_home.jsp?error=Missing blog ID");
                return;
            }

            int blogId = Integer.parseInt(idParam);
            
            BlogDao dao = new BlogDao(DBConnection.getConnection());
            
            Blog blog = dao.getBlogById(blogId);

            if (blog != null) {
            	
                req.setAttribute("blog", blog);
                req.getRequestDispatcher("viewBlog.jsp").forward(req, resp);
                
            } else {
            	
                resp.sendRedirect("blogs_home.jsp?error=Blog not found");
            }

        } catch (NumberFormatException e) {
        	
            e.printStackTrace();
            resp.sendRedirect("blogs_home.jsp?error=Invalid blog ID format");
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            resp.sendRedirect("blogs_home.jsp?error=Unable to load blog");
        }
    }
}
