<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="./assests/css/bootstrap.min.css" />
<style>
	body {
		background-color: #f8f9fa;
	}
	
	.register-container {
		margin-top: 100px;
	}
	
	.register-box {
		max-width: 400px;
		margin: auto;
		padding: 20px;
		background: white;
		border-radius: 8px;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	}
	
	.register-box .btn {
		width: 100%;
	}
</style>
<script src="./assests/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="container register-container">
		<div class="register-box">
			<h4 class="text-center">Register</h4>
			<form action="<%=request.getContextPath()%>/MemberRegisterServlet" 
				method="get">
				<div class="form-group">
					<label for="username">User name</label> 
					<input type="text" name="username" class="form-control" id="username" placeholder="User name">
				</div>
				<div class="form-group">
					<label for="email">E-mail</label> 
					<input type="email" name="email" class="form-control" id="email" placeholder="E-mail">
				</div>
				<div class="form-group">
					<label for="password">Password</label> 
					<input type="password" name="password" class="form-control" id="password" placeholder="Password">
				</div>
				<div class="form-group">
					<label for="repassword">Re Password</label> 
					<input type="password" name="repassword" class="form-control" id="repassword" placeholder="Re Password">
				</div>
				<button type="submit" class="btn btn-success mt-3">Register</button>
			</form>
			<div class="text-center mt-2">
				<a href="<%=request.getContextPath()%>/login.jsp">Click here to Login</a>
			</div>
			
			<c:if test="${not empty errors}">
				<div class="alert alert-danger">
					<ul>
						<c:forEach var="error" items="${errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>
