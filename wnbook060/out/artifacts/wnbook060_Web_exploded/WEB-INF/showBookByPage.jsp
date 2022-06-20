<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/6/2
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show book by page</title>
</head>
<!-- 引入Bootstrap核心样式文件 -->
<link href="./bootstrap-3.4.1/css/bootstrap.min.css" rel="stylesheet">
<!-- 引入jQuery核心js文件 -->
<script src="./javascript/jQuery1.12.4.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="./bootstrap-3.4.1/js/bootstrap.min.js"></script>

<link href="./bootstrap-table/bootstrap-table.css" rel="stylesheet">
<script src="./bootstrap-table/bootstrap-table.js"></script>
<script src="./bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>

<link rel="stylesheet" href="./bootstrap-timepicker/css/bootstrap-datetimepicker.css">
<script src="./bootstrap-timepicker/js/bootstrap-datetimepicker.js"></script>
<%--<script src="./bootstrap-timepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>--%>
<%--<script src="./bootstrap-timepicker/js/locales/bootstrap-datetimepicker.bn.js"></script>--%>
<body onload="loadCategory()">

<!--搜索框-->
<form class="form-inline">
    <div class="form-group">
        <label>书籍名</label>
        <input type="text" class="form-control" id="s_bookName" placeholder="请输入要搜索的书名">
    </div>
    <div class="form-group">
        <label >书的售价</label>
        <input type="email" class="form-control" id="s_bookPrice" placeholder="请输入价格">
    </div>
    <div class="form-group">
        <label >书的类别</label>
        <select id="s_category" class="form-control">
            <option value="0">请选择类别</option>
        </select>
    </div>
    <button type="button" class="btn btn-primary" onclick="doSearch()">确定搜索</button>
</form>

<!--修改用模态框-->
<table id="mytable"></table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">书籍修改</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" id="myform">

                    <input type="text" name="op" value="doEdit" hidden/>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">书籍ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="bookId" ID="bookId" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">书籍名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookName" id="bookName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">价格:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookPrice" id="bookPrice"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">类别</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="categoryId" id="cate">
                                <option value="0">请选择目录</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">作者</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookAuthor" id="bookAuthor"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">封面</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookImage" id="bookImage"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">发行时间</label>
                        <div class="col-sm-8 input-group date form_datetime"
                            data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="dtp_input1"
                        style="...">
                            <input class="form-control" size="14" type="text" name="bookPublishDate" id="bookPublishDate" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">发行商</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookPublish" id="bookPublish"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">库存</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookStoreCount" id="bookStoreCount"/>
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

<!--增加用模态框-->
<table id="addtable"></table>

