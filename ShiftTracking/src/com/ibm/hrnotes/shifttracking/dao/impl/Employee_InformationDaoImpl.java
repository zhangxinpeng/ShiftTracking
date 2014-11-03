package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.Employee_InformationDao;
import com.ibm.hrnotes.shifttracking.entites.Employee_Information;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;

public class Employee_InformationDaoImpl extends BaseDao implements Employee_InformationDao {

	/**
	 * Employee Information Database Operation 
	 */
	@Override
	public boolean insertEmployee_Information(Employee_Information employee) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(employee);
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
	public boolean deleteEmployee_Information(Employee_Information emplyee) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.delete(emplyee);
			trans.commit();
			session.close();
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateEmployee_Information_IntranetId(Employee_Information emplyee_Old,Employee_Information emplyee_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Employee_Information EI SET EI.intranetId = ?  where EI.intranetId = ? and EI.notesId = ? and EI.name = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, emplyee_New.getIntranetId());
			queryUpdate.setString(1, emplyee_Old.getIntranetId());
			queryUpdate.setString(2, emplyee_Old.getNotesId());
			queryUpdate.setString(3, emplyee_Old.getName());
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
	
	public boolean updateEmployee_Information_NotesId(Employee_Information emplyee_Old,Employee_Information emplyee_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Employee_Information EI SET EI.notesId = ?  where EI.intranetId = ? and EI.notesId = ? and EI.name = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, emplyee_New.getNotesId());
			queryUpdate.setString(1, emplyee_Old.getIntranetId());
			queryUpdate.setString(2, emplyee_Old.getNotesId());
			queryUpdate.setString(3, emplyee_Old.getName());
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
	
	public boolean updateEmployee_Information_Name(Employee_Information emplyee_Old,Employee_Information emplyee_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Employee_Information EI SET EI.name = ?  where EI.intranetId = ? and EI.notesId = ? and EI.name = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, emplyee_New.getName());
			queryUpdate.setString(1, emplyee_Old.getIntranetId());
			queryUpdate.setString(2, emplyee_Old.getNotesId());
			queryUpdate.setString(3, emplyee_Old.getName());
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
	public Employee_Information selectEmployee_InformationByIntranetId(
			String intranetId) {
		// TODO Auto-generated method stub
		Employee_Information employee_Information = new Employee_Information();;
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select EI.intranetId, EI.notesId, EI.name from Employee_Information EI where EI.intranetId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, intranetId);
      
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){      
			employee_Information.setIntranetId((String)object[0]);
			employee_Information.setNotesId((String)object[1]);
			employee_Information.setName((String)object[2]);       
        }   

		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee_Information;	
	}

}
