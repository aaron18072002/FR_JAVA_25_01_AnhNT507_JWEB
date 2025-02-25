<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>List Page</title>
<link href="assets/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<c:if test="${not empty message}">
	    <div class="alert ${isSuccess ? 'alert-success' : 'alert-danger'}  alert-dismissible fade show" role="alert">
			${message}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<div class="container">
		<div class="list-page">
			<div class="buttons d-flex">
				<a href="<%=request.getContextPath()%>/GetPollServlet?status=Active" class="my-btn">Active</a> 
				<a href="<%=request.getContextPath()%>/GetPollServlet?status=Draft" class="my-btn"
					style="background-color: black; color: white; border: none">Drafts</a>
				<a href="<%=request.getContextPath()%>/GetPollServlet?status=Closed" class="my-btn">Closed</a>
			</div>

			<div class="list-items mt-5">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>The list of questions and issues within</th>
							<th>Management</th>
						</tr>
					</thead>
					<tbody id="tbody-list">
						<c:forEach var="poll" items="${polls}">
							<tr>
								<td>${poll.id}</td>
								<td>
									<a href="poll?id=${poll.id}">${poll.text}</a>
								</td>
								<td>
									<a href="view-result?id=${poll.id}" class="my-btn">View results</a>
									<c:if test="${status == 'Active' && sessionScope.userLogin != null}">
									    <a href="<%=request.getContextPath()%>/close-poll?id=${poll.id}" class="my-btn">Close poll</a>
									</c:if>
									<c:if test="${status == 'Closed' && sessionScope.userLogin != null}">
									    <a class="my-btn btn-delete">Delete</a>
									</c:if>									
									
								</td>
							</tr>
						</c:forEach> 
					</tbody>
				</table>
			</div>

			<div id="deleteModal" class="delete-modal">
				<div class="delete-modal-content">
					<p>Are you sure to delete?</p>
					<button class="btn btn-yes">Yes</button>
					<button class="btn btn-no">No</button>
				</div>
			</div>
		</div>

	</div>

	<!-- Scripts -->
	<script src="assets/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="assets/jquery/jquery.min.js"></script>
	<script src="js/create.js"></script>
	<script src="js/listQuestion.js"></script>
</body>
</html>
