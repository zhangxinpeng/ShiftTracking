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
public class Project_AdminDaoImplTest {
	public static Project_AdminDaoImpl project_AdminDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			project_AdminDaoImpl = (Project_AdminDaoImpl)beanFactory.getBean("Project_AdminDaoImpl");
		    
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

		//insertProject_Admin_Test();
		//updateProject_Admin_Test();
		//selectProject_Admin_Test(); 
		//insertProject_Admin_Test();
		deleteProject_Admin();
	}
	
	public void selectProject_Admin_Test(){
		Project_Admin pa = project_AdminDaoImpl.selectProject_Admin("aaaaaaaaaa");
		System.out.println("project admin id:" + pa.getProjectAdminId());
		System.out.println("project id:" + pa.getProjectId());
	}
	
	public void updateProject_Admin_Test(){
		Project_Admin project_Admin_old = new Project_Admin();
		project_Admin_old.setProjectAdminId("zhxinp@cn.ibm.com");
		project_Admin_old.setProjectId("aaaaaaaaaa");

		Project_Admin project_Admin_new = new Project_Admin();
		project_Admin_new.setProjectAdminId("jingzhang@cn.ibm.com");
		project_Admin_new.setProjectId("aaaaaaaaaa"); 
	     
	     boolean result = project_AdminDaoImpl.updateProject_Admin(project_Admin_old, project_Admin_new);
	     System.out.println(result);
	}
	
	public void deleteProject_Admin(){
		 Project_Admin project_Admin = new Project_Admin();
		 project_Admin.setProjectAdminId("cdxiao@cn.ibm.com");
		 project_Admin.setProjectId("baaaaaaaaa");
	     //project_manager.setProjectId("aaaaaaaaaa");
	     boolean result = project_AdminDaoImpl.deleteProject_Admin(project_Admin);
	     System.out.println(result);
	}
	
	public void insertProject_Admin_Test()
	{
		 Project_Admin project_Admin = new Project_Admin();
		 project_Admin.setProjectAdminId("cdxiao@cn.ibm.com");
		 project_Admin.setProjectId("baaaaaaaaa");
     
	     boolean result = project_AdminDaoImpl.insertProject_Admin(project_Admin);
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
