package com.ibm.hrnotes.shifttracking.entites;

import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee {

	private Set<Project> managedProjects = new HashSet<Project>();

	public Set<Project> getManagedProjects() {
		return managedProjects;
	}

	public void setManagedProjects(Set<Project> managedProjects) {
		this.managedProjects = managedProjects;
	}
	
}
