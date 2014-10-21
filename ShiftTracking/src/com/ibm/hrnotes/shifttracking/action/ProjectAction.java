package com.ibm.hrnotes.shifttracking.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.ibm.hrnotes.shifttracking.entites.Project;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ProjectAction extends ActionSupport implements RequestAware,
		Preparable, ModelDriven<Project> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4093816076913418777L;
	private Map<String, Object> request;
	private Project model;
	
	private String admins;
	
	
	@Override
	public Project getModel() {
		return model;
	}

	@Override
	public void prepare() throws Exception {
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
	
	public void preCreate() {
		model = new Project ();
	}

	public String create() {
		System.out.println(model);
		return null;
	}
	
	public String createPage () {
		return "project-create-page";
	}

	public String getAdmins() {
		return admins;
	}

	public void setAdmins(String admins) {
		this.admins = admins;
	}
	
	
}
