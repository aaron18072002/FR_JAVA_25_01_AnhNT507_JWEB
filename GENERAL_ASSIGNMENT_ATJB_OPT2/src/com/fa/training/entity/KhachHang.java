package com.fa.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
	@Id
	@Column(name = "MaKH", length = 11)
	private String maKH;

	@Column(name = "TenKH", length = 35)
	private String tenKH;

	@Column(name = "DiaChi", length = 70)
	private String diaChi;

	@Column(name = "SoDienThoai", length = 10)
	private String soDienThoai;

	@Column(name = "DiaChiEmail", length = 55)
	private String diaChiEmail;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
	private Set<SuDungDichVu> serviceSet = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
	private Set<SuDungMay> mayService = new HashSet<>();
	
	
	
	
	public KhachHang() {
	}
	
	

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}



	public Set<SuDungMay> getMayService() {
		return mayService;
	}

	public void setMayService(Set<SuDungMay> mayService) {
		this.mayService = mayService;
	}

	public Set<SuDungDichVu> getServiceSet() {
		return serviceSet;
	}

	public void setServiceSet(Set<SuDungDichVu> serviceSet) {
		this.serviceSet = serviceSet;
	}

	// Getters & Setters
	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiEmail() {
		return diaChiEmail;
	}

	public void setDiaChiEmail(String diaChiEmail) {
		this.diaChiEmail = diaChiEmail;
	}
}