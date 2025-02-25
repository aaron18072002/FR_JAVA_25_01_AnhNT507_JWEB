package com.coding.dao;

import java.util.List;

import org.hibernate.type.StandardBasicTypes;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.Question;

public class HibernateQuestionDao extends GenericDao {
	
	private static final String Q_GET_BY_POLL_ID =
			"SELECT * FROM QUESTIONS AS Q\r\n"
			+ "INNER JOIN POLLS_QUESTIONS AS PQ\r\n"
			+ "ON Q.id = PQ.question_id\r\n"
			+ "WHERE PQ.poll_id = :pollId";
	
	public void save(Question question) {
		this.execute(session -> session.persist(question));
	}
	
	public List<Question> getByPollId(int pollId) {
		return this.openSession()
				.createNativeQuery(Q_GET_BY_POLL_ID, this.getEntityClass())
				.setParameter("pollId", pollId, StandardBasicTypes.INTEGER)
				.getResultList();
	}
	
	public Class<Question> getEntityClass() {
		return Question.class;
	}

}
