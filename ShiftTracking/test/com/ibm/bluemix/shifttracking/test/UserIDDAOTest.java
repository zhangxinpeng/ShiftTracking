package com.ibm.bluemix.shifttracking.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.bluemix.shifttracking.beans.UserIDBean;
import com.ibm.bluemix.shifttracking.dao.impl.UserIDDAO;

public class UserIDDAOTest {

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
	public void testAdd() {
		UserIDDAO dao = new UserIDDAO();
		UserIDBean bean = new UserIDBean();
		bean.setUserID("jianjunw@cn.ibm.com");
		bean.setPassword("aaaa");
		bean.setAnswer("who are you");
		dao.add(bean);
		
		UserIDBean b = dao.find("jianjunw@cn.ibm.com");
		System.out.println(b);
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		UserIDDAO dao = new UserIDDAO();
		UserIDBean b = dao.find("jianjunw@cn.ibm.com");
		b.setAnswer("I don't know you a");
		dao.update(b);
		
		b = dao.find("jianjunw@cn.ibm.com");
		System.out.println("in test update:\n" + b);
	}

	@Test
	public void testDelete() {
		UserIDDAO dao = new UserIDDAO();
		UserIDBean b = new UserIDBean();
		b.setUserID("jianjunw@cn.ibm.com");
		dao.remove(b);
	}

	@Test
	public void testFind() {
		UserIDDAO dao = new UserIDDAO();
		UserIDBean b = dao.find("jianjunw@cn.ibm.com");
		System.out.println("in test find:\n" + b);
	}

	@Test
	public void testClearPassword() {
		fail("Not yet implemented");
	}

}
