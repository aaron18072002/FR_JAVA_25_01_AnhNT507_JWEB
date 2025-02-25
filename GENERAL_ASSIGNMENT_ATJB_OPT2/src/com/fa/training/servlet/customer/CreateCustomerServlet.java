package com.fa.training.servlet.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.hibernate.dao.KhachHangDAO;
import com.fa.training.hibernate.service.KhachHangService;

/**
 * Servlet implementation class CreateCustomerServlet
 */
@WebServlet("/CreateCustomerServlet")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangService khachHangService;

	public void init() {
		khachHangService = new KhachHangService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCustomerServlet() {
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
		Map<String, String> customerData = new HashMap<>();

		for (Map.Entry<String, String[]> entry : param.entrySet()) {
			customerData.put(entry.getKey(), entry.getValue()[0]);
		}
		
		Map<String, String> errors = khachHangService.validateCustomer(customerData);
		
		if(!errors.isEmpty()) {
			request.setAttribute("errorMessages", errors);
			request.getRequestDispatcher("/customer/create.jsp").forward(request, response);
			return;
		}
		
		boolean isSuccess = khachHangService.saveOrUpdate(customerData);
		handleRequest(request, response, isSuccess);
		
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response, boolean isSuccess)
			throws ServletException, IOException {
		
			if (isSuccess) {
				response.sendRedirect(request.getContextPath() + "/SearchCustomerServlet");
			} else {
				request.setAttribute("errorMessage", "Có lỗi xảy ra trong quá trình lưu dữ liệu");
				request.getRequestDispatcher("/customer/create.jsp").forward(request, response);
			}
	}
}