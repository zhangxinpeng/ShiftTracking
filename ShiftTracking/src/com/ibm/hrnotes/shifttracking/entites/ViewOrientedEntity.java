package com.ibm.hrnotes.shifttracking.entites;

import java.util.LinkedList;

public class ViewOrientedEntity {
	String project_Name;
	String project_Manager_Name;
	String memberName;
	String PeMNotesId;
	LinkedList<ProjectMemberDateShiftRecord> memberShiftRecordList;
	public String getProject_Name() {
		return project_Name;
	}
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	public String getProject_Manager_Name() {
		return project_Manager_Name;
	}
	public void setProject_Manager_Name(String project_Manager_Name) {
		this.project_Manager_Name = project_Manager_Name;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPeMNotesId() {
		return PeMNotesId;
	}
	public void setPeMNotesId(String peMNotesId) {
		PeMNotesId = peMNotesId;
	}
	public LinkedList<ProjectMemberDateShiftRecord> getMemberShiftRecordList() {
		return memberShiftRecordList;
	}
	public void setMemberShiftRecordList(
			LinkedList<ProjectMemberDateShiftRecord> memberShiftRecordList) {
		this.memberShiftRecordList = memberShiftRecordList;
	}
}
