<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/27
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String loginName =(String)session.getAttribute("loginName");
    if (loginName==null){
        out.write("<script>alert('对不起，请先登录');location.href='back-login.jsp'</script>");
    }
%>
</body>
</html>
