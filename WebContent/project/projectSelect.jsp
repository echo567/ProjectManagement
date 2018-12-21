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
<link rel="stylesheet" type="text/css"
	href="../static/layui/css/layui.css" />
</head>
<body>
	<form action="<%=path%>/projectServlet?op=toSelect" method="post">

		<div class="layui-form-item">
			<label class="layui-form-label">项目名称：</label>
			<div class="layui-input-inline">
				<input type="text" name="name" lay-verify="required"
					autocomplete="off" placeholder="请输入项目名称" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">查找</button>
			</div>
		</div>
		<c:if test="${msg != null }">
			<p style="color: red">${msg }</p>
		</c:if>
	</form>

	<c:if test="${p != null }">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="200">
				<col width="200">
				<col width="200">
				<col width="200">
			</colgroup>
			<tr>
				<th>项目id</th>
				<th>名称</th>
				<th>开始时间</th>
				<th>项目负责人</th>
				<th>项目简介</th>
				<th>操作</th>
			</tr>

			<tr align="center">
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
	<script src="static/layui/layui.js" type="text/javascript"
		charset="utf-8"></script>
</body>
</html>