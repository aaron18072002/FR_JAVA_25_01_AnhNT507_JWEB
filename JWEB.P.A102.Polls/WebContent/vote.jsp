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
	
	<div class="great-poll container">
		<h1>${pollName}</h1>
		<form id="great-poll-form" action="poll" method="post">
			<ol>
				<c:forEach var="qDto" items="${questions}">
					<input type="hidden" name="question" value="${qDto.question.id}" />
					<li class="mt-4">${qDto.question.text}<c:if
							test="${qDto.question.isRequired() == true}">
							<span class="required-field">*</span>
						</c:if> <c:forEach var="answer" items="${qDto.answers}"
							varStatus="status">
							<div class="form-check">
								<input class="form-check-input"
									type="${qDto.question.isMultiple() ? 'checkbox' : 'radio'}"
									name="question-${qDto.question.id}"
									id="question-${qDto.question.id}-option-${status.index}"
									value="${answer.id}" /> <label class="form-check-label"
									for="question-${qDto.question.id}-option-${status.index}">
									${answer.text} </label>
							</div>
						</c:forEach>
					</li>
				</c:forEach>
			</ol>
			<div class="btn-retain mt-5">
				<button type="submit" class="btn btn-outline-success">Retain</button>
			</div>
		</form>
	</div>
	<!-- Scripts -->
	<script src="assets/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="assets/jquery/jquery.min.js"></script>
</body>
</html>
