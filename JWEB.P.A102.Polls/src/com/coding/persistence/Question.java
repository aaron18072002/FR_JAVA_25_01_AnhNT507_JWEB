package com.coding.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "is_multiple", nullable = false, columnDefinition = "BIT NOT NULL")
	private boolean isMultiple;

	@Column(name = "is_required", nullable = false, columnDefinition = "BIT NOT NULL")
	private boolean isRequired;

	@Column(name = "text", nullable = false, columnDefinition = "NVARCHAR(255) NOT NULL")
	private String text;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private List<PollQuestion> pollQuestions;

	public Question() {

	}

	public List<PollQuestion> getPollQuestions() {
		return pollQuestions;
	}

	public void setPollQuestions(List<PollQuestion> pollQuestions) {
		this.pollQuestions = pollQuestions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
