<%@ page import="com.blog.model.Blog"%>

<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
</head>
<body>
	<%@ include file="includes/header.jsp"%>

	<div class="viewblog-container">
		<%
		Blog blog = (Blog) request.getAttribute("blog");
		if (blog != null) {
		%>
		<div class="blog-detail">
			<h2><%=blog.getTitle()%></h2>

			<div class="blog-image">
				<img src="images/<%=blog.getImagePath()%>" alt="Blog Image">
			</div>

			<div class="blog-content">
				<%=blog.getContent()%>
			</div>

			<p>
				<strong>Author:</strong>
				<%=blog.getAuthorName()%>
			</p>
		</div>
		<%
		} else {
		%>
		<p>Blog post not found.</p>
		<%
		}
		%>
	</div>

	<%@ include file="includes/footer.jsp"%>
	<script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>
</html>
