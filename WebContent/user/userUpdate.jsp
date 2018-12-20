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
<title>修改用户资料</title>
<link rel="stylesheet" type="text/css"
	href="../static/layui/css/layui.css" />

</head>
<body>
	<form action="<%=path%>/userServlet?op=toUpdate&id=${user.userId }"
		method="post">

		<input type="hidden" name="userId" value="${user.userId }" />
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" name="userName" lay-verify="required"
					autocomplete="off" placeholder="${user.userName }"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="text" name="userPassword" lay-verify="required"
					autocomplete="off" placeholder="******" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
			</div>
		</div>


		<tr>
			<td colspan="2"><c:if test="${msg != null }">
					<p style="color: red">${msg }</p>
				</c:if></td>
		</tr>
		</table>
	</form>
</body>
</html>