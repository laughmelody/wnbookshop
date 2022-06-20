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
    <title></title>
    <link rel="stylesheet" href="bootstrap-3.4.1/css/bootstrap.min.css"/>
    <script src="javascript/jQuery1.12.4.js"></script>
    <script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>
    <link href="css/back-login.css" rel="stylesheet"/>
    <style>
        body{
            background:url("img/moshou.png") no-repeat top;
            background-size: 100%;
        }
        .box{
            color: white;
            background-color: rgba(0,0,0,0.3);;
            margin-top: 500px ;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }
        .box:hover{
            box-shadow: 0 0 10px 5px  rgba(255, 255, 255, 0.3);
        }
        .login-box{
            padding-top: 28px;
            padding-bottom: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="box col-xs-4 col-xs-offset-4 login-box">
    <form action="./admin" class="form-horizontal" method="post">

        <!--使用隐藏域提交数据-->
        <input type="text" name="op" value="login" hidden/>

        <div class="form-group">
            <label class="col-sm-2">UserName:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-6">
                <button type="submit" class="btn btn-default btn-block">Login</button>
            </div>
            <div class="col-xs-6">
                <button type="reset" class="btn btn-default btn-block">Reset</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
