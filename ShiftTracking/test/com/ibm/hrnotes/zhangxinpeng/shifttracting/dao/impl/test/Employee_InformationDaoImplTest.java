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
public class Employee_InformationDaoImplTest {
	public static Employee_InformationDaoImpl employee_InformationDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			employee_InformationDaoImpl = (Employee_InformationDaoImpl)beanFactory.getBean("Employee_InformationDaoImpl");
		    
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
		insertEmployee_InformationDaoImpl_Test();
		//updateEmployee_Information_IntranetIdTest();
		//updateEmployee_Information_NotesIdTest();
		//updateEmployee_Information_NameIdTest();
		//selectEmployee_InformationByIntranetId_Test();
		//deleteEmployee_Information();
	}
	
	/*
	public void selectEmployee_PeM_ByPeMIntranet_Test(){
		LinkedList<Employee_PeM> ep_list = employee_InformationDaoImpl.selectEmployee_PeMByPeMIntranetId("xuntaozhango@cn.ibm.com");
		for(int i = 0; i < ep_list.size(); i++ )
		{
			System.out.println("Employee No. " + i);
			System.out.println("Empleyee Intranet Id :" + ep_list.get(i).getIntranetId());
			System.out.println("PeM Intranet Id :" + ep_list.get(i).getPeMIntranetId());
		}

	}
	*/
	
	public void selectEmployee_InformationByIntranetId_Test(){
		Employee_Information ei = employee_InformationDaoImpl.selectEmployee_InformationByIntranetId("zhangxinpeng@cn.ibm.com");
		System.out.println("Intranet Id :" + ei.getIntranetId());
		System.out.println("Notes Id :" + ei.getNotesId());
		System.out.println("Name :" + ei.getName());
		

	}
	
    
	public void updateEmployee_Information_IntranetIdTest(){
		Employee_Information employee_Information_Old = new Employee_Information();
		employee_Information_Old.setIntranetId("zhxinp@cn.ibm.com");;
		employee_Information_Old.setNotesId("Xin Peng XP Zhang/China/Contr/IBM");
		employee_Information_Old.setName("Xin Peng Zhang");

		Employee_Information employee_Information_New = new Employee_Information();
		employee_Information_New.setIntranetId("zhangxinpeng@cn.ibm.com");
		employee_Information_New.setNotesId("Xin Peng XP Zhang/China/Contr/IBM");
		employee_Information_New.setName("Xin Peng Zhang");
	     
	    boolean result = employee_InformationDaoImpl.updateEmployee_Information_IntranetId(employee_Information_Old, employee_Information_New);
	    System.out.println(result);
	}
	
	public void updateEmployee_Information_NotesIdTest(){
		Employee_Information employee_Information_Old = new Employee_Information();
		employee_Information_Old.setIntranetId("zhangxinpeng@cn.ibm.com");;
		employee_Information_Old.setNotesId("Xin Peng XP Zhang/China/Contr/IBM");
		employee_Information_Old.setName("Xin Peng Zhang");

		Employee_Information employee_Information_New = new Employee_Information();
		employee_Information_New.setIntranetId("zhangxinpeng@cn.ibm.com");
		employee_Information_New.setNotesId("Xin Peng AB Zhang/China/Contr/IBM");
		employee_Information_New.setName("Xin Peng Zhang");
	     
	    boolean result = employee_InformationDaoImpl.updateEmployee_Information_NotesId(employee_Information_Old, employee_Information_New);
	    System.out.println(result);
	}
	
	public void updateEmployee_Information_NameIdTest(){
		Employee_Information employee_Information_Old = new Employee_Information();
		employee_Information_Old.setIntranetId("zhangxinpeng@cn.ibm.com");;
		employee_Information_Old.setNotesId("Xin Peng AB Zhang/China/Contr/IBM");
		employee_Information_Old.setName("Xin Peng AB Zhang/China/Contr/IBM");

		Employee_Information employee_Information_New = new Employee_Information();
		employee_Information_New.setIntranetId("zhangxinpeng@cn.ibm.com");
		employee_Information_New.setNotesId("Xin Peng AB Zhang/China/Contr/IBM");
		employee_Information_New.setName("Xin Peng");
	     
	    boolean result = employee_InformationDaoImpl.updateEmployee_Information_Name(employee_Information_Old, employee_Information_New);
	    System.out.println(result);
	}
	
	
	
	
	
	
	public void deleteEmployee_Information(){
		Employee_Information employee_Information_New = new Employee_Information();
		employee_Information_New.setIntranetId("zhangxinpeng@cn.ibm.com");
		employee_Information_New.setNotesId("Xin Peng AB Zhang/China/Contr/IBM");
		employee_Information_New.setName("Xin Peng");
	    boolean result = employee_InformationDaoImpl.deleteEmployee_Information(employee_Information_New);
	    System.out.println(result);
	}
	
	public void insertEmployee_InformationDaoImpl_Test()
	{
		 Employee_Information employee_Information = new Employee_Information();
		 employee_Information.setIntranetId("zhxinp@cn.ibm.com");
		 employee_Information.setNotesId("Xin Peng XP Zhang/China/Contr/IBM");
		 employee_Information.setName("Xin Peng Zhang");
     
	     boolean result = employee_InformationDaoImpl.insertEmployee_Information(employee_Information);
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
