<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//1.点击delete时弹出确定是要删除信息吗？
		$(".delete").click(function(){
			var lastName=$(this).next(":input").val();
			var flag=confirm("确定需要删除"+lastName+"的信息吗？");
			if(flag){
				var $tr=$(this).parent().parent();
				//删除，使用ajax的方法
				var url=this.href;
				alert(url);
				var args={"time":new Date()};
				$.post(url,args,function(data){
					//若data的返回值为1，则提示删除成功
					if(data=="1"){
						alert("删除成功！");
						$tr.remove();
					}else{
						alert("删除失败！");
					}
				});
			}
			return false;
		});
	})
</script>
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
				<td>DepartmentName </td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td>
						<s:date name="birth" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${department.departmentName }</td>
					<td>
						<a href="emp-delete?id=${id }" class="delete">delete</a>
						<input type="hidden" value="${lastName }">
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
</body>
</html>