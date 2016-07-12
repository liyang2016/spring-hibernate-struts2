<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Employee List Page</h4>
	<s:debug></s:debug>
	<s:if test="#request.employees==null || #request.employees.size()==0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Birth</td>
				<td>CreateTime</td>
				<td>DepartmentID</td>
			</tr>
			<s:iterator value="#request.employees">
			<tr>
				<td>${id }</td>
				<td>${lastName }</td>
				<td>${email }</td>
				<td>${birth }</td>
				<td>${createTime }</td>
				<td>${department.departmentName }</td>
				<td><a href="emp-delete?id=${id }">delete</a></td>
			</tr>
			</s:iterator>
		</table>
	</s:else>
</body>
</html>