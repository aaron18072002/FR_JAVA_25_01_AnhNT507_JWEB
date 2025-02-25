package com.coding.dto;

public class AnswerDTO {

	private int id;
	private String text;
	private int total;

	public AnswerDTO(int id, String text, int total) {
		this.id = id;
		this.text = text;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "AnswerDTO [id=" + id + ", text=" + text + ", total=" + total + "]";
	}

}
