package com.ibm.hrnotes.shifttracking.dao.inter;

import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface AM_ProjectDao {
	/**
	 * AM Project Database Operation
	 */
	
	public boolean insertAM_project(AM_Project am_Project);
	
	public boolean deleteAM_Project(AM_Project am_Project);
	
	public boolean update_AMId_Of_Project(AM_Project am_Project_Old, AM_Project am_Project_New) ;
	
	public AM_Project selectAM_Project(String projectId);
	
	public LinkedList<AM_Project> selectAMProject(String intranetId);
}
