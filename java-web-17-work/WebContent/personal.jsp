<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link href="./css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main_page">
		<div id="header">
			<img src="./images/image-logo.png" />
		</div>
		<div id="body">
			<div id="navigation">
				<div id="inner">
					<p>
						当前用户：
						<%=session.getAttribute("name")%></p>
					<ul>
						<li><a href="user_index" class="index">首&nbsp;&nbsp;&nbsp;&nbsp;页</a>
						<li>
						<li><a href="user_personal" class="personal">个人信息</a>
						<li>
						<li><a href="item_exam" class="exam">参加考试</a>
						<li>
						<li><a href="user_examlog" class="examlog">考试记录</a>
						<li>
						<li><a href="user_d" class="logout">注&nbsp;&nbsp;&nbsp;&nbsp;销</a>
						<li>
					</ul>
				</div>
			</div>
			<form action="user_personal" method="post">
				<div id="user_update">
					<div class="title">
						<p>
							<img src="./images/icon-title.jpg" /> 个 人 资 料
						</p>
					</div>
					<div class="main">
						<h2>
							<img src="./images/icon-modifyInfo.jpg" /> 用户信息
						</h2>
						<table width="50%" cellspacing="6">
							<tr>
								<td align="right" width="46%">用 户 名：</td>
								<td width="54%"><%=session.getAttribute("name")%></td>
							</tr>
							<tr>
								<td align="right">真实姓名：</td>
								<td><%=session.getAttribute("name")%></td>
							</tr>
							<tr>
								<td align="right">身份证号：</td>
								<td><%=session.getAttribute("idnumber")%></td>
							</tr>
							<tr>
								<td align="right">联系电话：</td>
								<td ><%=session.getAttribute("telno")%></td>
							</tr>
							<tr>
								<td><input class="" type="submit" name="" value="确认"  /></td>
							</tr>
						</table>
					</div>
				</div>
				<!--content-->
			</form>
			
			<form action="user_update" method="post" align="left">
				<!-- 点击跳转到修改页面 -->
				<input type="submit" value="修改" />
			</form>
			
		</div>
		<!--body-->
	</div>
</body>
</html>