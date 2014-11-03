package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.Project_AdminDao;
import com.ibm.hrnotes.shifttracking.dao.inter.Project_MemberDao;
import com.ibm.hrnotes.shifttracking.entites.Project_Admin;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.entites.Project_Member;

public class Project_MemberDaoImpl extends BaseDao implements Project_MemberDao {

	/**
	 * Project Member Database Operation
	 */
	@Override
	public boolean insertMemeberToProject(Project_Member projectMemeber) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(projectMemeber);
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
	public boolean deleteMemeberFromProject(Project_Member projectMemeber) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			//session.delete(projectMemeber);
			String hql = "delete from Project_Member pm where pm.memberId = ? and pm.projectId = ?";
			Query queryDelete = session.createQuery(hql);
			queryDelete.setString(0, projectMemeber.getMemberId());
			queryDelete.setString(1, projectMemeber.getProjectId());	
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

	public boolean updateMemberIdOfProject(Project_Member oldProjectMemeber,Project_Member newProjectMemeber) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Project_Member pm SET pm.memberId = ? where pm.memberId = ? and pm.projectId = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, newProjectMemeber.getMemberId());
			queryUpdate.setString(1, oldProjectMemeber.getMemberId());
			queryUpdate.setString(2, oldProjectMemeber.getProjectId());
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
	public LinkedList<Project_Member> selectMember_ProjectByProjectId(
			String projectId) {
		// TODO Auto-generated method stub
		LinkedList<Project_Member> project_Member_List = new LinkedList<Project_Member>();
		Project_Member project_Member;
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select pm.projectId, pm.memberId from Project_Member pm where pm.projectId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectId);
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){   
			project_Member = new Project_Member();
			project_Member.setProjectId((String)object[0]);
			project_Member.setMemberId((String)object[1]);
			project_Member_List.add(project_Member);
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project_Member_List;		
	}


	@Override
	public LinkedList<Project_Member> selectMember_ProjectByIntrnetId(
			String intranetId) {
		// TODO Auto-generated method stub
		LinkedList<Project_Member> project_Member_List = new LinkedList<Project_Member>();
		Project_Member project_Member;
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select pm.projectId, pm.memberId from Project_Member pm where pm.memberId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, intranetId);
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){   
			project_Member = new Project_Member();
			project_Member.setProjectId((String)object[0]);
			project_Member.setMemberId((String)object[1]);
			project_Member_List.add(project_Member);
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project_Member_List;	
	}




}
