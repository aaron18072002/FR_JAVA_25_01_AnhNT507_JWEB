package com.fa.training.entity;

import java.io.Serializable;
import java.util.Date;
import java.sql.Time;
import java.util.Objects;

public class SuDungDichVuPK implements Serializable {
    private String khachHang; // Tương ứng với MaKH
    private String dichVu;    // Tương ứng với MaDV
    private Date ngaySuDung;
    private Time gioSuDung;

    // Constructors (bắt buộc Hibernate cần)
    public SuDungDichVuPK() {}

    public SuDungDichVuPK(String khachHang, String dichVu, Date ngaySuDung, Time gioSuDung) {
        this.khachHang = khachHang;
        this.dichVu = dichVu;
        this.ngaySuDung = ngaySuDung;
        this.gioSuDung = gioSuDung;
    }

    // Override equals() để so sánh 2 object khóa chính
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuDungDichVuPK that = (SuDungDichVuPK) o;
        return Objects.equals(khachHang, that.khachHang) &&
               Objects.equals(dichVu, that.dichVu) &&
               Objects.equals(ngaySuDung, that.ngaySuDung) &&
               Objects.equals(gioSuDung, that.gioSuDung);
    }

    // Override hashCode() để đảm bảo tính nhất quán khi lưu vào HashMap hoặc Hibernate Cache
    @Override
    public int hashCode() {
        return Objects.hash(khachHang, dichVu, ngaySuDung, gioSuDung);
    }
}