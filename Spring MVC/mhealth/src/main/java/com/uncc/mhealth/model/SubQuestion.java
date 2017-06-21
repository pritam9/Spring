package com.uncc.mhealth.model;

import javax.persistence.*;

@Entity
@Table(name = "subquestion")
public class SubQuestion {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "text")
	private String text;
	@Column(name = "answer")
	private String answer;
	@Column(name="orderNo")
	private int orderNo;
	@Column(name="active_yn")
	private String active_yn;
	
	public SubQuestion(){

	}
	
	public SubQuestion(int id){
		super();
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	// @ManyToOne
	// @JoinColumn(name="question_id")
	// private Question question;
	// public Question getQuestion() {
	// return question;
	// }
	// public void setQuestion(Question question) {
	// this.question = question;
	// }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public int getQuestion_id() {
	// return question_id;
	// }
	// public void setQuestion_id(int question_id) {
	// this.question_id = question_id;
	// }
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getActive_yn() {
		return active_yn;
	}

	public void setActive_yn(String active_yn) {
		this.active_yn = active_yn;
	}

	@Override
	public String toString() {
		return "SubQuestion [id=" + id + ", text=" + text + ", answer=" + answer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubQuestion other = (SubQuestion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
