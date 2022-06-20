<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/31
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
<%--    <jsp:include page="top.jsp"/>--%>
    <meta charset="utf-8">
    <meta name="description" content="大学生就业实训,品质就业,职业规划,IT行业人才基地" />
    <title>蜗牛书城(woniuxy.com)-正品低价、品质保障、配送及时、轻松购物！222</title>

    <!-- 引入Bootstrap核心样式文件 -->
    <link href="bootstrap-3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="javascript/jQuery1.12.4.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>

    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

    <link href="css/common.css" rel="stylesheet" />

    <link href="css/index.css" rel="stylesheet" />
    <script src="javascript/index.js"></script>
</head>
<body>
<jsp:include page="top.jsp"/>


<!-- 搜索结果显示  -->
<div class="container no-padding mt15">
    <h4>好书热卖</h4>
    <div class="book-box">
        <div class="book-left fl">
            <img src="img/good-book.png" />
        </div>
        <div class="book-right">
            <ul >
                <c:forEach items="${pageInfo.list}" var="book">
                    <li>
                        <a href="id=${book.id}">
                            <img src="http://localhost/${book.bookImage}">
                            <p class="book-name">${book.bookName}</p>
                            <p class="book-price">￥${book.bookPrice}</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="container page">
    <c:if test="${pageInfo.pageNum==1}"><a class="col-xs-1 col-xs-offset-1">上一页</a></c:if>
    <c:if test="${pageInfo.pageNum>1}">
        <a class="col-xs-1 col-xs-offset-1" href="./book?op=doSearch&currentPage=${pageInfo.prePage}&pageSize=8&bookName=${keyWord}">上一页</a>
    </c:if>
    <span class="col-xs-1 col-xs-offset-2">总第${pageInfo.pages}页</span>
    <span class="col-xs-2 col-xs-offset-1">当前第${pageInfo.pageNum}页</span>
    <c:if test="${pageInfo.pageNum==pageInfo.pages}"><a class="col-xs-1 col-xs-offset-2">下一页</a> </c:if>
    <c:if test="${pageInfo.pageNum<pageInfo.pages}">
        <a class="col-xs-1 col-xs-offset-2" href="./book?op=doSearch&currentPage=${pageInfo.nextPage}&pageSize=8&bookName=${keyWord}">下一页</a>
    </c:if>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>

