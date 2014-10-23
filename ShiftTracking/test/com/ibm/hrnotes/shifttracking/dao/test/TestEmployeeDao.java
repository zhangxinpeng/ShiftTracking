package com.ibm.hrnotes.shifttracking.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.hrnotes.shifttracking.dao.impl.EmployeeDao;
import com.ibm.hrnotes.shifttracking.entites.Employee;

public class TestEmployeeDao extends BaseDAOTestCase {

	EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao (EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddEmployee() {
		Employee employee = new Employee ();
		employee.setEmail("jianjunw@cn.ibm.com");
		employee.setPassword("abc");
		
		
		//EmployeeDao empDao = (EmployeeDao) this.getApplicationContext().getBean(EmployeeDao.class);
		
		employeeDao.add(employee);
		
		//Employee e = empDao.getByEmail("jianjunw@cn.ibm.com");
		System.out.println("done");
	}
	
	@Test
	public void testGetEmployee () {
		Employee e = employeeDao.getByEmail("jianjunw@cn.ibm.com");
		System.out.println(e.getId());
	}

}
