<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/6/16
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
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


    <link rel="shortcut icon" href="favicon.ico" />
    <link href="css/common.css" rel="stylesheet" />
    <link href="css/top.css" rel="stylesheet" />
    <link href="css/foot.css" rel="stylesheet" />

    <!-- 订单页和购物车类似，所以需要购物车的样式 -->
    <link href="css/cart.css" rel="stylesheet" />
    <link href="css/order.css" rel="stylesheet" />

</head>

<body>

<jsp:include page="top.jsp"/>

<!-- ==================== 订单页 ==================== -->
<div class="container no-padding book-detail-bg">
</div>

<div class="index mt50">
    <div class="container no-padding">
        <span class="cart-name">订单结算页：</span>
    </div>
</div>

<div class="container no-padding">
    <input type="text" id="orderNum" value="${order.orderNum}"/>
    <div class="address">
        <p>收货人信息：</p>

        <c:forEach items="${list}" var="add">
            <div class="user-address">
                <c:if test="${add.id == order.addressId}">
                    <span class="user active">${add.receiver}</span>
                </c:if>
                <c:if test="${add.id != order.addressId}">
                    <span class="user">${add.receiver}</span>
                </c:if>
                    <span class="address-detail">${add.detailAddress}</span>
            </div>
        </c:forEach>



    </div>


    <table class="table mt10">
        <tr>
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
        </tr>
        <c:forEach items="${order.list}" var="detail">
        <tr>
            <td>
                <img src="http://localhost/${detail.bookImage}" />
            </td>
            <td>
                ${detail.bookName}
            </td>
            <td>
						<span class="book-price">
							${detail.bookPrice}
						</span>
            </td>
            <td>
						<span class="book-num">
							${detail.buyCount}
						</span>
            </td>
            <td>
						<span class="book-total">
							${detail.total}
						</span>
            </td>
        </tr>
        </c:forEach>
        <tr id="last-tr">
            <td colspan="7" class="no-padding">

                <a href="#" class="buy btn btn-danger fr ml10" onclick="pay()">
                    去付款
                </a>
                <span class="fr ">合计 : <i class="total">${order.totalPrice}</i> 元</span>

            </td>
        </tr>

    </table>

</div>

<jsp:include page="foot.jsp"/>
</body>

<script>
    function pay(){
        location.href="./pay?WIDout_trade_no=${order.orderNum}&WIDtotal_amount=${order.totalPrice}&WIDsubject=PayBooks&WIDbody=hello";
    }


    $(".address .user").click(function (){
        $(".user").removeClass("active")
        $(this).addClass("active");
    })



    var prices ="";
    $(".book-price").each(function(index, dom){
        prices += dom.innerText+" ";
    })
    var arr = prices.split(" ");

    for(i of arr){
        console.log(i);
    }

</script>


</html>

