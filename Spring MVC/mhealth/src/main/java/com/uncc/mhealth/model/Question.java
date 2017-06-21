package com.uncc.mhealth.model;

import java.util.Comparator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
	
@Entity
@Table(name = "questions")
public class Question {
	public static final int TYPE_HEADING = -1;
	public static final int TYPE_TEXT = 0;
	public static final int TYPE_NUMBER = 1;
	public static final int TYPE_CHECK = 2;
	public static final int TYPE_RADIO = 3;
	public static final int TYPE_SUB_TEXT = 4;
	public static final int TYPE_SUB_NUMBER = 5;
	public static final int TYPE_SUB_CHECK = 6;
	public static final int TYPE_SUB_RADIO = 7;
	public static final int TYPE_SUB_OPTION_TEXT = 8;
	public static final int TYPE_SUB_OPTION_NUMBER = 9;
	public static final int TYPE_TEXT_AREA = 10;
	
	public Question(){
		
	}
	
	public Question(int id){
		super();
		this.id = id;
	}
	
	private int id;
	private int index;
	private String text;
	private int type;
	private String answer;
	@OneToMany(mappedBy="question")
	@OrderBy("orderNo")
	private Set<Option> options;
	@OneToMany(mappedBy="question")
	@OrderBy("orderNo")
	private Set<SubQuestion> subquestions;
	private String survey;
	private String strId;
	@Column(name="orderNo")
	private int orderNo;
	private boolean ignore;
	private int pageNo;
	private String active_yn;
	private String sixWeekFlag;

	@Id
    @GeneratedValue
    @Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(name="type")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(name="answer")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Set<Option> getOptions() {
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	public Set<SubQuestion> getSubquestions() {
		return subquestions;
	}
	public void setSubquestions(Set<SubQuestion> subquestions) {
		this.subquestions = subquestions;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getSurvey() {
		return survey;
	}
	public void setSurvey(String survey) {
		this.survey = survey;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Column(name="ignore", columnDefinition="TINYINT(1)")
	public boolean isIgnore() {
		return ignore;
	}

	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}
	@Column(name="pageNo")
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	@Column(name="active_yn")
	public String getActive_yn() {
		return active_yn;
	}

	public void setActive_yn(String active_yn) {
		this.active_yn = active_yn;
	}
	@Column(name="sixWeekFlag")
	public String getSixWeekFlag() {
		return sixWeekFlag;
	}

	public void setSixWeekFlag(String sixWeekFlag) {
		this.sixWeekFlag = sixWeekFlag;
	}

	public static class Comparators {

        public static Comparator<Question> INDEX = new Comparator<Question>() {
            public int compare(Question o1, Question o2) {
                return o1.index - o2.index;
            }
        };
    }
	@Override
	public String toString() {
		return "Question [id=" + id + ",strId=" + strId + ", index=" + index + ", text=" + text + ", type=" + type + ", answer=" + answer
				+ ", options=" + options + ", subquestions=" + subquestions + ", survey=" + survey + "]";
	}
}
