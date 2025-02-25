package com.coding.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernatePollDao;
import com.coding.persistence.Poll;

/**
 * Servlet implementation class ReadPollServlet
 */
@WebServlet("/polls")
public class ReadPollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernatePollDao pollDao = new HibernatePollDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		List<Poll> polls = this.pollDao.getAll().stream()
				.filter(p -> p.getStatus().equalsIgnoreCase(status))
				.collect(Collectors.toList());
		request.setAttribute("polls", polls);
		request.setAttribute("status", status);
		request.getRequestDispatcher("list.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
