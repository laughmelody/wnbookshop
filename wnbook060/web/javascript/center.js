/*  ======= ���ﳵ����ʵ�� ===========*/
$(function() {
	// --------------  �˺Ű�ť  ------------------------------------hello

	$("#account-detail").click(function() {
		// ��ַ����
		$(".account-address").fadeOut(1).delay(500);

		$("#showAll").slideDown(600);
		// ѡ�б�ǩҳ
		$("#showAll ul li:first").addClass("active");
		$("#showAll ul li:first").siblings().removeClass("active");

		// ��ʾdiv
		$(".account-detail").fadeIn(1000);
	})

	// --------------  ��ַ��ť  ------------------------------------
	$("#account-address").click(function() {
		$("#showAll").slideDown(600);
		$("#showAll ul li:eq(1)").addClass("active");
		$("#showAll ul li:eq(1)").siblings().removeClass("active");
		// ��ʾdiv
		$(".account-detail").hide(1);
		$(".account-address").fadeIn(1000);
		//ajax����õ���ǰ�û��������ջ���ַ�������Ǹ���userIdȥ���ַ
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
				//�ж�Ĭ�ϵ�ַ��ѡ��
				$(".account-address input[type=checkbox]").each(function (index,obj){
					if (obj.getAttribute("data-index")==1){
						obj.checked=true;
					}
				})
			}
		})
	})

	// ��ͷ����js
	$(".account-img").click(function() {
		// jQuery������˼��
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
	})

	// tab������
	$(".nav-tabs li").click(function() {
		$(this).addClass("active");
		$(this).siblings().removeClass("active");

		let v = $(this).children("a").html();

		if (v == "�˺���Ϣ") {
			$(".account-detail").show();
			$(".account-address").hide();
			$(".account-newadd").hide();

		} else if (v == "�ջ���ַ") {
			$(".account-detail").hide();
			$(".account-address").show();
			$(".account-newadd").hide();
		} else if (v == "������ַ") {
			$(".account-detail").hide();
			$(".account-address").hide();
			$(".account-newadd").show();
		}
	})



	// ����ʡ�ݣ���json���ص�������
	$.getJSON("./javascript/region.json", function(arr) {
		for (p of arr) {
			let op = $(new Option(p.name));
			// 
			op.data("list", p.children);

			$("#province").append(op);
		}
	});

	// ���س��У����ı�ʡ�ݵ�ֵʱ���������г��ļ���
	$("#province").change(function() {
		let citys = $("#province option:selected").data('list');
		$("#city")[0].options.length = 1;
		// ʡ�ݸı��ʱ����������ҲҪ���
		$("#country")[0].options.length = 1;
		for (c of citys) {
			let op = $(new Option(c.name));
			op.data("list", c.children);
			$("#city").append(op);
		}
	})


		// $.getJSON("./javascript/region.json", function(arr) {
		// 	for (p of arr) {
		// 		// ��ǰѡ�е�ʡ�ݵ�code��p.codeƥ�䣬��ô�������������Ҫ�ҵ�����
		// 		if (v == p.code) {
		// 			let citys = p.children;
		// 			// ��ǰ��ĳ������������
		// 			$("#city")[0].options.length = 1;

		// 			for (c of citys) {
		// 				let op = new Option(c.name, c.code);
		// 				$("#city").append(op);
		// 			}
		// 		}
		// 	}
		// });

	// �������أ����ı���е�ֵʱ���������صļ���
	$("#city").change(function() {
		// �ȵõ���ǰ���е�ֵ��
		let countrys = $("#city option:selected").data("list");
		// ��ǰ����������������
		$("#country")[0].options.length = 1;

		for (cou of countrys) {
			let op = new Option(cou.name);
			$("#country").append(op);
		}
	})

		// $.getJSON("./javascript/region.json", function(arr) {
		// 	// ���ҵ�ʡ��
		// 	for (p of arr) {

		// 		let citys = p.children;
		// 		// �ٱ������еĺ��ӣ����أ�
		// 		for (c of citys) {

		// 			// ������ѡ�е�option��value�ͱ����ĳ���code��ͬ����������µĺ��Ӿ�������Ҫ���ص�����
		// 			if (c.code == v) {
		// 				let countrys = c.children;
		// 				// ��ǰ����������������
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

//�޸�ͷ��
function doEditImg() {
	let path = $(".img-box .active").children("img").prop("src");
	path = path.substring(path.indexOf("user"));
	console.log(path);
	let uid = $("#userId").val();
	location.href = "./user?op=doEditImg&id="+uid+"&address="+path;
}

//������ַ
function addressAdd(){
	let address = $("#province").val()+$("#city").val()+$("#country").val()+$("#addressdetail").val();
	let addtel = $("#addtel").val();
	let addreceiver = $("#addreceiver").val();

	location.href = "./address?op=add&address="+address+"&addtel="+addtel+"&addreceiver="+addreceiver;
}


