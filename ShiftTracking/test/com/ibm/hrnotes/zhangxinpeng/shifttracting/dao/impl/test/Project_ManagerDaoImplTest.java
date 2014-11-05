package com.ibm.hrnotes.zhangxinpeng.shifttracting.dao.impl.test;

import static org.junit.Assert.*;

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

import com.ibm.hrnotes.shifttracking.dao.impl.Project_ManagerDaoImpl;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.action.*;
import com.ibm.hrnotes.shifttracking.converters.*;
import com.ibm.hrnotes.shifttracking.dao.impl.*;
import com.ibm.hrnotes.shifttracking.dao.inter.*;
import com.ibm.hrnotes.shifttracking.entites.*;
import com.ibm.hrnotes.shifttracking.service.*;
public class Project_ManagerDaoImplTest {
	public static Project_ManagerDaoImpl project_ManagerDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			project_ManagerDaoImpl = (Project_ManagerDaoImpl)beanFactory.getBean("Project_ManagerDaoImpl");
		    
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
		//ApplicationContext ctx = 
		//		new FileSystemXmlApplicationContext("applicationContext-DatabaseOperation.xml");
		// insertProject_Manager_Test();
		//insertProject_Manager_Test();
		//deleteProject_Manager_Test();
		selectProject_Manager_ByManagerId_Test();
	     
	}
	
	public void selectProject_Manager_Test(){
		Project_Manager pm = project_ManagerDaoImpl.selectProject_Manager("aaaaaaaaaa");
		System.out.println("project id:" + pm.projectId);
		System.out.println("manager id:" + pm.ManagerId);
	}
	
	public void selectProject_Manager_ByManagerId_Test(){
		Project_Manager pm = project_ManagerDaoImpl.selectProject_Manager_ByManagerId("wangjianjun@qq.com");
		System.out.println("project id:" + pm.projectId);
		System.out.println("manager id:" + pm.ManagerId);
	}
	
	public void updateProject_Manager_Test(){
		 Project_Manager project_manager = new Project_Manager();
	     project_manager.setManagerId("jianjunw@cn.ibm.com");
	     project_manager.setProjectId("aaaaaaaaaa");
	     boolean result = project_ManagerDaoImpl.updateProject_Manager(project_manager);
	     System.out.println(result);
	}
	public void deleteProject_Manager_Test(){
		Project_Manager project_manager = new Project_Manager();
	     project_manager.setManagerId("zhxinp@cn.ibm.com");
	     project_manager.setProjectId("bbaaaaaaaa");
	     boolean result = project_ManagerDaoImpl.deleteProject_Manager(project_manager);
	     System.out.println(result);
	}
	
	public void insertProject_Manager_Test()
	{
		 Project_Manager project_manager = new Project_Manager();
	     project_manager.setManagerId("zhxinp@cn.ibm.com");
	     project_manager.setProjectId("bbaaaaaaaa");
	     
	     boolean result = project_ManagerDaoImpl.insertProject_Manager(project_manager);
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
