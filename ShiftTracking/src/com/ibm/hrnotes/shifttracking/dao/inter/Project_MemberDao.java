package com.ibm.hrnotes.shifttracking.dao.inter;

import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface Project_MemberDao {
	/**
	 * Project Member Database Operation
	 */
	public boolean insertMemeberToProject(Project_Member projectMemeber);
	
	public boolean deleteMemeberFromProject(Project_Member projectMemeber);
	
	public boolean updateMemberIdOfProject(Project_Member oldProjectMemeber,Project_Member newProjectMemeber);
	
	public LinkedList<Project_Member> selectMember_ProjectByProjectId(String projectId);
	
	public LinkedList<Project_Member> selectMember_ProjectByIntrnetId(String intranetId);

}
