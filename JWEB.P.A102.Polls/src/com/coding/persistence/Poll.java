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
@Table(name = "POLLS")
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "status", nullable = false, columnDefinition = "NVARCHAR(255) NOT NULL")
	private String status;
	
	@Column(name = "text", nullable = false, columnDefinition = "NVARCHAR(255) NOT NULL")
	private String text;
	
	@OneToMany(mappedBy = "poll", fetch = FetchType.LAZY)
    private List<PollQuestion> pollQuestions;
	
	public Poll() {
		
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
