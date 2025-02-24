package com.coding.persistence.keys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class KeyPollQuestion implements Serializable {

	@Column(name = "poll_id")
	private Integer pollId;
	
	@Column(name = "question_id")
	private Integer questionId;
	
	public KeyPollQuestion() {
		
	}

	public Integer getPollId() {
		return pollId;
	}

	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pollId, questionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyPollQuestion other = (KeyPollQuestion) obj;
		return Objects.equals(pollId, other.pollId) && Objects.equals(questionId, other.questionId);
	}

	
}
