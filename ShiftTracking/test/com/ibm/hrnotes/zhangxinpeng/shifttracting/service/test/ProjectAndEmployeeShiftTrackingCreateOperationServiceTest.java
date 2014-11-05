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
import com.ibm.hrnotes.shifttracking.service.ProjectAndEmployeeShiftTrackingService;

public class ProjectAndEmployeeShiftTrackingCreateOperationServiceTest {
    public static ProjectAndEmployeeShiftTrackingService projectAndEmployeeShiftTrackingService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try{
			BeanFactory beanFactory   =   new   ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-DatabaseOperation.xml"); 

			projectAndEmployeeShiftTrackingService = (ProjectAndEmployeeShiftTrackingService)beanFactory.getBean("ProjectAndEmployeeShiftTrackingService");
		    
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
		
		createProjectTest();
		createEmployeeTest();
		createNewMemberForProjectTest();
		createNewProjectForEmployeeTest();
		createShiftTrackingTest();
		
		
		
		
	}
	
	public void createProjectTest(){
	
		Project_Entity project_Entity = new Project_Entity();
		project_Entity.setProjectId("project_01");
		project_Entity.setProjectName("HR-Help");
		project_Entity.setManagerId("wangjianjun@qq.com");
		project_Entity.setProjectAdminId("tangyukang@qq.com");
		project_Entity.setAMId("shujun@qq.com");
		boolean result = projectAndEmployeeShiftTrackingService.createProject(project_Entity);
	    System.out.println(result);
	    
	    
	    Project_Entity project_Entity1 = new Project_Entity();
		project_Entity1.setProjectId("project_02");
		project_Entity1.setProjectName("One-Help");
		project_Entity1.setManagerId("hello@qq.com");
		project_Entity1.setProjectAdminId("tangyukang@qq.com");
		project_Entity1.setAMId("shujun@qq.com");
		boolean result1 = projectAndEmployeeShiftTrackingService.createProject(project_Entity1);
	    System.out.println(result1);
	    
	    
	    
	    
	}
	
	public void createEmployeeTest(){
		Employee_Entity employee_Entity = new Employee_Entity();
		employee_Entity.setIntranetId("zhangxinpeng@qq.com");
		employee_Entity.setNotesId("Xin Peng Zhang/China");
		employee_Entity.setName("Zhang Xin Peng");
		employee_Entity.setPeMIntranetId("qiuchenghong@qq.com");
		boolean result = projectAndEmployeeShiftTrackingService.createEmployee(employee_Entity);
	    System.out.println(result);
	    
	    
	    Employee_Entity employee_Entity1 = new Employee_Entity();
		employee_Entity1.setIntranetId("chengxiao@qq.com");
		employee_Entity1.setNotesId("Xiao Cheng/China");
		employee_Entity1.setName("Cheng Xiao");
		employee_Entity1.setPeMIntranetId("zhangxuntao@qq.com");
		boolean result1 = projectAndEmployeeShiftTrackingService.createEmployee(employee_Entity1);
	    System.out.println(result1);
	    
	    Employee_Entity employee_Entity2 = new Employee_Entity();
		employee_Entity2.setIntranetId("qiuchenghong@qq.com");
		employee_Entity2.setNotesId("Qiu Cheng Hong/China");
		employee_Entity2.setName("Qiu Cheng Hong");
		employee_Entity2.setPeMIntranetId("HIGH POSITION/China");
		boolean result2 = projectAndEmployeeShiftTrackingService.createEmployee(employee_Entity2);
	    System.out.println(result2);
	    
	    Employee_Entity employee_Entity3 = new Employee_Entity();
		employee_Entity3.setIntranetId("wangjianjun@qq.com");
		employee_Entity3.setNotesId("Jian Jun Wang/China");
		employee_Entity3.setName("Wang Jian Jun");
		employee_Entity3.setPeMIntranetId("shujun@qq.com");
		boolean result3 = projectAndEmployeeShiftTrackingService.createEmployee(employee_Entity3);
	    System.out.println(result3);
	    
	    Employee_Entity employee_Entity4 = new Employee_Entity();
		employee_Entity4.setIntranetId("shujun@qq.com");
		employee_Entity4.setNotesId("Shu Jun/China");
		employee_Entity4.setName("Shu Jun");
		employee_Entity4.setPeMIntranetId("wangguohua@qq.com");
		boolean result4 = projectAndEmployeeShiftTrackingService.createEmployee(employee_Entity4);
	    System.out.println(result4);
	    
	    Employee_Entity employee_Entity5 = new Employee_Entity();
		employee_Entity5.setIntranetId("zhangxuntao@qq.com");
		employee_Entity5.setNotesId("Zhang Xun Tao/China");
		employee_Entity5.setName("Zhang Xun Tao");
		employee_Entity5.setPeMIntranetId("wangguohua@qq.com");
		boolean result5 = projectAndEmployeeShiftTrackingService.createEmployee(employee_Entity5);
	    System.out.println(result5);
	    
	    
	    
	}
	
