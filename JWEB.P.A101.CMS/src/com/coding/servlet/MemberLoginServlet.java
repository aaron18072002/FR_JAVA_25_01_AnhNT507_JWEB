package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernateMemberDao;
import com.coding.persistence.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernateMemberDao memberDao = new HibernateMemberDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String rememberMe = request.getParameter("rememberMe");

	    Member member = memberDao.login(email, password);
	      
	    System.out.println(member + ", " + email + ", " + password);

	    if (member == null) {
	        request.setAttribute("errorMessage", "Sai email hoặc password!");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    } else {
	        if (rememberMe != null) {
	            Cookie emailCookie = new Cookie("rememberEmail", email);
	            emailCookie.setMaxAge(60 * 60 * 24 * 7);
	            response.addCookie(emailCookie); // 7 ngày
	        }

	        Cookie loginCookie = new Cookie("loggedInEmail", email);
	        loginCookie.setMaxAge(60 * 60 * 24 * 7);
	        loginCookie.setPath("/"); 
	        response.addCookie(loginCookie);

	        response.sendRedirect("edit.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
