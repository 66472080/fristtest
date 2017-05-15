<%@page import="com.lanou.entity.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试页面</title>
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
			<form action="item_xuan" method="post" style="text-align: left;">
				<table width="50%" cellspacing="6">
					<%
						List<Item> li = (List<Item>) request.getAttribute("list");
						int it = 1;
					%>
					<%
						for (Item item : li) {
					%>
					<tr>
						<%=item.getId()%>
						<%=item.getQusetion()%>
						<td><input style="display: none" name="daan<%=it%>"
							type="text" value="<%=item.getAnswer()%>" /><br></td>
					</tr>


					<tr>
						<td><input name="<%=it%>" type="radio" value="A" /><%=item.getOption_a()%>
							<br></td>
					</tr>
					<tr>
						<td><input name="<%=it%>" type="radio" value="B" /><%=item.getOption_b()%>
							<br></td>
					</tr>
					<tr>
						<td><input name="<%=it%>" type="radio" value="C" /><%=item.getOption_c()%>
							<br></td>
					</tr>
					<tr>
						<td><input name="<%=it%>" type="radio" value="D" /><%=item.getOption_d()%>
							<br></td>
					</tr>
					<%
						it++;
						}
					%>
					<tr>
						<td>
							<center>
								<input type="submit" value="提交">
							</center>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!--body-->
	</div>
</body>
</html>