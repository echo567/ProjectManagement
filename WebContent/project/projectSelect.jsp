<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加项目</title>
</head>
<body>
	<form action="<%=path%>/projectServlet?op=toSelect" method="post">
		<table align="center" cellpadding="0">
			<tr>
				<td>请输入项目名称</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="查找"></td>
			</tr>




			<tr>
				<td colspan="2"><c:if test="${msg != null }">
						<p style="color: red">${msg }</p>
					</c:if></td>
			</tr>
		</table>
	</form>
	<c:if test="${p != null }">
		<table align="center" cellpadding="0" border="1">
			<tr>
				<th>项目id</th>
				<th>名称</th>
				<th>开始时间</th>
				<th>项目负责人</th>
				<th>项目简介</th>
				<th>操作</th>
			</tr>

			<tr>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.startTime }</td>
				<td>${p.user }</td>
				<td>${p.introduction }</td>
				<td><a
					href="<%=path%>/projectServlet?op=toUpdatePage&id=${p.id }">修改</a>
					<a href="<%=path%>/projectServlet?op=toDelete&id=${p.id }">删除</a></td>
			</tr>
		</table>
	</c:if>
</body>
</html>