package com.ibm.hrnotes.shifttracking.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ibm.hrnotes.shifttracking.entites.*;
import com.ibm.hrnotes.shifttracking.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {

	private EmployeeService employeeService;
	// I am not xiao huan xiong!
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6840700037768314074L;
	private Map<String, Object> request;
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String login () {
		return "login";
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}

