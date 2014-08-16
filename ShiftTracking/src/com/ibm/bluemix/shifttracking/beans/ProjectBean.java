package com.ibm.bluemix.shifttracking.beans;

import java.util.*;

public class ProjectBean {
	private String projectID;
	private String projectManager;
	private String accountManager;
	private ArrayList<EmployeeBean> members;
	private ArrayList<EmployeeBean> projectAdmins;

	public ProjectBean() {
	}


	public String getProjectID() {
		return projectID;
	}


	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}


	public String getProjectManager() {
		return projectManager;
	}


	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}


	public String getAccountManager() {
		return accountManager;
	}


	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}


	public ArrayList<EmployeeBean> getMembers() {
		return members;
	}


	public void setMembers(ArrayList<EmployeeBean> members) {
		this.members = members;
	}


	public ArrayList<EmployeeBean> getProjectAdmins() {
		return projectAdmins;
	}


	public void setProjectAdmins(ArrayList<EmployeeBean> projectAdmins) {
		this.projectAdmins = projectAdmins;
	}

	
}
