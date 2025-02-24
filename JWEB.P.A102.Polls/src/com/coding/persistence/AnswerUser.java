package com.coding.persistence;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coding.persistence.keys.KeyAnswerUser;

@Entity
@Table(name = "ANSWERS_USERS")
public class AnswerUser {

    @EmbeddedId
    private KeyAnswerUser keys;

    @ManyToOne
    @JoinColumn(name = "answer_id", insertable = false, updatable = false)
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public AnswerUser() {
    	
    }

    public KeyAnswerUser getKeys() {
        return keys;
    }

    public void setKeys(KeyAnswerUser keys) {
        this.keys = keys;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
