<%@ page import="java.util.*, com.blog.model.Blog"%>
<%@ page session="true" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <%@ include file="includes/header.jsp"%>

    <div class="bloghome-container">
        <h2><%= request.getAttribute("pageTitle") != null ? request.getAttribute("pageTitle") : "Latest Blogs" %></h2>

        <div class="blog-cards">
            <%
                List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
                if (blogs != null && !blogs.isEmpty()) {
                    for (Blog blog : blogs) {
            %>
                <div class="blog-card">
                    <img src="images/<%= blog.getImagePath() %>" alt="Blog Image">
                    <h3><%= blog.getTitle() %></h3>
                    <p><%= blog.getContent().length() > 100 ? blog.getContent().substring(0, 100) + "..." : blog.getContent() %></p>
                    <p><strong>Author:</strong> <%= blog.getAuthorName() %></p>
                    <a href="viewBlog?id=<%= blog.getId() %>">Read More</a>
                </div>
            <%
                    }
                } else {
            %>
                <p>No blogs found.</p>
            <%
                }
            %>
        </div>

        <%
            Object userId = session.getAttribute("userId");
            if (userId != null) {
        %>
            <a href="createBlog.jsp" class="floating-plus-btn" title="Create New Blog">
                <span>+</span>
            </a>
        <%
            } else {
        %>
            <a href="login.jsp?redirect=blogs_home" class="floating-plus-btn" title="Please login to create a blog">
                <span>+</span>
            </a>
        <%
            }
        %>
    </div>

    <%@ include file="includes/footer.jsp"%>
</body>
</html>
