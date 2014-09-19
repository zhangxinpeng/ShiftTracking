package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.Employee;

public interface IEmployeeDao {
	
	public boolean add(Employee employee);
	public boolean update(Employee employee);
	public Employee getByEmail(String email);
	public Employee get(Integer id);
	public boolean resetPassword(Employee employee);

}
