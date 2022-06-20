$(function() {

	// --------------  数量按钮  ------------------------------------
	// 加数量的按钮
	$(".glyphicon-plus").click(function() {
		//找到当前元素的兄弟input,并得到值
		let n = $(this).siblings("input").val();
		// 把值相加，并给其value 属性赋值
		$(this).siblings("input").val(parseInt(n) + 1);

	})

	// 减数量的按钮
	$(".glyphicon-minus").click(function() {
		//找到当前元素的兄弟input,并得到值
		let n = $(this).siblings("input").val();
		// 把值相减，并给其value 属性赋值
		if (n > 1) {
			$(this).siblings("input").val(parseInt(n) - 1);
		}
	})
})


function addToCart(){
	$.ajax({
		url:"./cart",
		data:{
			"op":"addToCart",
			"bookId":$("#bookId").val(),
			"buyCount":$("#buyCount").val()
		},
		type:"post",
		success:function (msg){
			if (msg=="ok"){
				alert("----添加进购物车成功---")
			}else {
				alert("---对不起，添加失败----")
			}
		}
	})
}