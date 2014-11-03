package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.Project_AdminDao;
import com.ibm.hrnotes.shifttracking.entites.Project_Admin;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;

public class Project_AdminDaoImpl extends BaseDao implements Project_AdminDao {

	/**
	 * Project Admin Database Operation
	 */
	@Override
	public boolean insertProject_Admin(Project_Admin project_Admin) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(project_Admin);
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
	public boolean deleteProject_Admin(Project_Admin project_Admin) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.delete(project_Admin);
			trans.commit();
			session.close();
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateProject_Admin(Project_Admin project_Admin_Old ,Project_Admin project_Admin_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Project_Admin PA SET PA.projectAdminId = ? where PA.projectAdminId = ? and PA.projectId = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, project_Admin_New.getProjectAdminId());
			queryUpdate.setString(1, project_Admin_Old.getProjectAdminId());
			queryUpdate.setString(2, project_Admin_Old.getProjectId());
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
	public Project_Admin selectProject_Admin(String projectId) {
		// TODO Auto-generated method stub
		Project_Admin project_Admin = new Project_Admin();
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select PA.projectAdminId, PA.projectId from Project_Admin PA where PA.projectId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectId);
	
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){     
			project_Admin.setProjectAdminId((String)object[0]);
			project_Admin.setProjectId((String)object[1]);       
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project_Admin;	
	}
}
