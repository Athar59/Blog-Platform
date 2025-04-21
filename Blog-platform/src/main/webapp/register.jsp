<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="includes/header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="bg-wrapper">
        <div class="register-container">
            <h2 class="register-title">Create Account</h2>
            <form action="register" method="post">
                <input type="text" name="name" placeholder="Username" class="register-input" required>
                <input type="email" name="email" placeholder="Email" class="register-input" required>
                <input type="password" name="password" placeholder="Password" class="register-input" required>
                <button type="submit" class="register-button">Register</button>
            </form>
            <p class="register-message">Already have an account? <a href="login.jsp">Login</a></p>
        </div>
    </div>
</body>
</html>
<jsp:include page="includes/footer.jsp" />