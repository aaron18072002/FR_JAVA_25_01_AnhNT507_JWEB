package com.fa.training.servlet.computer;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.hibernate.dao.SuDungMayDAO;

/**
 * Servlet implementation class RegisterComputerServlet
 */
@WebServlet("/RegisterComputerServlet")
public class RegisterComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SuDungMayDAO suDungMayDAO;
	
	public void init() {
		suDungMayDAO = new SuDungMayDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterComputerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> param = request.getParameterMap();
		Map<String, String> data = new HashMap<>();

		for (Map.Entry<String, String[]> entry : param.entrySet()) {
			data.put(entry.getKey(), entry.getValue()[0]);
		}
		
		boolean isSuccess = suDungMayDAO.save(data);
		handleRequest(request, response, isSuccess);

	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response, boolean isSuccess)
			throws ServletException, IOException {
		
			if (isSuccess) {
				response.sendRedirect(request.getContextPath()+"/DisplayDataComputerServlet");
			} else {
				request.setAttribute("errorMessage", "Có lỗi xảy ra trong quá trình lưu dữ liệu");
				request.getRequestDispatcher("/service/register.jsp").forward(request, response);
			}
	}

}