<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addModalLabel">书籍新增</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" id="addform">

                    <input type="text" name="op" value="doAdd" hidden/>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">书籍ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="bookId" ID="addbookId" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">书籍名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookName" id="addbookName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">价格:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookPrice" id="addbookPrice"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">类别</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="categoryId" id="addcate">
                                <option value="0">请选择目录</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">作者</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookAuthor" id="addbookAuthor"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">封面</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookImage" id="addbookImage"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">发行时间</label>
                        <div class="col-sm-8 input-group date form_datetime"
                             data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="dtp_input1"
                             style="...">
                            <input class="form-control" size="14" type="text" name="bookPublishDate" id="addbookPublishDate" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">发行商</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookPublish" id="addbookPublish"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">库存</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="bookStoreCount" id="addbookStoreCount"/>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
                <button type="button" class="btn btn-primary" onclick="doAdd()">确定新增</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    $(function (){
        console.log("---换一种对象的方式加载表格----")
        //从一开始就加载表格里的数据
        new TableInit().init();
    })


    //写一个表格的构造方法 从该分页方法上下文中可查 修改queryparams参数时添加 参考文档cnblogs.com/landeanfen/p/4976838.html
    var TableInit = function (){
        let obj = new Object();
        obj.init = function (){
            $('#mytable').bootstrapTable({
                url: './book',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                // toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                // sortable: false,                     //是否启用排序
                // sortOrder: "asc",                   //排序方式
                queryParams: obj.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [5, 10, 15,25,35,50, 100],        //可供选择的每页的行数（*）
                // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                //strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                //detailView: false,                   //是否显示父子表
                columns: [{
                    checkbox: true
                }, {
                    field: 'id',
                    title: '书籍ID'
                }, {
                    field: 'bookName',
                    title: '书籍名'
                }, {
                    field: 'bookPrice',
                    title: '书籍价格'
                }, {
                    field: 'bookAuthor',
                    title: '作者'
                }, {
                    field: 'bookPublishDate',
                    title: '发行日期',
                    formatter:mydate
                }, {
                    field: 'cate.typeName',
                    title: '所属目录'
                }, {
                    field: 'id',
                    title: '操作',
                    formatter:actionOp
                },{
                    field: 'add',
                    title: '新增',
                    formatter:addop
                }]
            });
        }
        //多条件搜索
        obj.queryParams = function(params){
            //这里写需要的参数
            let temp={
                "op":"showByPage" ,
                limit : params.limit,
                offset:params.offset,
                "bookName":$("#s_bookName").val(),
                "bookPrice":$("#s_bookPrice").val(),
                "bookTypeId":$("#s_category").val()
            }
            return temp;
        }
        return obj;
    }
    function doSearch(){
        $("#mytable").bootstrapTable("refresh",{
            //带参数刷新，就相当于一次新的请求
            query:{
                "op": "showByPage",
                "limit": "5",
                "offset": "0",
                "bookName": $("#s_bookName").val(),
                "bookPrice": $("#s_bookPrice").val(),
                "bookTypeId": $("#s_category").val()
            }
        })
    }

    function addop(value,row,index){
            return `
            <a class="btn btn-info" data-toggle="modal" data-target="#addModal">新增</a>
            `
        }
    function doAdd(){
            $.ajax({
                url: "./book?=doAdd",

                data: $("#addform").serialize(),  //serialize表单序列化
                type: "post",
                success: function (msg) {
                    if (msg=="ok"){
                        $('#addtable').bootstrapTable("refresh");
                        $("#addModal").modal('hide');
                        console.log("=========");
                        $("#addform")[0].reset();
                    }else {
                        alert("对不起，新增失败");
                    }

                }
            })
        }
    // function addBook(id){
        //     $.ajax({
        //         url: "./book",
        //         data:{
        //             "op":"readyAdd",
        //             "id":id
        //         },
        //         type:"get",
        //         dataType:"json",
        //         success:function (obj){
        //             // $("#bookId").val(obj.id);
        //             $("#bookName").val(obj.bookName);
        //             $("#bookPrice").val(obj.bookPrice);
        //             $("#bookAuthor").val(obj.bookAuthor);
        //             $("#bookImage").val(obj.bookImage);
        //             $("#bookPublish").val(obj.bookPublish);
        //             $("#bookStoreCount").val(obj.bookStoreCount);
        //             //时间要单独处理
        //             let year = obj.bookPublishDate.year+1900;
        //             let month = obj.bookPublishDate.month+1;
        //             let day = obj.bookPublishDate.date;
        //             let hour = obj.bookPublishDate.hours;
        //             let minute = obj.bookPublishDate.minutes;
        //             let second = obj.bookPublishDate.seconds;
        //             $("#bookPublishDate").val(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
        //             //把书籍的目录选中
        //             $("#cate option").each(function (index,o){
        //                 if (o.value==obj.cate.id){
        //                     o.selected = true;
        //                 }
        //             })
        //         }
        //     })
        // }
    //value就是当前项的值
    function actionOp(value,row,index){
            return `
                <a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="readyEdit(`+value+`)">修改</a>
                 <a class="btn btn-danger"  onclick="del(`+value+`)">删除</a>

            `;
        }
        function del(id){
            $.ajax({
                url: "./book",
                data: {
                    "id": id,
                    "op": "del"
                },
                type: "post",
                success: function (msg) {
                    if (msg=="ok"){
                        $('#mytable').bootstrapTable("refresh");
                    }else {
                        alert("对不起，删除失败");
                    }
                }
            })
        }
        function loadCategory(){
            $.ajax({
                url: "./cate",
                data: {
                    "op": "showAll",

                },
                type: "get",
                dataType: "json",
                success: function (cateArr) {
                    console.log(cateArr);
                    for (cate of cateArr){
                        $("#cate")[0].append(new Option(cate.typeName,cate.id));
                        $("#addcate")[0].append(new Option(cate.typeName,cate.id));
                    }
                    for (cate of cateArr){
                        $("#s_category")[0].append(new Option(cate.typeName,cate.id));

                    }
                }
            })
        }
    function doEdit(){
        $.ajax({
            url: "./book?=doEdit",
            data: $("#myform").serialize(),  //serialize表单序列化
            type: "post",
            success: function (msg) {
                if (msg=="ok"){
                    $('#mytable').bootstrapTable("refresh");
                    $("#myModal").modal('hide');

                }else {
                    alert("对不起，修改失败");
                }

            }
        })
    }
    function readyEdit(id){
            $.ajax({
                url: "./book",
                data:{
                    "op":"readyEdit",
                    "id":id
                },
                type:"get",
                dataType:"json",
                success:function (obj){
                    $("#bookId").val(obj.id);
                    $("#bookName").val(obj.bookName);
                    $("#bookPrice").val(obj.bookPrice);
                    $("#bookAuthor").val(obj.bookAuthor);
                    $("#bookImage").val(obj.bookImage);
                    $("#bookPublish").val(obj.bookPublish);
                    $("#bookStoreCount").val(obj.bookStoreCount);
                    //时间要单独处理
                    let year = obj.bookPublishDate.year+1900;
                    let month = obj.bookPublishDate.month+1;
                    let day = obj.bookPublishDate.date;
                    let hour = obj.bookPublishDate.hours;
                    let minute = obj.bookPublishDate.minutes;
                    let second = obj.bookPublishDate.seconds;
                    $("#bookPublishDate").val(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
                    //把书籍的目录选中
                    $("#cate option").each(function (index,o){
                        if (o.value==obj.cate.id){
                            o.selected = true;
                        }
                    })
                }
            })
        }

        function mydate(value){
            let year=value.year+1900;
            let month = value.month+1;
            let day = value.date;
            let hour = value.hours;
            let minute = value.minutes;
            let second = value.seconds;
            return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        }
</script>
</html>
