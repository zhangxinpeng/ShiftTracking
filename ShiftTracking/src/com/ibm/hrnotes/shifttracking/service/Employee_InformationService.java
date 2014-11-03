package com.ibm.hrnotes.shifttracking.service;


import java.util.LinkedList;

import com.ibm.hrnotes.shifttracking.entites.Employee_Information;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;

public class Employee_InformationService {
	
	/**
	 * Employee Information Operation
	 */
     public boolean addEmployee_Information(Employee_Information employee){
    	 return true;
     }
     
     public boolean removeEmployee_Information(Employee_Information emplyee){
    	 return true;
     }
     
     public boolean modifyEmployee_Information(Employee_Information emplyee){
    	 return true;
     }
     
     public Employee_Information getEmployee_InformationByIntranetId(String intranetId){
    	 return null;
     }
     
     /**
      * Employee PeM Operation
      */
     public boolean addEmployee_PeM(Employee_PeM employeePeM){
    	 return true;
     }
     
     public boolean removeEmployee_PeM(Employee_PeM emplyeePeM){
    	 return true;
     }
     
     public boolean modifyEmployee_Information(Employee_PeM emplyeePeM){
    	 return true;
     }
     
     public Employee_PeM getEmployee_PeMByEmployeeIntranetId(String intranetId){
    	 return null;
     }
     
     public LinkedList<Employee_PeM> getEmployee_PeMByPeMIntranetId(String intranetId){
    	 return null;
     }
     
}
