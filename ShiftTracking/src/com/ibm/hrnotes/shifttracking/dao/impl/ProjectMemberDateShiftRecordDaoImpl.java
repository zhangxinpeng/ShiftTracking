package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.ProjectMemberDateShiftRecordDao;
import com.ibm.hrnotes.shifttracking.entites.AM_Project;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;
import com.ibm.hrnotes.shifttracking.entites.ProjectMemberDateShiftRecord;

public class ProjectMemberDateShiftRecordDaoImpl extends BaseDao implements
		ProjectMemberDateShiftRecordDao {

	@Override
	public boolean insertProjectMemberDateShiftRecord(
			LinkedList<ProjectMemberDateShiftRecord> shiftRecordList) {
		// TODO Auto-generated method stub
		Session session;
		Transaction trans;
		try{
			
			for(int i = 0; i < shiftRecordList.size(); i++ ){
				session = getSession();
				trans = session.beginTransaction();
				session.save(shiftRecordList.get(i));
				trans.commit();
				session.close();
			}		
			
			

		}catch(Exception e)
		{
			e.printStackTrace();
			//return false;
		}		
		return true;
	}

	@Override
	public boolean deleteProjectMemberDateShiftRecord(
			ProjectMemberDateShiftRecord shiftRecordList) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();		
			//session.delete(am_Project);
			String hql = "delete from ProjectMemberDateShiftRecord SR where SR.projectId = ? and SR.memberId = ? and SR.year = ? and SR.month = ? and SR.day = ?";
			
				Query queryDelete = session.createQuery(hql);
				queryDelete.setString(0, shiftRecordList.getProjectId());
				queryDelete.setString(1, shiftRecordList.getMemberId());
				queryDelete.setString(2, shiftRecordList.getYear());
				queryDelete.setString(3, shiftRecordList.getMonth());
				queryDelete.setString(4, shiftRecordList.getDay());
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
	public boolean updateProjectMemberDateShiftRecord(
			ProjectMemberDateShiftRecord shiftRecord_Old,ProjectMemberDateShiftRecord shiftRecord_New) {
		// TODO Auto-generated method stub
		try{
			Session session;
			Query queryUpdate;
			Transaction trans;
			String hql = "update ProjectMemberDateShiftRecord SR SET SR.shiftRecord = ?  where SR.projectId = ? and SR.memberId = ? and SR.year = ? and SR.month = ? and SR.day = ? and SR.shiftRecord = ?";

				session = getSession();
				trans = session.beginTransaction();
				queryUpdate = session.createQuery(hql);
				queryUpdate.setString(0, shiftRecord_New.getShiftRecord());
				queryUpdate.setString(1, shiftRecord_Old.getProjectId());
				queryUpdate.setString(2, shiftRecord_Old.getMemberId());
				queryUpdate.setString(3, shiftRecord_Old.getYear());
				queryUpdate.setString(4, shiftRecord_Old.getMonth());
				queryUpdate.setString(5, shiftRecord_Old.getDay());
				queryUpdate.setString(6, shiftRecord_Old.getShiftRecord());
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
	public ProjectMemberDateShiftRecord selectShiftRecord(
			ProjectMemberDateShiftRecord shiftRecord) {
		// TODO Auto-generated method stub
		ProjectMemberDateShiftRecord projectMemberDateShiftRecord = new ProjectMemberDateShiftRecord();
		
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();

		String hql = "select pmdsr.shiftRecord from ProjectMemberDateShiftRecord pmdsr where pmdsr.projectId = ? and pmdsr.memberId = ? and pmdsr.year = ? and pmdsr.month = ? and pmdsr.day = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, shiftRecord.getProjectId());
		querySelect.setString(1, shiftRecord.getMemberId());
		querySelect.setString(2, shiftRecord.getYear());
		querySelect.setString(3, shiftRecord.getMonth());
		querySelect.setString(4, shiftRecord.getDay());
	    
		List<String> list = querySelect.list();
	
		trans.commit();
		for(int i = 0; i < list.size(); i++ ) {
			
			projectMemberDateShiftRecord.setShiftRecord(list.get(i));
        } 
		projectMemberDateShiftRecord.setProjectId(shiftRecord.getProjectId());
		projectMemberDateShiftRecord.setMemberId(shiftRecord.getMemberId());
		projectMemberDateShiftRecord.setYear(shiftRecord.getYear());
		projectMemberDateShiftRecord.setMonth(shiftRecord.getMonth());
		projectMemberDateShiftRecord.setDay(shiftRecord.getDay());
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return projectMemberDateShiftRecord;
	}
	
	public LinkedList<ProjectMemberDateShiftRecord> selectShiftRecordByProjectIdAndMemberId(
			String projectId, String memberId) {
		// TODO Auto-generated method stub
		ProjectMemberDateShiftRecord projectMemberDateShiftRecord;
		LinkedList<ProjectMemberDateShiftRecord> ShiftRecord_list = new LinkedList<ProjectMemberDateShiftRecord>();
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();

		String hql = "select pmdsr.projectId, pmdsr.memberId, pmdsr.year ,pmdsr.month, pmdsr.day, pmdsr.shiftRecord from ProjectMemberDateShiftRecord pmdsr where pmdsr.projectId = ? and pmdsr.memberId = ? ";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, projectId);
		querySelect.setString(1, memberId);
	    
		//list = (LinkedList<ProjectMemberDateShiftRecord>)querySelect.list();
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){ 
			projectMemberDateShiftRecord = new ProjectMemberDateShiftRecord();
			projectMemberDateShiftRecord.setProjectId((String)object[0]);
			projectMemberDateShiftRecord.setMemberId((String)object[1]);
			
			projectMemberDateShiftRecord.setYear((String)object[2]);
			projectMemberDateShiftRecord.setMonth((String)object[3]);
			projectMemberDateShiftRecord.setDay((String)object[4]);
			projectMemberDateShiftRecord.setShiftRecord((String)object[5]);
			ShiftRecord_list.add(projectMemberDateShiftRecord);
        } 
		
		
		
		
		//for(int i = 0; i < list.size(); i++ ) {
			
		//	projectMemberDateShiftRecord.setShiftRecord(list.get(i));
        //} 
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ShiftRecord_list;
	}

}
