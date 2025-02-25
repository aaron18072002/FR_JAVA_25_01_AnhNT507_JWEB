package com.coding.dao;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.Question;

public class HibernateQuestionDao extends GenericDao {
	
	public void save(Question question) {
		this.execute(session -> session.persist(question));
	}

}
