package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface Project_AdminDao {
	/**
	 * Project Admin Database Operation
	 */
	public boolean insertProject_Admin(Project_Admin project_Admin);
	
	public boolean deleteProject_Admin(Project_Admin project_Admin);
	
	public boolean updateProject_Admin(Project_Admin project_Admin_Old ,Project_Admin project_Admin_New);
	
	public Project_Admin selectProject_Admin(String projectId);
}
