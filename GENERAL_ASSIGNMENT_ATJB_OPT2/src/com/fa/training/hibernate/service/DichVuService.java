package com.fa.training.hibernate.service;

import java.util.List;
import java.util.Map;

import com.fa.training.entity.DichVu;
import com.fa.training.hibernate.dao.DichVuDAO;

public class DichVuService {
	private DichVuDAO dichVuDAO;

	public DichVuService() {
		dichVuDAO = new DichVuDAO();
	}

	public boolean saveOrUpdate(Map<String, String> serviceData) {
		if (dichVuDAO.findById(serviceData.get("serviceId")) != null) {
			return dichVuDAO.update(serviceData);
		} else {
			return dichVuDAO.save(serviceData);
		}
	}

	public DichVu findById(String serviceId) {
		return dichVuDAO.findById(serviceId);
	}

	public boolean deleteById(String serviceId) {
		return dichVuDAO.deleteById(serviceId);
	}

	public List<DichVu> findAll() {
		return dichVuDAO.findAll();
	}

	public List<DichVu> findService(Map<String, String> data, int page) {
		return dichVuDAO.findService(data, page);
	}

	public long countTotalRecords(Map<String, String> data) {
		return dichVuDAO.countTotalRecord(data);
	}
}