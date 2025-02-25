<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="assets/js/jquery.min.js"></script>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/assets/fontawesome/all.min.css">
<script src="assets/js/bootstrap.min.js"></script>
<title>Quản lý sử dụng máy</title>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<!-- Nội dung động -->
	<div class="container mt-4">
		<h2>Chào mừng đến hệ thống quản lý</h2>
		<p>Chọn một chức năng từ menu.</p>
	</div>

	<!-- Footer -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>