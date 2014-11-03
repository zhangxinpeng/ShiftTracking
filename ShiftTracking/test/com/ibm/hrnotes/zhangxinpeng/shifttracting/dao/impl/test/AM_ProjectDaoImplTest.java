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
public class AM_ProjectDaoImplTest {
	public static AM_ProjectDaoImpl am_ProjectDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			am_ProjectDaoImpl = (AM_ProjectDaoImpl)beanFactory.getBean("AM_ProjectDaoImpl");
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

		//insertAM_Project_Test();
		//updateAM_Project_Test();
		//selectAM_Project_ByProjectId_Test();
		//selectAM_Project_ByAMIntranetId_Test();
		deleteAM_Project();
	}
	
	
	public void selectAM_Project_ByAMIntranetId_Test(){
		LinkedList<AM_Project> ap_list = am_ProjectDaoImpl.selectAMProject("junshu@cn.ibm.com");
		for(int i = 0; i < ap_list.size(); i++ )
		{
			System.out.println("Employee No. " + i);
			System.out.println("AM Id :" + ap_list.get(i).getAMId());
			System.out.println("Project Id :" + ap_list.get(i).getProjectId());
		}

	}
	
	public void selectAM_Project_ByProjectId_Test(){
		AM_Project ap = am_ProjectDaoImpl.selectAM_Project("aaaaaaaa");
		System.out.println("AM Id :" + ap.getAMId());
		System.out.println("Project Id :" + ap.getProjectId());
		

	}
	

	public void updateAM_Project_Test(){
		AM_Project am_Project_Old = new AM_Project();
		am_Project_Old.setAMId("zhxinp@cn.ibm.com");
		am_Project_Old.setProjectId("aaaaaaaa");

		AM_Project am_Project_New = new AM_Project();
		am_Project_New.setAMId("junshu@cn.ibm.com");
		am_Project_New.setProjectId("aaaaaaaa");
	     
	    boolean result = am_ProjectDaoImpl.update_AMId_Of_Project(am_Project_Old, am_Project_New);
	    System.out.println(result);
	}

	
	public void deleteAM_Project(){
		AM_Project am_Project = new AM_Project();
	    am_Project.setAMId("junshu@cn.ibm.com");
		am_Project.setProjectId("aaaaaaaa");
	    boolean result = am_ProjectDaoImpl.deleteAM_Project(am_Project);
	    System.out.println(result);
	}
	
	public void insertAM_Project_Test()
	{
		 AM_Project am_Project = new AM_Project();
		 am_Project.setAMId("junshu@cn.ibm.com");
		 am_Project.setProjectId("aaaaaaaa");
		 boolean result = am_ProjectDaoImpl.insertAM_project(am_Project);
     
	     System.out.println(result);
	     
	     AM_Project am_Project1 = new AM_Project();
		 am_Project1.setAMId("junshu@cn.ibm.com");
		 am_Project1.setProjectId("bbbbbbbb");
		 boolean result1 = am_ProjectDaoImpl.insertAM_project(am_Project1);
	     System.out.println(result1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        
		fail("Not yet implemented");
	}

}
