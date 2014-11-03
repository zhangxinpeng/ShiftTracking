package com.ibm.hrnotes.shifttracking.dao.inter;

import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface ProjectMemberDateShiftRecordDao {
	/**
	 * Project Manager Database Operation
	 */

	public boolean insertProjectMemberDateShiftRecord(LinkedList<ProjectMemberDateShiftRecord> shiftRecordList);
	
	public boolean deleteProjectMemberDateShiftRecord(
			ProjectMemberDateShiftRecord shiftRecordList);
	
	public boolean updateProjectMemberDateShiftRecord(
			ProjectMemberDateShiftRecord shiftRecord_Old,ProjectMemberDateShiftRecord shiftRecord_New);
	
	public ProjectMemberDateShiftRecord selectShiftRecord(ProjectMemberDateShiftRecord shiftRecord);
	
	
}
