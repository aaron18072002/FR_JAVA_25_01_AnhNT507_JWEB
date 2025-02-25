package com.coding.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding.dao.HibernatePollDao;
import com.coding.persistence.Poll;
import com.coding.persistence.User;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/poll")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernatePollDao pollDao = new HibernatePollDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * try { HttpSession session = request.getSession(); String userId; if(session
		 * != null && session.getAttribute("userLogin") != null) { User user =
		 * (User)session.getAttribute("userLogin"); userId = user.getId(); } else {
		 * InetAddress localhost = InetAddress.getLocalHost(); userId =
		 * localhost.getHostAddress(); }
		 * 
		 * int id = Integer.parseInt(request.getParameter("id")); Poll poll =
		 * this.pollDao.getById(id);
		 * 
		 * boolean isVoted = userService.isVoted(id, userId);
		 * 
		 * if(isVoted) { request.setAttribute("isSuccess", false);
		 * request.setAttribute("message", "You've been voted this poll!");
		 * request.getRequestDispatcher("polls").forward(request, response); }
		 * 
		 * List<QuestionDTO> questions = service.GetQuestions(id);
		 * request.setAttribute("questions", questions);
		 * request.setAttribute("pollName", poll.getText());
		 * request.getRequestDispatcher("vote.jsp").forward(request, response); } catch
		 * (Exception e) { // TODO: handle exception }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); String userId; if(session != null
		 * && session.getAttribute("userLogin") != null) { User user =
		 * (User)session.getAttribute("userLogin"); userId = user.getId(); } else {
		 * InetAddress localhost = InetAddress.getLocalHost(); userId =
		 * localhost.getHostAddress(); } String[] questionIds =
		 * request.getParameterValues("question"); List<String> answerIdList = new
		 * ArrayList<String>(); for (String id : questionIds) { String[] answerIds =
		 * request.getParameterValues("question-" + id); if (answerIds != null) {
		 * Collections.addAll(answerIdList, answerIds); } }
		 * 
		 * try { answerService.VoteService(answerIdList, userId);
		 * request.setAttribute("isSuccess", true); request.setAttribute("message",
		 * "Voted successfully!"); } catch (Exception e) {
		 * request.setAttribute("isSuccess", false); request.setAttribute("message",
		 * "Voted fail!"); }
		 * 
		 * request.getRequestDispatcher("polls").forward(request, response);
		 */
		
	}

}
