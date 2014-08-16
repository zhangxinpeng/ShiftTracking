package com.ibm.bluemix.shifttracking.dao.inter;

import com.ibm.bluemix.shifttracking.beans.*;

public interface IEmployeeBeamDAO {
	public boolean add(EmployeeBean bean);
	public boolean remove(EmployeeBean bean);
	public boolean update(EmployeeBean bean);
	public boolean delete(EmployeeBean bean);
	public EmployeeBean find(String name);
}
