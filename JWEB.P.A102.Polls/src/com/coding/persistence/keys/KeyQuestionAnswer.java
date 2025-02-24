package com.coding.persistence.keys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class KeyQuestionAnswer implements Serializable {

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "answer_id")
    private Integer answerId;

    public KeyQuestionAnswer() {}

    public KeyQuestionAnswer(Integer questionId, Integer answerId) {
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

	@Override
	public int hashCode() {
		return Objects.hash(answerId, questionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyQuestionAnswer other = (KeyQuestionAnswer) obj;
		return Objects.equals(answerId, other.answerId) && Objects.equals(questionId, other.questionId);
	}

}