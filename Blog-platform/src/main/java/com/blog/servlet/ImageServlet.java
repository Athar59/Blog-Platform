package com.blog.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    private String imagePath;

    @Override
    public void init() throws ServletException {
    	
        imagePath = getServletContext().getInitParameter("uploadDir");
        
        if (imagePath == null) {
        	
            throw new ServletException("Upload directory not configured");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String requestedFileName = request.getPathInfo(); 

        if (requestedFileName == null || requestedFileName.equals("/")) {
        	
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        File imageFile = new File(imagePath, requestedFileName);
        
        if (!imageFile.exists()) {
        	
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String contentType = getServletContext().getMimeType(imageFile.getName());
        
        if (contentType == null) {
        	
            String name = imageFile.getName().toLowerCase();
            if (name.endsWith(".jpeg") || name.endsWith(".jpg")) contentType = "image/jpeg";
            else if (name.endsWith(".png")) contentType = "image/png";           
            else if (name.endsWith(".webp")) contentType = "image/webp";
            else contentType = "application/octet-stream";
        }

        response.setContentType(contentType);
        response.setContentLengthLong(imageFile.length());

        try (FileInputStream in = new FileInputStream(imageFile);
             OutputStream out = response.getOutputStream()) {
        	
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
