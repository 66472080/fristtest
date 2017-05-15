<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<h1>注册页面</h1>
<form action="user_register" method="post">
用&nbsp;&nbsp;户&nbsp;名：<input type="text" name="user.username" ><br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="user.password" ><br>
密码确认：<input type="text" name="user.pass" ><br>
真实姓名：<input type="text" name="user.name" ><br>
身份证号：<input type="text" name="user.idnumber" ><br>
联系电话：<input type="text" name="user.telno" ><br>
<input type="submit" value="确定">
<input type="reset" value="清除">
</form>

</body>
</html>