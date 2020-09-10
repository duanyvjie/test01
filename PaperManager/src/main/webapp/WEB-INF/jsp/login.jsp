<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录页</title>
    <style>
        h1{
            margin-top: 50px;
            text-align: center;
            font-size: 30px;
            font-weight: bolder;
        }
        #form{
            height: 250px;
            width: 400px;
            border: 1px solid #A5C4E0;
            margin: 0px auto;
            line-height:60px;
            padding-top: 40px;
            padding-left: 140px;
        }
        #submit{
            margin-left: 50px;
        }
        #reset{
            margin-left: 50px;
        }
    </style>
</head>
<body>
<h1>论文管理系统</h1>
<br>
<div id="form">
    <form action="${pageContext.request.contextPath }/dologin">
        用户名：<input type="text" name="userName" placeholder="请输入用户名"><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userPwd" placeholder="请输入密码"><br>
        <input id="submit" type="submit" value="登录">
        <input id="reset" type="reset" value="重置">
    </form>
</div>

</body>
</html>
