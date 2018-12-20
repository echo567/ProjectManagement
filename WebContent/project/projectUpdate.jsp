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
	<form action="<%=path%>/projectServlet?op=toUpdate&id=${p.id }"
		method="post">
		<table align="center" cellpadding="0">
			<input type="hidden" name="id" value="${p.id }">
			<tr>
				<td>项目名</td>
				<td><input type="text" name="name" value="${p.name }" /></td>
			</tr>
			<tr>
				<td>开始时间(不准修改)</td>
				<td><input type="text" name="startTime" value="${p.startTime }"
					readonly></td>
			</tr>
			<tr>
				<td>项目负责人</td>
				<td><input type="text" name="user" value="${p.user }" /></td>
			</tr>
			<tr>
				<td>项目简介</td>
				<td><textarea rows="5" cols="10" name="introduction">${p.introduction }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"></td>

			</tr>
			<tr>
				<td colspan="2"><c:if test="${msg != null }">
						<p style="color: red">${msg }</p>
					</c:if></td>
			</tr>
		</table>
	</form>
</body>
</html>