package com.coding.dao;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.Answer;

public class HibernateAnswerDao extends GenericDao {

	public void save(Answer answer) {
		this.execute(session -> session.persist(answer));
	}
	
}
