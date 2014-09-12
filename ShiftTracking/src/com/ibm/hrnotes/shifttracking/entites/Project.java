package com.ibm.hrnotes.shifttracking.entites;

import java.util.HashSet;
import java.util.Set;

public class Project {

	private Integer id;
	private String projectId;
	private String projectName;
	
	private Manager projectManager;
	
	private Set<ProjectAdmin> admins = new HashSet<ProjectAdmin> ();
	
	private Set<Employee> members = new HashSet<Employee>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Manager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(Manager projectManager) {
		this.projectManager = projectManager;
	}

	public Set<ProjectAdmin> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<ProjectAdmin> admins) {
		this.admins = admins;
	}

	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}
	
	
}
