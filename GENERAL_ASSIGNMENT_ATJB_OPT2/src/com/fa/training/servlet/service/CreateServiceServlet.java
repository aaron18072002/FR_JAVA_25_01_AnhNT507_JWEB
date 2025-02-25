package com.fa.training.servlet.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.hibernate.service.DichVuService;

/**
 * Servlet implementation class CreateServiceServlet
 */
@WebServlet("/CreateServiceServlet")
public class CreateServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DichVuService dichVuService;

	public void init() {
		dichVuService = new DichVuService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServiceServlet() {
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

		Map<String, String> serviceData = new HashMap<>();

		for (Map.Entry<String, String[]> entry : param.entrySet()) {
			serviceData.put(entry.getKey(), entry.getValue()[0]);
		}

		boolean isSuccess = dichVuService.saveOrUpdate(serviceData);
		handleRequest(request, response, isSuccess);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response, boolean isSuccess)
			throws ServletException, IOException {
		
			if (isSuccess) {
				response.sendRedirect(request.getContextPath() + "/SearchServiceServlet");
			} else {
				request.setAttribute("errorMessage", "Có lỗi xảy ra trong quá trình lưu dữ liệu");
				request.getRequestDispatcher("/machine/create.jsp").forward(request, response);
			}
	}

}