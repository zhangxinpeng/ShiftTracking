package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.Employee_Information;

public interface Employee_InformationDao {
	
	/**
	 * Employee Information Database Operation 
	 */
	public boolean insertEmployee_Information(Employee_Information employee);
	public boolean deleteEmployee_Information(Employee_Information emplyee);
	public boolean updateEmployee_Information_IntranetId(Employee_Information emplyee_Old,Employee_Information emplyee_New);
	public Employee_Information selectEmployee_InformationByIntranetId(String intranetId);
	 
}
