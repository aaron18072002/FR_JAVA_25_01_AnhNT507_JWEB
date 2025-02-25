package com.fa.training.servlet.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.entity.DichVu;
import com.fa.training.hibernate.dao.DichVuDAO;

/**
 * Servlet implementation class ListServiceServlet
 */
@WebServlet("/ListServiceServlet")
public class ListServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DichVuDAO dichVuDAO = new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DichVu> list = dichVuDAO.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/service/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}