package com.ibm.bluemix.shifttracking.beans;



public class UserIDBean {

	private String userID;
	private String password;
	private String answer;
	public UserIDBean() {
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "UserIDBean [toString()=" + "user id:" + userID + ",password:" + password + ",answer:" + answer + "]";
	}


	
}
