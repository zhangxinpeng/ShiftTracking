package com.ibm.hrnotes.zhangxinpeng.shifttracting.service.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.hrnotes.shifttracking.dao.impl.Employee_InformationDaoImpl;
import com.ibm.hrnotes.shifttracking.entites.Employee_Entity;
import com.ibm.hrnotes.shifttracking.entites.ProjectMemberDateShiftRecord;
import com.ibm.hrnotes.shifttracking.entites.Project_Entity;
import com.ibm.hrnotes.shifttracking.entites.Project_Member;
import com.ibm.hrnotes.shifttracking.entites.ViewOrientedEntity;
import com.ibm.hrnotes.shifttracking.service.ProjectAndEmployeeShiftTrackingGetService;
import com.ibm.hrnotes.shifttracking.service.ProjectAndEmployeeShiftTrackingService;

public class ProjectAndEmployeeShiftTrackingGetOperationServiceTest {
    public static ProjectAndEmployeeShiftTrackingGetService projectAndEmployeeShiftTrackingGetService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 

			projectAndEmployeeShiftTrackingGetService = (ProjectAndEmployeeShiftTrackingGetService)beanFactory.getBean("ProjectAndEmployeeShiftTrackingGetService");
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		getProjectAndEmployeeShiftTracking_For_ProjectManagerTest();
		
		
		
		
	}
	
	public void getProjectAndEmployeeShiftTracking_For_ProjectManagerTest(){
		String project_Manager_IntranetId = "wangjianjun@qq.com";
		LinkedList<ViewOrientedEntity> viewOrientedEntity_List = projectAndEmployeeShiftTrackingGetService.getProjectAndEmployeeShiftTracking_For_ProjectManager(project_Manager_IntranetId);
	    for(int i = 0 ; i < viewOrientedEntity_List.size(); i++ ){
	    	System.out.println();
	    	System.out.print(viewOrientedEntity_List.get(i).getProject_Name()+"||");
	    	System.out.print(viewOrientedEntity_List.get(i).getProject_Manager_Name()+"||");
	    	System.out.print(viewOrientedEntity_List.get(i).getMemberName()+"||");
	    	System.out.print(viewOrientedEntity_List.get(i).getPeMNotesId()+"||");
	    	
	    	LinkedList<ProjectMemberDateShiftRecord> memberShiftRecord_List = viewOrientedEntity_List.get(i).getMemberShiftRecordList();
	    	for(int j = 0 ; j < memberShiftRecord_List.size(); j ++ ){
	    		System.out.print(memberShiftRecord_List.get(j).getYear() + "/");
	    		System.out.print(memberShiftRecord_List.get(j).getMonth() + "/");
	    		System.out.print(memberShiftRecord_List.get(j).getDay()+"--");
	    		System.out.print(memberShiftRecord_List.get(j).getShiftRecord());
	    		
	    	}
	    }
	    
	    
	    
	}
	


	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
