package com.uncc.mhealth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class User {
	private int id;
    private String username;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String dob;
    
    private String email;
    private String token;
    private String nickname;
    private int admin;
    private boolean pf;
    private boolean goal;
    private boolean strategy;
    private String gender;
    private String randomized_id;
	private String detailsUpdated;
	private String istoApp;
	private String sixWeekFlag;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email=" + email + ", token=" + token + ", nickname="
				+ nickname + ", admin=" + admin + ", pf=" + pf + ", goal=" + goal + ", strategy=" + strategy
				+ ", registrationDate=" + registrationDate + ", randomized_id="+ randomized_id +", detailsUpdated="+detailsUpdated+", istoApp="+istoApp+", sixWeekFlag="+sixWeekFlag+"]";
	}
	public boolean isPf() {
		return pf;
	}
	public void setPf(boolean pf) {
		this.pf = pf;
	}
	public boolean isGoal() {
		return goal;
	}
	public void setGoal(boolean goal) {
		this.goal = goal;
	}
	public boolean isStrategy() {
		return strategy;
	}
	public void setStrategy(boolean strategy) {
		this.strategy = strategy;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	private String registrationDate;
    
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRandomized_id() {
		return randomized_id;
	}
	public void setRandomized_id(String randomized_id) {
		this.randomized_id = randomized_id;
	}
	public String getDetailsUpdated() {
		return detailsUpdated;
	}
	public void setDetailsUpdated(String detailsUpdated) {
		this.detailsUpdated = detailsUpdated;
	}
	public String getIstoApp() {
		return istoApp;
	}
	public void setIstoApp(String istoApp) {
		this.istoApp = istoApp;
	}
	public String getSixWeekFlag() {
		return sixWeekFlag;
	}
	public void setSixWeekFlag(String sixWeekFlag) {
		this.sixWeekFlag = sixWeekFlag;
	}
}
