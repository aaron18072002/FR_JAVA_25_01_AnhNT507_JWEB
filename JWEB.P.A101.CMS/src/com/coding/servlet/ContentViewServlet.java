package com.coding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernateContentDao;
import com.coding.dao.HibernateMemberDao;
import com.coding.persistence.Content;
import com.coding.persistence.Member;
import com.coding.utils.PrintUtils;

/**
 * Servlet implementation class ContentViewServlet
 */
@WebServlet("/ContentViewServlet")
public class ContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final HibernateContentDao contentDao = new HibernateContentDao();
	private final HibernateMemberDao memberDao = new HibernateMemberDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContentViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loggedInEmail = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("loggedInEmail".equals(cookie.getName())) {
					loggedInEmail = cookie.getValue();
					break;
				}
			}
		}

		if (loggedInEmail == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		Member author = memberDao.getMemberEmail(loggedInEmail);
		if (author == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		System.out.println("author id --> " + author.getId());

		List<Content> contents = this.contentDao.getByAuthorId(author.getId());

		PrintUtils.generate("contents --> ", contents); // test
		
		request.setAttribute("contents", contents);
        request.getRequestDispatcher("viewContent.jsp").forward(request, response);
		
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(contents);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

		System.out.println(json);
		*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
