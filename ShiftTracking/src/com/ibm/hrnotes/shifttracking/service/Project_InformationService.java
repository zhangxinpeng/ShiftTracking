package com.ibm.hrnotes.shifttracking.service;


import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.dao.impl.AM_ProjectDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.ProjectMemberDateShiftRecordDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.Project_AdminDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.Project_InformationDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.Project_ManagerDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.Project_MemberDaoImpl;
import com.ibm.hrnotes.shifttracking.entites.AM_Project;
import com.ibm.hrnotes.shifttracking.entites.ProjectMemberDateShiftRecord;
import com.ibm.hrnotes.shifttracking.entites.Project_Admin;
import com.ibm.hrnotes.shifttracking.entites.Project_Information;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.entites.Project_Member;

public class Project_InformationService {
    
	private Project_InformationDaoImpl project_InformationDaoImpl;// = new Project_InformationDaoImpl();
	private Project_ManagerDaoImpl project_ManagerDaoImpl;// = new Project_ManagerDaoImpl();
	private Project_AdminDaoImpl project_AdminDaoImpl;// = new Project_AdminDaoImpl();
	private Project_MemberDaoImpl project_MemberDaoImpl;// = new Project_MemberDaoImpl();
	private AM_ProjectDaoImpl am_ProjectDaoImpl;// = new AM_ProjectDaoImpl();
	private ProjectMemberDateShiftRecordDaoImpl projectMemberDateShiftRecordDaoImpl; // = new ProjectMemberDateShiftRecordDaoImpl();

	
	public Project_InformationDaoImpl getProject_InformationDaoImpl() {
		return project_InformationDaoImpl;
	}

	public void setProject_InformationDaoImpl(
			Project_InformationDaoImpl project_InformationDaoImpl) {
		this.project_InformationDaoImpl = project_InformationDaoImpl;
	}

	public Project_ManagerDaoImpl getProject_ManagerDaoImpl() {
		return project_ManagerDaoImpl;
	}

	public void setProject_ManagerDaoImpl(
			Project_ManagerDaoImpl project_ManagerDaoImpl) {
		this.project_ManagerDaoImpl = project_ManagerDaoImpl;
	}

	public Project_AdminDaoImpl getProject_AdminDaoImpl() {
		return project_AdminDaoImpl;
	}

	public void setProject_AdminDaoImpl(Project_AdminDaoImpl project_AdminDaoImpl) {
		this.project_AdminDaoImpl = project_AdminDaoImpl;
	}

	public Project_MemberDaoImpl getProject_MemberDaoImpl() {
		return project_MemberDaoImpl;
	}

	public void setProject_MemberDaoImpl(Project_MemberDaoImpl project_MemberDaoImpl) {
		this.project_MemberDaoImpl = project_MemberDaoImpl;
	}

	public AM_ProjectDaoImpl getAM_ProjectDaoImpl() {
		return am_ProjectDaoImpl;
	}

	public void setAM_ProjectDaoImpl(AM_ProjectDaoImpl am_ProjectDaoImpl) {
		this.am_ProjectDaoImpl = am_ProjectDaoImpl;
	}

	public ProjectMemberDateShiftRecordDaoImpl getProjectMemberDateShiftRecordDaoImpl() {
		return projectMemberDateShiftRecordDaoImpl;
	}

	public void setProjectMemberDateShiftRecordDaoImpl(
			ProjectMemberDateShiftRecordDaoImpl projectMemberDateShiftRecordDaoImpl) {
		this.projectMemberDateShiftRecordDaoImpl = projectMemberDateShiftRecordDaoImpl;
	}

	/**
	 * Project Information Operation
	 */
	public boolean addProject_Information(Project_Information project_Information){
		return project_InformationDaoImpl.insertProject_Information(project_Information);
	}
	
	public boolean removeProject_Information(Project_Information project_Information){
		return project_InformationDaoImpl.deleteProject_Information(project_Information);
	}
	public boolean modifiedProject_Information(Project_Information project_Information_Old,Project_Information project_Information_New){
		return project_InformationDaoImpl.updateProject_Information_ProjectName(project_Information_Old, project_Information_New);
	}
	public Project_Information getProject_InformationByProjectId(String projectId){
		return project_InformationDaoImpl.selectProject_InformationByProjectId(projectId);
	}
	
