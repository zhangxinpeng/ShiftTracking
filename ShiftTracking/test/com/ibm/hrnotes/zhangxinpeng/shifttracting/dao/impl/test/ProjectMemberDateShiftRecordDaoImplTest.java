package com.ibm.hrnotes.zhangxinpeng.shifttracting.dao.impl.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ibm.hrnotes.shifttracking.dao.impl.Employee_PeMDaoImpl;
import com.ibm.hrnotes.shifttracking.dao.impl.Project_ManagerDaoImpl;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.action.*;
import com.ibm.hrnotes.shifttracking.converters.*;
import com.ibm.hrnotes.shifttracking.dao.impl.*;
import com.ibm.hrnotes.shifttracking.dao.inter.*;
import com.ibm.hrnotes.shifttracking.entites.*;
import com.ibm.hrnotes.shifttracking.service.*;
public class ProjectMemberDateShiftRecordDaoImplTest {
	public static ProjectMemberDateShiftRecordDaoImpl projectMemberDateShiftRecordDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			projectMemberDateShiftRecordDaoImpl = (ProjectMemberDateShiftRecordDaoImpl)beanFactory.getBean("ProjectMemberDateShiftRecordDaoImpl");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		//insertProjectMemberDateShiftRecord_Test();
		//selectProjectMemberDateShiftRecord_Test();
		//updateProjectMemberDateShiftRecord();
		deleteProjectMemberDateShiftRecord();
	}
	
	/*
	public void selectAM_Project_ByAMIntranetId_Test(){
		LinkedList<AM_Project> ap_list = am_ProjectDaoImpl.selectAMProject("junshu@cn.ibm.com");
		for(int i = 0; i < ap_list.size(); i++ )
		{
			System.out.println("Employee No. " + i);
			System.out.println("AM Id :" + ap_list.get(i).getAMId());
			System.out.println("Project Id :" + ap_list.get(i).getProjectId());
		}

	}
	
	*/
	public void selectProjectMemberDateShiftRecord_Test(){
		ProjectMemberDateShiftRecord record = new ProjectMemberDateShiftRecord();
		record.setProjectId("ddddddddd");
		record.setMemberId("zhxinp@cn.ibm.com");
		record.setYear("2014");
		record.setMonth("09");
		record.setDay("30");
		
		record = projectMemberDateShiftRecordDaoImpl.selectShiftRecord(record);

		System.out.println("Project Id :" + record.getProjectId());
		System.out.println("Member Id :" + record.getMemberId());
		System.out.println("Year :" + record.getYear());
		System.out.println("Month :" + record.getMonth());
		System.out.println("Day :" + record.getDay());
		System.out.println("Shift Record :" + record.getShiftRecord());
		

	}
	
    
	public void updateProjectMemberDateShiftRecord(){
		
		
		ProjectMemberDateShiftRecord record_old = new ProjectMemberDateShiftRecord();
		record_old.setProjectId("ddddddddd");
		record_old.setMemberId("zhxinp@cn.ibm.com");
		record_old.setYear("2014");
		record_old.setMonth("09");
		record_old.setDay("20");
		record_old.setShiftRecord("1shift");
		
		ProjectMemberDateShiftRecord record_new = new ProjectMemberDateShiftRecord();
		record_new.setProjectId("ddddddddd");
		record_new.setMemberId("zhxinp@cn.ibm.com");
		record_new.setYear("2014");
		record_new.setMonth("09");
		record_new.setDay("20");
		record_new.setShiftRecord("2shift");
		
		
	     
	    boolean result = projectMemberDateShiftRecordDaoImpl.updateProjectMemberDateShiftRecord(record_old, record_new);
	    System.out.println(result);
	}

	
	public void deleteProjectMemberDateShiftRecord(){
		ProjectMemberDateShiftRecord record = new ProjectMemberDateShiftRecord();
		record.setProjectId("ddddddddd");
		record.setMemberId("zhxinp@cn.ibm.com");
		record.setYear("2014");
		record.setMonth("09");
		record.setDay("20");
	    boolean result = projectMemberDateShiftRecordDaoImpl.deleteProjectMemberDateShiftRecord(record);
	    System.out.println(result);
	}
	
	public void insertProjectMemberDateShiftRecord_Test()
	{
		LinkedList<ProjectMemberDateShiftRecord> record_list = new LinkedList<ProjectMemberDateShiftRecord>();
		ProjectMemberDateShiftRecord record = new ProjectMemberDateShiftRecord();
		record.setProjectId("ddddddddd");
		record.setMemberId("zhxinp@cn.ibm.com");
		record.setYear("2014");
		record.setMonth("09");
		record.setDay("20");
		record.setShiftRecord("1shift");
		record_list.add(record);
		
		
		ProjectMemberDateShiftRecord record2 = new ProjectMemberDateShiftRecord();
		record2.setProjectId("ddddddddd");
		record2.setMemberId("zhxinp@cn.ibm.com");
		record2.setYear("2014");
		record2.setMonth("09");
		record2.setDay("30");
		record2.setShiftRecord("2shift");
		record_list.add(record2);
		
		boolean result = projectMemberDateShiftRecordDaoImpl.insertProjectMemberDateShiftRecord(record_list);
		System.out.println(result);

	}
    
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        
		fail("Not yet implemented");
	}

}
