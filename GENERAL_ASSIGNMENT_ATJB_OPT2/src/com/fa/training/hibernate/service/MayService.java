package com.fa.training.hibernate.service;

import java.util.List;
import java.util.Map;

import com.fa.training.entity.May;
import com.fa.training.hibernate.dao.MayDAO;

public class MayService {
	private MayDAO mayDAO = new MayDAO();

	public boolean saveOrUpdate(Map<String,String> param) {
		if (mayDAO.findById(param.get("machineId")) != null) {
			return mayDAO.update(param);
		} else {
			return mayDAO.save(param);
		}
	}
	
	public May findById(String computerId) {
		return mayDAO.findById(computerId);
	}
	
	public boolean deleteById(String computerId) {
		return mayDAO.deleteById(computerId);
	}
	
	public List<May> findByStatusFree(){
		return mayDAO.findByStatusFree();
	}
	
	public List<May> findComputer(Map<String, String> data,int page){
		return mayDAO.findComputer(data, page);
	}
	
	public long countTotalRecords(Map<String, String> data) {
		return mayDAO.countTotalRecord(data);
	}
}