<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: zzj--%>
<%--  Date: 2022/5/31--%>
<%--  Time: 22:22--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>

<%--    <!-- 引入Bootstrap核心样式文件 -->--%>
<%--    <link href="bootstrap-3.4.1/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <!-- 引入jQuery核心js文件 -->--%>
<%--    <script src="javascript/jQuery1.12.4.js"></script>--%>
<%--    <!-- 引入BootStrap核心js文件 -->--%>
<%--    <script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>--%>

<%--    <link href="css/common.css" rel="stylesheet" />--%>
<%--    <link href="css/login-new.css" rel="stylesheet" />--%>
<%--    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />--%>
<%--    <link href="bootstrapValidator/css/bootstrapValidator.min.css" rel="stylesheet"/>--%>
<%--    <script src="bootstrapValidator/js/bootstrapValidator.min.js"></script>--%>


<%--    <title>蜗牛书城-欢迎登陆</title>--%>
<%--</head>--%>
<%--<style>--%>
<%--    .form-control {--%>
<%--        border-radius: 0;--%>
<%--    }--%>
<%--</style>--%>

<%--<body>--%>
<%--<!-- header -->--%>
<%--<div class="w">--%>
<%--    <div class="header">--%>
<%--        <div class="logo">--%>
<%--            <img src="img/title-logo.png">--%>
<%--            <span>欢迎登录</span>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<%--<!-- content -->--%>
<%--<div class="warning-wrap">--%>
<%--    <div class="warning">--%>
<%--        <p><i class="iconfont">&#xe6cd;</i>--%>
<%--            依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版--%>
<%--            <a href="#">《蜗牛隐私政策》</a>已上线，将更有利于保护您的个人隐私。--%>
<%--        </p>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<div class="login-wrap">--%>
<%--    <div class="w">--%>
<%--        <div class="content">--%>

<%--            <div class="login-form fr">--%>

<%--                <div class="login-box h50">--%>
<%--                    <div class="login-way login fl active" onclick="changeForm(1)">账户登录</div>--%>
<%--                    <div class="login-way register fr" onclick="changeForm(2)">注册账号</div>--%>
<%--                </div>--%>

<%--                <!-- ===================== 登录的表单 ========================-->--%>
<%--                <form id="login" class="show-form form-horizontal" action="./user?op=doLogin" method="post">--%>
<%--                    <div class="pl20 pr20">--%>

<%--                        <div class="h50"></div>--%>


<%--                        <div class="form-group">--%>
<%--                            <label class="col-xs-3 control-label">--%>
<%--                                <i class="iconfont">&#xe604;</i>--%>
<%--                            </label>--%>
<%--                            <div class="col-xs-9">--%>
<%--                                <input type="text" class="form-control itxt" name="username" placeholder="用户账号:"--%>
<%--                                       autocomplete="off" />--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="form-group">--%>
<%--                            <label class="col-xs-3 control-label">--%>
<%--                                <i class="iconfont">&#xe625;</i>--%>
<%--                            </label>--%>
<%--                            <div class="col-xs-9">--%>
<%--                                <input type="text" class="form-control itxt" name="password" placeholder="用户密码:"--%>
<%--                                       autocomplete="off" />--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                        <div class="wp">--%>
<%--                            <div class="h50 right-link">--%>
<%--                                <div class="fr fs10 pt15 "><a href="#">忘记密码</a></div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="wp mt100">--%>
<%--                            <div class="h50 center">--%>
<%--                                <div class="login-btn"><button type="submit">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>

<%--                <!-- =========================== 注册的表单 ======================== -->--%>
<%--                <form id="register" class="form form-horizontal" action="./user?op=add" >--%>
<%--                    <div class="pl20 pr20">--%>
<%--                        <div class="h34"></div>--%>

