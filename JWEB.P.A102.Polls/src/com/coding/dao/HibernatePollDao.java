package com.coding.dao;

import java.util.List;

import org.hibernate.type.StandardBasicTypes;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.Poll;

public class HibernatePollDao extends GenericDao {
	
	private static final String Q_GET_ALL = 
			"SELECT * FROM POLLS";

	/*
	 * private static final String Q_GET_BY_ID =
	 * "SELECT * FROM POLLS AS P WHERE P.id";
	 */
	public void save(Poll poll) {
		this.execute(session -> session.persist(poll));
	}
	
	public void update(Poll poll) {
		this.execute(session -> session.merge(poll));
	}
	
	public Poll getById(int id) {
		return this.openSession()
		        .createQuery("FROM Poll P WHERE P.id = :id", Poll.class)
		        .setParameter("id", id, StandardBasicTypes.INTEGER)
		        .uniqueResult();
	}
	
	public List<Poll> getAll() {
		return this.openSession()
				.createNativeQuery(Q_GET_ALL, this.getEntityClass())
				.getResultList();
	}
	
	private Class<Poll> getEntityClass() {
		return Poll.class;
	}
	
}
