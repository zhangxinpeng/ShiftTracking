package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.AM_ProjectDao;
import com.ibm.hrnotes.shifttracking.entites.AM_Project;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;

public class AM_ProjectDaoImpl extends BaseDao implements AM_ProjectDao {

	/**
	 * AM Project Database Operation
	 */
	@Override
	public boolean insertAM_project(AM_Project am_Project) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(am_Project);
			trans.commit();
			session.close();

		}catch(Exception e)
		{
			return false;
		}		
		return true;
	}

	@Override
	public boolean deleteAM_Project(AM_Project am_Project) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();		
			//session.delete(am_Project);
			String hql = "delete from AM_Project AP where AP.AMId = ? and AP.projectId = ?";
			Query queryDelete = session.createQuery(hql);
			queryDelete.setString(0, am_Project.getAMId());
			queryDelete.setString(1, am_Project.getProjectId());	
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
	public boolean update_AMId_Of_Project(AM_Project am_Project_Old, AM_Project am_Project_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update AM_Project AP SET AP.AMId = ?  where AP.AMId = ? and AP.projectId = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, am_Project_New.getAMId());
			queryUpdate.setString(1, am_Project_Old.getAMId());
			queryUpdate.setString(2, am_Project_Old.getProjectId());
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
	public AM_Project selectAM_Project(String projectId) {
		// TODO Auto-generated method stub
		AM_Project am_Project = new AM_Project();;
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select AP.AMId, AP.projectId from AM_Project AP where AP.projectId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectId);
	
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){ 
			am_Project.setAMId((String)object[0]);
			am_Project.setProjectId((String)object[1]);
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return am_Project;
	}

	@Override
	public LinkedList<AM_Project> selectAMProject(String AMIntranetId) {
		// TODO Auto-generated method stub
		AM_Project am_Project;
		LinkedList<AM_Project> AM_Project_List = new LinkedList<AM_Project>();
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select AP.AMId, AP.projectId from AM_Project AP where AP.AMId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, AMIntranetId);
	
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){ 
			am_Project = new AM_Project();
			am_Project.setAMId((String)object[0]);
			am_Project.setProjectId((String)object[1]);
 
			AM_Project_List.add(am_Project);
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return AM_Project_List;
	}

}
