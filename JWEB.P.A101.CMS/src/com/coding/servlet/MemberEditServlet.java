package com.coding.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dao.HibernateMemberDao;
import com.coding.persistence.Member;

/**
 * Servlet implementation class MemberEditServlet
 */
@WebServlet("/MemberEditServlet")
public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HibernateMemberDao memberDao = new HibernateMemberDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");

        Member member = memberDao.getMemberById(id);
        System.out.println(member);
        System.out.println("id: " + id);
        if (member != null) {
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setPhone(phone);
            member.setDescription(description);

            memberDao.update(member);
        }
        
        response.sendRedirect("edit.jsp?success=true");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
