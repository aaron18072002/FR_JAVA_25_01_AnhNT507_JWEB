<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link href="./assests/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="./assests/css/main.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1 class="text-center">The result of poll</h1>
	<div class="great-poll container">
		<h3>${pollName}</h3>
		<div id="great-poll-form">
			<ol>
				<c:forEach var="result" items="${results}">
					<li class="mt-4">${result.question.text}
						<c:if test="${result.question.isRequired() == true}">
							<span class="required-field">*</span>
						</c:if> 
						<c:forEach var="answer" items="${result.answers}">
							<div class="form-check">
								<span style="margin-right: 100px">
									${answer.text} 
								</span>
								<span><i class="text-secondary">(Have ${answer.total} votes for this option!)</i></span>
							</div>
						</c:forEach>
					</li>
				</c:forEach>
			</ol>
		</div>
	</div>
	<!-- Scripts -->
	<script src="assets/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="assets/jquery/jquery.min.js"></script>
</body>
</html>
