package com.fa.training.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "SUDUNGMAY")
@IdClass(SuDungMayPK.class)
public class SuDungMay {
    @Id
    @ManyToOne
    @JoinColumn(name = "MaKH")
    private KhachHang khachHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "MaMay")
    private May may;

    @Id
    @Column(name = "NgayBatDauSuDung")
    private Date ngayBatDauSuDung;

    @Id
    @Column(name = "GioBatDauSuDung")
    private java.sql.Time gioBatDauSuDung;

    @Column(name = "SoLuong")
    private int soLuong;
    
    public SuDungMay() {
    	
    }
    

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public Date getNgayBatDauSuDung() {
		return ngayBatDauSuDung;
	}

	public void setNgayBatDauSuDung(Date ngayBatDauSuDung) {
		this.ngayBatDauSuDung = ngayBatDauSuDung;
	}

	public java.sql.Time getGioBatDauSuDung() {
		return gioBatDauSuDung;
	}

	public void setGioBatDauSuDung(java.sql.Time gioBatDauSuDung) {
		this.gioBatDauSuDung = gioBatDauSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
    
    
}