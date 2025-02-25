package com.fa.training.servlet.computer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.hibernate.service.MayService;

/**
 * Servlet implementation class CreateComputerServlet
 */
@WebServlet("/CreateComputerServlet")
public class CreateComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MayService mayService;
    
    public void init() {
    	mayService = new MayService();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> param = request.getParameterMap();
		
		Map<String, String> computerData = new HashMap<>();
		
		for(Map.Entry<String, String[]> entry : param.entrySet()) {
			computerData.put(entry.getKey(), entry.getValue()[0]);
		}
		
		boolean isSuccess = mayService.saveOrUpdate(computerData);
		handleRequest(request, response, isSuccess);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response, boolean isSuccess)
			throws ServletException, IOException {
		
			if (isSuccess) {
				response.sendRedirect(request.getContextPath() + "/SearchComputerServlet");
			} else {
				request.setAttribute("errorMessage", "Có lỗi xảy ra trong quá trình lưu dữ liệu");
				request.getRequestDispatcher("/machine/create.jsp").forward(request, response);
			}
	}
}