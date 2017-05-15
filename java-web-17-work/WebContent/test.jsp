<%@page import="com.lanou.entity.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页面模板</title>
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
						<li><a href="indexlogin" class="index">首&nbsp;&nbsp;&nbsp;&nbsp;页</a>
						<li>
						<li><a href="findItem" class="personal">查看题库</a>
						<li>
						<li><a href="updateItem" class="exam">编辑题库</a>
						<li>
						<li><a href="#" class="examlog">查看用户</a>
						<li>
						<li><a href="#" class="examlog">查看考试成绩</a>
						<li>
						<li><a href="out" class="logout">注&nbsp;&nbsp;&nbsp;&nbsp;销</a>
						<li>
					</ul>
				</div>
			</div>
			<div id="content">
				<div class="title">
					<p>
						<img src="./images/icon-title.jpg" /> 题库
					</p>
				</div>
				<div class="main">
					<h2>
						<img src="./images/icon-modifyInfo.jpg" /> 题库列表
					</h2>

					<table width="50%" cellspacing="6">
						<% List<Item> li=( List<Item>) request.getAttribute("list"); %>
						<% for (Item item : li) {
					%>
						
						<tr>
							<td align="right" width="46%">
							题号:<input type="text" name="tiem.id" value="666"  >
							
							题目:<input type="text" name="item.qusetion">
							</td>
						</tr>						
						<tr>
							<td align="right">
							选项A:<input type="text"  name="item.option_a">
							</td>
						</tr>
						<tr>
							<td align="right">
							选项B:<input type="text"  name="item.option_b">
							</td>
						</tr>
						<tr>
							<td align="right">
							选项C:<input type="text" name="item.option_c">
							</td>
						</tr>
						<tr>
							<td align="right">
							选项D:<input type="text"  name="item.option_d">
							</td>
						</tr>
						<tr>
							<td align="right">
							正确答案:<input type="text" name="item.answer">
							</td>
						</tr>
						<tr>
							<td align="right">								
								<input  type="submit"  value= "修改" />														
							</td>
							<td>
							<input  type="reset"  value= "重置" />
							</td>						
						</tr>
						
						<%} %>
					</table>
				</div>

			</div>
			<!--content-->
		</div>
		<!--body-->
	</div>
</body>
</html>