package com.ibm.hrnotes.shifttracking.service;

import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.AM_Project;
import com.ibm.hrnotes.shifttracking.entites.Employee_Entity;
import com.ibm.hrnotes.shifttracking.entites.Employee_Information;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;
import com.ibm.hrnotes.shifttracking.entites.ProjectMemberDateShiftRecord;
import com.ibm.hrnotes.shifttracking.entites.Project_Admin;
import com.ibm.hrnotes.shifttracking.entites.Project_Entity;
import com.ibm.hrnotes.shifttracking.entites.Project_Information;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.entites.Project_Member;

public class ProjectAndEmployeeShiftTrackingService {
	Employee_InformationService employee_InformationService; // = new Employee_InformationService();
	Project_InformationService project_InformationService; // = new Project_InformationService();
	
	public Employee_InformationService getEmployee_InformationService() {
		return employee_InformationService;
	}

	public void setEmployee_InformationService(
			Employee_InformationService employee_InformationService) {
		this.employee_InformationService = employee_InformationService;
	}

	public Project_InformationService getProject_InformationService() {
		return project_InformationService;
	}

	public void setProject_InformationService(
			Project_InformationService project_InformationService) {
		this.project_InformationService = project_InformationService;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////Create Operation///////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean createProject(Project_Entity project_Entity){
		/**
		 * Set Project_Entity information
		 */
		//Project_Entity project_Entity = new Project_Entity();
		//project_Entity.setProjectId("");
		//project_Entity.setProjectName("");
		//project_Entity.setManagerId("");
		//project_Entity.setProjectAdminId("");
		//project_Entity.setAMId("");
		//////////////////////////////////////////////////////////////////
		//LinkedList<String> memberId_List = new LinkedList<String>();
		//memberId_List.add("");
		//memberId_List.add("");
		//project_Entity.setMemberId_List(memberId_List);
		/////////////////////////////////////////////////////////////////
		
		/**
		 * Change format to all kinds of Entity
		 */
		Project_Admin project_Admin = new Project_Admin();
		project_Admin.setProjectId(project_Entity.getProjectId());
		project_Admin.setProjectAdminId(project_Entity.getProjectAdminId());
		
		Project_Information project_Information = new Project_Information();
		project_Information.setProjectId(project_Entity.getProjectId());
		project_Information.setProjectName(project_Entity.getProjectName());
		
		Project_Manager project_Manager = new Project_Manager();
		project_Manager.setProjectId(project_Entity.getProjectId());
		project_Manager.setManagerId(project_Entity.getManagerId());
		
		AM_Project am_Project = new AM_Project();
		am_Project.setProjectId(project_Entity.getProjectId());
		am_Project.setAMId(project_Entity.getAMId());
		
		/**
		 * Execute specified project service. 
		 */
		project_InformationService.addProject_Admin(project_Admin);
		project_InformationService.addProject_Information(project_Information);
		project_InformationService.addProject_Manager(project_Manager);
		project_InformationService.addAM_project(am_Project);

		
		return true;
	}
	
	public boolean createEmployee(Employee_Entity employee_Entity){
		/**
		 * Set Employee_Entity information
		 */
		//Employee_Entity employee_Entity = new Employee_Entity();
		//employee_Entity.setIntranetId("");
		//employee_Entity.setNotesId("");
		//employee_Entity.setName("");
		//employee_Entity.setPeMIntranetId("");
		///////////////////////////////////////////////////////////////
		//LinkedList<String> projectIdList = new LinkedList<String>();
		//projectIdList.add("");
		//projectIdList.add("");
		//employee_Entity.setProjectIdList(projectIdList);
		//////////////////////////////////////////////////////////////
		/**
		 * Change format to all kinds of Entity
		 */
		Employee_Information employee_Information = new Employee_Information();
		employee_Information.setIntranetId(employee_Entity.getIntranetId());
		employee_Information.setNotesId(employee_Entity.getNotesId());
		employee_Information.setName(employee_Entity.getName());
		
		
		Employee_PeM employee_PeM = new Employee_PeM();
		employee_PeM.setIntranetId(employee_Entity.getIntranetId());
		employee_PeM.setPeMIntranetId(employee_Entity.getPeMIntranetId());
		/**
		 * Execute specified employee service
		 */
		try{
			employee_InformationService.addEmployee_Information(employee_Information);
			employee_InformationService.addEmployee_PeM(employee_PeM);
		}
		catch(Exception e)
		{
			return false;
		}
			
		return true;
	}
	
	public boolean createShiftTracking(LinkedList<ProjectMemberDateShiftRecord> projectMemberDateShiftRecord_List){
		/**
		 * Set Shift_Record information and add to list
		 */
		/*
		LinkedList<ProjectMemberDateShiftRecord> projectMemberDateShiftRecord_List = new LinkedList<ProjectMemberDateShiftRecord>();
		ProjectMemberDateShiftRecord ProjectMemberDateShiftRecord = new ProjectMemberDateShiftRecord();
		ProjectMemberDateShiftRecord.setProjectId("");
		ProjectMemberDateShiftRecord.setMemberId("");
		ProjectMemberDateShiftRecord.setYear("");
		ProjectMemberDateShiftRecord.setMonth("");
		ProjectMemberDateShiftRecord.setDay("");
		ProjectMemberDateShiftRecord.setProjectId("");
		projectMemberDateShiftRecord_List.add(ProjectMemberDateShiftRecord);
		
		ProjectMemberDateShiftRecord ProjectMemberDateShiftRecord1 = new ProjectMemberDateShiftRecord();
		ProjectMemberDateShiftRecord1.setProjectId("");
		ProjectMemberDateShiftRecord1.setMemberId("");
		ProjectMemberDateShiftRecord1.setYear("");
		ProjectMemberDateShiftRecord1.setMonth("");
		ProjectMemberDateShiftRecord1.setDay("");
		ProjectMemberDateShiftRecord1.setProjectId("");
		projectMemberDateShiftRecord_List.add(ProjectMemberDateShiftRecord1);
		*/
		/**
		 * Execute specified project service
		 */
		try{
			project_InformationService.addProjectMemberDateShiftRecord(projectMemberDateShiftRecord_List);
		}catch(Exception e){
			return false;
		}				
		return true;
	}
	
	public boolean createNewMemberForProject(Project_Member project_Member){
		/*
		Project_Member project_Member = new Project_Member();
		project_Member.setMemberId("");
		project_Member.setProjectId("");
		*/
		try{
			project_InformationService.addMemeberToProject(project_Member);
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean createNewProjectForEmployee(Project_Member project_Member){
		/*
		Project_Member project_Member = new Project_Member();
		project_Member.setMemberId("");
		project_Member.setProjectId("");
		*/
		try{
			project_InformationService.addMemeberToProject(project_Member);
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
    
	
}
