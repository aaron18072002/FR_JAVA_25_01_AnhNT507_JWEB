package com.fa.training.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MAY")
public class May implements Serializable{
	@Id
	@Column(name = "MaMay",length = 11)
	private String maMay;
	
	@Column(name = "ViTri",length = 11)
	private String viTri;
	
	@Column(name = "TrangThai",length = 50)
	private String trangThai;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "may")
	private Set<SuDungMay> maySet = new HashSet<>();
	
	public May() {
		
	}
	

	public May(String maMay) {
		this.maMay = maMay;
	}
	
	public May(String maMay, String viTri, String trangThai) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}

	public Set<SuDungMay> getMaySet() {
		return maySet;
	}

	public void setMaySet(Set<SuDungMay> maySet) {
		this.maySet = maySet;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}