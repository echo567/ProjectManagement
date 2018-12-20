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
<title>登录页面</title>
</head>
<body>
	<form action="<%=path%>/userServlet?op=toLogin" method="post">
		<table align="center" cellpadding="0">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td><a href="register.jsp">注册</a></td>
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