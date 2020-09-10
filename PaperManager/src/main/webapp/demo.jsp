<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/9
  Time: 10:01
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
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-container">
    <form action="${pageContext.request.contextPath }/dologin">
        用户名：<input class="layui-input" type="text" name="userName" placeholder="请输入用户名"><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;码：<input class="layui-input" type="password" name="userPwd" placeholder="请输入密码"><br>
        <input class="layui-form-" id="submit" type="submit" value="登录">
        <input id="reset" type="reset" value="重置">
    </form>
</div>
<script src="layui/layui.all.js"></script>
<script>
    //由于模块都一次性加载，因此不用执行 layui.use() 来加载对应模块，直接使用即可：
    ;!function(){
        var layer = layui.layer
            ,form = layui.form;

        layer.msg('Hello World');
    }();
    console.dir(layer)
</script>
</body>
</html>
