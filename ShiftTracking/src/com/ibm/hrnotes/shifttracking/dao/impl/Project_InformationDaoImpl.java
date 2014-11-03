package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.Project_InformationDao;
import com.ibm.hrnotes.shifttracking.entites.Project_Information;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;

public class Project_InformationDaoImpl extends BaseDao implements Project_InformationDao {

	/**
	 * Project Information Operation
	 */
	@Override
	public boolean insertProject_Information(
			Project_Information project_Information) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(project_Information);
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
	public boolean deleteProject_Information(
			Project_Information project_Information) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.delete(project_Information);
			trans.commit();
			session.close();
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateProject_Information_ProjectName(
			Project_Information project_Information_Old,Project_Information project_Information_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Project_Information PI SET PI.projectName = ? where PI.projectId = ? and PI.projectName = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, project_Information_New.getProjectName());
			queryUpdate.setString(1, project_Information_Old.getProjectId());
			queryUpdate.setString(2, project_Information_Old.getProjectName());
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
	public Project_Information selectProject_InformationByProjectId(
			String projectId) {
		// TODO Auto-generated method stub
		Project_Information project_Information = new Project_Information();

		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select PI.projectId, PI.projectName from Project_Information PI where PI.projectId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectId);
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){      
			project_Information.setProjectId((String)object[0]);
			project_Information.setProjectName((String)object[1]);        
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project_Information;	
	}

}
