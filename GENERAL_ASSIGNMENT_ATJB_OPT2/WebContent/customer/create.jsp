<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="java.util.*"%>
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
	boolean isEdit = request.getAttribute("customer") != null;
	%>
	<% Map<String, String> errorMessages = (Map<String, String>) request.getAttribute("errorMessages"); %>
	<div class="container mt-4">
		<h2>Tạo mới KH</h2>
		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null) {
		%>
		<p class="text-danger font-weight-bold"><%=errorMessage%></p>
		<%
		}
		%>
		<form action="<%=request.getContextPath()%>/CreateCustomerServlet"
			method="post">
			<div class="form-group">
				<label for="maKH">Mã KH</label> <input type="text"
					class="form-control" name="customerId" id="maKH"
					placeholder="KHxxxxx" value="${customer.maKH}" <%if(isEdit) { %>
					readonly <% } %>>
				<% if(errorMessages != null && errorMessages.containsKey("customerId")) { %>
				<p class="text-danger font-weight-bold"><%=errorMessages.get("customerId") %></p>
				<%} %>
			</div>
			<div class="form-group">
				<label for="customerName">Tên khách hàng</label> <input type="text"
					class="form-control" name="customerName" id="customerName"
					placeholder="Nguyen Van A" value="${customer.tenKH}">
				<% if(errorMessages != null && errorMessages.containsKey("customerName")) { %>
				<p class="text-danger font-weight-bold"><%=errorMessages.get("customerName") %></p>
				<%} %>
			</div>
			<div class="form-group">
				<label for="address">Địa chỉ</label> <input type="text"
					class="form-control" name="address" id="address"
					placeholder="Da Nang" value="${customer.diaChi}">
				<% if(errorMessages != null && errorMessages.containsKey("address")) { %>
				<p class="text-danger font-weight-bold"><%=errorMessages.get("address")%></p>
				<%} %>
			</div>
			<div class="form-group">
				<label for="phone">Số điện thoại</label> <input type="text"
					class="form-control" id="phone" maxlength="10" name="phone"
					placeholder="090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx"
					value="${customer.soDienThoai }">
				<% if(errorMessages != null && errorMessages.containsKey("phone")) { %>
				<p class="text-danger font-weight-bold"><%=errorMessages.get("phone") %></p>
				<%} %>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" name="email" id="email"
					placeholder="name@example.com" value="${customer.diaChiEmail}">
				<% if(errorMessages != null && errorMessages.containsKey("email")) { %>
				<p class="text-danger font-weight-bold"><%=errorMessages.get("email") %></p>
				<%} %>
			</div>
			<button type="submit" id="btn-Sub" class="btn btn-primary mb-2">
				<%= isEdit ? "Cập nhật" : "Tạo mới" %></button>
			`
		</form>

	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
	 	$(document)
				.ready(
						function() {
							function showError(input, message) {
								let parent = $(input).closest(".form-group");
								$(input).addClass("is-invalid");

								parent.find(".invalid-feedback").remove();

								$(
										"<div class='invalid-feedback d-block'>"
												+ message + "</div>").appendTo(
										parent);
							}

							function clearError(input) {
								$(input).removeClass("is-invalid");
								$(input).next(".invalid-feedback").remove();
							}

							$("#btn-Sub")
									.click(
											function(event) {

												let phonePattern = /^(090|091)\d{7}$|^\(84\)\+90\d{7}$|^\(84\)\+91\d{7}$/;
												let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
												let customerPattern = /^KH\d{5}$/
												let namePattern = /^[A-Za-zÀ-ỹ\s]+$/

												let customerId = $("#maKH")
														.val().trim();
												let customerName = $(
														"#customerName").val()
														.trim();
												let address = $("#address")
														.val().trim();
												let phone = $("#phone").val()
														.trim();
												let email = $("#email").val()
														.trim();

												let isValid = true;

												if (!phonePattern.test(phone)) {
													showError(
															"#phone",
															"Số điện thoại phải có định dạng sau  090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
													isValid = false;
												} else {
													clearError("#phone")
												}

												if (!emailPattern.test(email)) {
													showError("#email",
															"Email không đúng định dạng");
													isValid = false;
												} else {
													clearError("#email");
												}

												if (!customerPattern
														.test(customerId)) {
													showError("#maKH",
															"Mã Khách hàng không đúng định dạng")
													isValid = false;
												} else {
													clearError("#maKH");
												}

												if (!namePattern
														.test(customerName)) {
													showError("#customerName",
															"Tên khách hàng không đúng định dạng!");
													isValid = false;
												} else {
													clearError("#customerName");
												}

												if (address.length === 0) {
													showError("#address",
															"Địa chỉ không đúng định dạng!");
													isValid = false;
												} else {
													clearError("#address");
												}

												if (!isValid) {
													event.preventDefault();
												}
											})
						}); 
	</script>
</body>
</html>