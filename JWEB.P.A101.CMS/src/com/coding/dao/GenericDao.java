package com.coding.dao;

import java.util.function.Consumer;

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
	
}
