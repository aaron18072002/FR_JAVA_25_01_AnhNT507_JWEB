package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernatePollDao;
import com.coding.persistence.Poll;

/**
 * Servlet implementation class DeletePollServlet
 */
@WebServlet("/delete-poll")
public class DeletePollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernatePollDao pollDao = new HibernatePollDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pollId = request.getParameter("pollId");
		
		int id = Integer.parseInt(pollId);
		Poll poll = this.pollDao.getById(id);
		poll.setStatus("draft");
		
		this.pollDao.update(poll);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
