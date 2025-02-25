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

	<%int currentRecord = (int)request.getAttribute("currentRecord"); %>

	<%long total = (long) request.getAttribute("total"); %>
	<%
	String error = (String) request.getAttribute("Error");
	%>

	<%
	if (error != null) {
	%>
	<p class="text-danger font-weight-bold"><%=error%></p>
	<%
	}
	%>

	<div class="container mt-3 mb-3">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/SearchCustomerServlet" method="get">
					<div class="form-row">
						<div class="form-group col">
							<label for="maKH">Mã KH</label> <input type="text"
								class="form-control" name="customerId" id="maKH"
								placeholder="KHxxxxx">
						</div>
						<div class="form-group col">
							<label for="customerName">Tên khách hàng</label> <input
								type="text" class="form-control" name="customerName"
								id="customerName" placeholder="Nguyen Van A">
						</div>
						<div class="form-group col">
							<label for="address">Địa chỉ</label> <input type="text"
								class="form-control" name="address" id="address"
								placeholder="Da Nang">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col">
							<label for="phone">Số điện thoại</label> <input type="text"
								class="form-control" id="phone" maxlength="10" name="phone"
								placeholder="090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx">
						</div>
						<div class="form-group col">
							<label for="email">Email</label> <input type="email"
								class="form-control" name="email" id="email"
								placeholder="name@example.com">
						</div>
					</div>
					<div class="form-row">
				<button type="submit" id="btn-Sub"  class="btn btn-primary mb-2 ">Tim
					kiem</button>
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
					<th scope="col">MaKH</th>
					<th scope="col">TenKH</th>
					<th scope="col">DiaChi</th>
					<th scope="col">SoDienThoai</th>
					<th scope="col">DiaChiEmail</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<c:forEach items="${customers }" var="it" varStatus="loop">
				<tbody>
					<tr>
						<td>${loop.index + 1}</td>
						<td>${it.maKH }</td>
						<td>${it.tenKH }</td>
						<td>${it.diaChi }</td>
						<td>${it.soDienThoai}</td>
						<td>${it.diaChiEmail}</td>
						<td>
							<button class=" border-0 bg-transparent mr-2 edit-button" data-id = "${it.maKH }"
								onclick="editCustomer('${it.maKH}')">
								<i class="fas fa-pen"></i>
							</button>
							<button class="border-0 bg-transparent delete-button" data-toggle="modal"
								data-target="#confirmModal" data-id = "${it.maKH }"
								onclick="setIdToDelete('${it.maKH}')">
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
				Showing <strong><%= currentRecord %></strong> out of <strong><%= total %></strong> entries
			</p>
			<div>
				<ul class="pagination">
					<c:if test="${currentPage > 1}">
						<li class="page-item"><a class="page-link"
							href="<%= request.getContextPath()%>/SearchCustomerServlet?page=${currentPage - 1}">Previous</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="1" end="${noOfPages}">
						<li class="page-item ${i == currentPage ? 'active' : ''}"><a
							class="page-link"
							href="<%= request.getContextPath()%>/SearchCustomerServlet?page=${i}">${i}</a>
						</li>
					</c:forEach>
					<c:if test="${currentPage < noOfPages}">
						<li class="page-item"><a class="page-link"
							href="<%= request.getContextPath()%>/SearchCustomerServlet?page=${currentPage + 1}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>



	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
	 function editCustomer(customerId) {
	        window.location.href = '<%=request.getContextPath()%>/EditCustomerServlet?customerId=' + customerId;
	    }
	 
	 let customerId = null;
	 
	 function setIdToDelete(customerIdToDelete){
		 customerId = customerIdToDelete;
	 }
	 
	    $(document).ready(function () {

	 
	 $("#confirmDelete").click(function(event){
		 if(customerId){
			 window.location.href =  '<%=request.getContextPath()%>/DeleteCustomerServlet?customerId='+ customerId;
							} else {
								event.preventDefault();
							}
						});
	    });
	    
	    $(document).on("click", ".edit-button", function () {
            let customerId = $(this).data("id");
            editCustomer(customerId);
        });

        $(document).on("click", ".delete-button", function () {
            let customerIdToDelete = $(this).data("id");
            setIdToDelete(customerIdToDelete);
        });
	</script>
</body>
</html>