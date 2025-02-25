package com.fa.training.hibernate.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fa.training.entity.KhachHang;
import com.fa.training.entity.May;
import com.fa.training.entity.SuDungMay;
import com.fa.training.hibernate.HibernateUtil;

public class SuDungMayDAO {

	public boolean save(Map<String, String> data) {
		boolean isSuccess = true;
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			String customerId = data.get("customerId");
			String computerId = data.get("machineId");
			Date ngaySuDung = Date.valueOf(data.get("date"));
			Time gioSuDung = Time.valueOf(data.get("hour") + ":00");
			int soLuong = Integer.parseInt(data.get("quantity").trim());

			SuDungMay suDungMay = new SuDungMay();
			suDungMay.setGioBatDauSuDung(gioSuDung);
			suDungMay.setNgayBatDauSuDung(ngaySuDung);
			suDungMay.setSoLuong(soLuong);
			suDungMay.setMay(new May(computerId));
			suDungMay.setKhachHang(new KhachHang(customerId));
			
			session.save(suDungMay);
			transaction.commit();
			
		} catch (Exception ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			isSuccess = false;
			ex.printStackTrace();
		}
		return isSuccess;
	}

}