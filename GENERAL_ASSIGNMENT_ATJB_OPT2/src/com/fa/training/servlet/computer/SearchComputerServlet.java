package com.fa.training.servlet.computer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.entity.May;
import com.fa.training.hibernate.service.MayService;

/**
 * Servlet implementation class SearchComputerServlet
 */
@WebServlet("/SearchComputerServlet")
public class SearchComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MayService mayService;
    
    public void init() {
    	mayService = new MayService();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> param = request.getParameterMap();
		
		Map<String, String> data = new HashMap<>();
		for(Map.Entry<String, String[]> entry : param.entrySet()) {
			data.put(entry.getKey(), entry.getValue()[0]);
		}
		
		int page = 1;
		int recordsPerPage = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<May> computers = mayService.findComputer(data, page);
		long totalRecords = mayService.countTotalRecords(data);
		
        int noOfPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

		
		request.setAttribute("currentRecord", computers.size());
        request.setAttribute("total", totalRecords);
        request.setAttribute("computers", computers);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
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