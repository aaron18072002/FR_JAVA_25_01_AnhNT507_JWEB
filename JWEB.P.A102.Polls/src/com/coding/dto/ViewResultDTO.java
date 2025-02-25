package com.coding.dto;

import java.util.List;

import com.coding.persistence.Question;

public class ViewResultDTO {
	private Question question;
	private List<AnswerDTO> answers;

	public ViewResultDTO(Question question, List<AnswerDTO> answers) {
		this.question = question;
		this.answers = answers;
	}

	public Question getQuestion() {
		return question;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QuestionDTO [question=" + question + ", answers=" + answers + "]";
	}

}
