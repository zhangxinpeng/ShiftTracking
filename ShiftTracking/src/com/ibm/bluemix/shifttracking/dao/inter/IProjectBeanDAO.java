package com.ibm.bluemix.shifttracking.dao.inter;

import com.ibm.bluemix.shifttracking.beans.*;

public interface IProjectBeanDAO {
	public boolean add(ProjectBean bean);
	public boolean remove(ProjectBean bean);
	public boolean update(ProjectBean bean);
	public boolean delete(ProjectBean bean);
	public ProjectBean find(String projectID);
}
