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
@Table(name = "ANSWERS")
public class Answer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text", nullable = false, columnDefinition = "NVARCHAR(255) NOT NULL")
    private String text;
    
    @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY)
    private List<QuestionAnswer> questionAnswers;

    @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY)
    private List<AnswerUser> answerUsers;
    
    public Answer() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	public List<AnswerUser> getAnswerUsers() {
		return answerUsers;
	}

	public void setAnswerUsers(List<AnswerUser> answerUsers) {
		this.answerUsers = answerUsers;
	}  
	
}
