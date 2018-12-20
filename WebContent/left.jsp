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
	<h5>项目管理</h5>
	<ul>
		<li><a href="<%=path%>/project/projectAdd.jsp" target="show">添加项目</a></li>
		<li><a href="<%=path%>/projectServlet?op=toList" target="show">查看所有项目</a></li>

	</ul>
</body>
</html>