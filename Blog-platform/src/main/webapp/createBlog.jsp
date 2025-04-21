<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
<%
    if (session.getAttribute("userId") == null) {
        String query = request.getQueryString();
        String fullPath = request.getRequestURI() + (query != null ? "?" + query : "");
        String encodedRedirect = java.net.URLEncoder.encode(fullPath, "UTF-8");

        response.sendRedirect("login.jsp?msg=Please+login+first&redirect=" + encodedRedirect);
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
</head>
<body>
    <div class="create-blog-page">
        <div class="container">
            <h2 class="form-title">Create New Blog</h2>

            <form id="blogForm" action="CreateBlogServlet" method="post" enctype="multipart/form-data">
                
                <label for="title">Title</label>
                <input type="text" id="title" name="title" class="form-input" required>

             
                <label for="editor-container">Content</label>
                <div id="editor-container" style="height: 300px;"></div>
                <textarea id="content" name="content" style="display:none;"></textarea>

              
                <label for="image">Image</label>
                <input type="file" id="image" name="image" class="form-input" accept="image/*">

                <button type="submit" class="submit-btn">Publish Blog</button>
            </form>

            <div class="back-link">
                <a href="home.jsp">← Back to Home</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <script>
        const quill = new Quill('#editor-container', {
            theme: 'snow',
            placeholder: 'Write your blog content here...',
            modules: {
                toolbar: [
                    [{ header: [1, 2, false] }],
                    ['bold', 'italic', 'underline'],
                    [{ color: [] }, { background: [] }],
                    ['blockquote', 'code-block'],
                    [{ list: 'ordered' }, { list: 'bullet' }],
                    [{ align: [] }],   
                ]
            }
        });

        document.addEventListener("DOMContentLoaded", function () {
            const form = document.getElementById("blogForm");
            const hiddenContent = document.getElementById("content");

            form.addEventListener("submit", function (e) {
                const htmlContent = quill.root.innerHTML.trim();

                if (htmlContent === "" || htmlContent === "<p><br></p>") {
                    alert("Please write some content before publishing.");
                    e.preventDefault();
                    return;
                }

                hiddenContent.value = htmlContent;
            });
        });
    </script>
    <jsp:include page="includes/footer.jsp" />
</body>
</html>