	/**
	 * Project Admin Operation
	 */
	public boolean addProject_Admin(Project_Admin project_Admin){
		return project_AdminDaoImpl.insertProject_Admin(project_Admin);
	}
	
	public boolean removeProject_Admin(Project_Admin project_Admin){
		return project_AdminDaoImpl.deleteProject_Admin(project_Admin);
	}
	
	public boolean modifyProject_Admin(Project_Admin project_Admin_Old,Project_Admin project_Admin_New){
		return project_AdminDaoImpl.updateProject_Admin(project_Admin_Old, project_Admin_New);
	}
	
	public Project_Admin getProject_Admin(String projectId){
		return project_AdminDaoImpl.selectProject_Admin(projectId);
	}
	
	/**
	 * Project Manager Operation
	 */

	public boolean addProject_Manager(Project_Manager projectManager){
		return project_ManagerDaoImpl.insertProject_Manager(projectManager);
	}
	
	public boolean removeProject_ManagerById(Project_Manager projectManage){
		return project_ManagerDaoImpl.deleteProject_Manager(projectManage);
	}
	
	public boolean modifyProject_Manager(Project_Manager projectManager){
		return project_ManagerDaoImpl.updateProject_Manager(projectManager);
	}
	
	public Project_Manager getProject_Manager(String projectId){
		return project_ManagerDaoImpl.selectProject_Manager(projectId);
	}
	
	
	/**
	 * Project Member Operation
	 */
	public boolean addMemeberToProject(Project_Member projectMemeber){
		return project_MemberDaoImpl.insertMemeberToProject(projectMemeber);
	}
	
	public boolean removeMemeberFromProject(Project_Member projectMemeber){
		return project_MemberDaoImpl.deleteMemeberFromProject(projectMemeber);
	}
	
	public boolean modifyMemberOfProject(Project_Member oldProjectMemeber,Project_Member newProjectMemeber){
		return project_MemberDaoImpl.updateMemberIdOfProject(oldProjectMemeber, newProjectMemeber);
	}
	
	public LinkedList<Project_Member> getMember_ProjectByProjectId(String projectId){
		return project_MemberDaoImpl.selectMember_ProjectByProjectId(projectId);
	}
	
	public LinkedList<Project_Member> getMember_ProjectByIntrnetId(String intranetId){
		return project_MemberDaoImpl.selectMember_ProjectByIntrnetId(intranetId);
	}
	
	/**
	 * AM Project Operation
	 */
	
	public boolean addAM_project(AM_Project am_Project){
		return am_ProjectDaoImpl.insertAM_project(am_Project);
	}
	
	public boolean removeAM_Project(AM_Project am_Project){
		return am_ProjectDaoImpl.deleteAM_Project(am_Project);
	}
	
	public boolean modifyAM_Project(AM_Project am_Project_Old,AM_Project am_Project_New){
		return am_ProjectDaoImpl.update_AMId_Of_Project(am_Project_Old, am_Project_New);
	}
	
	public AM_Project getAM_Project(String projectId){
		return am_ProjectDaoImpl.selectAM_Project(projectId);
	}
	
	public LinkedList<AM_Project> gerAMProject(String AMIntranetId){
		return am_ProjectDaoImpl.selectAMProject(AMIntranetId);
	}
	
	/**
	 * Project Member Shift Record Operation
	 */
	
	public boolean addProjectMemberDateShiftRecord(
			LinkedList<ProjectMemberDateShiftRecord> shiftRecordList){
		return projectMemberDateShiftRecordDaoImpl.insertProjectMemberDateShiftRecord(shiftRecordList);
	}
	
	public boolean removeProjectMemberDateShiftRecord(
			ProjectMemberDateShiftRecord shiftRecordList){
		return projectMemberDateShiftRecordDaoImpl.deleteProjectMemberDateShiftRecord(shiftRecordList);
	}
	
	public boolean modifyProjectMemberDateShiftRecord(
			ProjectMemberDateShiftRecord shiftRecord_Old,ProjectMemberDateShiftRecord shiftRecord_New){
		return projectMemberDateShiftRecordDaoImpl.updateProjectMemberDateShiftRecord(shiftRecord_Old, shiftRecord_New);
	}
	
	public ProjectMemberDateShiftRecord getShiftRecord(
			ProjectMemberDateShiftRecord shiftRecord){
		return projectMemberDateShiftRecordDaoImpl.selectShiftRecord(shiftRecord);
	}
	
}