<%--                        <div class="form-group">--%>
<%--                            <label class="col-xs-3 control-label">--%>
<%--                                <i class="iconfont">&#xe604;</i>--%>
<%--                            </label>--%>
<%--                            <div class="col-xs-9">--%>
<%--                                <input type="text" class="form-control itxt" name="username"--%>
<%--                                       placeholder="新账号:" autocomplete="off" />--%>
<%--                            </div>--%>

<%--                        </div>--%>

<%--                        <div class="form-group">--%>
<%--                            <label class="col-xs-3 control-label">--%>
<%--                                <i class="iconfont">&#xe625;</i>--%>
<%--                            </label>--%>
<%--                            <div class="col-xs-9">--%>
<%--                                <input type="text" class="form-control itxt" name="password"--%>
<%--                                       placeholder="新密码:" autocomplete="off" />--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="form-group">--%>
<%--                            <label class="col-xs-3 control-label">--%>
<%--                                <i class="iconfont">&#xe625;</i>--%>
<%--                            </label>--%>
<%--                            <div class="col-xs-9">--%>
<%--                                <input type="text" class="form-control itxt" name="password2"--%>
<%--                                       placeholder="重输密码:" autocomplete="off" />--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="wp mt100">--%>
<%--                            <div class="h50 center">--%>
<%--                                <div class="login-btn"><button type="submit">注&nbsp;&nbsp;&nbsp;&nbsp;册</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                </form>--%>


<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<!-- footer -->--%>

<%--<div class="footer ">--%>
<%--    <div class="pt15 fs10 center">--%>
<%--        <a href="#">关于我们</a> <span>|</span>--%>
<%--        <a href="#">联系我们</a> <span>|</span>--%>
<%--        <a href="#">人才招聘</a> <span>|</span>--%>
<%--        <a href="#">商家入驻</a> <span>|</span>--%>
<%--        <a href="#">广告服务</a> <span>|</span>--%>
<%--        <a href="#">手机蜗牛</a> <span>|</span>--%>
<%--        <a href="#">友情链接</a> <span>|</span>--%>
<%--        <a href="#">销售联盟</a> <span>|</span>--%>
<%--        <a href="#">蜗牛社区</a> <span>|</span>--%>
<%--        <a href="#">English Site</a>--%>
<%--    </div>--%>
<%--    <div class="pt10 fs10 center">--%>
<%--        <span>Copyright © 2004-2021</span>--%>
<%--        <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>--%>
<%--        <span>模拟京东商城登录界面</span>--%>
<%--    </div>--%>

<%--</div>--%>
<%--</body>--%>
<%--<script>--%>
<%--    &lt;%&ndash;$.ajax({&ndash;%&gt;--%>
<%--    &lt;%&ndash;    type: "get",&ndash;%&gt;--%>
<%--    &lt;%&ndash;    url: "${pageContext.request.contextPath}/user",&ndash;%&gt;--%>
<%--    &lt;%&ndash;    data: {&ndash;%&gt;--%>
<%--    &lt;%&ndash;        "op":"checkName"&ndash;%&gt;--%>
<%--    &lt;%&ndash;    },&ndash;%&gt;--%>
<%--    &lt;%&ndash;    success: function(msg){&ndash;%&gt;--%>
<%--    &lt;%&ndash;        alert( "Data Saved: " + msg );&ndash;%&gt;--%>
<%--    &lt;%&ndash;    }&ndash;%&gt;--%>
<%--    &lt;%&ndash;});&ndash;%&gt;--%>
<%--    &lt;%&ndash;$.get("${pageContext.request.contextPath}/user",{&ndash;%&gt;--%>
<%--    &lt;%&ndash;    "op":"chechkName",&ndash;%&gt;--%>
<%--    &lt;%&ndash;    "name":obj.value&ndash;%&gt;--%>
<%--    &lt;%&ndash;},function (msg){&ndash;%&gt;--%>
<%--    &lt;%&ndash;    alert("服务器信息"+msg);&ndash;%&gt;--%>
<%--    &lt;%&ndash;})&ndash;%&gt;--%>


