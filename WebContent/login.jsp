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
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="static/css/login.css" />
</head>
<body>
	<div class="m-login-bg">
		<div class="m-login">
			<img src="static/images/dog.png" alt="">
			<div class="m-login-warp">
				<form class="layui-form" action="<%=path%>/userServlet?op=toLogin"
					method="post">
					<h3>项目管理系统</h3>

					<div class="layui-form-item">
						<input type="text" name="name" required lay-verify="required"
							placeholder="用户名" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-item">
						<input type="password" name="password" required
							lay-verify="required" placeholder="密码" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-item m-login-btn">
						<div class="layui-inline">
							<button class="layui-btn layui-btn-normal" lay-submit
								lay-filter="login">登录</button>
						</div>
						<div class="layui-inline">
							<button type="reset" class="layui-btn layui-btn-primary">
								<a href="register.jsp">去注册</a>
							</button>
						</div>
					</div>
					<c:if test="${msg != null }">
						<p style="color: red; text-align: center;">${msg }</p>
					</c:if>
				</form>
			</div>
			<p class="copyright">&copy;Copyright 项目管理系统 by 刘军辉、徐红、杜佳霖</p>
		</div>
	</div>
	<script src="static/layui/layui.js" type="text/javascript"
		charset="utf-8"></script>
</body>
</html>