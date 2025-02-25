<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/fontawesome/css/all.min.css">
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
<title>Quản lý sử dụng máy</title>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<%
	int currentRecord = (int) request.getAttribute("currentRecord");
	%>

	<%
	long total = (long) request.getAttribute("total");
	%>

	<%
	String errorDelete = (String) request.getAttribute("errorDelete");
	%>

	<%
	if (errorDelete != null) {
	%>
	<p class="text-danger font-weight-bold"><%=errorDelete%></p>
	<%
	}
	%>


	<div class="container mt-3 mb-3">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/SearchComputerServlet"
					method="get">
					<div class="form-row">
						<div class="form-group col">
							<label for="maKH">Mã Máy</label> <input type="text"
								class="form-control" name="computerId" id="computerId"
								placeholder="Mxxxxx">
						</div>
						<div class="form-group col">
							<label for="customerName">Vị Trí</label> <input type="text"
								class="form-control" name="position" id="customerName"
								placeholder="Khu A">
						</div>
						<div class="form-group col">
							<label for="address">Trạng Thái</label> <select name="status"
								class="form-control" id="status">
								<option value="">-- Chọn trạng thái --</option>
								<option value="Ranh">Rảnh</option>
								<option value="Ban">Bận</option>
								<option value="Dang sua chua">Đang sửa chữa</option>
							</select>
						</div>
					</div>

					<div class="form-row">
						<button type="submit" id="btn-Sub" class="btn btn-primary mb-2 ">Tim
							kiem</button>
						`
					</div>
				</form>
				`
			</div>
		</div>
	</div>


	<div class="container mt-4">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">MaMay</th>
					<th scope="col">ViTri</th>
					<th scope="col">TrangThai</th>
					<th scope="col">Action></th>
				</tr>
			</thead>
			<c:forEach items="${computers }" varStatus="loop" var="it">
				<tbody>
					<tr>
						<td>${loop.index+1 }</td>
						<td>${it.maMay }</td>
						<td>${it.viTri }</td>
						<td>${it.trangThai }</td>
						<td>
							<button class=" border-0 bg-transparent mr-2"
								onclick="editComputer('${it.maMay}')" id="edit-button"
								data-id="${it.maMay}">
								<i class="fas fa-pen"></i>
							</button>
							<button class="border-0 bg-transparent" data-toggle="modal"
								data-target="#confirmModal" id="delete-button"
								data-id="${it.maMay}" onclick="setIdToDelete('${it.maMay}')">
								<i class="fas fa-trash"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

		<div class="modal" tabindex="-1" id="confirmModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Delete Poll</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>Are you sure about that?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-danger" id="confirmDelete">Delete</button>
					</div>
				</div>
			</div>
		</div>

		<div
			class="container d-flex align-items-center justify-content-between">
			<p class="">
				Showing <strong><%=currentRecord%></strong> out of <strong><%=total%></strong>
				entries
			</p>
			<div>
				<ul class="pagination">
					<c:if test="${currentPage > 1}">
						<li class="page-item"><a class="page-link"
							href="<%= request.getContextPath()%>/SearchComputerServlet?page=${currentPage - 1}">Previous</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="1" end="${noOfPages}">
						<li class="page-item ${i == currentPage ? 'active' : ''}"><a
							class="page-link"
							href="<%= request.getContextPath()%>/SearchComputerServlet?page=${i}">${i}</a>
						</li>
					</c:forEach>
					<c:if test="${currentPage < noOfPages}">
						<li class="page-item"><a class="page-link"
							href="<%= request.getContextPath()%>/SearchComputerServlet?page=${currentPage + 1}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
    function editComputer(computerId) {
        window.location.href = "<%=request.getContextPath()%>/EditMachineServlet?computerId=" + computerId;
    }

    let computerId = null;

    function setIdToDelete(computerIdToDelete) {
        computerId = computerIdToDelete;
    }

    $(document).ready(function () {
        $("#confirmDelete").click(function (event) {
            if (computerId) {
                window.location.href = "<%=request.getContextPath()%>
		/DeleteComputerServlet?computerId="
															+ computerId;
												} else {
													event.preventDefault();
												}
											});

							$(document).on("click", "#edit-button", function() {
								let computerId = $(this).data("id");
								editComputer(computerId);
							});

							$(document).on(
									"click",
									"#delete-button",
									function() {
										let computerIdToDelete = $(this).data(
												"id");
										setIdToDelete(computerIdToDelete);
									});
						});
	</script>

</body>
</html>