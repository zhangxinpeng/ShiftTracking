package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.ibm.hrnotes.shifttracking.dao.inter.Project_ManagerDao;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;

public class Project_ManagerDaoImpl extends BaseDao implements Project_ManagerDao {

	/**
	 * Project Manager Database Operation
	 */
	@Override
	public boolean insertProject_Manager(Project_Manager projectManager) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(projectManager);
			trans.commit();
			session.close();
			//getSessionFactory().close();
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
				

	}

	@Override
	public boolean deleteProject_Manager(Project_Manager projectManage) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			//session.delete(projectManage);
			String hql = "delete from Project_Manager pm where pm.ManagerId = ? and pm.projectId = ?";
			Query queryDelete = session.createQuery(hql);
			queryDelete.setString(0, projectManage.getManagerId());
			queryDelete.setString(1, projectManage.getProjectId());	
			queryDelete.executeUpdate();
			trans.commit();
			session.close();
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateProject_Manager(Project_Manager projectManager) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Project_Manager pm SET pm.ManagerId = ? where pm.projectId = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, projectManager.ManagerId);
			queryUpdate.setString(1, projectManager.projectId);
			queryUpdate.executeUpdate();
			trans.commit();
			session.close();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Project_Manager selectProject_Manager(String projectId) {
		// TODO Auto-generated method stub
		Project_Manager project_Manager = new Project_Manager();
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select pm.projectId, pm.ManagerId from Project_Manager pm where pm.projectId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectId);
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){      
			project_Manager.setProjectId((String)object[0]);
			project_Manager.setManagerId((String)object[1]);        
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project_Manager;		
	}
	
	public Project_Manager selectProject_Manager_ByManagerId(String projectManagerId) {
		// TODO Auto-generated method stub
		Project_Manager project_Manager = new Project_Manager();
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select pm.projectId, pm.ManagerId from Project_Manager pm where pm.ManagerId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectManagerId);
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){      
			project_Manager.setProjectId((String)object[0]);
			project_Manager.setManagerId((String)object[1]);        
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project_Manager;		
	}
}
