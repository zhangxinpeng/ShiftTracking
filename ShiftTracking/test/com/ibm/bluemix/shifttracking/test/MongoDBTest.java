package com.ibm.bluemix.shifttracking.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.bluemix.shifttracking.util.*;
import com.mongodb.*;
import java.util.*;

public class MongoDBTest {

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
	public void testGetMongoConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCollection() {
		
		DBCollection project = SimpleMongoDBHelper.getCollection("users");
		/*
		BasicDBObject document = new BasicDBObject();
        document.put("name", "Tom");
        document.put("age", 30);
        document.put("createdDate", new Date());
        project.insert(document);
        */
        DBCursor myDoc  = project.find();
        while(myDoc.hasNext()){
        	//project.remove(myDoc.next());
			System.out.println(myDoc.next());
			
		}
		fail("Not yet implemented");
	}

}
