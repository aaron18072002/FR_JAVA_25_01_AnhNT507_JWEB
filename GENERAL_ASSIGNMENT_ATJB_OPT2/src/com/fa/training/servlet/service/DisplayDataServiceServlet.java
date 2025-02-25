package com.fa.training.servlet.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.training.entity.DichVu;
import com.fa.training.entity.KhachHang;
import com.fa.training.hibernate.service.DichVuService;
import com.fa.training.hibernate.service.KhachHangService;

/**
 * Servlet implementation class DisplayDataServiceServlet
 */
@WebServlet("/DisplayDataServiceServlet")
public class DisplayDataServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangService khachHangService;
	private DichVuService dichVuService;
	
	public void init() {
		khachHangService = new KhachHangService();
		dichVuService = new DichVuService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDataServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DichVu> serviceList = dichVuService.findAll();
		List<KhachHang> customerList = khachHangService.findAll();
		
		request.setAttribute("dv", serviceList);
		request.setAttribute("kh", customerList);
		request.getRequestDispatcher("/service/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}