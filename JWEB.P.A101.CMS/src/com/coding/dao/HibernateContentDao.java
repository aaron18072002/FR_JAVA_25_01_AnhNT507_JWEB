package com.coding.dao;

import java.util.List;

import com.coding.persistence.Content;

public class HibernateContentDao extends GenericDao {
	
	private static final String Q_GET_BY_AUTHORID = 
			"SELECT * FROM contents AS C WHERE C.AuthorId = :authorId";
	
	public void save(Content content) {
		this.execute(session -> session.persist(content));
	}
	
	public List<Content> getByAuthorId(int authorId) {
		return this.openSession()
	            .createNativeQuery(Q_GET_BY_AUTHORID, this.getEntityClass())
	            .setParameter("authorId", authorId)
	            .getResultList();
	}
	
	public Class<Content> getEntityClass() {
		return Content.class;
	}

}
