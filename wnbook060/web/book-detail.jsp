<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/26
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="description" content="大学生就业实训,品质就业,职业规划,IT行业人才基地" />
		<title>蜗牛书城(woniuxy.com)-正品低价、品质保障、配送及时、轻松购物！</title>

		<link rel="stylesheet" href="bootstrap-3.4.1/css/bootstrap.min.css"/>
		<script src="javascript/jQuery1.12.4.js"></script>
		<script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>

		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		<link href="css/common.css" rel="stylesheet" />
		<link href="css/top.css" rel="stylesheet" />
		<link href="css/foot.css" rel="stylesheet" />

		<link href="css/book-detail.css" rel="stylesheet" />
		<script src="javascript/book-detail.js"></script>

	</head>

	<body>
	<jsp:include page="top.jsp"/>
		<!-- ==================== 书籍详情页 ==================== -->

	<div class="container no-padding book-detail-bg">
	</div>

	<div class="index mt50">
		<div class="container no-padding">
			<a href="index.html">首 页</a>
		</div>
	</div>

	<!-- 书本详情 -->
	<div class="container no-padding">
		<div class="book-img fl">
			<img src="./img/01.jpg" />
		</div>

		<div class="book-info fl">
			<input type="text" id="bookId" value="${book.id}" hidden/>
			<p id="bookName" class="book-name">${book.bookName}</p>
			<p class="book-price mt50">价格 :<font color="red">￥</font><span id="bookPrice">${book.bookPrice}</span> </p>
			<p id="bookCollect" class="book-collect mt50">收藏 : ${book.bookCollectionCount}</p>

			<div class="book-count mt50 form-inline">
				购买数量 :
				<div class="input-group">
					<span class="input-group-addon glyphicon glyphicon-minus"></span>
					<input id="buyCount" type="text" class="form-control" maxlength="3" value="1" >
					<span class="input-group-addon glyphicon glyphicon-plus"></span>
				</div>
				库存量 : <span>99</span>
			</div>

			<div class="btn-box mt50">
				<a href="#" onclick="addToCart()">添加购物车</a>
				<a>立即购买</a>
			</div>

		</div>
	</div>

	<jsp:include page="foot.jsp"/>
	</body>

</html>
