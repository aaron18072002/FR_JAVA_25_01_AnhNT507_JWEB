package com.coding.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.query.Query;
import com.coding.dao.base.GenericDao;
import com.coding.dto.AnswerDTO;
import com.coding.persistence.Answer;

public class HibernateAnswerDao extends GenericDao {

	private static final String STATISTIC = "SELECT A.id, A.text, COUNT(AU.answer_id) AS TOTAL "
			+ "FROM QUESTIONS_ANSWERS AS QA " + "INNER JOIN ANSWERS AS A ON QA.answer_id = A.id "
			+ "LEFT JOIN ANSWERS_USERS AS AU ON A.id = AU.answer_id " + "WHERE QA.question_id = :questionId "
			+ "GROUP BY A.id, A.text";

	public void save(Answer answer) {
		this.execute(session -> session.persist(answer));
	}

	public List<AnswerDTO> statistic(int questionId) {
		return this.executeWithResult(session -> {
			Query<Object[]> query = session.createNativeQuery(STATISTIC);
			query.setParameter("questionId", questionId);

			List<Object[]> results = query.getResultList();
			return results.stream().map(row -> 
						new AnswerDTO(((Number) row[0]).intValue(), // id
					(String) row[1], // text
					((Number) row[2]).intValue() // total
			)).collect(Collectors.toList());
		});
	}

	public Class<Answer> getEntityClass() {
		return Answer.class;
	}
}
