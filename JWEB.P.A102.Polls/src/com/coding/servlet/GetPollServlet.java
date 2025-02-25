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
 * Servlet implementation class GetPollServlet
 */
@WebServlet("/GetPollServlet")
public class GetPollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernatePollDao pollDao = new HibernatePollDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		
		final String finalStatus = (status == null) ? "active" : status;
        
        List<Poll> allPolls = pollDao.getAll();
        
        List<Poll> filteredPolls = allPolls.stream()
                    .filter(p -> p.getStatus().equalsIgnoreCase(finalStatus))
                    .collect(Collectors.toList());

        request.setAttribute("polls", filteredPolls);
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
