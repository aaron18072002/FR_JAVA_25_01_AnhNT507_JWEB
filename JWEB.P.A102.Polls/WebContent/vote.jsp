<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home Page</title>
<link href="assets/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container mt-5">
		<h2 class="font-weight-bold">Great poll</h2>
		<form>
			<!-- Câu hỏi 1 -->
			<div class="form-group mt-5">
				<label class="font-weight-bold">1. Is it necessary to you? <span
					class="text-danger">*</span></label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="question1"
						id="q1_yes"> <label class="form-check-label" for="q1_yes">Yes</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="question1"
						id="q1_no"> <label class="form-check-label" for="q1_no">No</label>
				</div>
			</div>

			<!-- Câu hỏi 2 -->
			<div class="form-group mt-5">
				<label class="font-weight-bold">2. Often pass polls?</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="question2"
						id="q2_month"> <label class="form-check-label"
						for="q2_month">Once a month</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="question2"
						id="q2_week"> <label class="form-check-label"
						for="q2_week">Once a week</label>
				</div>
			</div>

			<!-- Câu hỏi 3 -->
			<div class="form-group mt-5">
				<label class="font-weight-bold">3. How old are you?</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="question3"
						id="q3_18_20"> <label class="form-check-label"
						for="q3_18_20">18-20</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="question3"
						id="q3_21_23"> <label class="form-check-label"
						for="q3_21_23">21-23</label>
				</div>
			</div>

			<!-- Nút bấm -->
			<button type="submit" class="btn btn-secondary mt-5" style="margin-left: 150px">
				Retain
			</button>
		</form>
	</div>

	<%-- <div class="great-poll container">
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
	</div> --%>
	<!-- Scripts -->
	<script src="assets/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="assets/jquery/jquery.min.js"></script>
</body>
</html>
