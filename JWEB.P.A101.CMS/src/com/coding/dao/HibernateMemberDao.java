package com.coding.dao;

import org.hibernate.type.StandardBasicTypes;

import com.coding.persistence.Member;

public class HibernateMemberDao extends GenericDao {
	
	private static final String Q_GET_BY_USERNAME = 
			"SELECT * FROM members m WHERE m.Username = :username";
	private static final String Q_GET_BY_EMAIL = 
			"SELECT * FROM members m WHERE m.Email = :email";
//	private static final String Q_GET_BY_ID = 
//			"SELECT * FROM members m WHERE m.id = :id";
	private static final String Q_GET_BY_EMAIL_AND_PASSWORD = 
			"SELECT * FROM members m WHERE m.Email = :email AND m.Password = :password";
	
	public void save(Member member) {
		this.execute(session -> session.persist(member));
	}
	
	public void update(Member member) {
		this.execute(session -> session.merge(member));
	}
	
	private Class<Member> getEntityClass() {
		return Member.class;
	}
	
	public Member getMemberById(int id) {
	    return this.openSession()
	            .createQuery("FROM Member m WHERE m.id = :id", Member.class)
	            .setParameter("id", id, StandardBasicTypes.INTEGER)
	            .uniqueResult();
	}
	
	public Member login(String email,String password) {
		return this.openSession()
				.createNativeQuery(Q_GET_BY_EMAIL_AND_PASSWORD, getEntityClass())
				.setParameter("email", email, StandardBasicTypes.STRING)
				.setParameter("password", password, StandardBasicTypes.STRING)
				.uniqueResult();
	}
	
	public Member getMemberByUsername(String username) {
		return this.openSession()
				.createNativeQuery(Q_GET_BY_USERNAME, getEntityClass())
				.setParameter("username", username, StandardBasicTypes.STRING)
				.uniqueResult();
	}

    public Member getMemberEmail(String email) {
    	return this.openSession()
				.createNativeQuery(Q_GET_BY_EMAIL, getEntityClass())
				.setParameter("email", email, StandardBasicTypes.STRING)
				.uniqueResult();
    }
	
}
