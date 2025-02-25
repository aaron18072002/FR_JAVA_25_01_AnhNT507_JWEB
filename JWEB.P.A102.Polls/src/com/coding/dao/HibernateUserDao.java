package com.coding.dao;


import org.hibernate.type.StandardBasicTypes;

import com.coding.dao.base.GenericDao;
import com.coding.persistence.User;

public class HibernateUserDao extends GenericDao {
	
	private static final String Q_GET_BY_USERNAME_AND_PASSWORD = 
			"SELECT * FROM USERS AS U WHERE U.Username = :username "
			+ "AND U.Password = :password";
	
	public User login(String username,String password) {
		return this.openSession()
				.createNativeQuery(Q_GET_BY_USERNAME_AND_PASSWORD, this.getEntityClass())
				.setParameter("username", username, StandardBasicTypes.STRING)
				.setParameter("password", password, StandardBasicTypes.STRING)
				.uniqueResult();
	}
	
	private Class<User> getEntityClass() {
		return User.class;
	}
	
}
