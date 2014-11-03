package com.ibm.hrnotes.shifttracking.entites;

import java.util.Date;

public class ProjectMemberDateShiftRecord {
    private String projectId;
    private String memberId;
    private String year;
    private String month;
    private String day;
    private String shiftRecord;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getShiftRecord() {
		return shiftRecord;
	}
	public void setShiftRecord(String shiftRecord) {
		this.shiftRecord = shiftRecord;
	}
}
