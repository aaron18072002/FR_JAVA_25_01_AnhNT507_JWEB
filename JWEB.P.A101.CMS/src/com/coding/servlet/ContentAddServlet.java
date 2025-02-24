package com.coding.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class ContentAddServlet
 */
@WebServlet("/ContentAddServlet")
public class ContentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernateContentDao contentDao = new HibernateContentDao();
	private final HibernateMemberDao memberDao = new HibernateMemberDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String contentText = request.getParameter("contentV2");

		Content content = new Content(title, brief, contentText, author);
		contentDao.save(content);

		response.sendRedirect
			(request.getContextPath() + "/ContentViewServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
