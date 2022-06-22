<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/31
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<!-- 引入Bootstrap核心样式文件 -->
<link href="bootstrap-3.4.1/css/bootstrap.min.css" rel="stylesheet">
<!-- 引入jQuery核心js文件 -->
<script src="javascript/jQuery1.12.4.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>
<link href="css/common.css" rel="stylesheet" />
<link href="css/top.css" rel="stylesheet" />
<body>

<!--  最顶部的导航栏 -->
<div class="top-nav">
    <div class="container">
        <div>
            <span class="location-top fl iconfont mr5">&#xe60b;</span>
            <span class="fl mr420">上海</span>
        </div>
        <ul>
            <li><a href="./cart?op=findByUid">我的购物车</a></li>
            <li class="spacer">|</li>
            <li><a href="#">我的订单</a></li>
            <li class="spacer">|</li>
            <li>
                <c:if test="${empty loginUser}">
                    <a href="login.jsp">你好，请登录</a>
                </c:if>
                <c:if test="${!empty loginUser}">
                    你好:<span style="color: red" onclick="toCenter()">${loginUser.username}</span>
                </c:if>



                &nbsp;&nbsp;
                <a class="free-login">免费注册</a>
            </li>
        </ul>
    </div>
</div>

<!--  =================== head =============================== -->
<div class="head">
    <div class="container">
        <!-- ============= logo ============= -->
        <div class="logo fl">
            <h1>
                <a class="hot-word">蜗牛学苑</a>
            </h1>
        </div>
        <!-- ============= 搜索框部份 ============= -->
        <div class="search fl ml100">
            <div class="up">
                <div class="search-box fl mr18">
                    <input id="keyWord" class="fl" type="text" placeholder="请输入搜索关键字" value="${keyWord}"/>
                    <span class="photo">&#xe663;</span>
                    <span class="search-icon fl" onclick="doSearch()">&#xe660;</span>
                </div>

                <div class="cart fl">
                    <span class="iconfont">&#xe622;</span>
                    <a href="./cart?op=findByUid">我的购物车</a>
                    <i class="num" onmouseover="getTotQuan(this)">
                    0
                    </i>
                </div>
            </div>

            <div class="navitems">
                <ol>
                    <li><a class="red-and-weight" href="#">秒杀</a></li>
                    <li><a class="red-and-weight" href="#">优惠券</a></li>
                    <li><a href="#">程序设计</a></li>
                    <li><a href="#">数据库</a></li>
                    <li><a href="#">网络与数据通信</a></li>
                    <li><a href="#">科普读物</a></li>
                    <li><a href="#">建筑学</a></li>
                </ol>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    function doSearch(){
        location.href="./book?op=doSearch&currentPage=1&pageSize=8&bookName="+$("#keyWord").val();
    }
    function toCenter(){
        location.href="./center.jsp"
    }

    function getTotQuan(obj){
        $.ajax({
            url: "./cart",
            data:{
                "op" : "findCartCount",
                "id": ${loginUser.id},
                // "username": $("#username").val(),
            },
            type: "get",
            success: function (msg) {
                obj.innerHTML=msg;

            }
        })
    }
    <%--function  getNum(state){--%>
    <%--    ${loginUser.userId}--%>

    <%--}--%>

</script>
</html>
