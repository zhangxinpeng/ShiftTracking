package com.ibm.hrnotes.shifttracking.entites;

import java.util.HashSet;
import java.util.Set;

public class Employee {

	private Integer id;
	private String email;
	private String password;
	
	private Set<Project> projects = new HashSet<Project>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
}
