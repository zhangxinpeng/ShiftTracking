package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface IProjectAdminDao {
	public boolean add(ProjectAdmin projectAdmin);
	public boolean update(ProjectAdmin projectAdmin);
	public ProjectAdmin getByEmail(String email);
}
