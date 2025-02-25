package com.coding.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernateAnswerDao;
import com.coding.dao.HibernatePollDao;
import com.coding.dao.HibernatePollQuestionDao;
import com.coding.dao.HibernateQuestionAnswerDao;
import com.coding.dao.HibernateQuestionDao;
import com.coding.persistence.Answer;
import com.coding.persistence.Poll;
import com.coding.persistence.PollQuestion;
import com.coding.persistence.Question;
import com.coding.persistence.QuestionAnswer;
import com.coding.persistence.keys.KeyPollQuestion;
import com.coding.persistence.keys.KeyQuestionAnswer;

/**
 * Servlet implementation class CreateInterviewServlet
 */
@WebServlet("/CreateInterviewServlet")
public class CreateInterviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final HibernateAnswerDao answerDao = new HibernateAnswerDao();
	private final HibernatePollDao pollDao = new HibernatePollDao();
	private final HibernatePollQuestionDao pollQuestionDao = new HibernatePollQuestionDao();
	private final HibernateQuestionDao questionDao = new HibernateQuestionDao();
	private final HibernateQuestionAnswerDao questionAnswerDao = new HibernateQuestionAnswerDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateInterviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pollName = request.getParameter("pollName");
		String[] questions = request.getParameterValues("question");

		// Kiểm tra dữ liệu đầu vào
		if (pollName == null || pollName.trim().isEmpty() || questions == null || questions.length == 0) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input data");
			return;
		}

		// Tạo Poll mới
		Poll poll = new Poll();
		poll.setText(pollName.trim());
		poll.setStatus("active");
		pollDao.save(poll);

		// Lặp qua từng câu hỏi
		for (int i = 0; i < questions.length; i++) {
			String questionText = questions[i].trim();
			String[] answers = request.getParameterValues("answer-" + i);

			// Kiểm tra nếu câu hỏi rỗng thì bỏ qua
			if (questionText.isEmpty())
				continue;

			// Kiểm tra trạng thái bắt buộc và nhiều lựa chọn
			boolean isRequired = request.getParameter("mandatory-" + i) != null;
			boolean isMultiple = request.getParameter("multiple-" + i) != null;

			// Tạo question
			Question question = new Question();
			question.setText(questionText);
			question.setRequired(isRequired);
			question.setMultiple(isMultiple);
			questionDao.save(question);

			// Liên kết Poll và Question
			PollQuestion pollQuestion = new PollQuestion();
			pollQuestion.setKeys(new KeyPollQuestion(poll.getId(), question.getId()));
			pollQuestion.setPoll(poll);
			pollQuestion.setQuestion(question);
			pollQuestionDao.save(pollQuestion);

			// Xử lý câu trả lời nếu có
			if (answers != null) {
				Arrays.stream(answers).map(String::trim).filter(answerText -> !answerText.isEmpty())
						.forEach(answerText -> {
							// Tạo Answer
							Answer answer = new Answer();
							answer.setText(answerText);
							answerDao.save(answer);

							// Tạo QuestionAnswer để liên kết Question và Answer
							QuestionAnswer questionAnswer = new QuestionAnswer();
							questionAnswer.setKeys(new KeyQuestionAnswer(question.getId(), answer.getId()));
							questionAnswer.setQuestion(question);
							questionAnswer.setAnswer(answer);
							questionAnswerDao.save(questionAnswer);
						});
			}
		}
		
		response.sendRedirect("polls");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
