<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
        <div class="alert alert-danger">
            <h2 class="text-center">Oops! Đã xảy ra lỗi.</h2>
            <p><strong>Thông báo lỗi:</strong> ${pageContext.exception.message}</p>
            <p><strong>Loại lỗi:</strong> 
                <% if (pageContext.getException() != null) { %>
                    <%= pageContext.getException().getClass().getName() %>
                <% } %>
            </p>
            <p><strong>Quay lại:</strong> <a href="${pageContext.request.contextPath}/index.jsp">Trang chủ</a></p>
        </div>
    </div>
</body>
</html>
