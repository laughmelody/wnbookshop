/*  ======= 购物车功能实现 ===========*/
$(function() {

	// --------------  数量按钮  ------------------------------------
	// 加数量的按钮
	$(".glyphicon-plus").click(function() {
		//找到当前元素的兄弟input,并得到值
		let n = $(this).siblings("input").val();
		// 把值相加，并给其value 属性赋值
		$(this).siblings("input").val(parseInt(n) + 1);

		// 通过单价和数量 计算 当前一行的总价 ==============
		//   找到 price 和 book-total
		//console.log("---"+$(this).parent().parent().prev().html()+"---");
		// 这是前一个，单价
		let price = parseFloat($(this).parents("td").prev().html());
		// 现在的个数
		n = $(this).siblings("input").val();

		let bookPrice = n * price;
		// 这是后一个，这行的总价,把给果赋值过来        保留两位小数
		$(this).parents("td").next().html(bookPrice.toFixed(2));
		
		// 购物车总价：
		totalPrice();
		
	})

	// 减数量的按钮
	$(".glyphicon-minus").click(function() {
		//找到当前元素的兄弟input,并得到值
		let n = $(this).siblings("input").val();
		// 把值相减，并给其value 属性赋值
		if (n > 1) {
			$(this).siblings("input").val(parseInt(n) - 1);
		}

		// 通过单价和数量 计算 当前一行的总价 ==============
		//   找到 price 和 book-total
		//console.log("---"+$(this).parent().parent().prev().html()+"---");
		// 这是前一个，单价
		let price = parseFloat($(this).parents("td").prev().html());
		// 现在的个数
		n = $(this).siblings("input").val();

		let bookPrice = n * price;
		// 这是后一个，这行的总价,把给果赋值过来        保留两位小数
		$(this).parents("td").next().html(bookPrice.toFixed(2));
		
		// 购物车总价：
		totalPrice();
	})
	
	
	// 1: 全选框功能
	$(".all").change(function() {
		// 设置其它的小的商品的选择框和 .all 保持一致
		$(".goods").prop("checked", $(this).prop('checked'));
		
		// 选中的数量
		choicNum();
		
		// 购物车总价：
		totalPrice();
	})
	
	// 2: 小商品选择框的功能
	// 使用 :checked 来过滤 .goods .如果选出来的元素个数达到了3个，那么全选框应该被选中，否则反之
	$(".goods").change(function() {
	
		if ($(".goods:checked").length == $(".goods").length) {
			$(".all").prop("checked", true);
		} else {
			$(".all").prop("checked", false);
		}
		
		choicNum();
		
		// 购物车总价：
		totalPrice();
	})
	
	// 删除行
	$(".remove").click(function(){
		$(this).parents("tr").remove();
		// 删除行后，被选中的数量也要有变量
		choicNum();
		
		// 购物车总价：
		totalPrice();
	});
})

// 选中的数量 
function choicNum(){
	$(".choic-num").html($(".goods:checked").length);
}

// 购物车的总价计算
function totalPrice(){
	let total = 0;
	$(".goods:checked").parents("tr").find("td:eq(5)").each(function(index, obj){
		total += parseFloat(obj.innerText);
	})
	
	$(".total").html(total.toFixed(2));
}


//--- 结算（提交定单）---------
function toOrder(){
	// 得到所有的先中的id
	let ids = "";
	$(".goods:checked").each(function(index, obj){
		ids += "&id="+obj.value;
		
	})
	let totalPrice = $(".total").html().trim();
	let path ="./cart?op=findByIds&totalPrice="+totalPrice+ids;
	console.log(path);
	 location.href=path;
	// console.log(ids.substring(0,ids.length-1));
	
}

