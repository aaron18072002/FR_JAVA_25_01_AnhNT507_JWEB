package com.coding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernateContentDao;
import com.coding.persistence.Content;
import com.coding.utils.PrintUtils;

/**
 * Servlet implementation class SearchContentServlet
 */
@WebServlet("/SearchContentServlet")
public class SearchContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernateContentDao contentDao = new HibernateContentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		List<Content> contents = this.contentDao.getByTitle(title);

		PrintUtils.generate("contents --> ", contents);
		
		request.setAttribute("contents", contents);
        request.getRequestDispatcher("viewContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
