<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<link href="./css/style.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#0591C2">
	<div id="login">
		<div class="main_body">
			<div class="left">
				<img src="./images/image-login-left.jpg" />
			</div>
			<div class="right">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户登录系统</h2>
				<form action="loginin" method="post">
					<input type="submit" value="管理员登陆">
				</form>
				<form action="user_loginnn" method="post">
					<input type="submit" value="学生登陆">
				</form>
			</div>
		</div>
	</div>
</body>
</html>