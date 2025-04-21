<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body class="home-page">

	<jsp:include page="includes/header.jsp" />

	<!-- Hero Section -->
	<section class="hero">
		<div class="hero-text">
			<h1>Welcome to the Blog Platform</h1>
			<p>Share your thoughts, connect with others, and explore a world
				of stories.</p>
			<a href="blogs_home" class="btn">Explore blogs</a>
		</div>
		<div class="hero-img">
		<img src="${pageContext.request.contextPath}/assets/blog.png" alt="Blog Illustration">
		</div>
	</section>

	<!-- about section -->
	<jsp:include page="includes/about.jsp" />

	<!-- Features Section -->
	<section id="features" class="features">
	<h2>Why Choose This Blog Platform </h2>
	<div class="feature-grid">
		<div class="feature">
			<img src="${pageContext.request.contextPath}/assets/write-icon.png" alt="Write Icon">
			<h3>Write Freely</h3>
			<p>Express your thoughts in an easy-to-use editor built for bloggers.</p>
		</div>
		<div class="feature">
			<img src="${pageContext.request.contextPath}/assets/connect-icon.png" alt="Connect Icon">
			<h3>Connect</h3>
			<p>Engage with a community of like-minded readers and writers.</p>
		</div>
		<div class="feature">
			<img src="${pageContext.request.contextPath}/assets/explore-icon.png" alt="Explore Icon">
			<h3>Explore</h3>
			<p>Discover trending stories and follow your favorite authors.</p>
		</div>
	</div>
</section>

	<!-- contact section -->
	<jsp:include page="includes/contact.jsp" />

	<!-- footer section -->
	<jsp:include page="includes/footer.jsp" />
	<script src="js/script.js"></script>
	
</body>
</html>
