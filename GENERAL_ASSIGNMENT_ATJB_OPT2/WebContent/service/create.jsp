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
	<%
	boolean isEdit = request.getAttribute("service") != null;
	%>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="container mt-4">
		<h2>Tạo mới Dịch vụ</h2>
		<form action="<%=request.getContextPath()%>/CreateServiceServlet"
			method="post">
			<div class="form-group">
				<label for="serviceId">Mã DV</label> <input type="text"
					class="form-control" name="serviceId" id="serviceId"
					placeholder="DVxxx" value="${service.maDV }" <%if(isEdit) { %>
					readonly <% } %>>
			</div>
			<div class="form-group">
				<label for="serviceName">Tên DV</label> <input type="text"
					class="form-control" name="serviceName" id="serviceName"
					placeholder="khăn lạnh" value="${service.tenDV }">
			</div>
			<div class="form-group">
				<label for="unit">Don vi Tinh</label> <input type="text"
					class="form-control" name="unit" id="unit" placeholder="chai"
					value="${service.donViTinh }">
			</div>
			<div class="form-group">
				<label for="price">Đơn giá</label> <input type="number"
					class="form-control" name="price" id="price" placeholder="123456"
					value="${service.donGia }">
			</div>
			<button type="submit" id="btn-Sub" class="btn btn-primary mb-2"><%= isEdit ? "Cập nhật" : "Tạo mới" %></button>
			`
		</form>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
	$(document).ready(function () {
		function showError(input, message) {
	    	let parent = $(input).closest(".form-group");
	        $(input).addClass("is-invalid"); 

	        parent.find(".invalid-feedback").remove();

	        $("<div class='invalid-feedback d-block'>" + message + "</div>").appendTo(parent);
	    }

        function clearError(input) {
            $(input).removeClass("is-invalid");
            $(input).next(".invalid-feedback").remove();
        }

        $("#btn-Sub").click(function(event){

            let pricePattern = /^[1-9]\d*$/;
            let servicePattern = /^DV\d{3}$/
            let price = $("#price").val().trim();
            let serviceId = $("#serviceId").val().trim();
            let unit = $("#unit").val().trim();
            let serviceName = $("#serviceName").val().trim();

            let isValid = true;
            if(!servicePattern.test(serviceId)){
                showError("#serviceId","Mã dịch vụ không đúng định dạng");
                isValid = false;
            }else{
                clearError("#serviceId");
            }

            if(!pricePattern.test(price)){
                isValid = false;
                showError("#price","đơn giá không đúng định dạng");
            }else{
                clearError("#price");
            }

            if(serviceName.length === 0){
                isValid = false;
                showError("#serviceName","tên dịch vụ không đúng định dạng");
            }else{
                clearError("#serviceName");
            }

            if(unit.length === 0){
                isValid = false;
                showError("#unit","đơn vị không đúng định dạng");
            }else{
                clearError("#unit");
            }
            
            if(!isValid){
            	event.preventDefault();
            }
        });
    });
	</script>

</body>
</html>