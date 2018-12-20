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
<title>项目列表</title>
</head>
<body>

	<table align="center" cellpadding="0" border="1">
		<tr>
			<th>项目id</th>
			<th>名称</th>
			<th>开始时间</th>
			<th>项目负责人</th>
			<th>项目简介</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="p">
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
		</c:forEach>





	</table>

</body>
</html>