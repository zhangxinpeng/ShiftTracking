package com.ibm.hrnotes.shifttracking.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.hrnotes.shifttracking.dao.impl.EmployeeDao;
import com.ibm.hrnotes.shifttracking.entites.Employee;

public class TestEmployeeDao extends BaseDAOTestCase {

	EmployeeDao employeeDao;
	
	String email; //employee email
	
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
		email = "test" + (int)(Math.random() * 1000) +"@cn.ibm.com";
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAddEmployee() {
		Employee employee = new Employee ();
		employee.setEmail(email);
		employee.setPassword(email);
		employeeDao.add(employee);
		Employee e = employeeDao.getByEmail(email);
		System.out.println(email);
		Assert.assertNotNull(e);
	}
	
	@Test
	public void testGetEmployee () {
		Employee e = employeeDao.getByEmail("jianjunw@cn.ibm.com");
		Assert.assertNotNull(e);
	}
	
	@Test
	public void testGetEmployeeNull () {
		Employee e = employeeDao.getByEmail(null);
		Assert.assertNull(e);
	}
	
	@Test
	public void testGetEmployeeEmptyString () {
		Employee e = employeeDao.getByEmail(" ");
		Assert.assertNull(e);
	}

}
