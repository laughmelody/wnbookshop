<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/31
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="cate-menu container no-padding clear">
    <ul class="fl">
        <li><a href="#">程序设计</a></li>
        <li><a href="#">数据库</a></li>
        <li><a href="#">网络与数据通信</a></li>
        <li><a href="#">科普读物</a></li>
        <li><a href="#">建筑学</a></li>
    </ul>
    <!-- bootstrap轮播图 -->
    <div id="carousel-example-generic" class="carousel slide fl" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/banner1.jpeg" alt="...">
            </div>
            <div class="item">
                <img src="img/banner2.jpeg" alt="...">
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<!-- 中间的广告 -->
<div class="container no-padding mt15">
    <div class="f clear">
        <div class="ad-box fl">
            <div class="left fl">
                <p><a href="#">古典小说系列</a></p>
                <p><a href="#">九折优惠</a></p>
            </div>
            <div class="right fl">
                <a href="#">
                    <img src="img/ad1.jpeg" />
                </a>
            </div>
        </div>

        <div class="ad-box fl">
            <div class="left fl">
                <p><a href="#">古典小说系列</a></p>
                <p><a href="#">九折优惠</a></p>
            </div>
            <div class="right fl">
                <a href="#">
                    <img src="img/ad2.jpeg" />
                </a>
            </div>
        </div>

        <div class="ad-box fl">
            <div class="left fl">
                <p><a href="#">古典小说系列</a></p>
                <p><a href="#">九折优惠</a></p>
            </div>
            <div class="right fl">
                <a href="#">
                    <img src="img/ad3.jpeg" />
                </a>
            </div>
        </div>

    </div>
</div>

<!-- 好书热卖  -->
<div class="container no-padding mt15">
    <h4>好书热卖</h4>
    <div class="book-box">
        <div class="book-left fl">
            <img src="img/good-book.png" />
        </div>
        <div class="book-right">
            <ul id="hotBook">
            </ul>
        </div>
    </div>
</div>

<!-- 新书推荐  -->
<div class="container no-padding mt15">
    <h4>新书推荐</h4>
    <div class="book-box">
        <div class="book-left fl">
            <img src="img/new-book.png" />
        </div>
        <div class="book-right">
            <ul id="newBook">

            </ul>
        </div>
    </div>
</div>

<!-- 收藏最多  -->
<div class="container no-padding mt15">
    <h4>收藏最多</h4>
    <div class="book-box">
        <div class="book-left fl">
            <img src="img/collect-book.png" />
        </div>
        <div class="book-right">
            <ul id="collBook">

            </ul>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>

