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




<!--修改用模态框-->
<table id="mytable"></table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">目录修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="myform">
                    <input type="text" name="op" value="doEdit" hidden/>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">目录ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="id" ID="id" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">目录名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="typeName" id="typeName"/>
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
                <h4 class="modal-title" id="addModalLabel">目录新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addform">
                    <input type="text" name="op" value="doAdd" hidden/>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">目录ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="id" ID="addid" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">目录名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="typeName" id="addtypeName"/>
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
    $('#mytable').bootstrapTable({
        url: './cate?op=showAl',         //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        // toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        // sortable: false,                     //是否启用排序
        // sortOrder: "asc",                   //排序方式
        // queryParams: obj.queryParams,//传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [5, 10, 15, 25, 35, 50, 100],        //可供选择的每页的行数（*）
        // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        //strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        //detailView: false,                   //是否显示父子表
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: '目录ID'
        }, {
            field: 'typeName',
            title: '目录名'
        }, {
            field: 'gmtCreate',
            title: '创建时间'
        }, {
            field: 'gmtModified',
            title: '修改时间'
        },{
            field: 'id',
            title: '操作',
            formatter: actionOp
        }, {
            field: 'add',
            title: '新增',
            formatter: addop
        }]
    });
    // }

    function addop(value, row, index) {
        return `
            <a class="btn btn-info" data-toggle="modal" data-target="#addModal">新增</a>
            `
    }

    function doAdd() {
        $.ajax({
            url: "./cate?=doAdd",
            data: $("#addform").serialize(),  //serialize表单序列化
            type: "post",
            success: function (msg) {
                if (msg == "ok") {
                    $('#addtable').bootstrapTable("refresh");
                    $("#addModal").modal('hide');
                    console.log("=========");
                    $("#addform")[0].reset();
                } else {
                    alert("对不起，新增失败");
                }

            }
        })
    }

    //value就是当前项的值
    function actionOp(value, row, index) {
        return `
                <a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="readyEdit(` + value + `)">修改</a>
                 <a class="btn btn-danger"  onclick="del(` + value + `)">删除</a>
            `;
    }

    function del(id) {
        $.ajax({
            url: "./cate",
            data: {
                "id": id,
                "op": "del"
            },
            type: "post",
            success: function (msg) {
                if (msg == "ok") {
                    $('#mytable').bootstrapTable("refresh");
                } else {
                    alert("对不起，删除失败");
                }
            }
        })
    }
    function doEdit() {
        $.ajax({
            url: "./cate?=doEdit",
            data: $("#myform").serialize(),  //serialize表单序列化
            type: "post",
            success: function (msg) {
                if (msg == "ok") {
                    $('#mytable').bootstrapTable("refresh");
                    $("#myModal").modal('hide');

                } else {
                    alert("对不起，修改失败");
                }

            }
        })
    }

    function readyEdit(id) {
        $.ajax({
            url: "./cate",
            data: {
                "op": "readyEdit",
                "id": id
            },
            type: "get",
            dataType: "json",
            success: function (obj) {
                $("#id").val(obj.id);
                $("#typeName").val(obj.typeName);
                // $("#gmtCreate").val(obj.gmtCreate);
                // $("#gmtModified").val(obj.gmtModified);
            }
        })
        // }


    }
</script>
</html>
