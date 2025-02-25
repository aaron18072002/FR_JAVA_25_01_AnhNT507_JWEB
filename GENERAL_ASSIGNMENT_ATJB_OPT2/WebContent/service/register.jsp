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


	<div class="container mt-4">
		<div class="card">
			<div class="card-header text-center font-weight-bold">Đăng kí
				sử dụng dịch vụ</div>
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/RegisterServiceServlet">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="customerId">Ma KH</label> <select id="customerId"
								class="form-control" name="customerId">
								<option value="">Choose...</option>
								<c:forEach items="${kh }" var="it">
									<option value="${it.maKH}">${it.maKH }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-6">
							<label for="serviceId">Ma DV</label> <select id="serviceId"
								class="form-control" name="serviceId">
								<option value="">Choose...</option>
								<c:forEach items="${dv}" var="it">
									<option value="${it.maDV}">${it.maDV }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="">Ngay su dung</label> <input type="date" name="date"
								id="Date" class="form-control">
						</div>
						<div class="form-group col-md-4">
							<label for="">Gio su dung</label> <input type="time" name="hour"
								id="hour" class="form-control">
						</div>
						<div class="form-group col-md-4">
							<label for="">So Luong</label> <input type="number"
								name="quantity" id="quantity" class="form-control">
						</div>
					</div>
					<button type="submit" id="btn-Sub" class="btn btn-primary">Dang
						ky</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
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
    
    $("#btn-Sub").click(function (e) {

        let customerId = $("#customerId").val();
        let serviceId = $("#serviceId").val();
        let startDate = $("#Date").val();
        let quantity = $("#quantity").val();
        let startHour = $("#hour").val();

		let isValid = true;
        if (quantity <= 0) {
            showError("#quantity", "Số lượng phải lớn hơn 0");
            isValid = false;
        } else {
            clearError("#quantity");
        }

        if (customerId === "") {
            showError("#customerId", "Vui lòng chọn Mã KH");
            isValid = false;
        } else {
            clearError("#customerId");
        }

        if (serviceId === "") {
            showError("#serviceId", "Vui lòng chọn Mã máy")
            isValid = false;
        } else {
            clearError("#serviceId");
        }

        if (startHour === "") {
            showError("#hour", "Không được để trống");
            isValid = false;
        } else {
            clearError("#hour");
        }

        if (startDate === "") {
            showError("#Date","Ngày bắt đầu không đúng định dạng");
            isValid = false;
        }else{
            clearError("#Date");
        }
        
        if(!isValid){
        	e.preventDefault();
        }
    });
});
	</script>

</body>
</html>