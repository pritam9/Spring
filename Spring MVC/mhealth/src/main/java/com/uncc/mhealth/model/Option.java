package com.uncc.mhealth.model;

import java.util.Comparator;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {
	
	@Id
    @GeneratedValue
    @Column(name="id")
	private int id;
//	@Column(name="question_id")
//	private int question_id;
	@Column(name="text")
	private String text;
	@Column(name="value")
	private int value;
	@Column(name="orderNo")
	private int orderNo;
	@Column(name="active_yn")
	private String active_yn;
//	@ManyToOne
//    @JoinColumn(name="question_id")
//	private Question question;
//	public Question getQuestion() {
//		return question;
//	}
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getQuestion_id() {
//		return question_id;
//	}
//	public void setQuestion_id(int question_id) {
//		this.question_id = question_id;
//	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + value;
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
		Option other = (Option) obj;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	public static class Comparators {
		public static Comparator<Option> VALUE = new Comparator<Option>() {
            public int compare(Option o1, Option o2) {
                return o1.value - o2.value;
            }
        };
    }
	@Override
	public String toString() {
		return "Option [id=" + id + ", text=" + text + ", value=" + value + "]";
	}
	
	
	
}
