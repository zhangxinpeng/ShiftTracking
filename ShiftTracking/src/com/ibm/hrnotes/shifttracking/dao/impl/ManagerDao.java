package com.ibm.hrnotes.shifttracking.dao.impl;

import org.hibernate.Query;

import com.ibm.hrnotes.shifttracking.dao.inter.IManagerDao;
import com.ibm.hrnotes.shifttracking.entites.Employee;
import com.ibm.hrnotes.shifttracking.entites.Manager;

public class ManagerDao extends BaseDao implements IManagerDao {

	@Override
	public boolean add(Manager manager) {
		getSession().save(manager);
		return true;
	}

	@Override
	public boolean update(Manager manager) {
		getSession().update(manager);
		return true;
	}

	@Override
	public Manager getByEmail(String email) {
		String hql = "FROM Manager e WHERE e.email = ?";
		Query query = getSession().createQuery(hql).setString(0, email);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}

	@Override
	public Manager get(Integer id) {
		return (Manager) getSession().get(Manager.class, id);
	}

}
