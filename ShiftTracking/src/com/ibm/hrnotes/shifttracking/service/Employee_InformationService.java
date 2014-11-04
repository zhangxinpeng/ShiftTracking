package com.ibm.hrnotes.shifttracking.service;


import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.dao.impl.Employee_InformationDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.Employee_PeMDaoImpl;
import com.ibm.hrnotes.shifttracking.entites.Employee_Information;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;

public class Employee_InformationService {
	private Employee_InformationDaoImpl employee_InformationDaoImpl; // = new Employee_InformationDaoImpl();
	private Employee_PeMDaoImpl employee_PeMDaoImpl; // = new Employee_PeMDaoImpl();
	

	public Employee_InformationDaoImpl getEmployee_InformationDaoImpl() {
		return employee_InformationDaoImpl;
	}

	public void setEmployee_InformationDaoImpl(
			Employee_InformationDaoImpl employee_InformationDaoImpl) {
		this.employee_InformationDaoImpl = employee_InformationDaoImpl;
	}

	public Employee_PeMDaoImpl getEmployee_PeMDaoImpl() {
		return employee_PeMDaoImpl;
	}

	public void setEmployee_PeMDaoImpl(Employee_PeMDaoImpl employee_PeMDaoImpl) {
		this.employee_PeMDaoImpl = employee_PeMDaoImpl;
	}

	/**
	 * Employee Information Operation
	 */
     public boolean addEmployee_Information(Employee_Information employee){
    	 return employee_InformationDaoImpl.insertEmployee_Information(employee);
     }
     
     public boolean removeEmployee_Information(Employee_Information emplyee){
    	 return employee_InformationDaoImpl.deleteEmployee_Information(emplyee);
     }
     
     public boolean modifyEmployee_Information_IntranetId(Employee_Information emplyee_Old,Employee_Information emplyee_New){
    	 return employee_InformationDaoImpl.updateEmployee_Information_IntranetId(emplyee_Old, emplyee_New);
     }
     
     public boolean modifyEmployee_Information_NotesId(Employee_Information emplyee_Old,Employee_Information emplyee_New){
    	 return employee_InformationDaoImpl.updateEmployee_Information_NotesId(emplyee_Old, emplyee_New);
     }
     
     public boolean modifyEmployee_Information_Name(Employee_Information emplyee_Old,Employee_Information emplyee_New){
    	 return employee_InformationDaoImpl.updateEmployee_Information_Name(emplyee_Old, emplyee_New);
     }
       
     public Employee_Information getEmployee_InformationByIntranetId(String intranetId){
    	 return employee_InformationDaoImpl.selectEmployee_InformationByIntranetId(intranetId);
     }
     
     /**
      * Employee PeM Operation
      */
     public boolean addEmployee_PeM(Employee_PeM employeePeM){
    	 return employee_PeMDaoImpl.insertEmployee_PeM(employeePeM);
     }
     
     public boolean removeEmployee_PeM(Employee_PeM emplyeePeM){
    	 return employee_PeMDaoImpl.deleteEmployee_PeM(emplyeePeM);
     }
     
     public boolean modifyEmployee_Information(Employee_PeM emplyeePeM_Old,Employee_PeM emplyeePeM_New){
    	 return employee_PeMDaoImpl.updateEmployee_PeM(emplyeePeM_Old, emplyeePeM_New);
     }
     
     public Employee_PeM getEmployee_PeMByEmployeeIntranetId(String employeeIntranetId){
    	 return employee_PeMDaoImpl.selectEmployee_PeMByEmployeeIntranetId(employeeIntranetId);
     }
     
     public LinkedList<Employee_PeM> getEmployee_PeMByPeMIntranetId(String PeMIntranetId){
    	 return employee_PeMDaoImpl.selectEmployee_PeMByPeMIntranetId(PeMIntranetId);
     }
     
}
