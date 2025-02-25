package com.fa.training.servlet.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.hibernate.dao.SuDungDichVuDAO;

/**
 * Servlet implementation class RegisterServiceServlet
 */
@WebServlet("/RegisterServiceServlet")
public class RegisterServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SuDungDichVuDAO suDungDichVuDAO;
	
	public void init() {
		suDungDichVuDAO = new SuDungDichVuDAO();
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServiceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> param = request.getParameterMap();

		Map<String, String> serviceData = new HashMap<>();

		for (Map.Entry<String, String[]> entry : param.entrySet()) {
			serviceData.put(entry.getKey(), entry.getValue()[0]);
		}
		
		boolean isSuccess = suDungDichVuDAO.save(serviceData);
		handleRequest(request, response, isSuccess);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response, boolean isSuccess)
			throws ServletException, IOException {
		
			if (isSuccess) {
				response.sendRedirect(request.getContextPath() + "/DisplayDataServiceServlet");
			} else {
				request.setAttribute("errorMessage", "Có lỗi xảy ra trong quá trình lưu dữ liệu");
				request.getRequestDispatcher("/service/register.jsp").forward(request, response);
			}
	}

}