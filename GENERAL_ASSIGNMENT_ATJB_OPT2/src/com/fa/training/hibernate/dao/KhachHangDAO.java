package com.fa.training.hibernate.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.fa.training.entity.KhachHang;
import com.fa.training.hibernate.HibernateUtil;

public class KhachHangDAO {
	
	private String countEmail = "SELECT COUNT(*) FROM KHACHHANG WHERE DiaChiEmail = :email";
	private String countPhone = "SELECT COUNT(*) FROM KHACHHANG WHERE SoDienThoai = :phone";
	
	public List<KhachHang> findAll(){
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			 session.beginTransaction();
			return (List<KhachHang>) session.createQuery("From KhachHang", KhachHang.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean save(Map<String, String> customerData) {
		Transaction transaction = null;
		boolean isSuccess = true;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			KhachHang kh = new KhachHang();
			kh.setMaKH(customerData.get("customerId"));
			kh.setDiaChi(customerData.get("address"));
			kh.setTenKH(customerData.get("customerName"));
			kh.setDiaChiEmail(customerData.get("email"));
			kh.setSoDienThoai(customerData.get("phone"));
			session.save(kh);
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
	
	public KhachHang findById(String customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return session.get(KhachHang.class, customerId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isEmailExists(String email) {
		Transaction transaction = null;
		Long count = 0L;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			NativeQuery<?> query = session.createNativeQuery(countEmail);
			query.setParameter("email", email);
			count = ((Number) query.getSingleResult()).longValue();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count > 0;
	}
	
	public boolean isPhoneExist(String phone) {
		Transaction transaction = null;
		Long count = 0L;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			NativeQuery<?> query = session.createNativeQuery(countPhone);
			query.setParameter("phone", phone);
			count = ((Number) query.getSingleResult()).longValue();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count > 0;
	}
	
	public boolean update(Map<String, String> customerData) {
		Transaction transaction = null;
		boolean isSuccess = true;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			KhachHang kh = new KhachHang();
			kh.setMaKH(customerData.get("customerId"));
			kh.setDiaChi(customerData.get("address"));
			kh.setTenKH(customerData.get("customerName"));
			kh.setDiaChiEmail(customerData.get("email"));
			kh.setSoDienThoai(customerData.get("phone"));
			session.update(kh);
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
	
	public boolean deleteById(String customerId) {
		Transaction transaction = null;
		boolean isSuccess = true;
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
		 
			session.createNativeQuery("DELETE FROM SUDUNGDICHVU WHERE MaKH = :maKH")
	           .setParameter("maKH", customerId)
	           .executeUpdate();

	    session.createNativeQuery("DELETE FROM SUDUNGMAY WHERE MaKH = :maKH")
	           .setParameter("maKH",customerId)
	           .executeUpdate();
	    
	    session.createNativeQuery("DELETE FROM KHACHHANG WHERE MaKH = :maKH")
	           .setParameter("maKH", customerId)
	           .executeUpdate();
			
			transaction.commit();
		} catch (Exception ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			isSuccess = false;
			ex.printStackTrace();
		}
		return isSuccess;
	}
	
	
		public long countTotalRecord(Map<String, String> data) {
	    Session session = null;
	    Transaction transaction = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();  
	        
	        StringBuilder hql = new StringBuilder("Select COUNT(*) From KhachHang Where 1=1 ");
	        
	        String customerId = data.get("customerId");
	        String customerName = data.get("customerName");
	        String email = data.get("email");
	        String phone = data.get("phone");
	        String address = data.get("address");
	        
	        if (customerId != null && !customerId.isEmpty()) {
	            hql.append(" AND maKH LIKE :customerId");
	        }
	        
	        if (customerName != null && !customerName.isEmpty()) {
	            hql.append(" AND tenKH LIKE :customerName");
	        }
	        
	        if (address != null && !address.isEmpty()) {
	            hql.append(" AND diaChi LIKE :address");
	        }
	        
	        if (phone != null && !phone.isEmpty()) {
	            hql.append(" AND soDienThoai LIKE :phone");
	        }
	        
	        if (email != null && !email.isEmpty()) {
	            hql.append(" AND diaChiEmail LIKE :email");
	        }
	        
	        Query<Long> query = session.createQuery(hql.toString(), Long.class);
	        
	        if (customerId != null && !customerId.isEmpty()) {
	            query.setParameter("customerId", "%" + customerId + "%");
	        }
	        
	        if (customerName != null && !customerName.isEmpty()) {
	            query.setParameter("customerName", "%" + customerName + "%");
	        }
	        
	        if (address != null && !address.isEmpty()) {
	            query.setParameter("address", "%" + address + "%");
	        }
	        
	        if (phone != null && !phone.isEmpty()) {
	            query.setParameter("phone", "%" + phone + "%");
	        }
	        
	        if (email != null && !email.isEmpty()) {
	            query.setParameter("email", "%" + email + "%");
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
	
	public List<KhachHang> findCustomer(Map<String, String> data,int page) {
	    Session session = null;
	    Transaction transaction = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();  // Start transaction
	        
	        StringBuilder hql = new StringBuilder("SELECT MaKH,TenKH,DiaChi,SoDienThoai,DiaChiEmail From KHACHHANG Where 1=1 ");
	        
	        String customerId = data.get("customerId");
	        String customerName = data.get("customerName");
	        String email = data.get("email");
	        String phone = data.get("phone");
	        String address = data.get("address");
	        
	        
	        if (customerId != null && !customerId.isEmpty()) {
	            hql.append(" AND MaKH LIKE :customerId");
	        }
	        
	        if (customerName != null && !customerName.isEmpty()) {
	            hql.append(" AND TenKH LIKE :customerName");
	        }
	        
	        if (address != null && !address.isEmpty()) {
	            hql.append(" AND DiaChi LIKE :address");
	        }
	        
	        if (phone != null && !phone.isEmpty()) {
	            hql.append(" AND SoDienThoai LIKE :phone");
	        }
	        
	        if (email != null && !email.isEmpty()) {
	            hql.append(" AND DiaChiEmail LIKE :email");
	        }
	        
	        int offset = (page -1) * 5;
	        
	        hql.append(" ORDER BY MaKH OFFSET "+offset +" ROWS FETCH NEXT "+5 + " ROWS ONLY");
	        Query<KhachHang> query = session.createNativeQuery(hql.toString(), KhachHang.class);
	        
	        if (customerId != null && !customerId.isEmpty()) {
	            query.setParameter("customerId", "%" + customerId + "%");
	        }
	        
	        if (customerName != null && !customerName.isEmpty()) {
	            query.setParameter("customerName", "%" + customerName + "%");
	        }
	        
	        if (address != null && !address.isEmpty()) {
	            query.setParameter("address", "%" + address + "%");
	        }
	        
	        if (phone != null && !phone.isEmpty()) {
	            query.setParameter("phone", "%" + phone + "%");
	        }
	        
	        if (email != null && !email.isEmpty()) {
	            query.setParameter("email", "%" + email + "%");
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