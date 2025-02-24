package com.coding.persistence.keys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class KeyAnswerUser implements Serializable {

	@Column(name = "answer_id")
	private Integer answerId;

	@Column(name = "user_id")
	private String userId;

	public KeyAnswerUser() {
	}

	public KeyAnswerUser(Integer answerId, String userId) {
		this.answerId = answerId;
		this.userId = userId;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(answerId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyAnswerUser other = (KeyAnswerUser) obj;
		return Objects.equals(answerId, other.answerId) && Objects.equals(userId, other.userId);
	}

}
