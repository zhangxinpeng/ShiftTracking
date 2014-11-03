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
public class Employee_PeMDaoImplTest {
	public static Employee_PeMDaoImpl employee_PeMDaoImpl;
	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 
			//sessionFactory = (SessionFactory)beanFactory.getBean("sessionFactory");
			//session = sessionFactory.openSession();
			employee_PeMDaoImpl = (Employee_PeMDaoImpl)beanFactory.getBean("Employee_PeMDaoImpl");
		    
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
		//insertEmployee_PeM_Test();
		//selectEmployee_PeM_ByPeMIntranet_Test();
		//selectEmployee_PeMByEmployeeIntranetId_Test();
		//updateEmployee_PeM_Test();
		insertEmployee_PeM_Test();
		deleteEmployee_PeM();
	}
	
	
	public void selectEmployee_PeM_ByPeMIntranet_Test(){
		LinkedList<Employee_PeM> ep_list = employee_PeMDaoImpl.selectEmployee_PeMByPeMIntranetId("xuntaozhango@cn.ibm.com");
		for(int i = 0; i < ep_list.size(); i++ )
		{
			System.out.println("Employee No. " + i);
			System.out.println("Empleyee Intranet Id :" + ep_list.get(i).getIntranetId());
			System.out.println("PeM Intranet Id :" + ep_list.get(i).getPeMIntranetId());
		}

	}
	
	public void selectEmployee_PeMByEmployeeIntranetId_Test(){
		Employee_PeM ep = employee_PeMDaoImpl.selectEmployee_PeMByEmployeeIntranetId("cdxiao@cn.ibm.com");
		System.out.println("Empleyee Intranet Id :" + ep.getIntranetId());
		System.out.println("PeM Intranet Id :" + ep.getPeMIntranetId());
		

	}
	

	public void updateEmployee_PeM_Test(){
		Employee_PeM employee_PeM_old = new Employee_PeM();
		employee_PeM_old.setIntranetId("cdxiao@cn.ibm.com");
		employee_PeM_old.setPeMIntranetId("xuntaozhango@cn.ibm.com");

		Employee_PeM employee_PeM_new = new Employee_PeM();
		employee_PeM_new.setIntranetId("cdxiao@cn.ibm.com");
		employee_PeM_new.setPeMIntranetId("jianjunw@cn.ibm.com");
	     
	    boolean result = employee_PeMDaoImpl.updateEmployee_PeM(employee_PeM_old, employee_PeM_new);
	    System.out.println(result);
	}
	
	public void deleteEmployee_PeM(){
		Employee_PeM employee_PeM = new Employee_PeM();
		employee_PeM.setIntranetId("cdxiao@cn.ibm.com");
		employee_PeM.setPeMIntranetId("xuntaozhango@cn.ibm.com");
	    boolean result = employee_PeMDaoImpl.deleteEmployee_PeM(employee_PeM);
	    System.out.println(result);
	}
	
	public void insertEmployee_PeM_Test()
	{
		Employee_PeM employee_PeM = new Employee_PeM();
		employee_PeM.setIntranetId("cdxiao@cn.ibm.com");
		employee_PeM.setPeMIntranetId("xuntaozhango@cn.ibm.com");
     
	     boolean result = employee_PeMDaoImpl.insertEmployee_PeM(employee_PeM);
	     System.out.println(result);
	     /*
	     Employee_PeM employee_PeM1 = new Employee_PeM();
	     employee_PeM1.setIntranetId("zhxinp@cn.ibm.com");
		 employee_PeM1.setPeMIntranetId("xuntaozhango@cn.ibm.com");
		 boolean result1 = employee_PeMDaoImpl.insertEmployee_PeM(employee_PeM1);
	     System.out.println(result1);*/
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        
		fail("Not yet implemented");
	}

}
