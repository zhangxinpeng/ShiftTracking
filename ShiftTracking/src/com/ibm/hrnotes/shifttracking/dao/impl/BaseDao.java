package com.ibm.hrnotes.shifttracking.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		//return this.sessionFactory.getCurrentSession();
		return this.sessionFactory.openSession();
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
}
