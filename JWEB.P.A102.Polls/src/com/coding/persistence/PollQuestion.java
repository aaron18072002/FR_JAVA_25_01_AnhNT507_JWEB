package com.coding.persistence;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coding.persistence.keys.KeyPollQuestion;

@Entity
@Table(name = "POLLS_QUESTIONS")
public class PollQuestion {

	@EmbeddedId
	private KeyPollQuestion keys;
	
	@ManyToOne
	@JoinColumn(name = "poll_id", insertable = false, updatable = false)
	private Poll poll;
	
	@ManyToOne
	@JoinColumn(name = "question_id", insertable = false, updatable = false)
	private Question question;

	public KeyPollQuestion getKeys() {
		return keys;
	}

	public void setKeys(KeyPollQuestion keys) {
		this.keys = keys;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
