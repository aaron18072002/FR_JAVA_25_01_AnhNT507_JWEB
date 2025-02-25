package com.fa.training.hibernate.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fa.training.entity.DichVu;
import com.fa.training.entity.KhachHang;
import com.fa.training.entity.SuDungDichVu;
import com.fa.training.hibernate.HibernateUtil;

public class SuDungDichVuDAO {

	public boolean save(Map<String, String> serviceData) {
        Transaction transaction = null;
        boolean isSuccess = true;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            String maKH = serviceData.get("customerId");
            String maDV = serviceData.get("serviceId");
            Date ngaySuDung = Date.valueOf(serviceData.get("date"));
            Time gioSuDung = Time.valueOf(serviceData.get("hour")+":00");
            int soLuong = Integer.parseInt(serviceData.get("quantity").trim());
            
            SuDungDichVu suDungDichVu = new SuDungDichVu();
            suDungDichVu.setKhachHang(new KhachHang(maKH));
            suDungDichVu.setDichVu(new DichVu(maDV));
            suDungDichVu.setNgaySuDung(ngaySuDung);
            suDungDichVu.setGioSuDung(gioSuDung);
            suDungDichVu.setSoLuong(soLuong);
            
            session.save(suDungDichVu);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            isSuccess = false;
            e.printStackTrace();
        }
        return isSuccess;
    }
}