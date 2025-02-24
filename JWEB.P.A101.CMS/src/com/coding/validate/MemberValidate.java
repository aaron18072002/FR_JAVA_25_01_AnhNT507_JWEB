package com.coding.validate;

import java.util.ArrayList;
import java.util.List;

public class MemberValidate {

	private MemberValidate() {
		
	}
	
	
	public static List<String> validateRegister
		(String username, String email, String password, String repassword) {

		List<String> errors = new ArrayList<>();

	    if (username == null || username.trim().isEmpty()) {
	        errors.add("Username không được để trống.");
	    }

	    if (email == null || email.trim().isEmpty()) {
	        errors.add("Email không được để trống.");
	    } else if (!email.matches("^[A-Za-z0-9._%+-]+@fpt\\.com\\.vn$")) {
	        errors.add("Email phải có định dạng tên@fpt.com.vn.");
	    }

	    if (password == null || password.trim().isEmpty()) {
	        errors.add("Password không được để trống.");
	    } else if (password.length() < 6) {
	        errors.add("Password phải dài hơn 6 ký tự.");
	    }

	    if (repassword == null || repassword.trim().isEmpty()) {
	        errors.add("Repassword không được để trống.");
	    } else if (!repassword.equals(password)) {
	        errors.add("Password và Repassword không khớp.");
	    }

	    return errors;
	}
	
}
