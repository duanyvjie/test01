<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/head.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>论文管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/paper/getPaperList">
            <input type="text" value="${paper.id}" hidden>
            论文主题:<input type="text" name="title" class="input-text" value="${paper.title}">
            论文类型:
            <select name="type">
                <%--<c:if test="${codeList != null }">
                    <option value="0">--请选择--</option>
                    <c:forEach var="code" items="${codeList}">
                        <option
                                <c:if test="${code.id == type }">selected="selected"</c:if>
                                value="${code.id}">${code.codeName}</option>
                    </c:forEach>
                </c:if>--%>
                <option value="0">--请选择--</option>
                <option value="1">应用型</option>
                <option value="2">理论型</option>
            </select>
            <input type="hidden" name="pageIndex" value="1"/>
            <input type="submit" value="查询" id="searchbutton">
            <a id="add" href="${pageContext.request.contextPath }/paper/toadd">添加论文</a>
        </form>

    </div>

    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">论文主题</th>
            <th width="10%">作者</th>
            <th width="20%">论文类型</th>
            <th width="20%">发表时间</th>
            <th width="20%">修改时间</th>
        </tr>
        <c:forEach var="paper" items="${paperList }" varStatus="status">

            <tr>
                <td width="10%">
                    <span>${paper.title }</span>
                </td>
                <td width="10%">
                    <span>${paper.author }</span>
                </td>

                <td width="20%">
                    <span>${paper.type}</span>
                </td>
                <td width="20%">
                    <span><fmt:formatDate value="${paper.creationDate}"></fmt:formatDate></span>
                </td>
                <td width="20%">
                    <span><fmt:formatDate value="${paper.modifyDate}"></fmt:formatDate></span>
                </td>
                <td>
                        <%--<span><a class="modifyUser" href="javascript:;" userid=${paper.id } username=${paper.title  }><img
                                src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改"
                                title="修改"/></a></span>--%>
                            <span><a class="modifyUser" href="javascript:;" id=${paper.id } username=${paper.title }><img
                                    src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改"
                                    title="修改"/></a></span>
                            <span><a class="deleteUser" href="javascript:;" id=${paper.id } username=${paper.title }><img
                                    src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
    </c:import>
</div>
</section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>


