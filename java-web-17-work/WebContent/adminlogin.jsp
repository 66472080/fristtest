<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>登录页面模板</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body bgcolor="#0591C2" >
        <div id="login">
            <div class="main_body">
                <div class="left">
                    <img src="./images/image-login-left.jpg"/>
                </div>
                <div class="right">
                    <center><img src="./images/image-adminlogin.jpg" /></center>
                    <form action="login" method="post">
                        用 户 名： <input type="text" name="admin.adminName" /><br/>
                        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
                        <input type="text" name="admin.adminPwd" /><br/>
                        <!-- 验 证 码： <input type="text" name="" size="6"/> 
                        <img src="./images/image-validcode.jpg" border="1" /><br/>
                        <p> -->
                            <input type="submit"  value="登&nbsp;&nbsp;录" />
                            
                            
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>