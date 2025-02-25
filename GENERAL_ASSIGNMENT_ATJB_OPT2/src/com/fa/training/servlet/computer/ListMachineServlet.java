package com.fa.training.servlet.computer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.entity.KhachHang;
import com.fa.training.entity.May;
import com.fa.training.hibernate.dao.MayDAO;

/**
 * Servlet implementation class ListMachineServlet
 */
@WebServlet("/ListMachineServlet")
public class ListMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MayDAO mayDAO = new MayDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMachineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<May> list = mayDAO.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/machine/list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}