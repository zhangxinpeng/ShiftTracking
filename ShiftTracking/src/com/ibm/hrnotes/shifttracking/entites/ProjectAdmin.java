package com.ibm.hrnotes.shifttracking.entites;

import java.util.HashSet;
import java.util.Set;

public class ProjectAdmin extends Employee {

	private Set<Project> adminProjects = new HashSet<Project> ();

	public Set<Project> getAdminProjects() {
		return adminProjects;
	}

	public void setAdminProjects(Set<Project> adminProjects) {
		this.adminProjects = adminProjects;
	}
	
}
