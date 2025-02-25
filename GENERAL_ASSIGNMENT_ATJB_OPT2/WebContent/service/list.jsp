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
<title>Insert title here</title>
</head>
<body>
	<%String errorDelete = (String) request.getAttribute("errorDelete"); %>

	<%int currentRecord = (int)request.getAttribute("currentRecord"); %>

	<%
	long total = (long) request.getAttribute("total");
	%>

	<%
		if(errorDelete!=null){
	%>
	<p class="text-danger font-weight-bold"><%= errorDelete %></p>
	<%} %>

	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="container mt-3 mb-3">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/SearchServiceServlet"
					method="get">
					<div class="form-row">
						<div class="form-group col">
							<label for="maKH">Mã DV</label> <input type="text"
								class="form-control" name="serviceId" id="serviceId"
								placeholder="Mxxxxx">
						</div>
						<div class="form-group col">
							<label for="customerName">Tên DV</label> <input type="text"
								class="form-control" name="serviceName" id="customerName"
								placeholder="Khu A">
						</div>
						<div class="form-group col">
							<label for="address">Trạng Thái</label> <label for="unit">Don
								vi Tinh</label> <input type="text" class="form-control" name="unit"
								id="unit" placeholder="chai" value="${service.donViTinh }">
						</div>
						<div class="form-group col">
							<label for="price">Đơn giá</label> <input type="number"
								class="form-control" name="price" id="price"
								placeholder="123456" value="${service.donGia }">
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
					<th scope="col">MaDV</th>
					<th scope="col">TenDV</th>
					<th scope="col">DonViTinh</th>
					<th scope="col">DonGia</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<c:forEach items="${services }" var="it" varStatus="loop">
				<tbody>
					<tr>
						<td>${loop.index + 1}</td>
						<td>${it.maDV}</td>
						<td>${it.tenDV}</td>
						<td>${it.donViTinh}</td>
						<td><fmt:formatNumber value="${it.donGia}" type="currency"
								currencySymbol="₫" /></td>
						<td>
							<button class=" border-0 bg-transparent mr-2 edit-button"
								onclick="editService('${it.maDV}')" data-id="${it.maDV}">
								<i class="fas fa-pen"></i>
							</button>
							<button class="border-0 bg-transparent delete-button"
								onclick="setIdToDelete('${it.maDV}')" data-toggle="modal"
								data-id="${it.maDV}" data-target="#confirmModal">
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
				Showing <strong><%= currentRecord %></strong> out of <strong><%= total %></strong>
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
		function editService(serviceId){
			window.location.href = '<%= request.getContextPath()%>/EditServiceServlet?serviceId=' + serviceId;
		}
		
		let serviceId = null;
		
		function setIdToDelete(serviceIdToDelete){
			serviceId = serviceIdToDelete;
		}
		
		
		 
		 $(document).ready(function () {
 $("#confirmDelete").click(function(event){
			 if(serviceId){
				 window.location.href =  '<%= request.getContextPath() %>/DeleteServiceServlet?serviceId=' + serviceId;
			 }else{
				 event.preventDefault();
			 }
		 });

		        $(document).on("click", ".edit-button", function () {
		            let serviceId = $(this).data("id");
		            editService(serviceId);
		        });

		        $(document).on("click", ".delete-button", function () {
		            let serviceIdToDelete = $(this).data("id");
		            setIdToDelete(computerIdToDelete);
		        });
		    });
	</script>
</body>
</html>