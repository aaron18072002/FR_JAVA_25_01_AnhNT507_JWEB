package com.fa.training.servlet.computer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.entity.May;
import com.fa.training.hibernate.service.MayService;

/**
 * Servlet implementation class EditMachineServlet
 */
@WebServlet("/EditMachineServlet")
public class EditMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MayService mayService;
    
    public void init() {
    	mayService = new MayService();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMachineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String computerId = request.getParameter("computerId");
		May may = mayService.findById(computerId);
		request.setAttribute("may", may);
		request.getRequestDispatcher("/machine/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}