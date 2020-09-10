<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
</head>
<body>
<header class="publicHeader">
    <h1>论文管理系统</h1>
    <div class="publicHeaderR">
        <p><span>欢迎您！</span><span style="color: #fff21b"> ${userSession.userName }</span> </p>
        <a href="${pageContext.request.contextPath }/doLogout" >注销</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">

<div class="left">
    <div id="function">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul>
                <li><a href="#">用户管理</a> </li>
                <li><a href="${pageContext.request.contextPath }/paper/getPaperList">论文管理</a> </li>
                <li><a href="#">公共代码</a> </li>
                <li><a href="${pageContext.request.contextPath }/doLogout">退出系统</a> </li>
            </ul>
        </nav>
    </div>
</div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
