<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2022/5/26
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="./bootstrap-3.4.1/css/bootstrap.min.css" />
    <script src="./javascript/jQuery1.12.4.js"></script>
    <script src="./bootstrap-3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="row" >
        <nav class="navbar navbar-default ">
            <div class="container-fluid" >
                <div class="navbar-header col-xs-4">
                    <img alt="Brand" src="./img/title-logo.png">
                </div>
                <div class="col-xs-1 col-xs-offset-6" style="...">
                    你好，${loginAdmin.username}
                </div>
                <div>
                    <a class="btn btn-danger btn-xs" href="./login?op=loginOut">退出登录</a>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="col-xs-2">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                               aria-expanded="true" aria-controls="collapseOne">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">
                            <a class="btn btn-info btn-block" href="./manager?op=showUser" target="showAll">显示用户</a>
<%--                            <a class="btn btn-info btn-block" href="addUser.jsp" target="showAll" >新增用户</a>--%>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a  role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                图书管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingTwo">
                        <div class="panel-body">
                            <a class="btn btn-info btn-block" href="./manager?op=showAllBook" target="showAll">显示所有书籍</a>
                            <a class="btn btn-info btn-block" href="./manager?op=showBookByPage" target="showAll">显示书籍分页</a>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                目录管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">
                            <a class="btn btn-info btn-block" href="./manager?op=showAllCategory" target="showAll">显示所有目录</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-10">
            <iframe name="showAll" src="./manager?op=toWelcome" width="100%" height="600px" frameborder="0">

            </iframe>
        </div>
    </div>
</div>
</body>
</html>
