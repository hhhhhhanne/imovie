<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div class="loginframe">
		<div class="loginpic">
			<img src="static/img/loginpic.jpg">
		</div>
		<form class="loginin" action="logon.action" method="post">
			<div class="loginline">
				<s:label for="username">用户</s:label>
				<s:textfield name="Username" id="username" placeholder="用户名" />
				<p id="usernamemsg"></p>
			</div>
			<div class="loginline">
				<s:label for="password">密码</s:label>
				<s:password name="Password" id="password" placeholder="输入密码" />
				<p id="passwordmsg"></p>
			</div>
			<div class="loginline">
				<s:checkbox name="rememberme" id="rememberme" />
				<s:label for="Rememberme">记住我</s:label>
			</div>
			<s:submit value="登录" id="login" />
			<s:div class="loginmsg"> ${message}</s:div>
		</form>
	</div>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript">
		document.getElementById('login').onclick = function() {
			var username = document.getElementById('username');
			var password = document.getElementById('password');
			var usermsg = document.getElementById('usernamemsg');
			var pwdmsg = document.getElementById('passwordmsg');
			// init
			usermsg.innerHTML = "";
			pwdmsg.innerHTML = "";
			if (username.value == "") {
				//alert('username is empty!');
				usermsg.innerHTML = '用户名不能为空!';
				return false;
			} else if (password.value == "") {
				//alert('password is empty!');
				pwdmsg.innerHTML = '密码不能为空!';
				return false;
			}
		};
	</script>
</body>
</html>
