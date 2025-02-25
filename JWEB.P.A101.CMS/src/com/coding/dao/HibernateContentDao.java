package com.coding.dao;

import java.util.List;

import com.coding.persistence.Content;

public class HibernateContentDao extends GenericDao {
	
	private static final String Q_GET_BY_AUTHORID = 
			"SELECT * FROM contents AS C WHERE C.AuthorId = :authorId";
	
	private static final String Q_GET_BY_TITLE = 
			"SELECT * FROM contents AS C WHERE C.Title LIKE :title";
	
	public void save(Content content) {
		this.execute(session -> session.persist(content));
	}
	
	public List<Content> getByAuthorId(int authorId) {
		return this.openSession()
	            .createNativeQuery(Q_GET_BY_AUTHORID, this.getEntityClass())
	            .setParameter("authorId", authorId)
	            .getResultList();
	}
	
	public List<Content> getByTitle(String title) {
		return this.openSession()
	            .createNativeQuery(Q_GET_BY_TITLE, this.getEntityClass())
	            .setParameter("title", title)
	            .getResultList();
	}
	
	public Class<Content> getEntityClass() {
		return Content.class;
	}

}
