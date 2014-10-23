package com.ibm.hrnotes.shifttracking.dao.impl;

import org.hibernate.Query;

import com.ibm.hrnotes.shifttracking.dao.inter.IEmployeeDao;
import com.ibm.hrnotes.shifttracking.entites.Employee;

public class EmployeeDao extends BaseDao implements IEmployeeDao {

	@Override
	public boolean add(Employee employee) {
		getSession().save(employee);
		return true;
	}

	@Override
	public boolean update(Employee employee) {
		getSession().update(employee);
		return true;
	}

	@Override
	public Employee getByEmail(String email) {
		String hql = "FROM Employee e WHERE e.email = ?";
		Query query = getSession().createQuery(hql).setString(0, email);
		Employee employee = (Employee) query.uniqueResult();
		return employee;
	}

	@Override
	public boolean resetPassword(Employee employee) {
		employee.setPassword(employee.getEmail());
		getSession().update(employee);
		return true;
	}

	@Override
	public Employee get(Integer id) {
		return (Employee) getSession().get(Employee.class, id);
	}

}
