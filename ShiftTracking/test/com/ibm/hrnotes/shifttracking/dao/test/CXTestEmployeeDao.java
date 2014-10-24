package com.ibm.hrnotes.shifttracking.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Ignore;

import com.ibm.hrnotes.shifttracking.dao.impl.EmployeeDao;
import com.ibm.hrnotes.shifttracking.entites.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CXTestEmployeeDao extends BaseDAOTestCase {
	
	EmployeeDao employeeDao;
	
	String email; //employee email
	String updateEmail; // new email after updated
	
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
		//email = "test" + (int)(Math.random() * 1000) +"@cn.ibm.com";
		email = "cdxiaoch@cn.ibm.com";
		updateEmail = "cdxiaoch@cn.ibm.com";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testAddEmployee() {
		Employee employee = new Employee ();
		employee.setEmail(email);
		employee.setPassword(email);
		employeeDao.add(employee);
		Employee e = employeeDao.getByEmail(email);
		System.out.println(email);
		Assert.assertNotNull(e);
	}
	
	@Ignore
	public void testGetEmployee () {
		Employee e = employeeDao.getByEmail(email);
		e = employeeDao.getByEmail(email);
		Assert.assertNotNull(e);
	}
	
	@Ignore
	public void testGetEmployeeNull () {
		Employee e = employeeDao.getByEmail(null);
		Assert.assertNull(e);
	}
	
	@Ignore
	public void testGetEmployeeEmptyString () {
		Employee e = employeeDao.getByEmail(" ");
		Assert.assertNull(e);
	}
	
	// Test to get Employee by an exist Employee ID
	@Ignore
	public void testGetEmployeeByID () {
		Employee e = employeeDao.getByEmail(email);
		Integer ID = e.getId();
		Employee eByID = employeeDao.get(ID);
		System.out.println("----------------------------------------------------------------");
		System.out.println("In testGetEmployeeID -- e.getID == " + eByID.getId().toString());
		System.out.println("----------------------------------------------------------------");
		Assert.assertNotNull(eByID);
		
	}
	
	// Test to get Employee by null ID
	/*
	 * Test Failure .. no Action for getting Employee by null ID
	 */
	@Ignore
	public void testGetEmployeeByIDNull () {
		Employee eByID = employeeDao.get(null);
		Assert.assertNull(eByID);
	}
	
	// Test to get Employee by an exist Employee ID
	@Ignore
	public void testGetEmployeeByIDNoID () {
		Employee eByID = employeeDao.get(999999);
		Assert.assertNull(eByID);
	}
	
	// Test to update Employee email to an exist Employee
	@Ignore
	public void testUpdateEmployeeEmail () {
		Employee e = employeeDao.getByEmail(email);
		e.setEmail(updateEmail);
		employeeDao.update(e);
		Employee eUpdated = employeeDao.getByEmail(updateEmail);
		Assert.assertNotNull(eUpdated);
	}
	
	// Test to update Employee email to an exist Employee with null string
		@Ignore
		public void testUpdateEmployeeEmailNullStr () {
			Employee e = employeeDao.getByEmail(email);
			e.setEmail("");
			employeeDao.update(e);
			Employee eUpdated = employeeDao.get(e.getId());
			Assert.assertEquals("", eUpdated.getEmail().toString());
		}
		
		// Test to update Employee email to an exist Employee
		/*
		 * Test Failure
		 * No action for updating Employee email to an exist Employee with null object
		 */
		@Test
		public void testUpdateEmployeeEmailNull () {
			Employee e = employeeDao.getByEmail(email);
			e.setEmail(null);
			employeeDao.update(e);
			Employee eUpdated = employeeDao.get(e.getId());
			Assert.assertEquals("", eUpdated.getEmail().toString());
		}
	
	// Test to update Employee email to an non-exist Employee
	/*
	 * Test Failure .. no Action for updating an non-exist Employee
	 */
		@Ignore
		public void testUpdateEmployeeEmailNonExist () {
			Employee e = new Employee();
			e.setEmail(email);
			employeeDao.update(e);
			Employee eUpdated = employeeDao.getByEmail(email);
			Assert.assertNull(eUpdated);
		}
		
	// Test to update Employee ID to an exist Employee
		/*
		 * Test Failure : 
			org.springframework.orm.hibernate4.HibernateSystemException: identifier of an instance of com.ibm.hrnotes.shifttracking.entites.Employee was altered from 13 to 55; nested exception is org.hibernate.HibernateException: identifier of an instance of com.ibm.hrnotes.shifttracking.entites.Employee was altered from 13 to 55
		 */
	@Ignore
	public void testUpdateEmployeeID () {
		Employee e = employeeDao.getByEmail(email);
		e.setId(55);
		employeeDao.update(e);
		Employee eUpdated = employeeDao.get(55);
		Assert.assertNotNull(eUpdated);
	}
	
	// Test to update Employee email to an non-exist Employee
	/*
	 * Test Failure .. no Action for updating an non-exist Employee
	 */
		@Ignore
		public void testUpdateEmployeeIDNonExist () {
			Employee e = new Employee();
			e.setId(55);
			employeeDao.update(e);
			Employee eUpdated = employeeDao.get(55);
			Assert.assertNotNull(eUpdated);
		}
		
		// Test to update Employee ID to an exist Employee with null string
		@Ignore
		public void testUpdateEmployeeIDNullStr(){
			
		}
		
		// Test to update Employee ID to an exist Employee with null object
		@Ignore
		public void testUpdateEmployeeIDNull(){
					
		}
	
	// Test to update Employee password to an exist Employee
		/*
		 * Test Failure
		 * org.junit.ComparisonFailure: expected:<[newpassword]> but was:<[cdxiaoch@cn.ibm.com]>
		 */
	@Ignore
	public void testResetPassword () {
		Employee e = employeeDao.getByEmail(email);
		e.setPassword("newpassword");
		employeeDao.resetPassword(e);
		Employee eUpdated = employeeDao.getByEmail(email);
		System.out.println("----------------------------------------------------------------");
		System.out.println("In testGetEmployeeID -- eUpdated.getID() == " + eUpdated.getId().toString());
		System.out.println("In testGetEmployeeID -- eUpdated.getEmail() == " + eUpdated.getEmail().toString());
		System.out.println("In testGetEmployeeID -- eUpdated.getPassword() == " + eUpdated.getPassword().toString());
		System.out.println("----------------------------------------------------------------");
		Assert.assertEquals("newpassword", eUpdated.getPassword().toString());
	}
	
	// Test to update Employee password to an non-exist Employee
	/*
	 * Test Failure  , no action for resetting password to an non-exist Employee
	 * org.hibernate.TransientObjectException: The given object has a null identifier: com.ibm.hrnotes.shifttracking.entites.Employee
	 */
		@Ignore
		public void testResetPasswordNonExist () {
			Employee e = new Employee();
			e.setPassword("newpassword");
			employeeDao.resetPassword(e);
			Assert.fail("update Employee password to an non-exist Employee Failure");
		}
		
		// Test to update Employee password to an exist Employee with null String
		@Ignore
		public void testResetPasswordNullStr () {
			
		}
		
		// Test to update Employee password to an exist Employee with null object
		@Ignore
		public void testResetPasswordNonNull () {
			
		}

}
