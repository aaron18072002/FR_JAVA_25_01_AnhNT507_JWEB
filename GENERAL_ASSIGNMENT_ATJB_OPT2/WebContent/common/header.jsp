<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">Quản lý Máy & Dịch vụ</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown mr-3"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Máy </a>
				<div class="dropdown-menu">
					<a class="dropdown-item"
						href="<%= request.getContextPath()%>/machine/create.jsp">Tạo
						mới</a> <a class="dropdown-item"
						href="<%= request.getContextPath()%>/SearchComputerServlet">Danh
						sách máy</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item"
						href="<%= request.getContextPath()%>/DisplayDataComputerServlet">Đăng
						ký sử dụng máy</a>
				</div></li>
			<li class="nav-item dropdown mr-3"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Dịch vụ </a>
				<div class="dropdown-menu">
					<a class="dropdown-item"
						href="<%= request.getContextPath()%>/service/create.jsp">Tạo
						mới</a> <a class="dropdown-item"
						href="<%= request.getContextPath()%>/SearchServiceServlet">Danh
						sách DV</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item"
						href="<%=request.getContextPath()%>/DisplayDataServiceServlet">Đăng
						ký sử dụng DV</a>
				</div></li>
			<li class="nav-item dropdown mr-3"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Khách hàng </a>
				<div class="dropdown-menu">
					<a class="dropdown-item"
						href="<%= request.getContextPath()%>/customer/create.jsp">Tạo
						mới</a> <a class="dropdown-item"
						href="<%= request.getContextPath()%>/SearchCustomerServlet">Danh
						sách KH</a>
					<div class="dropdown-divider"></div>
					<!-- <a class="dropdown-item" href="#">Đăng ký sử dụng DV</a> -->
				</div></li>
		</ul>
	</div>
</nav>