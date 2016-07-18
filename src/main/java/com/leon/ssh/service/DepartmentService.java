package com.leon.ssh.service;

import java.util.List;

import com.leon.ssh.dao.DepartmentDao;
import com.leon.ssh.entities.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
}
