<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Blog Header</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<div class="nav-container">
			
			<div class="logo">
    			<a href="home.jsp" class="header-logo-link">myblog</a>
			</div>
			
			<% if (session.getAttribute("username") == null) { %>
			<div class="auth-buttons">
				<a href="login.jsp" class="btn-login">Login</a>

			</div>
			<% } %>

			<div class="hamburger" id="hamburger">
				<span></span> <span></span> <span></span>
			</div>

			<nav id="nav-links">

				<div class="mobile-username">
   					  Hi, 
   					 <%= session.getAttribute("username") != null ? session.getAttribute("username") : "Guest" %> 👤
				</div>


				<ul>
					<li><a href="${pageContext.request.contextPath}/home.jsp#home">Home</a></li>
					<li><a
						href="${pageContext.request.contextPath}/home.jsp#about">About</a></li>
					<li><a
						href="${pageContext.request.contextPath}/blogs_home">Blogs</a></li>
					<li><a
						href="${pageContext.request.contextPath}/home.jsp#contact">Contact</a></li>
				</ul>

				<% if (session.getAttribute("username") != null) { %>
				<div class="mobile-profile-toggle" id="mobile-profile-toggle">
					<span>👤 Profile</span>
				</div>
				 
				<div class="mobile-profile" id="mobile-profile">
				<a href="logout.jsp">🚪 Logout</a>
				</div>
				<% } %>
			</nav> 

			<% if (session.getAttribute("username") != null) { %>
			<div class="profile-desktop">
				<div class="profile-name" id="desktop-profile-toggle">
					 Hi,
					<%= session.getAttribute("username") %> 👤
				</div>
				
				<div class="dropdown" id="desktop-profile">
				 <a href="logout">🚪 Logout</a>
				</div>
			</div>
			<% } %>
		</div>
	</header>

	<script src="js/script.js"></script>
</body>
</html>
