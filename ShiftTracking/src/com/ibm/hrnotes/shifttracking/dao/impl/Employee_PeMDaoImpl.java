package com.ibm.hrnotes.shifttracking.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.hrnotes.shifttracking.dao.inter.Employee_PeMDao;
import com.ibm.hrnotes.shifttracking.entites.Employee_PeM;
import com.ibm.hrnotes.shifttracking.entites.Project_Admin;

public class Employee_PeMDaoImpl extends BaseDao implements Employee_PeMDao {

	@Override
	public boolean insertEmployee_PeM(Employee_PeM employeePeM) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			session.save(employeePeM);
			trans.commit();
			session.close();
			
		}catch(Exception e)
		{
			return false;
		}		
		return true;
	}

	@Override
	public boolean deleteEmployee_PeM(Employee_PeM emplyeePeM) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			//session.delete(emplyeePeM);
			String hql = "delete from Employee_PeM EP where EP.intranetId = ? and EP.PeMIntranetId = ?";
			Query queryDelete = session.createQuery(hql);
			queryDelete.setString(0, emplyeePeM.getIntranetId());
			queryDelete.setString(1, emplyeePeM.getPeMIntranetId());	
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
	public boolean updateEmployee_PeM(Employee_PeM emplyeePeM_Old,Employee_PeM emplyeePeM_New) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			String hql = "update Employee_PeM EP SET EP.PeMIntranetId = ?  where EP.intranetId = ? and EP.PeMIntranetId = ?";
			Query queryUpdate = session.createQuery(hql);
			queryUpdate.setString(0, emplyeePeM_New.getPeMIntranetId());
			queryUpdate.setString(1, emplyeePeM_Old.getIntranetId());
			queryUpdate.setString(2, emplyeePeM_Old.getPeMIntranetId());
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
	public Employee_PeM selectEmployee_PeMByEmployeeIntranetId(String employeeIntranetId) {
		// TODO Auto-generated method stub
		Employee_PeM employee_PeM = new Employee_PeM();;
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select EP.intranetId, EP.PeMIntranetId from Employee_PeM EP where EP.intranetId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, employeeIntranetId);
	
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){ 
			
			employee_PeM.setIntranetId((String)object[0]);
			employee_PeM.setPeMIntranetId((String)object[1]);  

        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee_PeM;	
	}

	@Override
	public LinkedList<Employee_PeM> selectEmployee_PeMByPeMIntranetId(
			String PeMIntranetId) {
		// TODO Auto-generated method stub
		Employee_PeM employee_PeM;
		LinkedList<Employee_PeM> employee_PeM_List = new LinkedList<Employee_PeM>();
		try{
		
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		String hql = "select EP.intranetId, EP.PeMIntranetId from Employee_PeM EP where EP.PeMIntranetId = ?";
		Query querySelect = session.createQuery(hql);
		querySelect.setString(0, PeMIntranetId);
	
		List<Object[]> list = querySelect.list();
		trans.commit();
		for(Object[] object : list){ 
			employee_PeM = new Employee_PeM();
			employee_PeM.setIntranetId((String)object[0]);
			employee_PeM.setPeMIntranetId((String)object[1]);  
			employee_PeM_List.add(employee_PeM);
        }   
		session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee_PeM_List;	
	}





}
