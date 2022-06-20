<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="大学生就业实训,品质就业,职业规划,IT行业人才基地" />
    <title>蜗牛书城(woniuxy.com)-正品低价、品质保障、配送及时、轻松购物！</title>

    <!-- 引入Bootstrap核心样式文件 -->
    <link href="bootstrap-3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="javascript/jQuery1.12.4.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <link href="css/common.css" rel="stylesheet" />
    <link href="css/top.css" rel="stylesheet" />
    <link href="css/foot.css" rel="stylesheet" />

    <link href="css/cart.css" rel="stylesheet" />

    <script src="javascript/cart-2.js"></script>

</head>

<body>
<jsp:include page="top.jsp"/>
<!-- ==================== 购物车 ==================== -->
<div class="container no-padding book-detail-bg">
</div>

<div class="index mt50">
    <div class="container no-padding">
        <span class="cart-name">我的购物车</span>
    </div>
</div>

<div class="container no-padding">

    <table class="table mt10">
        <tr>
            <td>
                <div class="checkbox">
                    <label>
                        <input class="all" type="checkbox"> 全选
                    </label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    书籍封面
                </div>
            </td>
            <td>
                <div class="checkbox">
                    书籍名称
                </div>
            </td>
            <td>
                <div class="checkbox">
                    单价
                </div>
            </td>
            <td>
                <div class="checkbox">
                    数量
                </div>
            </td>
            <td>
                <div class="checkbox">
                    小计
                </div>
            </td>
            <td>
                <div class="checkbox">
                    操作
                </div>
            </td>
        </tr>
        <c:forEach items="${list}" var="cart">
        <tr>
            <td>
                <input  class="goods" type="checkbox" id="cartId" value="${cart.cartId}">
            </td>
            <td>
                <img src="http://localhost/${cart.bookImage}" />
            </td>
            <td>
                    ${cart.bookName}
            </td>
            <td class="price">
                    ${cart.bookPrice}
            </td>
            <td>
                <div class="input-group">
                    <span class="input-group-addon glyphicon glyphicon-minus"></span>
                    <input type="text" class="form-control buy-count" maxlength="3" value="${cart.buyCount}" >
                    <span class="input-group-addon glyphicon glyphicon-plus"></span>
                </div>
            </td>
            <td class="total-price">
                    ${cart.bookPrice * cart.buyCount}
            </td>
            <td>
                <a class="btn btn-danger remove">删除</a>
            </td>
        </tr>

        </c:forEach>
        <tr id="last-tr">
            <td colspan="7" class="no-padding">

                <a href="#">继续购物</a>
                |
                已选择 <span class="choic-num">0</span> 件
                |
                <a href="#">删除所选项</a>


                <a href="#" class="buy btn btn-danger fr ml10" onclick="toOrder()">
                    下单
                </a>
                <span class="fr ">合计 : <i class="total">0</i> 元</span>

            </td>
        </tr>

    </table>

</div>

<jsp:include page="foot.jsp"/>
</body>

</html>
