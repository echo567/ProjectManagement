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
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
</head>
<body>
	<form action="<%=path%>/projectServlet?op=toUpdate&id=${p.id }"
		method="post">
		<table align="center" cellpadding="0">
			<input type="hidden" name="id" value="${p.id }">
			<div class="layui-form-item">
				<label class="layui-form-label">项目名</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="required"
						value="${p.name }" autocomplete="off" placeholder="${p.name }"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input type="text" name="startTime" id="date" lay-verify="required"
						placeholder="${p.startTime }" autocomplete="off"
						class="layui-input" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">项目负责人</label>
				<div class="layui-input-block">
					<input type="text" name="user" lay-verify="required"
						value="${p.user }" placeholder="${p.user }" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">项目简介</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入项目简介" class="layui-textarea"
						name="introduction">${p.introduction }</textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">修改</button>

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