package com.coding.dao;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.QuestionAnswer;

public class HibernateQuestionAnswerDao extends GenericDao {
	
	public void save(QuestionAnswer questionAnswer) {
		this.execute(session -> session.persist(questionAnswer));
	}

}
