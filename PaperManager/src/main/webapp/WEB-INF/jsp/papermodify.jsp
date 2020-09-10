<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/9
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/head.jsp" %>


<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>论文修改页面</span>
    </div>
    <div>
        <form id="paperForm" modelAttribute="paper" method="post" enctype="multipart/form-data"
              action="${pageContext.request.contextPath }/paper/modify">

            <input type="text" name="id" value="${paper.id}" hidden>
            论文题目：<input type="text" name="title" id="title" value="${paper.title}"><br>
            类型：
            <select name="type" id="type">


                    <c:if test="${paper.type eq 1 }">
                        <option value="1" selected="selected">应用型</option>
                        <option value="2">理论型</option>
                    </c:if>
                <c:if test="${paper.type eq 2 }">
                        <option value="1" >应用型</option>
                        <option value="2" selected="selected">理论型</option>
                </c:if>

            </select><br>
            论文摘要：<textarea name="paperSummary" id="paperSummary" >${paper.paperSummary}</textarea><br>
            <%--论文内容：<input type="file" id="paperPath" name="paperPath" value="${paper.paperPath}"><br>--%>
            <input type="submit" value="保存">
            <input type="button" id="back" onclick="back()" value="返回">
        </form>
    </div>
</div>

</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
