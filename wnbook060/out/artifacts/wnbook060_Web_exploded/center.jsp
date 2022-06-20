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

		<link href="css/center.css" rel="stylesheet" />
		<script src="javascript/center.js"></script>

	</head>

	<body>
	<jsp:include page="top.jsp"/>
		<!-- ==================== 个人信息中心 ==================== -->
		<div class="container no-padding center">
			<div class="row">
				<div class="col-xs-3 no-padding">
					<div class="account-info">
						<img src="http://localhost/${loginUser.avatar}" alt="更换头像" data-toggle="modal" data-target="#myModal" />
						<p class="account">${loginUser.username}</p>
						<p>
							<a href="#" id="account-detail">账号信息</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="#" id="account-address">收货地址</a>
						</p>

						<div class="row member">
							<div class="col-xs-7 no-padding">
								<span>开通书城会员尊享</span>
								<span>全年360元运费礼券</span>
							</div>
							<div class="col-xs-5 no-padding">
								<a href="#">立即开通</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-9">
					<div class="order-title">我的订单：</div>
					<div class="order-option">
						<div class="col-xs-2 col-xs-offset-1">
							<div class="op">
								<span class="iconfont">&#xe644;</span>
								<a href='#'>待付款</a>
							</div>
						</div>
						<div class="col-xs-2">
							<div class="op">
								<span class="iconfont">&#xe771;</span>
								<a href='#'>待收货</a>
							</div>

						</div>
						<div class="col-xs-2">
							<div class="op">
								<span class="iconfont">&#xe605;</span>
								<a href='#'>待评价</a>
							</div>
						</div>
						<div class="col-xs-2">
							<div class="op">
								<span class="iconfont">&#xe699;</span>
								<a href='#'>退换/售后</a>
							</div>
						</div>
						<div class="col-xs-2">
							<div class="op">
								<span class="iconfont">&#xe737;</span>
								<a href='#'>全部订单</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- ========================= 详细信息显示位置 ========================== -->
		<div class="container no-padding center">
			<div id="showAll">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="#">账号信息</a></li>
					<li role="presentation" ><a href="#">收货地址</a></li>
					<li role="presentation" ><a href="#">新增地址</a></li>
				</ul>
				<!-- 账号详细信息 -->
				<div class="account-detail" style="display: none;">

					<form id="form-account-detail" class="form-horizontal mt15">
						<input id="userId" type="text" name="id" value="${loginUser.id}" hidden/>
						<div class="form-group">
							<label class="col-xs-2 control-label">账号:</label>
							<div class="col-xs-6">
								<input type="text" class="form-control" value="${loginUser.username}" disabled>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">手机:</label>
							<div class="col-xs-6">
								<input type="text" class="form-control" value="${loginUser.tel}" disabled>
							</div>

						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">密码:</label>
							<div class="col-xs-6">
								<input type="password" class="form-control" value="${loginUser.password}" disabled>
							</div>
							<button type="button" class="btn btn-default col-xs-1" data-toggle="modal" data-target="#modifyModal" onclick="readyCenterEdit(${loginUser.id})">修改</button>
						</div>
					</form>

				</div>

				<!-- 地址详细信息 -->
				<div class="account-address" style="display: none;">
					<table class="table table-striped">
						<tr>
							<td>默认</td>
							<td>收货人</td>
							<td>手机</td>
							<td>详细地址</td>
						</tr>

					</table>
				</div>


				<!-- 新增地址 -->
				<div class="account-newadd" style="display: none;">
					<form id="form-newadd" class="form-horizontal mt15">
						<div class="form-group">
							<label class="col-xs-2 col-xs-offset-1 control-label">收货人:</label>
							<div class="col-xs-6">
								<input id="addreceiver" type="text" class="form-control">
							</div>
						</div>

						<div class="form-group">
							<label class="col-xs-2 col-xs-offset-1 control-label">联系电话:</label>
							<div class="col-xs-6">
								<input id="addtel" type="text" class="form-control">
							</div>
						</div>

						<div class="form-inline">
							<label class="col-xs-2 col-xs-offset-1 control-label">收货地址:</label>
							<div class="col-xs-5">
								
								<select id="province" class="form-control">
									<option>请选择省份</option>
								</select>
								
								<select id="city" class="form-control">
									<option>请选择城市</option>
								</select>
								
								<select id="country" class="form-control">
									<option>请选择区县</option>
								</select>
							</div>
						</div>
						<div class="form-group"></div>
						
						<div class="form-group">
							<label class="col-xs-2 col-xs-offset-1 control-label">详细地址:</label>
							<div class="col-xs-6">
								<input id="addressdetail" type="text" class="form-control">
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-xs-3 col-xs-offset-3">
								<input id="addAddress" type="submit" class="btn btn-primary btn-block" onclick="addressAdd()">
							</div>

							<div class="col-xs-3">
								<input type="reset" class="btn btn-info btn-block">
							</div>
						</div>

					</form>

				</div>

			</div>
		</div>
		<!--修改个人信息模态框-->
	<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="myModifyModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModifyModalLabel">用户修改</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="myform">
					<input type="text" name="op" value="doEdit" hidden/>
					<div class="form-group">
						<label  class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"  name="username" id="username" readonly/>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">电话号码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="tel" id="tel"/>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="password" id="password"/>
						</div>
					</div>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
				<button type="button" class="btn btn-primary" onclick="doEdit()">确定修改</button>
			</div>
		</div>
	</div>
	</div>

		<!-- 修改头像模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
								aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-body">

						<div class="img-box">
							<div class="account-img col-xs-2 no-padding">
								<img src="http://localhost/user/01.jpg">
							</div>
							<div class="account-img col-xs-2 no-padding">
								<img src="http://localhost/user/02.jpg">
							</div>
							<div class="account-img col-xs-2 no-padding">
								<img src="http://localhost/user/03.jpg">
							</div>
							<div class="account-img col-xs-2 no-padding">
								<img src="http://localhost/user/04.jpg">
							</div>
							<div class="account-img col-xs-2 no-padding">
								<img src="http://localhost/user/05.jpg">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
						<button type="button" class="btn btn-default" onclick="doEditImg()">确定修改</button>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="foot.jsp"/>
	</body>
<script>

	//修改信息
	function doEdit(){
		$.ajax({
			url: "./user",
			data:{
				"op" : "centerEdit",
				"id": ${loginUser.id},
				// "username": $("#username").val(),
				"tel": $("#tel").val(),
				"password": $("#password").val()
			},
			type: "post",
			success: function (msg) {
				if (msg=="ok"){
					$("#myModal").modal('hide');
				}else {
					alert("对不起，修改失败");
				}

			}
		})
	}

	function readyCenterEdit() {
		$.ajax({
			url: "./user",
			data: {
				"op": "readyCenterEdit",
				"id": ${loginUser.id}
				// "username" : username
			},
			type: "get",
			dataType: "json",
			success: function (obj) {
				// $("#id").val(obj.id);
				$("#id").val(${loginUser.id});
				$("#username").val(obj.username);
				$("#tel").val(obj.tel);
				$("#password").val(obj.password);
				<%--$("#username").val(${loginUser.username});--%>
				<%--$("#tel").val(${loginUser.tel});--%>
				<%--$("#password").val(${loginUser.password});--%>

			}
		})
	}
</script>
</html>
