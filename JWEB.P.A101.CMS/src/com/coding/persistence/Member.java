package com.coding.persistence;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Firstname", length = 50)
	private String firstName;

	@Column(name = "Lastname", length = 50)
	private String lastName;

	@Column(name = "Username", nullable = false, unique = true, length = 50)
	private String username;

	@Column(name = "Password", nullable = false, length = 255)
	private String password;

	@Column(name = "Phone", length = 15)
	private String phone;

	@Column(name = "Email", unique = true, length = 100)
	private String email;

	@Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
	private String description;

	@Column(name = "CreatedDate", updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "UpdateTime")
	private LocalDateTime updateTime;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonIgnore
	private List<Content> contents;	

	public Member() {
	}

	public Member(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@PrePersist
	protected void onCreate() {
		this.createdDate = LocalDateTime.now();
		this.updateTime = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updateTime = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	
	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	

}
