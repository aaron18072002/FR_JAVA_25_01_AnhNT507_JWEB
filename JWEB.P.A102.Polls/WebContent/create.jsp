<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Create Interview</title>
<link href="assets/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h1>Create Interview</h1>
		<form id="great-poll-form" novalidate 
			action="<%=request.getContextPath()%>/CreateInterviewServlet" method="get">
			<div class="mb-5 row">
				<label for="inputPassword" class="col-sm-3 col-form-label"></label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="inputNamePoll"
						placeholder="Name poll" name="pollName" />
					<div id="requiredNamepoll" class="invalid-feedback"></div>
				</div>
			</div>
			<div class="add-question">
				<div class="group-question">
					<hr />
					<div class="mb-5 row">
						<label class="col-sm-3 col-form-label labelQuestion" data-question="0"></label>
						<div class="col-sm-9">
							<input type="text" class="form-control inputQustion"
								placeholder="Enter your question"
								name="question" />
							<div id="validateQuestion" class="invalid-feedback validateClass"></div>
						</div>
					</div>
					<div class="mb row">
						<div class="col-3"></div>
						<div class="col-9">
							<div class="form-check mb-5">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckDefault" name="mandatory-0" /> <label
									class="form-check-label" for="flexCheckDefault">
									Mandatory </label>
							</div>
							<div class="form-check mb-5">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" name="multiple-0" /> <label
									class="form-check-label" for="flexCheckChecked">
									You can select multiple options </label>
							</div>
						</div>
					</div>
					<div class="mb-5 row">
						<label for="inputPassword"
							class="col-sm-3 col-form-label text-end">Possile
							answers</label>
						<div class="col-sm-9 group-answer">
							<div class="input-group mb-3" style="width: 500px">
								<input type="text" class="form-control inputAnswer"
									placeholder="Type your answer" id=""
									name="answer-0" />
								<button class="btn btn-primary" type="button" id="btn-addAnswer">
									+</button>
								<div id="validateAnswer"
									class="invalid-feedback validateAnswerClass"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="mb-5">
				<button type="button" class="btn btn-success" id="add-new-question">
					+ Add new question</button>
			</div>
			<div class="btn-retain mt-5">
				<button id="btn-submit" type="submit"
					class="btn btn-outline-success">Retain</button>
			</div>
		</form>

	</div>

	<!-- Scripts -->
	
	<script src="assets/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="assets/jquery/jquery.min.js"></script>
	<script src="js/create.js"></script>
</body>
</html>
