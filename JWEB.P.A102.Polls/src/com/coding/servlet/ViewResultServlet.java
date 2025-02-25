package com.coding.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernatePollDao;
import com.coding.dto.ViewResultDTO;
import com.coding.persistence.Poll;
import com.coding.persistence.Question;

/**
 * Servlet implementation class ViewResultServlet
 */
@WebServlet("/view-result")
public class ViewResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernatePollDao pollDao = new HibernatePollDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pollId = Integer.parseInt(request.getParameter("id"));
		Poll poll = this.pollDao.getById(pollId);
		
		List<ViewResultDTO> results = new ArrayList<ViewResultDTO>();
		List<Question> questions
		
		request.setAttribute("results", results);
		request.setAttribute("pollName", poll.getText());
		request.getRequestDispatcher("viewResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
