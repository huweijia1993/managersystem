package com.clps.managersystem.model;

import java.sql.Date;

public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String userGender;
	private Date userBirthday;
	private String userHometown;
	private float userHeight;
	private String userLevel;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserHometown() {
		return userHometown;
	}
	public void setUserHometown(String userHometown) {
		this.userHometown = userHometown;
	}
	public float getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(float userHeight) {
		this.userHeight = userHeight;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userGender="
				+ userGender + ", userBirthday=" + userBirthday + ", userHometown=" + userHometown + ", userHeight="
				+ userHeight + ", userLevel=" + userLevel + "]";
	}
	
	
	
	
	
	
	
}