	public void createShiftTrackingTest(){
		LinkedList<ProjectMemberDateShiftRecord> projectMemberDateShiftRecord_List = new LinkedList<ProjectMemberDateShiftRecord>();
		ProjectMemberDateShiftRecord ProjectMemberDateShiftRecord = new ProjectMemberDateShiftRecord();
		ProjectMemberDateShiftRecord.setProjectId("project_01");
		ProjectMemberDateShiftRecord.setMemberId("zhangxinpeng@qq.com");
		ProjectMemberDateShiftRecord.setYear("2014");
		ProjectMemberDateShiftRecord.setMonth("12");
		ProjectMemberDateShiftRecord.setDay("21");
		ProjectMemberDateShiftRecord.setShiftRecord("1Shift");
		projectMemberDateShiftRecord_List.add(ProjectMemberDateShiftRecord);
		
		ProjectMemberDateShiftRecord ProjectMemberDateShiftRecord1 = new ProjectMemberDateShiftRecord();
		ProjectMemberDateShiftRecord1.setProjectId("project_01");
		ProjectMemberDateShiftRecord1.setMemberId("chengxiao@qq.com");
		ProjectMemberDateShiftRecord1.setYear("2014");
		ProjectMemberDateShiftRecord1.setMonth("10");
		ProjectMemberDateShiftRecord1.setDay("11");
		ProjectMemberDateShiftRecord1.setShiftRecord("2shift");
		projectMemberDateShiftRecord_List.add(ProjectMemberDateShiftRecord1);
		
		ProjectMemberDateShiftRecord ProjectMemberDateShiftRecord2 = new ProjectMemberDateShiftRecord();
		ProjectMemberDateShiftRecord2.setProjectId("project_02");
		ProjectMemberDateShiftRecord2.setMemberId("chengxiao@qq.com");
		ProjectMemberDateShiftRecord2.setYear("2014");
		ProjectMemberDateShiftRecord2.setMonth("12");
		ProjectMemberDateShiftRecord2.setDay("06");
		ProjectMemberDateShiftRecord2.setShiftRecord("1shift");
		projectMemberDateShiftRecord_List.add(ProjectMemberDateShiftRecord2);
		
		boolean result = projectAndEmployeeShiftTrackingService.createShiftTracking(projectMemberDateShiftRecord_List);
	    System.out.println(result);
	}
	
	public void createNewMemberForProjectTest(){
		Project_Member project_Member = new Project_Member();
		project_Member.setMemberId("zhangxinpeng@qq.com");
		project_Member.setProjectId("project_01");
		boolean result = projectAndEmployeeShiftTrackingService.createNewMemberForProject(project_Member);
	    System.out.println(result);
	    
	    Project_Member project_Member1 = new Project_Member();
		project_Member1.setMemberId("chengxiao@qq.com");
		project_Member1.setProjectId("project_01");
		boolean result1 = projectAndEmployeeShiftTrackingService.createNewMemberForProject(project_Member1);
	    System.out.println(result1);
	}
	
	public void createNewProjectForEmployeeTest(){
		Project_Member project_Member = new Project_Member();
		project_Member.setMemberId("chengxiao@qq.com");
		project_Member.setProjectId("project_02");
		boolean result = projectAndEmployeeShiftTrackingService.createNewProjectForEmployee(project_Member);
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
