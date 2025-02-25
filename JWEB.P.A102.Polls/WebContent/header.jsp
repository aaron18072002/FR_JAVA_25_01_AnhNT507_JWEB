<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="mb-4">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Polls</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<c:if test="${sessionScope.userLogin != null}">
					    <li id="btn-create" class="nav-item"><a class="nav-link"
						href="create.jsp">Create</a></li>
					</c:if>	
					
					<li id="btn-list" class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/GetPollServlet">List</a></li>
				</ul>
				<c:choose>
					<c:when test="${sessionScope.userLogin == null}">
						<%-- Hiển thị nút Login nếu user chưa đăng nhập --%>
						<button type="button" class="btn btn-dark" data-bs-toggle="modal"
							data-bs-target="#staticBackdrop">Login</button>
					</c:when>
					<c:otherwise>
						<%-- Hiển thị dropdown nếu user đã đăng nhập --%>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">Hello,
								${sessionScope.userLogin.userName}!</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="logout">Logout</a></li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>
</header>

<!-- Login -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">Login</h5>
			</div>
			<form class="modal-body" 
				action="<%=request.getContextPath()%>/UserLoginServlet" method="post">
				<div class="mb-3">
					<label for="inpAllias" class="form-label">Allias:</label> <input
						type="text" class="form-control" id="inpAllias" name="userName" />
				</div>
				<div class="mb-3">
					<label for="inpPassword" class="form-label">Password:</label> <input
						type="password" class="form-control" id="inpPassword"
						name="password" />
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault" /> <label class="form-check-label"
						for="flexCheckDefault"> Remember me </label>
				</div>
				<button type="submit" class="btn btn-success mt-5 mb-5">Sign
					In</button>
			</form>
			<div class="modal-footer d-flex justify-content-center">
				<button type="button" class="btn my-btn" data-bs-dismiss="modal">
					Close</button>
			</div>
		</div>
	</div>
</div>