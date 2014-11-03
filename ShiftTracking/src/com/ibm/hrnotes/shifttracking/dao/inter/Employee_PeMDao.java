package com.ibm.hrnotes.shifttracking.dao.inter;

import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface Employee_PeMDao {
	/**
	 * Employee PeM Database Operation 
	 */
    public boolean insertEmployee_PeM(Employee_PeM employeePeM);
    public boolean deleteEmployee_PeM(Employee_PeM emplyeePeM);
    public boolean updateEmployee_PeM(Employee_PeM emplyeePeM_Old,Employee_PeM emplyeePeM_New);
    public Employee_PeM selectEmployee_PeMByEmployeeIntranetId(String intranetId);
    public LinkedList<Employee_PeM> selectEmployee_PeMByPeMIntranetId(String intranetId);
}
