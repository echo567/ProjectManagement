<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>修改个人资料</h4>
	<ul>
		<li><a href="<%=path%>/user/userUpdate.jsp" target="show">修改个人资料</a></li>
	</ul>
	<h4>项目管理</h4>
	<ul>
		<li><a href="<%=path%>/project/projectAdd.jsp" target="show">添加项目</a></li>
		<li><a href="<%=path%>/project/projectSelect.jsp" target="show">查找项目</a></li>
		<li><a href="<%=path%>/projectServlet?op=toList" target="show">查看所有项目</a></li>
	</ul>
</body>
</html>