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
<title>index页面</title>
</head>
<frameset rows="100px, " noresize="noresize">
	<frame src="header.jsp">
	<frameset cols="20%, ">

		<frame src="left.jsp">
		<frame name="show" src="right.jsp">
	</frameset>
</frameset>



</html>