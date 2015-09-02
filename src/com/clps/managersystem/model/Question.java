package com.clps.managersystem.model;

public class Question {

	private int questionId;
	private String questionContent;
	private String answer;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionContent=" + questionContent + ", answer=" + answer
				+ "]";
	}
	
	
	
	
}
