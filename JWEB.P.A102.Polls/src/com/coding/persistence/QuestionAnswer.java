package com.coding.persistence;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coding.persistence.keys.KeyQuestionAnswer;

@Entity
@Table(name = "QUESTIONS_ANSWERS")
public class QuestionAnswer {

    @EmbeddedId
    private KeyQuestionAnswer keys;

    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id", insertable = false, updatable = false)
    private Answer answer;

    public QuestionAnswer() {
    	
    }

    public KeyQuestionAnswer getKeys() {
        return keys;
    }

    public void setKeys(KeyQuestionAnswer keys) {
        this.keys = keys;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
}
