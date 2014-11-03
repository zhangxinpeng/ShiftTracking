package com.ibm.hrnotes.shifttracking.service;


import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.AM_Project;
import com.ibm.hrnotes.shifttracking.entites.Project_Admin;
import com.ibm.hrnotes.shifttracking.entites.Project_Information;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.entites.Project_Member;

public class Project_InformationService {
    
	
	/**
	 * Project Information Operation
	 */
	public boolean addProject_Information(Project_Information project_Information){
		return true;
	}
	
	public boolean removeProject_Information(Project_Information project_Information){
		return true;
	}
	public boolean modifiedProject_Information(Project_Information project_Information){
		return true;
	}
	public Project_Information getProject_InformationByProjectId(String projectId){
		return null;
	}
	
	/**
	 * Project Admin Operation
	 */
	public boolean addProject_Admin(Project_Admin project_Admin){
		return true;
	}
	
	public boolean removeProject_Admin(String projectId){
		return true;
	}
	
	public boolean modifyProject_Admin(Project_Admin project_Admin){
		return true;
	}
	
	public Project_Admin getProject_Admin(String projectId){
		return null;
	}
	
	/**
	 * Project Manager Operation
	 */

	public boolean addProject_Manager(Project_Manager projectManager){
		return true;
	}
	
	public boolean removeProject_ManagerById(Project_Manager projectManage){
		return true;
	}
	
	public boolean modifyProject_Manager(Project_Manager projectManager){
		return true;
	}
	
	public Project_Manager getProject_Manager(String projectId){
		return null;
	}
	
	
	
	
	/**
	 * Project Member Operation
	 */
	public boolean addMemeberToProject(Project_Member projectMemeber){
		return true;
	}
	
	public boolean removeMemeberFromProject(Project_Member projectMemeber){
		return true;
	}
	
	public boolean modifyMemberOfProject(Project_Member projectMemeber){
		return true;
	}
	
	public LinkedList<Project_Member> getMember_ProjectByProjectId(String projectId){
		return null;
	}
	
	public LinkedList<Project_Member> getMember_ProjectByIntrnetId(String intranetId){
		return null;
	}
	
	/**
	 * AM Project Operation
	 */
	
	public boolean addAM_project(AM_Project am_Project){
		return true;
	}
	
	public boolean removeAM_Project(AM_Project am_Project){
		return true;
	}
	
	public boolean modifyAM_Project(AM_Project am_Project){
		return true;
	}
	
	public AM_Project getAM_Project(String projectId){
		return null;
	}
	
	public LinkedList<AM_Project> gerAMProject(String intranetId){
		return null;
	}
	
}
