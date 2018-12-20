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
</head>
<body>
	<form action="<%=path%>/userServlet?op=toRegister" name="form1"
		method="post">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#CCCCCC">
			<tr>
				<th height="40" colspan="2" bgcolor="#FFFFFF" class="f12b-red"
					style="font-size: 11px;">用 户 注 册</th>
			</tr>
			<tr>
				<td width="20%" height="30" align="right" bgcolor="#F9F9F9"
					style="font-size: 11px;">用户名：</td>
				<td width="80%" bgcolor="#FFFFFF">&nbsp; <input type="text"
					name="name" id="loginname" />
				</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#F9F9F9"
					style="font-size: 11px;">密 码：</td>
				<td bgcolor="#FFFFFF">&nbsp; <input type="password"
					name="password" />
				</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#F9F9F9"
					style="font-size: 11px;">确认密 码：</td>
				<td bgcolor="#FFFFFF">&nbsp; <input type="password"
					name="password1" />
				</td>
			</tr>

			<tr>
				<td height="30" align="right" bgcolor="#F9F9F9">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp; <!-- <input type="button" value="确定" onclick="check1();"/> -->
					<input type="submit" value="确定" /> <input type="button" value="取消"
					onclick="closeOpen()" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${msg != null }">
						<p style="color: red">${msg }</p>
					</c:if></td>
			</tr>
		</table>
	</form>
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