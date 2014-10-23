package com.ibm.hrnotes.shifttracking.service;

import com.ibm.hrnotes.shifttracking.dao.impl.ProjectDao;

public class ProjectService {
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	

}
