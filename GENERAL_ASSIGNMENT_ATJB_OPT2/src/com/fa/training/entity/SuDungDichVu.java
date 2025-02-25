package com.fa.training.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUDUNGDICHVU")
@IdClass(SuDungDichVuPK.class)
public class SuDungDichVu {
	@Id
	@ManyToOne
	@JoinColumn(name = "MaKH")
	private KhachHang khachHang;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "MaDV")
	private DichVu dichVu;
	
	@Id
	@Column(name = "NgaySuDung")
	private Date ngaySuDung;
	
	@Id
	@Column(name = "GioSuDung")
	private Time gioSuDung;
	
	@Column(name = "SoLuong")
	private int soLuong;

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public Date getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(Date ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public Time getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(Time gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}