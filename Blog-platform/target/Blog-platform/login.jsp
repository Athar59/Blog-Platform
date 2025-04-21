<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:include page="includes/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/styles.css">

<style>
.login-alert-message {
	background-color: #ffe0e0;
	color: #cc0000;
	padding: 10px 20px;
	border: 1px solid #cc0000;
	border-radius: 6px;
	margin: 15px auto;
	max-width: 400px;
	text-align: center;
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="bg-wrapper">
		<div class="login-container">
			<h2 class="login-title">Welcome Back</h2>

			<%
			String paramMsg = request.getParameter("msg");
			if (paramMsg != null) {
			%>
			<div class="login-alert-message"><%=paramMsg%></div>
			<%
			}
			%>

			<%
			String sessionMsg = (String) session.getAttribute("msg");
			if (sessionMsg != null) {
			%>
			<div class="login-alert-message"><%=sessionMsg%></div>
			<%
			session.removeAttribute("msg");
			}
			%>

			<form action="login" method="post">
				<%
				   String redirect = request.getParameter("redirect");
				   if (redirect != null && !redirect.trim().isEmpty()) {
				%>
				<input type="hidden" name="redirect" value="<%=redirect%>">
				
				<%
				}
				%>
				
				<input type="email" name="email" placeholder="Email" class="login-input" required>	
						
				<input type="password" name="password" placeholder="Password" class="login-input" required>
					
				<button type="submit" class="login-button">Login</button>
				
			</form>
			<p class="login-message">
				Don't have an account? <a href="register.jsp">Register</a>
			</p>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>
