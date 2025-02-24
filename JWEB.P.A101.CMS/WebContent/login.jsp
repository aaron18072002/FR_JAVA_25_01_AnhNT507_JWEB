<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="./assests/css/bootstrap.min.css" />
<script src="./assests/js/jquery-3.7.1.min.js"></script>

<style>
	body {
		background-color: #f8f9fa;
	}
	
	.login-container {
		margin-top: 100px;
	}
	
	.login-box {
		max-width: 400px;
		margin: auto;
		padding: 20px;
		background: white;
		border-radius: 8px;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	}
	
	.login-box .btn {
		width: 100%;
	}
	
	.error-message {
        color: red;
        text-align: center;
        margin-top: 10px;
    }
</style>
</head>
<body>
	<div class="container login-container">
		<div class="login-box">
			<h4 class="text-center">Please Sign In</h4>
			<form action="<%=request.getContextPath()%>/MemberLoginServlet" method="get">
				<div class="form-group">
					<label for="email">E-mail</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="E-mail">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password" placeholder="Password">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="rememberMe">
					<label class="form-check-label" for="rememberMe">Remember
						Me</label>
				</div>
				<button type="submit" class="btn btn-success mt-3">Login</button>
				
                <%
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) {
                %>
                    <div class="error-message"><%= errorMessage %></div>
                <%
                    }
                %>
			</form>
			<div class="mt-2">
				<a href="<%=request.getContextPath()%>/register.jsp">Click here to Register</a>
			</div>
		</div>
	</div>
</body>
</html>