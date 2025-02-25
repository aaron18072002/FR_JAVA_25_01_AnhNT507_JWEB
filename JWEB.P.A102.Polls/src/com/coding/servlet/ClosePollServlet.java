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
 * Servlet implementation class ClosePollServlet
 */
@WebServlet("/close-poll")
public class ClosePollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernatePollDao pollDao = new HibernatePollDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClosePollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pollId = request.getParameter("id");
		if(pollId != null) {
			int id = Integer.parseInt(pollId);
			Poll poll = this.pollDao.getById(id);
			poll.setStatus("closed");
			
			this.pollDao.update(poll);
			
			request.setAttribute("isSuccess", true);
			request.setAttribute("message", "Closed poll successfully!");
		} else {
			request.setAttribute("isSuccess", false);
			request.setAttribute("message", "Closed poll fail!");
		}
		
		request.getRequestDispatcher("polls").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
