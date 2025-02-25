package com.fa.training.entity;

import java.io.Serializable;
import java.util.Date;
import java.sql.Time;
import java.util.Objects;

public class SuDungMayPK implements Serializable {
    private String khachHang;  // Tương ứng với MaKH
    private String may;        // Tương ứng với MaMay
    private Date ngayBatDauSuDung;
    private Time gioBatDauSuDung;

    // Constructors
    public SuDungMayPK() {}

    public SuDungMayPK(String khachHang, String may, Date ngayBatDauSuDung, Time gioBatDauSuDung) {
        this.khachHang = khachHang;
        this.may = may;
        this.ngayBatDauSuDung = ngayBatDauSuDung;
        this.gioBatDauSuDung = gioBatDauSuDung;
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuDungMayPK that = (SuDungMayPK) o;
        return Objects.equals(khachHang, that.khachHang) &&
               Objects.equals(may, that.may) &&
               Objects.equals(ngayBatDauSuDung, that.ngayBatDauSuDung) &&
               Objects.equals(gioBatDauSuDung, that.gioBatDauSuDung);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(khachHang, may, ngayBatDauSuDung, gioBatDauSuDung);
    }
}