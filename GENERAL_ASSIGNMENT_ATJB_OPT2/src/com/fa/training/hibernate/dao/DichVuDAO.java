package com.fa.training.hibernate.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fa.training.entity.DichVu;
import com.fa.training.entity.KhachHang;
import com.fa.training.entity.May;
import com.fa.training.hibernate.HibernateUtil;

public class DichVuDAO {
	public List<DichVu> findAll() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			session.beginTransaction();
			return (List<DichVu>) session.createQuery("From DichVu", DichVu.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public DichVu findById(String serviceId) {
		DichVu dv = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			dv = session.get(DichVu.class, serviceId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dv;
	}

	public boolean save(Map<String, String> serviceData) {
		boolean isSuccess = true;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();

			String serviceId = serviceData.get("serviceId");
			String serviceName = serviceData.get("serviceName");
			String unit = serviceData.get("unit");
			double price = Double.parseDouble(serviceData.get("price"));

			DichVu dv = new DichVu(serviceId, serviceName, unit, price);
			session.save(dv);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}

	public boolean update(Map<String, String> serviceData) {
		boolean isSuccess = true;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();

			String serviceId = serviceData.get("serviceId");
			String serviceName = serviceData.get("serviceName");
			String unit = serviceData.get("unit");
			double price = Double.parseDouble(serviceData.get("price"));

			DichVu dv = session.get(DichVu.class, serviceId);
			dv.setDonGia(price);
			dv.setMaDV(serviceId);
			dv.setDonViTinh(unit);
			session.update(dv);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}

	public boolean deleteById(String serviceId) {
		Transaction transaction = null;
		boolean isSuccess = true;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			session.createNativeQuery("DELETE FROM SUDUNGDICHVU WHERE MaDV = :maDV")
	           .setParameter("maDV",serviceId)
	           .executeUpdate();
			
			session.createNativeQuery("DELETE FROM DICHVU WHERE MaDV = :maDV")
	           .setParameter("maDV",serviceId)
	           .executeUpdate();
			
			transaction.commit();
		} catch (Exception ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			ex.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public List<DichVu> findService(Map<String, String> data, int page){
		 Session session = null;
		    Transaction transaction = null;
		    try {
		        session = HibernateUtil.getSessionFactory().openSession();
		        transaction = session.beginTransaction();  
		        
		        StringBuilder hql = new StringBuilder("SELECT MaDV,TenDV,DonViTinh,DonGia From DichVu Where 1=1 ");
		        
		        String serviceId = data.get("serviceId");
		        String serviceName = data.get("serviceName");
		        String unit = data.get("unit");
		        String price = data.get("price");
		        
		        if (serviceId != null && !serviceId.isEmpty()) {
		            hql.append(" AND MaDV LIKE :serviceId");
		        }
		        
		        if (serviceName != null && !serviceName.isEmpty()) {
		            hql.append(" AND TenDV LIKE :serviceName");
		        }
		        
		        if (unit != null && !unit.isEmpty()) {
		            hql.append(" AND DonViTinh LIKE :unit");
		        }
		        
		        if(price != null && !price.isEmpty()) {
		            hql.append(" AND DonGia = :price");
		        }
		        
		        int offset = (page -1) * 5;
		        
		        hql.append(" ORDER BY MaDV OFFSET "+offset +" ROWS FETCH NEXT "+5 + " ROWS ONLY");
		        Query<DichVu> query = session.createNativeQuery(hql.toString(), DichVu.class);
		        
		        if (serviceId != null && !serviceId.isEmpty()) {
		            query.setParameter("serviceId", "%" + serviceId + "%");
		        }
		        
		        if ( serviceName!= null && !serviceName.isEmpty()) {
		            query.setParameter("serviceName", "%" + serviceName + "%");
		        }
		        
		        if (unit != null && !unit.isEmpty()) {
		            query.setParameter("unit", "%" + unit + "%");
		        }
		        
		        if(price != null && !price.isEmpty()) {
		            query.setParameter("price", Double.parseDouble(price));
		        }
		        
		        return query.getResultList();
		    } catch (Exception ex) {
		        if (transaction != null) {
		            transaction.rollback();  
		        }
		        ex.printStackTrace();
		    } finally {
		        if (session != null && session.isOpen()) {
		            session.close();  
		        }
		    }
		    return null;
	}
	
	
	public long countTotalRecord(Map<String, String> data) {
	    Session session = null;
	    Transaction transaction = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();  
	        
	        StringBuilder hql = new StringBuilder("Select COUNT(maDV) From DichVu Where 1=1 ");
	        
	        String serviceId = data.get("serviceId");
	        String serviceName = data.get("serviceName");
	        String unit = data.get("unit");
	        String price = data.get("price");
	        
	        if (serviceId != null && !serviceId.isEmpty()) {
	            hql.append(" AND maDV LIKE :serviceId");
	        }
	        
	        if (serviceName != null && !serviceName.isEmpty()) {
	            hql.append(" AND tenDV LIKE :serviceName");
	        }
	        
	        if (unit != null && !unit.isEmpty()) {
	            hql.append(" AND donViTinh LIKE :unit");
	        }
	        
	        if(price != null && !price.isEmpty()) {
	            hql.append(" AND donGia = :price");
	        }
	        
	        
	        Query<Long> query = session.createQuery(hql.toString(), Long.class);
	        
	        if (serviceId != null && !serviceId.isEmpty()) {
	            query.setParameter("serviceId", "%" + serviceId + "%");
	        }
	        
	        if ( serviceName!= null && !serviceName.isEmpty()) {
	            query.setParameter("serviceName", "%" + serviceName + "%");
	        }
	        
	        if (unit != null && !unit.isEmpty()) {
	            query.setParameter("unit", "%" + unit + "%");
	        }
	        
	        if(price != null && !price.isEmpty()) {
	            query.setParameter("price", Double.parseDouble(price));
	        }
	        
	        return query.getSingleResult();  
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();  
	        }
	        ex.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();  
	        }
	    }
	    return 0;
	}
}