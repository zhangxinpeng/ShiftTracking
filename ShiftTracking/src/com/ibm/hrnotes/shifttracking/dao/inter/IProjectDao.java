package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.Project;

public interface IProjectDao {

	public boolean add(Project project);
	public boolean delete(Project project);
	public boolean update(Project project);
	public Project getByProjectID(String id);
	public Project getByProjectName(String name);
}
