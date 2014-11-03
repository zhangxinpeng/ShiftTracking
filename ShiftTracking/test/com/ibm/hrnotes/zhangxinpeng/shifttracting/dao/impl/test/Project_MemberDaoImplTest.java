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
public class Project_MemberDaoImplTest {
	public static Project_MemberDaoImpl project_MemberDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			project_MemberDaoImpl = (Project_MemberDaoImpl)beanFactory.getBean("Project_MemberDaoImpl");
		    
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
		deleteMemeberFromProject_Test();
	}
	

	public void selectProject_MemberByProjectId_Test(){
		LinkedList<Project_Member> pm = project_MemberDaoImpl.selectMember_ProjectByProjectId("aaaaaaaaaa");
		for(int i = 0; i < pm.size(); i++)
		{
			System.out.println("Member : "+ i);
			System.out.println("project id:" + pm.get(i).getProjectId());
			System.out.println("manager id:" + pm.get(i).getMemberId());
		}
		
	}
	
	public void selectProject_MemberByMemeberId_Test(){
		LinkedList<Project_Member> pm = project_MemberDaoImpl.selectMember_ProjectByIntrnetId("zhxinp@cn.ibm.com");
		for(int i = 0; i < pm.size(); i++)
		{
			System.out.println("Member : "+ i);
			System.out.println("project id:" + pm.get(i).getProjectId());
			System.out.println("manager id:" + pm.get(i).getMemberId());
		}
		
	}
	
	public void updateProject_Member_Test(){
		Project_Member project_Member_old = new Project_Member();
		project_Member_old.setProjectId("bbbbbbbbbb");
		project_Member_old.setMemberId("zhxinp@cn.ibm.com");
		
		Project_Member project_Member_new = new Project_Member();
		project_Member_new.setProjectId("bbbbbbbbbb");
		project_Member_new.setMemberId("xiaocd@cn.ibm.com");
	     boolean result = project_MemberDaoImpl.updateMemberIdOfProject(project_Member_old, project_Member_new);
	     System.out.println(result);
	}
	
	public void deleteMemeberFromProject_Test(){
		Project_Member project_member = new Project_Member();
		project_member.setProjectId("aaaaaaaaaa");
		project_member.setMemberId("zhxinp@cn.ibm.com");
	     //project_manager.setProjectId("aaaaaaaaaa");
	     boolean result = project_MemberDaoImpl.deleteMemeberFromProject(project_member);
	     System.out.println(result);
	}
	
	
	public void insertProject_Manager_Test()
	{
		/*
		Project_Member project_Member = new Project_Member();
		project_Member.setProjectId("aaaaaaaaaa");
		project_Member.setMemberId("jianjunw@cn.ibm.com");
	     
	     boolean result = project_MemberDaoImpl.insertMemeberToProject(project_Member);
	     System.out.println(result);
	     */
	     Project_Member project_Member1 = new Project_Member();
			project_Member1.setProjectId("bbbbbbbbbb");
			project_Member1.setMemberId("zhxinp@cn.ibm.com");
		     
		     boolean result1 = project_MemberDaoImpl.insertMemeberToProject(project_Member1);
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
