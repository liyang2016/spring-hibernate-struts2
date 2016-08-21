package com.leon.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.leon.ssh.entities.Employee;
import com.leon.ssh.service.DepartmentService;
import com.leon.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {

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

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	private String lastName;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String validateName() {
		if (employeeService.lastNameIsValid(lastName)) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return "ajax-success";
	}
	
	/*
	*  控制器
	*/
	public String delete() {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ajax-success";
	}

	public String list() {
		request.put("employees", employeeService.getAll());
		return "list";
	}

	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String input() {
		request.put("departments", departmentService.getAll());
		return "input";
	}

	private Map<String, Object> request;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String save() {
		model.setCreateTime(new Date());
		employeeService.saveOrUpdate(model);
		return "success";
	}

	public void prepareSave() {
		model = new Employee();
	}

	public void prepare() throws Exception {
	}

	private Employee model;

	public Employee getModel() {
		return model;
	}

}