<%--    $('#register').bootstrapValidator({--%>
<%--            message: '这是默认的提示信息',--%>
<%--            feedbackIcons: {--%>
<%--                valid: 'glyphicon glyphicon-ok',--%>
<%--                invalid: 'glyphicon glyphicon-remove',--%>
<%--                validating: 'glyphicon glyphicon-refresh'--%>
<%--            },--%>
<%--            fields: {--%>
<%--                username: {--%>
<%--                    message: '用户名，没有验证',--%>
<%--                    validators: {--%>
<%--                        notEmpty: {--%>
<%--                            message: '用户名不可以为空'--%>
<%--                        },--%>
<%--                        stringLength: {--%>
<%--                            min: 2,--%>
<%--                            max: 30,--%>
<%--                            message: '用户名最少2个字符，最大30个字符'--%>
<%--                        },--%>
<%--                        remote: {--%>
<%--                            url: '${pageContext.request.contextPath}/user?op=checkName'+$("#register input[name=username]").val(),--%>
<%--                            message: '名字已经被使用',--%>
<%--                            type:'get',--%>
<%--                            delay:500--%>
<%--                        },--%>
<%--                        regexp: {--%>
<%--                            regexp: /^[\w]{2,20}$/,--%>
<%--                            message: '用户名是2-20位字符'--%>
<%--                        }--%>
<%--                    }--%>
<%--                },--%>

<%--                password: {--%>
<%--                    validators: {--%>
<%--                        notEmpty: {--%>
<%--                            message: '密码不能为空!'--%>
<%--                        },--%>
<%--                        stringLength: {--%>
<%--                            min: 6,--%>
<%--                            max: 18,--%>
<%--                            message: '密码应该是6-18位的字符'--%>
<%--                        },--%>
<%--                        regexp: {--%>
<%--                            regexp: /^[a-z|0-9|A-Z]+$/,--%>
<%--                            message: '密码应该是数字英文组合',--%>
<%--                        }--%>
<%--                    }--%>
<%--                },--%>
<%--                password2: {--%>
<%--                    validators: {--%>
<%--                        notEmpty: {--%>
<%--                            message: '密码不能为空!'--%>
<%--                        },--%>
<%--                        identical: {--%>
<%--                            field: 'password',--%>
<%--                            message: '两次密码应该是一致的'--%>
<%--                        }--%>

<%--                    }--%>
<%--                }--%>
<%--            }--%>
<%--        })--%>
<%--        .on('success.form.bv', function(e) {--%>
<%--            // Prevent form submission--%>
<%--            e.preventDefault();--%>

<%--            // Get the form instance--%>
<%--            var $form = $(e.target);--%>

<%--            // Get the BootstrapValidator instance--%>
<%--            var bv = $form.data('bootstrapValidator');--%>

<%--            // Use Ajax to submit form data--%>
<%--            $.post($form.attr('action'), $form.serialize(), function(result) {--%>
<%--               if ("ok"==result){--%>
<%--                   location.href="login.jsp";--%>
<%--               }else {--%>
<%--                   alert(result);--%>
<%--               }--%>
<%--            });--%>
<%--        });--%>



<%--    // 切换登录和注册表单--%>
<%--    function changeForm(op) {--%>
<%--        if (op == 1) {--%>
<%--            // 改变登录按钮样式--%>
<%--            $(".login").addClass("active");--%>
<%--            $(".register").removeClass("active");--%>
<%--            // 显示登录表单--%>
<%--            $("#login").addClass("show-form");--%>
<%--            $("#register").removeClass("show-form");--%>

<%--        } else if (op == 2) {--%>
<%--            $(".register").addClass("active");--%>
<%--            $(".login").removeClass("active");--%>
<%--            $("#register").addClass("show-form");--%>
<%--            $("#login").removeClass("show-form");--%>
<%--        }--%>
<%--    }--%>

<%--  --%>
<%--</script>--%>


<%--</html>--%>

