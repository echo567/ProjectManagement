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
<link rel="stylesheet" type="text/css" href="../static/layui/css/layui.css" />
</head>
<body>
	<form class="layui-form" action="<%=path%>/projectServlet?op=toAdd" method="post">
	  <div class="layui-form-item">
	    <label class="layui-form-label">项目名</label>
	    <div class="layui-input-block">
	      <input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入项目名" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	      <label class="layui-form-label">开始时间</label>
	      <div class="layui-input-inline">
	        <input type="text" name="startTime" id="date" lay-verify="required" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
	      </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">项目负责人</label>
	    <div class="layui-input-block">
	      <input type="text" name="user" lay-verify="required" placeholder="请输入项目负责人" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">项目简介</label>
	    <div class="layui-input-block">
	      <textarea placeholder="请输入项目简介" class="layui-textarea" name="introduction"></textarea>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
	    </div>
	  </div>
	  <c:if test="${msg != null }">
		<p style="color: red">${msg }</p>
		</c:if>
	</form>

<script src="../static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	layui.use(['form', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,laydate = layui.laydate;
	  
	  //日期
	  laydate.render({
	    elem: '#date'
	  });
	});
</script>
</body>
</html>