package com.fa.training.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "DICHVU")
public class DichVu implements Serializable{
	@Id
	@Column(name = "MaDV", length = 11)
	private String maDV;

	@Column(name = "TenDV", length = 40)
	private String tenDV;

	@Column(name = "DonViTinh", length = 25)
	private String donViTinh;

	@Column(name = "DonGia")
	private double donGia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dichVu")
	private Set<SuDungDichVu> serviceSet = new HashSet<>();
	
	
	public DichVu() {
		
	}
	
	public DichVu(String maDV) {
		this.maDV = maDV;
	}
	
	public DichVu(String maDV, String tenDV, String donViTinh, double donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}



	public Set<SuDungDichVu> getServiceSet() {
		return serviceSet;
	}

	public void setServiceSet(Set<SuDungDichVu> serviceSet) {
		this.serviceSet = serviceSet;
	}

	// Getters & Setters
	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
}