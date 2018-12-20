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
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
</head>
<!-- <frameset rows="100px, " noresize="noresize">
	<frame src="header.jsp">
	<frameset cols="20%, ">

		<frame src="left.jsp">
		<frame name="show" src="right.jsp">
	</frameset>
</frameset> -->
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">项目管理系统</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><span>军辉</span></li>
				<li class="layui-nav-item"><a
					href="<%=path%>/userServlet?op=logout">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">

					<li class="layui-nav-item"><a href="javascript:;">修改个人资料</a>
						<dl class="layui-nav-child">
							<a href="javascript:;"
								data-options="{url:'<%=path%>/user/userUpdate.jsp',title:'修改个人资料' }">修改个人资料</a>


						</dl></li>

					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">项目管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;"
									data-options="{url:'<%=path%>/project/projectAdd.jsp',title:'添加项目'   }">添加项目</a>
							</dd>
							<dd>
								<a href="javascript:;"
									data-options="{url:'<%=path%>/project/projectSelect.jsp',title:'查找项目'   }">查找项目</a>
							</dd>
							<dd>
								<a href="javascript:;"
									data-options="{url:'<%=path%>/projectServlet?op=toList',title:'查看所有项目'   }">查看所有项目</a>
							</dd>
						</dl></li>


				</ul>
			</div>
		</div>

		<!--中间主体-->
		<div class="layui-body" id="container">
			<div class="layui-tab" lay-filter="tabs" lay-allowClose="true">
				<ul class="layui-tab-title">
					<li class="layui-this">首页</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">首页内容</div>
				</div>
			</div>
		</div>


		<div class="layui-footer">
			<!-- 底部固定区域 -->
			©项目管理系统by刘军辉，徐红，杜佳霖
		</div>
	</div>

	<script src="static/layui/layui.js" type="text/javascript"
		charset="utf-8"></script>
	<script>
		//JavaScript代码区域
		layui
				.use(
						[ 'element', 'jquery' ],
						function() {
							var element = layui.element, $ = layui.jquery;

							/*使用下面的方式需要引用jquery*/
							$('.layui-nav-child a')
									.click(
											function() {
												var options = eval('('
														+ $(this).data(
																'options')
														+ ')');
												var url = options.url;
												var title = options.title;
												element
														.tabAdd(
																'tabs',
																{
																	title : title,
																	content : '<iframe scrolling="auto" frameborder="0"  src="'
																			+ url
																			+ '" style="width:100%;min-height:500px;"></iframe>'
																});
											});
						});
	</script>


</body>
</html>