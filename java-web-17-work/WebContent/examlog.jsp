<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录</title>
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
					<p>当前用户： <%=session.getAttribute("name") %></p>
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
           <h1>考试记录界面</h1>
           <h2> 姓名:<%=session.getAttribute("name") %></h2>
           <h2> 本次考试成绩为:<%=session.getAttribute("f") %>分</h2>
          







		</div>
		<!--body-->
	</div>
</body>
</html>