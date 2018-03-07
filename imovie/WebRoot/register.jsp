<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div class="loginframe">
		<form class="registerin" action="register.action" method="post">
			<div class="registerline">
				<s:label for="username">用户名<small>*</small>
				</s:label>
				<div class="registerbox">
					<s:textfield name="Username" />
					<span id="usernamemsg"></span>
				</div>
			</div>
			<div class="registerline">
				<s:label for="password">登录密码<small>*</small>
				</s:label>
				<div class="registerbox">
					<s:password name="Password" />
					<span id="pwdmsg"></span>
				</div>
			</div>
			<div class="registerline">
				<s:label for="again">确认密码<small>*</small>
				</s:label>
				<div class="registerbox">
					<s:password name="Again" />
					<span id="againmsg"></span>
				</div>
			</div>
			<div class="registerline">
				<s:label for="mobile">联系电话</s:label>
				<div class="registerbox">
					<s:textfield name="Mobile" />
					<span id="mobilemsg"></span>
				</div>
			</div>
			<div class="registerline">
				<s:label for="email">电子邮箱</s:label>
				<div class="registerbox">
					<s:textfield name="Email" />
					<span id="emailmsg"></span>
				</div>
			</div>
			<div class="registerline">
				<s:label for="address">送货地址</s:label>
				<div class="registerbox">
					<s:textfield name="Address" />
					<span id="addressmsg"></span>
				</div>
			</div>
			<s:submit value="注册" id="register" />
			<s:div class="loginmsg"> ${message}</s:div>
		</form>
	</div>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var username = $('#Username');
							var pwd = $('#Password');
							var again = $('#Again');
							var mobile = $('#Mobile');
							var mail = $('#Email');
							var address = $('#Address');

							username.blur(function() {
								if (username.val() == "") {
									$('#usernamemsg').text("用户名不能为空");
								} else {
									$('#usernamemsg').text("");
								}
							});

							pwd.blur(function() {
								var reg = /[^\d]/g;
								if (pwd.val().length < 6) {
									$('#pwdmsg').text("密码不足6位");
								} else if (!reg.test(pwd.val())) {
									$('#pwdmsg').text("缺英文字母");
								} else {
									$('#pwdmsg').text("");
								}
							});

							again.blur(function() {
								if (pwd.val() != again.val()) {
									$('#againmsg').text("确认密码不匹配");
								} else {
									$('#againmsg').text("");
								}
							});

							mobile
									.blur(function() {
										var reg = /^((\d{3}-\d{8}|\d{4}-\d{7,8})|(1[3|5|7|8][0-9]{9}))$/;
										if (!reg.test(mobile.val())
												&& mobile.val() != "") {
											$('#mobilemsg').text("请输入正确的手机号");
										} else {
											$('#mobilemsg').text("");
										}
									});

							mail
									.blur(function() {
										var reg = /^(\.|[a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
										if (!reg.test(mail.val())
												&& mail.val() != "") {
											$('#emailmsg').text("邮箱格式错误");
										} else {
											$('#emailmsg').text("");
										}
									});

							address.blur(function() {
								if (address.val().length > 100) {
									$('#addressmsg').text("地址过长");
								} else {
									$('#addressmsg').text("");
								}
							});

							$('#register')
									.on(
											'click',
											function() {
												if (username.val() == "") {
													$('#usernamemsg').text(
															"用户名不能为空");
													return false;
												}
												if (pwd.val() == "") {
													$('#pwdmsg').text("密码不能为空");
													return false;
												}
												if (again.val() == "") {
													$('#againmsg').text(
															"确认密码不能为空");
													return false;
												}
												if ($('#mobilemsg').text() != ""
														|| $('#address').text() != ""
														|| $('#emailmsg')
																.text() != "") {

													return false;
												}
											})
						});
	</script>
</body>
</html>
