package com.ibm.hrnotes.shifttracking.service;

import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.Employee_Information;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;
import com.ibm.hrnotes.shifttracking.entites.ProjectMemberDateShiftRecord;
import com.ibm.hrnotes.shifttracking.entites.Project_Information;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.entites.Project_Member;
import com.ibm.hrnotes.shifttracking.entites.ViewOrientedEntity;

public class ProjectAndEmployeeShiftTrackingGetService {
	Employee_InformationService employee_InformationService; //= new Employee_InformationService();
	Project_InformationService project_InformationService;// = new Project_InformationService();
	
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

	public LinkedList<ViewOrientedEntity> getProjectAndEmployeeShiftTracking_For_ProjectManager(String project_Manager_IntranetId){

		/**
		 * Get project manager name according to project intranet id
		 */
		Employee_Information projectManager_Employee_Information = new Employee_Information();
		projectManager_Employee_Information = employee_InformationService.getEmployee_InformationByIntranetId(project_Manager_IntranetId);
		String project_Manager_Name = projectManager_Employee_Information.getName();
			
		/**
		 * Get Project Id according to project manager intranet Id
		 */
		Project_Manager project_Manager = new Project_Manager();
		//project_Manager = project_InformationService.getProject_Manager(project_Manager_IntranetId);	
		project_Manager = project_InformationService.getProject_Manager_ByManagerId(project_Manager_IntranetId);
		String projectId = project_Manager.getProjectId();
		
		/**
		 * Get Project Name according to project Id
		 */
		String project_Name;
		Project_Information project_Information = new Project_Information();
		project_Information = project_InformationService.getProject_InformationByProjectId(projectId);
		project_Name = project_Information.getProjectName();
		
		
		/**
		 * Get Project Member according to Project Id
		 */
		LinkedList<Project_Member> project_Member_List = new LinkedList<Project_Member>();
		//////////////////////////////////////////////////////////////////////////////////
		project_Member_List = project_InformationService.getMember_ProjectByProjectId(projectId);
		/**
		 * Get every project member information according to their member Id
		 */
        LinkedList<ViewOrientedEntity> viewOrientedEntity_List = new LinkedList<ViewOrientedEntity>();
		for(int i = 0; i < project_Member_List.size(); i++ ){
			String memberId;
			String memberName;
			String memberNotesId;
			String PeMIntranetId;
			String PeMNotesId;
			ViewOrientedEntity viewOrientedEntity = new ViewOrientedEntity();
			memberId = project_Member_List.get(i).getMemberId();
			//get member "name" and "notesId" according to their intranetid
			Employee_Information employee_Information = employee_InformationService.getEmployee_InformationByIntranetId(memberId);
			memberName = employee_Information.getName();
			memberNotesId = employee_Information.getNotesId();
			//get member PeM intranetId according to their member id
			Employee_PeM employee_PeM = employee_InformationService.getEmployee_PeMByEmployeeIntranetId(memberId);
			PeMIntranetId = employee_PeM.getPeMIntranetId();
			//get PeM information according to PeM intranet Id
			Employee_Information PeM_Employee_Information = new Employee_Information();
			PeM_Employee_Information = employee_InformationService.getEmployee_InformationByIntranetId(PeMIntranetId);
			PeMNotesId = PeM_Employee_Information.getNotesId();
			//get shift record according to Project Id and Member Id;
			LinkedList<ProjectMemberDateShiftRecord> memberShiftRecordList = new LinkedList<ProjectMemberDateShiftRecord>();
			memberShiftRecordList = project_InformationService.getShiftRecordByProjectIdAndMemberId(projectId, memberId);
			viewOrientedEntity.setProject_Name(project_Name);
			viewOrientedEntity.setProject_Manager_Name(project_Manager_Name);
			viewOrientedEntity.setMemberName(memberName);
			viewOrientedEntity.setPeMNotesId(PeMNotesId);
			viewOrientedEntity.setMemberShiftRecordList(memberShiftRecordList);
			viewOrientedEntity_List.add(viewOrientedEntity);
		}
		
		return viewOrientedEntity_List;
	}

}
