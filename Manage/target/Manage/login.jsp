<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>CKC计算机协会 后台管理系统-Computer Knowledge Community</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="iconfont/style.css" type="text/css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>

<body style="background:url(images/bg.jpg) no-repeat;">
<div>
    <div class="container wrap1" style="height:450px;">
        <h2 class="mg-b20 text-center">CKC计算机协会 后台管理系统</h2>
        <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
            <p class="text-center font16">用户登录</p>
            <form action="/adm/login" name="loginForm" method="POST">
                <div class="form-group mg-t20">
                    <i class="icon-user icon_font"></i>
                    <input type="text" class="login_input" name = "username" id="username" placeholder="请输入账号"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-lock icon_font"></i>
                    <input type="password" class="login_input" name = "password" id="password" placeholder="请输入密码"/>
                </div>
                    <div class="checkbox mg-b25 row">
                            <label class="col-xs-6">
                                <input type="checkbox" checked="checked"  id="rememberMe"/>记住我的登录信息
                            </label>
                        <div class="col-xs-6">
                            <a href="register.jsp">
                                <p class="text-right">注册一个新账号</p>
                            </a>
                        </div>
                    </div>
                <button type="button" class="login_btn" name = "submitForm" id = "submitForm" onclick="doLogin()">登 录</button>
            </form>
        </div><!--row end-->
    </div>
</div><!--container end-->
<div class="footer-left">
    <p>© 2018 Computer Knowledge Community.</p>
    <p>All rights reserved | Design by ZhangShuo.</p>
</div>
<script type="text/javascript">
        function doLogin(){

            var username = $("#username").val();
            var password = $("#password").val();
            $.ajax({
                type: "POST",
                url: "login",
                data: "username="+username+"&password=" + password,
                success: function(msg){
                    alert( "Data Saved: " + msg );
                }
            });
        }
</script>
</body>
</html>

