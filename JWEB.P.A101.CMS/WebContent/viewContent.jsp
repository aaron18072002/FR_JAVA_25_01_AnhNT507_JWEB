<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <jsp:forward page="ContentViewServlet" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Content</title>
<link rel="stylesheet" href="./assests/css/bootstrap.min.css" />
<link rel="stylesheet" href="./assests/fontawesome/css/all.min.css" />
<style>
	* {
		margin: 0;
		padding: 0;
		border: 0;
		box-sizing: border-box;
	}
	
	body, html {
		height: 100vh;
		margin: 0;
	}
	
	.wrapper {
		display: flex;
		height: 100vh;
	}
	
	.sidebar {
		width: 300px;
		background: #f8f9fa;
		/* padding: 15px; */
	}
	
	.sidebar-title {
		padding: 15px;
		border-bottom: 1px solid #D4D4D4;
		margin-bottom: 30px
	}
	
	.search-box {
		display: flex;
		align-items: center;
		border: 1px solid #ccc;
		border-radius: 5px;
		overflow: hidden;
	}
	
	.search-box input {
		border: none;
		padding: 8px 10px;
		flex: 1;
		outline: none;
	}
	
	.search-box .search-icon {
		padding: 8px 12px;
		background: white;
		color: #555;
		border-left: 1px solid #ccc;
	}
	
	.content {
		flex-grow: 1;
		display: flex;
		flex-direction: column;
	}
	
	.navbar {
		border-bottom: 1px solid #D4D4D4;
		background-color: #f8f9fa;
	}
	
	.form-title {
		width: 100%;
		padding: 30px 0px 0px 0px;
		border-bottom: 1px solid #D4D4D4;
		margin-bottom: 30px;
	}
	
	.form-container {
		width: 80%;
		padding: 30px;
	}
	
	.nav.flex-column {
		width: 250px;
		background: #f8f9fa;
		padding: 10px;
		border-radius: 5px;
	}
	
	.nav.flex-column .nav-link {
		color: #007bff;
		padding: 10px;
		border-radius: 5px;
		display: flex;
		align-items: center;
	}
	
	.nav.flex-column .nav-link:hover {
		background: #e9ecef;
		text-decoration: none;
	}
	
	.nav.flex-column .nav-link i {
		margin-right: 10px;
	}
	
	.dropdown-menu {
		right: 0 !important;
		left: auto !important;
	}
	
	.dropdown-item i {
		margin-right: 8px;
	}
	
	.table tbody tr:nth-child(odd) {
		background-color: #f2f2f2;
	}
	
	.card-header {
		padding-top: 1.25rem;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<!-- Sidebar -->
		<nav class="sidebar d-none d-md-block">
			<div class="sidebar-title">
				<h5 style="margin: 0px">CMS</h5>
			</div>
			<div style="padding: 15px">
				<form action="<%=request.getContextPath()%>/SearchContentServlet"
					method="GET" class="search-box">
					<input type="text" name="title" placeholder="Search...">
					<button type="submit" class="search-icon">
						<i class="fas fa-search"></i>
					</button>
				</form>
				
				<ul class="nav flex-column">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/ContentViewServlet"><i
							class="fas fa-th-list"></i> View contents</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/addContent.jsp"><i
							class="fas fa-edit"></i> Form content</a></li>
				</ul>
			</div>
		</nav>

		<!-- Main content -->
		<div class="content">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<div class="dropdown ml-auto">
						<button class="btn btn-light dropdown-toggle" type="button"
							data-toggle="dropdown">
							<i class="fas fa-user"></i>
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="<%=request.getContextPath()%>/edit.jsp">
							<i class="fas fa-user"></i>
								User Profile</a> 
							<a class="dropdown-item" href="<%=request.getContextPath()%>/MemberLogoutServlet">
							<i class="fas fa-sign-out-alt"></i> Logout
							</a>
						</div>
					</div>
				</div>
			</nav>

			<div class="form-container">
				<div class="form-title">
					<h2>View Content</h2>
				</div>
				<div class="card">
					<div class="card-header">
						<h5>View Content List</h5>
					</div>
					<div class="card-body">
						<table id="contentTable" class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Title</th>
									<th>Brief</th>
									<th>Created Date</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
					                <c:when test="${empty contents}">
					                    <tr>
					                        <td colspan="4" class="text-center">Không có nội dung nào</td>
					                    </tr>
					                </c:when>
					                <c:otherwise>
					                    <c:forEach var="content" items="${contents}" varStatus="status">
					                        <tr>
					                            <td>${status.index + 1}</td>
					                            <td>${content.title}</td>
					                            <td>${content.brief}</td>
					                            <td>${content.createDate}</td>
					                        </tr>
					                    </c:forEach>
					                </c:otherwise>
					            </c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		
		<%-- $(document).ready(function() {
		    $.ajax({
		    	url: "<%= request.getContextPath() %>/ContentViewServlet",
		        method: "GET",
		        dataType: "json",
		        success: function(response) {
		            var tableBody = $("#contentTable tbody");
		            tableBody.empty();
		
		            if (response.length === 0) {
		                tableBody.append("<tr><td colspan='4' class='text-center'>Không có nội dung nào</td></tr>");
		                return;
		            }
		 
		            $.each(response, function(index, content) {
		                var row = "<tr>" +
		                    "<td>" + (index + 1) + "</td>" +
		                    "<td>" + content.title + "</td>" +
		                    "<td>" + content.brief + "</td>" +
		                    "<td>" + content.content + "</td>" +
		                    "</tr>";
		                tableBody.append(row);
		            });
		        },
		        error: function(xhr, status, error) {
		            console.error("Lỗi khi lấy dữ liệu:", error);
		            $("#contentTable tbody").append("<tr><td colspan='4' class='text-center text-danger'>Lỗi tải dữ liệu</td></tr>");
		        }
		    });
		}); --%>
		
		</script>


	<script src="./assests/js/jquery-3.7.1.min.js"></script>
	<script src="./assests/js/bootstrap.bundle.min.js"></script>
</body>
</html>