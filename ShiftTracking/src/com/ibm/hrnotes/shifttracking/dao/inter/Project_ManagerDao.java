package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface Project_ManagerDao {
	/**
	 * Project Manager Database Operation
	 */

	public boolean insertProject_Manager(Project_Manager projectManager);
	
	public boolean deleteProject_Manager(Project_Manager projectManage);
	
	public boolean updateProject_Manager(Project_Manager projectManager);
	
	public Project_Manager selectProject_Manager(String projectId);
}
