package com.ibm.hrnotes.shifttracking.entites;

import java.util.LinkedList;

public class Employee_Entity {
	private String intranetId;//Key
	private String notesId;
	private String name;
	private String PeMIntranetId;

	
	public String getIntranetId() {
		return intranetId;
	}
	public void setIntranetId(String intranetId) {
		this.intranetId = intranetId;
	}
	public String getNotesId() {
		return notesId;
	}
	public void setNotesId(String notesId) {
		this.notesId = notesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeMIntranetId() {
		return PeMIntranetId;
	}
	public void setPeMIntranetId(String peMIntranetId) {
		PeMIntranetId = peMIntranetId;
	}


	
	
	
	//Employee_Information employee_Information = new Employee_Information();
	   //private String intranetId;
	   //private String notesId;
	   //private String name;
	//Employee_PeM employee_PeM = new Employee_PeM();
	  //private String intranetId;
	  //private String PeMIntranetId;
	//Project_Member project_Member = new Project_Member();
	  // private String projectId;
      // private String memberId;
}
