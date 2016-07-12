package com.leon.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.leon.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String delete(){
		employeeService.delete(id);
		return "delete";
	}
	
	public String list(){
		request.put("employees", employeeService.getAll());
		return "list";
	}

	private Map<String, Object> request;

	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
}
