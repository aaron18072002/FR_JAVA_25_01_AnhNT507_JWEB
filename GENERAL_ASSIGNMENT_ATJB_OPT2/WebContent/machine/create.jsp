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
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null) {
	%>
	<p class="text-danger font-weight-bold"><%=errorMessage%></p>
	<%
	}
	%>
	<%
	boolean isEdit = request.getAttribute("may") != null;
	%>
	<div class="container mt-4">
		<h2>Tạo mới máy</h2>
		<form action="<%=request.getContextPath()%>/CreateComputerServlet"
			method="post">
			<div class="form-group">
				<label for="machineId">Mã máy</label> <input type="text"
					class="form-control" name="machineId" id="machineId"
					placeholder="Mxxxxx" value="${may.maMay}" <%if(isEdit) { %>
					readonly <% } %>>
			</div>
			<div class="form-group">
				<label for="position">Vị trí</label> <input type="text"
					class="form-control" name="position" id="position"
					placeholder="Khu A" value="${may.viTri }">
			</div>
			<div class="form-group">
				<label for="status">Trạng thái</label> <select name="status"
					class="form-control" id="status">
					<option value="">-- Chọn trạng thái --</option>
					<option value="Ranh" ${may.trangThai == 'Ranh' ? 'selected' : ''}>Rảnh</option>
					<option value="Ban" ${may.trangThai == 'Ban' ? 'selected' : ''}>Bận</option>
					<option value="Dang sua chua"
						${may.trangThai == 'Dang sua chua' ? 'selected' : ''}>Đang
						sửa chữa</option>
				</select>
			</div>
			<button type="submit" id="btn-Sub" class="btn btn-primary mb-2"><%=isEdit ? "Cập nhật" : "Tạo mới"%></button>
			`
		</form>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
		function showError(input, message) {
			let parent = $(input).closest(".form-group");
			$(input).addClass("is-invalid");

			parent.find(".invalid-feedback").remove();

			$("<div class='invalid-feedback d-block'>" + message + "</div>")
					.appendTo(parent);
		}

		function clearError(input) {
			$(input).removeClass("is-invalid");
			$(input).next(".invalid-feedback").remove();
		}

		$("#btn-Sub").click(function(e) {

			let machinePattern = /^M\d{5}$/

			let position = $("#position").val().trim();
			let machineId = $("#machineId").val().trim();
			let status = $("#status").val();

			let isValid = true;

			if (!machinePattern.test(machineId)) {
				isValid = false;
				showError("#machineId", "Mã máy không đúng định dạng");
			} else {
				clearError("#machineId");
			}

			if (status === "") {
				showError("#status", "phải chọn trạng thái của máy");
				isValid = false;
			} else {
				clearError("#status");
			}

			if (position.length === 0) {
				showError("#position", "vị trí không đúng định dạng")
				isValid = false
			} else {
				clearError("#position");
			}

			if (!isValid) {
				e.preventDefault();
			}
		});
	</script>

</body>
</html>