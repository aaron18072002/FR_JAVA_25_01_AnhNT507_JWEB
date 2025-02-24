<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
 <style>
        body {
            background-color: #ccc;
        }
        .register-container {
            max-width: 400px;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
	<div class="container">
    <div class="register-container">
        <h4 class="text-center">Register</h4>
        <form action="registerServlet" method="post">
            <div class="form-group">
                <label for="alias">Alias:</label>
                <input type="text" class="form-control" id="alias" name="alias" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe">
                <label class="form-check-label" for="rememberMe">Remember me</label>
            </div>
            <button type="submit" class="btn btn-success btn-block mt-3">Sign Up</button>
            <button type="button" class="btn btn-secondary btn-block mt-2">Close</button>
        </form>
    </div>
</div>
</body>
</html>