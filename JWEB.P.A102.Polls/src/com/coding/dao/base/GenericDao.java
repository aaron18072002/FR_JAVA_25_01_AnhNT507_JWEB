package com.coding.dao.base;

import java.util.function.Consumer;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coding.connection.DbConnection;

public class GenericDao {
	
	private SessionFactory sessionFactory;
	
	public GenericDao() {
		sessionFactory = DbConnection.getSessionFactory();
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected void execute(Consumer<Session> worker) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			worker.accept(session);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	protected <T> T executeWithResult(Function<Session, T> worker) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            T result = worker.apply(session);
            transaction.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }
	
}
