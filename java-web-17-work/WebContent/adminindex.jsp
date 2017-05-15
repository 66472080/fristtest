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
                <img src="./images/image-logo.png"/>
            </div>
            <div id="body">
                <div id="navigation">
                    <div id="inner">
                        <p>当前用户：<%=session.getAttribute("name") %></p>
                        <ul>
                            <li><a href="indexlogin" class="index">首&nbsp;&nbsp;&nbsp;&nbsp;页</a><li>
                            <li><a href="findItem" class="personal">查看题库</a><li>
                            <li><a href="updateItem" class="exam">编辑题库</a><li>
                            <li><a href="findUser" class="examlog">查看用户</a><li>
                            <li><a href="#" class="examlog">查看考试成绩</a><li>
                            <li><a href="out" class="logout">注&nbsp;&nbsp;&nbsp;&nbsp;销</a><li>
                        </ul>
                    </div>
                </div>
                <div id="content">
                    <div class="title" >
                        <p><img src="./images/66.jpg" style="height: 500px ;width: 800px"/></p>
                    </div>
                   
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>
