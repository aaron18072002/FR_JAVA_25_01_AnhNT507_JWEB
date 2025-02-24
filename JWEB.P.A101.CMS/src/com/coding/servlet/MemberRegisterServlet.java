package com.coding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernateMemberDao;
import com.coding.persistence.Member;

import static com.coding.validate.MemberValidate.*;

/**
 * Servlet implementation class MemberRegisterServlet
 */
@WebServlet("/MemberRegisterServlet")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernateMemberDao memberDao = new HibernateMemberDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String repassword = request.getParameter("repassword");

	    List<String> errors = validateRegister(username, email, password, repassword);

	    if (memberDao.getMemberByUsername(username) != null) {
	        errors.add("Username đã có có người dùng!");
	    }

	    if (memberDao.getMemberEmail(email) != null) {
	        errors.add("Email đã có có người dùng!");
	    }

	    if (!errors.isEmpty()) {
	        request.setAttribute("errors", errors);
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
	    } else {
	        Member member = new Member(username, password, email);
	        memberDao.save(member);
	        response.sendRedirect(request.getContextPath() + "/login.jsp");
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
