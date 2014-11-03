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

import com.ibm.hrnotes.shifttracking.dao.impl.Project_ManagerDaoImpl;
import com.ibm.hrnotes.shifttracking.entites.Project_Manager;
import com.ibm.hrnotes.shifttracking.action.*;
import com.ibm.hrnotes.shifttracking.converters.*;
import com.ibm.hrnotes.shifttracking.dao.impl.*;
import com.ibm.hrnotes.shifttracking.dao.inter.*;
import com.ibm.hrnotes.shifttracking.entites.*;
import com.ibm.hrnotes.shifttracking.service.*;
public class Project_InformationDaoImplTest {
	public static Project_InformationDaoImpl project_InformationDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			project_InformationDaoImpl = (Project_InformationDaoImpl)beanFactory.getBean("Project_InformationDaoImpl");
		    
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

		//insertProject_Information_Test();
		//deleteProject_Information_Test();
		//updateProject_Member_Test();
		selectProject_Information_Test();
	}
	
    /*
	public void selectProject_MemberByProjectId_Test(){
		LinkedList<Project_Member> pm = project_MemberDaoImpl.selectMember_ProjectByProjectId("aaaaaaaaaa");
		for(int i = 0; i < pm.size(); i++)
		{
			System.out.println("Member : "+ i);
			System.out.println("project id:" + pm.get(i).getProjectId());
			System.out.println("manager id:" + pm.get(i).getMemberId());
		}
		
	}
	*/
	public void selectProject_Information_Test(){
		Project_Information pm = project_InformationDaoImpl.selectProject_InformationByProjectId("baaaaaaaa");
        System.out.println("ProjectId : " + pm.getProjectId());
        System.out.println("ProjectName : " + pm.getProjectName());
	}

	public void updateProject_Member_Test(){
		Project_Information project_Information_old = new Project_Information();
		project_Information_old.setProjectId("baaaaaaaa");
		project_Information_old.setProjectName("HR-Notes");

		
		Project_Information project_Information_new = new Project_Information();
		project_Information_new.setProjectId("baaaaaaaa");
		project_Information_new.setProjectName("One Team");
	    boolean result = project_InformationDaoImpl.updateProject_Information_ProjectName(project_Information_old, project_Information_new);
	    System.out.println(result);
	}
	
	
	public void deleteProject_Information_Test(){
		Project_Information project_Information = new Project_Information();
		project_Information.setProjectId("bbaaaaaaa");
	    project_Information.setProjectName("One Team");
	     //project_manager.setProjectId("aaaaaaaaaa");
	     boolean result = project_InformationDaoImpl.deleteProject_Information(project_Information);
	     System.out.println(result);
	}
	

	public void insertProject_Information_Test()
	{
		/*
		Project_Member project_Member = new Project_Member();
		project_Member.setProjectId("aaaaaaaaaa");
		project_Member.setMemberId("jianjunw@cn.ibm.com");
	     
	     boolean result = project_MemberDaoImpl.insertMemeberToProject(project_Member);
	     System.out.println(result);
	     */
 
		 Project_Information project_Information = new Project_Information();
		 project_Information.setProjectId("bbaaaaaaa");
		 project_Information.setProjectName("One Team");   
		 boolean result1 = project_InformationDaoImpl.insertProject_Information(project_Information);
		 
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
