package com.fa.training.servlet.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.entity.DichVu;
import com.fa.training.entity.KhachHang;
import com.fa.training.hibernate.service.DichVuService;

/**
 * Servlet implementation class SearchServiceServlet
 */
@WebServlet("/SearchServiceServlet")
public class SearchServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DichVuService dichVuService;
    
    public void init() {
    	dichVuService = new DichVuService();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int recordsPerPage = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		Map<String, String[]> param = request.getParameterMap();
		Map<String, String> data = new HashMap<>();
		
		for(Map.Entry<String, String[]> entry : param.entrySet()) {
			data.put(entry.getKey(), entry.getValue()[0]);
		}
		
		List<DichVu> serviceList = dichVuService.findService(data,page);
        long totalRecords = dichVuService.countTotalRecords(data);

        int noOfPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
        
        
        request.setAttribute("currentRecord", serviceList.size());
        request.setAttribute("total", totalRecords);
        request.setAttribute("services", serviceList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
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