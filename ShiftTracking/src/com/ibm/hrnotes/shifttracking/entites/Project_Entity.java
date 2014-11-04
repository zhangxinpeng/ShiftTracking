package com.ibm.hrnotes.shifttracking.entites;

import java.util.LinkedList;

public class Project_Entity {
	
	private String projectId;//Key
	private String projectAdminId;
	private String projectName;
	private String ManagerId;
	private String AMId;

	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectAdminId() {
		return projectAdminId;
	}
	public void setProjectAdminId(String projectAdminId) {
		this.projectAdminId = projectAdminId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getManagerId() {
		return ManagerId;
	}
	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}
	public String getAMId() {
		return AMId;
	}
	public void setAMId(String aMId) {
		AMId = aMId;
	}

	
}

/*

////////////////////////////////////////////////////////////////////////////////////////////
private Project_Admin project_Admin = new Project_Admin();	
   //private String projectId;
  // private String projectAdminId;
private Project_Information project_Information = new Project_Information();
   //private String projectId;
   //private String projectName;
private Project_Manager project_Manager = new Project_Manager();
  // public String ManagerId;
   //public String projectId;
private AM_Project am_Project = new AM_Project();
   //public String AMId;
   //public String projectId;
private LinkedList<Project_Member> project_Member_List = new LinkedList<Project_Member>();

private Project_Member project_Member = new Project_Member();   
   //private String projectId;
   //private String memberId;
///////////////////////////////////////////////////////////////////////////////////////////

*/
