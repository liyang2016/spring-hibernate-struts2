package com.leon.ssh.dao;

import java.util.List;

import com.leon.ssh.entities.Department;

public class DepartmentDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public List<Department> getAll(){
		String hql="FROM Department";
		return getSession().createQuery(hql).list();
	}
}
