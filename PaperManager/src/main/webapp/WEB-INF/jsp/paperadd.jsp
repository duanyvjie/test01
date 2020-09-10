<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/9
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/head.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>论文发表页面</span>
    </div>
    <div class="providerAdd">
        <fm:form id="userForm" modelAttribute="paper" method="post" enctype="multipart/form-data"
              action="${pageContext.request.contextPath }/paper/add">

            <div>
                <label for="title">论文题目：</label>
                <fm:input path="title" type="text" name="title" id="title" value=""/>
                <!-- 放置提示信息 -->
                <font color="red"></font><fm:errors path="title"/>
            </div>

            <div>
                <label >类型：</label>
                <fm:select path="type" name="type" id="type">
                    <option value="1" selected="selected">应用型</option>
                    <option value="2">理论型</option>
                </fm:select><fm:errors path="type"/>
            </div>

            <div>
                <label for="title">论文摘要：</label>
                <fm:textarea path="paperSummary" name="paperSummary" id="paperSummary"></fm:textarea>
                <!-- 放置提示信息 -->
                <font color="red"></font><fm:errors path="paperSummary"/>
            </div>

            <div>
                <label for="paperPath1">论文内容：</label>
                <input type="file" name="paperPath1" id="paperPath1"  value=""/>
                <font color="red"></font>
            </div>

            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存" >
                <input type="button" id="back" name="back" value="返回" >
            </div>

        </fm:form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
