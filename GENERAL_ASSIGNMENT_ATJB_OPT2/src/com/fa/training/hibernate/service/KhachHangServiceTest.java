package com.fa.training.hibernate.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class KhachHangServiceTest {
	private KhachHangService khachHangService = new KhachHangService();

	@Test
	public void test() {
		 Map<String, String> customerData = new HashMap<>();
	        customerData.put("customerId", "KH123"); // Sai định dạng
	        customerData.put("customerName", "123"); // Sai định dạng
	        customerData.put("phone", "0123456789"); // Sai
	        customerData.put("email", "abc@xyz"); // Sai

	        Map<String, String> errors = khachHangService.validateCustomer(customerData);

	        System.out.println("Errors: " + errors);

	        
	        assertTrue(errors.containsKey("customerId"));
	        assertTrue(errors.containsKey("customerName"));
	        assertTrue(errors.containsKey("phone"));
	        assertTrue(errors.containsKey("email"));
	}

}