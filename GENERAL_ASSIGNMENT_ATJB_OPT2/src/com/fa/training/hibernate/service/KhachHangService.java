package com.fa.training.hibernate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fa.training.common.ValidatorUtil;
import com.fa.training.entity.KhachHang;
import com.fa.training.hibernate.dao.KhachHangDAO;

public class KhachHangService {
	private KhachHangDAO khachHangDAO;
	
	public KhachHangService() {
		khachHangDAO = new KhachHangDAO();
	}
	
	public Map<String, String> validateCustomer(Map<String, String> customerData){
		Map<String, String> errors = new HashMap<>();
		
		String customerId = customerData.get("customerId");
		String customerName = customerData.get("customerName");
		String address = customerData.get("address");
		String phone = customerData.get("phone");
		String email = customerData.get("email");
		
		if(!ValidatorUtil.isValidCustomerId(customerId)) {
			errors.put("customerId", "Mã khách hàng không đúng định dạng (KHxxxxx).");
		}
		
		if(!ValidatorUtil.isValidCustomerName(customerName)) {
			errors.put("customerName", "Tên khách hàng không hợp lệ.");
		}
		
		if(khachHangDAO.isEmailExists(email)) {
			errors.put("email", "Email đã tồn tại.");
		}
		
		if(address == null || address.trim().isEmpty()) {
			errors.put("address", "Địa chỉ không được để trống.");
		}
		
		if(khachHangDAO.isPhoneExist(phone)) {
			errors.put("phone", "SDT đã tồn tại.");
		}
		
//		if (!ValidatorUtil.isValidEmail(email)) {
//            errors.put("email", "Email không đúng định dạng.");
//        }
		
		return errors;
	}
	
	public boolean saveOrUpdate(Map<String, String> customerData) {
		if(khachHangDAO.findById(customerData.get("customerId"))!=null) {
			 return khachHangDAO.update(customerData);
		}else {
			return khachHangDAO.save(customerData);
		}
	}
	
	public boolean deleteById(String customerId) {
		return khachHangDAO.deleteById(customerId);
	}
	
	public List<KhachHang> findAll(){
		return khachHangDAO.findAll();
	}
	
	public List<KhachHang> findCustomer(Map<String, String> data,int page){
		return khachHangDAO.findCustomer(data,page);
	}
	
	public long countTotalRecords(Map<String, String> data) {
		return khachHangDAO.countTotalRecord(data);
	}
}