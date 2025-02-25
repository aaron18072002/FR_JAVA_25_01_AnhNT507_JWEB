package com.coding.dao;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.PollQuestion;

public class HibernatePollQuestionDao extends GenericDao {

	public void save(PollQuestion pollQuestion) {
		this.execute(session -> session.persist(pollQuestion));
	}
	
}
