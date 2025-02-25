package com.fa.training.common;

public class ValidatorUtil {
	public static boolean isValidPhone(String phone) {
		String pattern = "^(090|091)\\d{7}$|^\\(84\\)\\+90\\d{7}$|^\\(84\\)\\+91\\d{7}$";
		return phone.matches(pattern);
	}
	
	public static boolean isValidEmail(String email) {
		String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(pattern);
	}
	
	public static boolean isValidCustomerId(String customerId) {
		String pattern = "^KH\\d{5}$";
		return customerId.matches(pattern);
	}
	
	public static boolean isValidCustomerName(String customerName) {
		String pattern = "^[A-Za-zÀ-ỹ\\s]+$";
		return customerName.matches(pattern);
	}
}
