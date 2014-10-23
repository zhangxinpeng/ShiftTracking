package com.ibm.hrnotes.shifttracking.service;

import com.ibm.hrnotes.shifttracking.dao.impl.EmployeeDao;
import com.ibm.hrnotes.shifttracking.entites.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public boolean validate(Employee employee) {
		
		Employee e = employeeDao.getByEmail(employee.getEmail());
		
		if (e == null) {
			if (employee.getEmail().equals(employee.getPassword())) {
				employeeDao.add(employee);
				return true;
			} else {
				return false;
			}
		} else {
			if (e.getPassword().equals(employee.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
