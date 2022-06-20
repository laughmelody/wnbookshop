<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<%
    String loginName = (String)session.getAttribute("loginName");

%>

<body>
<h3>你好,${loginAdmin.username}</h3>
<h3>您的联系方式,${loginAdmin.tel}</h3>

<c:if test="${empty lastTime}">
    <h3>这是第一次登录</h3>
</c:if>
<c:if test="${!empty lastTime}">
    <h3>上次登录的时间是:${lastTime}</h3>
</c:if>
<h3>上一次登录的时间是:${lastTime}</h3>
</body>
</html>
