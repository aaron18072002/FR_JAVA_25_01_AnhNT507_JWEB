package com.coding.persistence;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "id", columnDefinition = "NVARCHAR(50)")
	private String id;

	@Column(name = "UserName", columnDefinition = "NVARCHAR(50)")
	private String userName;

	@Column(name = "Password", columnDefinition = "NVARCHAR(255)")
	private String password;

	@Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;
	
	@PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<AnswerUser> answerUsers;;

	public User() {

	}

	public User(String id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public List<AnswerUser> getAnswerUsers() {
		return answerUsers;
	}

	public void setAnswerUsers(List<AnswerUser> answerUsers) {
		this.answerUsers = answerUsers;
	}

}
