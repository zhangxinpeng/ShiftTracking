package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.Project_Information;

public interface Project_InformationDao {

	/**
	 * Project Information Database Operation
	 */
	public boolean insertProject_Information(Project_Information project_Information);
	public boolean deleteProject_Information(Project_Information project_Information);
	public boolean updateProject_Information_ProjectName(Project_Information project_Information_Old,Project_Information project_Information_New);
	public Project_Information selectProject_InformationByProjectId(String projectId);

}
