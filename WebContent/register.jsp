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
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="static/css/login.css" />
</head>
<body>
<div class="m-login-bg">
    <div class="m-login">
        <img src="static/images/dog.png" alt="">
        <div class="m-login-warp">
            <form class="layui-form" action="<%=path%>/userServlet?op=toRegister" name="form1" method="post">
                <h3>影票购物系统注册</h3>
                <div class="layui-form-item">
                    <input type="text" name="name" required lay-verify="required" placeholder="名称"
                           autocomplete="off"
                           class="layui-input">
                </div>
                <div class="layui-form-item">
                    <input type="password" name="password" required lay-verify="required" placeholder="密码"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item m-login-btn">
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="register">注册</button>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-primary">
                            <a href="login.jsp"> 去登录</a>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <p class="copyright">&copy;Copyright 影票购物系统 by 刘军辉、徐红、杜佳霖、叶耿</p>
    </div>
</div>
<script src="static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	
	
	
	<script language="javascript">
		function closeOpen() {
			window.returnValue = false;
			window.close();
		}
		function check1() {
			if (document.form1.loginname.value == "") {
				alert("请输入用户名");
				return false;
			}
			if (document.form1.loginpw.value == "") {
				alert("请输入密码");
				return false;
			}
			if (document.form1.loginpw.value != document.form1.loginpw1.value) {
				alert("两次密码不一致");
				return false;
			}
			document.form1.submit();
		}
	</script>

</body>
</html>