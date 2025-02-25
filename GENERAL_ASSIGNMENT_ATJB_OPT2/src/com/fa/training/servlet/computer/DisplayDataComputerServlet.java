package com.fa.training.servlet.computer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.fa.training.entity.KhachHang;
import com.fa.training.entity.May;
import com.fa.training.hibernate.service.KhachHangService;
import com.fa.training.hibernate.service.MayService;

/**
 * Servlet implementation class DisplayDataComputerServlet
 */
@WebServlet("/DisplayDataComputerServlet")
public class DisplayDataComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KhachHangService khachHangService;
    private MayService mayService;
    
    public void init() {
    	khachHangService = new KhachHangService();
    	mayService = new MayService();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDataComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<May> computerList = mayService.findByStatusFree();
		List<KhachHang> customerList = khachHangService.findAll();
		
		request.setAttribute("may", computerList);
		request.setAttribute("kh", customerList);
		
		request.getRequestDispatcher("/machine/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}