package com.fa.training.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fa.training.entity.KhachHang;
import com.fa.training.entity.May;
import com.fa.training.hibernate.HibernateUtil;

public class MayDAO {
	public List<May> findAll(){
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			 session.beginTransaction();
			return (List<May>) session.createQuery("From May", May.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public boolean save(Map<String, String> param) {
		boolean isSuccess = true;
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			String machineId = param.get("machineId");
			String position = param.get("position");
			String status = param.get("status");
			May may = new May(machineId, position, status);
			session.save(may);
			transaction.commit();
		} catch (Exception ex) {
			isSuccess = false;
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return isSuccess; 
	}
	
	
	public boolean update(Map<String, String> param) {
		Transaction transaction = null;
		boolean isSuccess = true;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			String machineId = param.get("machineId");
			String position = param.get("position");
			String status = param.get("status");
			May may = new May();
			may.setMaMay(machineId);
			may.setTrangThai(status);
			may.setViTri(position);
			session.update(may);
			transaction.commit();
		} catch (Exception ex) {
			isSuccess = false;
			if(transaction!=null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return isSuccess;
	}
	
	public May findById(String machineId) {
		 May may = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        may = session.get(May.class, machineId);
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return may;
	}
	
	public boolean deleteById(String computerId) {
		Transaction transaction = null;
		boolean isSuccess = true;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			
			session.createNativeQuery("DELETE FROM SUDUNGMAY WHERE MaMay = :maMay")
	           .setParameter("maMay",computerId)
	           .executeUpdate();
			
			session.createNativeQuery("DELETE FROM May WHERE MaMay = :maMay")
	           .setParameter("maMay",computerId)
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
	
	public List<May> findByStatusFree(){
		Transaction transaction = null;
		List<May> list = new ArrayList<>();
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			
			list = session.createQuery("FROM May WHERE trangThai = :status", May.class)
			        .setParameter("status", "Ranh")
			        .getResultList();

			transaction.commit();
		} catch (Exception ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return list;
	}
	
	public long countTotalRecord(Map<String, String> data) {
	    Session session = null;
	    Transaction transaction = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();  
	        
	        StringBuilder hql = new StringBuilder("Select COUNT(*) From May Where 1=1 ");
	        
	        String computerId = data.get("computerId");
	        String status = data.get("status");
	        String position = data.get("position");
	        
	        if (computerId != null && !computerId.isEmpty()) {
	            hql.append(" AND maMay LIKE :computerId");
	        }
	        
	        if (position != null && !position.isEmpty()) {
	            hql.append(" AND viTri LIKE :position");
	        }
	        
	        if (status != null && !status.isEmpty()) {
	            hql.append(" AND trangThai LIKE :status");
	        }
	        
	        
	        Query<Long> query = session.createQuery(hql.toString(), Long.class);
	        
	        if (computerId != null && !computerId.isEmpty()) {
	            query.setParameter("computerId", "%" + computerId + "%");
	        }
	        
	        if (position != null && !position.isEmpty()) {
	            query.setParameter("position", "%" + position + "%");
	        }
	        
	        if (status != null && !status.isEmpty()) {
	            query.setParameter("status", "%" + status + "%");
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
	
	public List<May> findComputer(Map<String, String> data,int page) {
	    Session session = null;
	    Transaction transaction = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();  
	        
	        StringBuilder hql = new StringBuilder("SELECT MaMay, ViTri, TrangThai From MAY Where 1=1 ");
	        
	        String computerId = data.get("computerId");
	        String status = data.get("status");
	        String position = data.get("position");
	        
	        
	        if (computerId != null && !computerId.isEmpty()) {
	            hql.append(" AND MaMay LIKE :computerId");
	        }
	        
	        if (position != null && !position.isEmpty()) {
	            hql.append(" AND ViTri LIKE :position");
	        }
	        
	        if (status != null && !status.isEmpty()) {
	            hql.append(" AND TrangThai LIKE :status");
	        }
	        
	        
	        int offset = (page -1) * 5;
	        
	        hql.append(" ORDER BY MaMay OFFSET "+offset +" ROWS FETCH NEXT "+5 + " ROWS ONLY");
	        Query<May> query = session.createNativeQuery(hql.toString(), May.class);
	        
	        if (computerId != null && !computerId.isEmpty()) {
	            query.setParameter("computerId", "%" + computerId + "%");
	        }
	        
	        if (position != null && !position.isEmpty()) {
	            query.setParameter("position", "%" + position + "%");
	        }
	        
	        if (status != null && !status.isEmpty()) {
	            query.setParameter("status", "%" + status + "%");
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
}