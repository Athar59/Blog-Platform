package com.blog.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Timestamp;

import com.blog.dao.BlogDao;
import com.blog.db.DBConnection;
import com.blog.model.Blog;

@WebServlet("/CreateBlogServlet")
@MultipartConfig
public class CreateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
                response.getWriter().println("Title and content cannot be empty.");
                return;
            }

            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            
            int authorId = (int) session.getAttribute("userId");

            Part imageUploadPart = request.getPart("image");
            String fileName = Paths.get(imageUploadPart.getSubmittedFileName()).getFileName().toString();

            String uploadPath = getServletContext().getInitParameter("uploadDir");
            
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            if (!fileName.isEmpty()) {
                imageUploadPart.write(uploadPath + File.separator + fileName);
            }

            Connection conn = DBConnection.getConnection();
            BlogDao dao = new BlogDao(conn);

            Blog blog = new Blog();
            blog.setTitle(title);
            blog.setContent(content);
            blog.setImagePath(fileName);
            blog.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            blog.setAuthorId(authorId); 

            boolean inserted = dao.addBlog(blog);
            if (inserted) {
                response.sendRedirect("blogs_home");
            } else {
                response.getWriter().println("Blog could not be created. Please try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }
}
