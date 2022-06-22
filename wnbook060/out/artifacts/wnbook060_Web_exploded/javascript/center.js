/*  ======= 购物车功能实现 ===========*/
$(function() {
	// --------------  账号按钮  ------------------------------------hello

	$("#account-detail").click(function() {
		// 地址隐藏
		$(".account-address").fadeOut(1).delay(500);

		$("#showAll").slideDown(600);
		// 选中标签页
		$("#showAll ul li:first").addClass("active");
		$("#showAll ul li:first").siblings().removeClass("active");

		// 显示div
		$(".account-detail").fadeIn(1000);
	})

	// --------------  地址按钮  ------------------------------------
	$("#account-address").click(function() {
		$("#showAll").slideDown(600);
		$("#showAll ul li:eq(1)").addClass("active");
		$("#showAll ul li:eq(1)").siblings().removeClass("active");
		// 显示div
		$(".account-detail").hide(1);
		$(".account-address").fadeIn(1000);
		//ajax请求得到当前用户的所有收货地址，本质是根据userId去查地址
		console.log("---------test--------------")
		$.ajax({
			url:"./address",
			type:"get",
			data:{
				"op":"searchByUserId",
				"userid":$("#userId").val()
			},
			dataType:"json",
			success:function (arr){
				console.log(arr);
				for (address of arr){
					$(".account-address tbody").append(`
						<tr>
							<td>
								<input type="checkbox" data-index=${address.isDefault}/>
							</td>
							<td>${address.receiver}</td>
							<td>${address.tel}</td>
							<td>${address.detailAddress}</td>
						</tr>
					`)
				}
				//判断默认地址勾选中
				$(".account-address input[type=checkbox]").each(function (index,obj){
					if (obj.getAttribute("data-index")==1){
						obj.checked=true;
					}
				})
			}
		})
	})

	// 给头像框加js
	$(".account-img").click(function() {
		// jQuery的排他思想
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
	})

	// tab栏功能
	$(".nav-tabs li").click(function() {
		$(this).addClass("active");
		$(this).siblings().removeClass("active");

		let v = $(this).children("a").html();

		if (v == "账号信息") {
			$(".account-detail").show();
			$(".account-address").hide();
			$(".account-newadd").hide();

		} else if (v == "收货地址") {
			$(".account-detail").hide();
			$(".account-address").show();
			$(".account-newadd").hide();
		} else if (v == "新增地址") {
			$(".account-detail").hide();
			$(".account-address").hide();
			$(".account-newadd").show();
		}
	})



	// 加载省份：从json加载地区数据
	$.getJSON("./javascript/region.json", function(arr) {
		for (p of arr) {
			let op = $(new Option(p.name));
			// 
			op.data("list", p.children);

			$("#province").append(op);
		}
	});

	// 加载城市：当改变省份的值时，触发城市场的加载
	$("#province").change(function() {
		let citys = $("#province option:selected").data('list');
		$("#city")[0].options.length = 1;
		// 省份改变的时候，区县数据也要清除
		$("#country")[0].options.length = 1;
		for (c of citys) {
			let op = $(new Option(c.name));
			op.data("list", c.children);
			$("#city").append(op);
		}
	})


		// $.getJSON("./javascript/region.json", function(arr) {
		// 	for (p of arr) {
		// 		// 当前选中的省份的code和p.code匹配，那么，这个就是我们要找的数据
		// 		if (v == p.code) {
		// 			let citys = p.children;
		// 			// 把前面的城市数据先清空
		// 			$("#city")[0].options.length = 1;

		// 			for (c of citys) {
		// 				let op = new Option(c.name, c.code);
		// 				$("#city").append(op);
		// 			}
		// 		}
		// 	}
		// });

	// 加载区县：当改变城市的值时，触发区县的加载
	$("#city").change(function() {
		// 先得到当前城市的值；
		let countrys = $("#city option:selected").data("list");
		// 把前面的区县数据先清空
		$("#country")[0].options.length = 1;

		for (cou of countrys) {
			let op = new Option(cou.name);
			$("#country").append(op);
		}
	})

		// $.getJSON("./javascript/region.json", function(arr) {
		// 	// 先找到省份
		// 	for (p of arr) {

		// 		let citys = p.children;
		// 		// 再遍历城市的孩子（区县）
		// 		for (c of citys) {

		// 			// 当我们选中的option的value和遍历的城市code相同，这个城市下的孩子就是我们要加载的数据
		// 			if (c.code == v) {
		// 				let countrys = c.children;
		// 				// 把前面的区县数据先清空
		// 				$("#country")[0].options.length = 1;

		// 				for (cou of countrys) {
		// 					let op = new Option(cou.name, cou.code);
		// 					$("#country").append(op);
		// 				}
		// 			}

		// 		}
		// 	}
		// });


})

//修改头像
function doEditImg() {
	let path = $(".img-box .active").children("img").prop("src");
	path = path.substring(path.indexOf("user"));
	console.log(path);
	let uid = $("#userId").val();
	location.href = "./user?op=doEditImg&id="+uid+"&address="+path;
}

//新增地址
function addressAdd(){
	let address = $("#province").val()+$("#city").val()+$("#country").val()+$("#addressdetail").val();
	let addtel = $("#addtel").val();
	let addreceiver = $("#addreceiver").val();

	location.href = "./address?op=add&address="+address+"&addtel="+addtel+"&addreceiver="+addreceiver;
}


