<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="iconfont/style.css" type="text/css" rel="stylesheet">
</head>

<body style="background:url(images/bg.jpg) no-repeat;">
<div>
    <div class="container wrap1" style="height:700px;">
        <h2 class="mg-b20 text-center">CKC计算机协会 用户注册</h2>
        <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
            <p class="text-center font16">创建新用户</p>
            <form>
                <div class="form-group mg-t20">
                    <i class="icon-user icon_font"></i>
                    <input type="text" class="login_input" id="userId" placeholder="请输入账号"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-user icon_font"></i>
                    <input type="text" class="login_input" id="userName" placeholder="请输入姓名"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-lock icon_font"></i>
                    <input type="password" class="login_input" id="userPw" placeholder="请输入密码"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-lock icon_font"></i>
                    <input type="password" class="login_input" id="userPwRe" placeholder="请再次输入密码"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-agentlist icon_font"></i>
                    <input type="text" class="login_input" id="userJob" placeholder="请输入职务"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-ydlist icon_font"></i>
                    <input type="text" class="login_input" id="userTel" placeholder="请输入手机号"/>
                </div>
                <div class="form-group mg-t20">
                    <i class="icon-data icon_font"></i>
                    <input type="text" class="login_input" id="userQq" placeholder="请输入QQ号"/>
                </div>
                <button type="submit" class="login_btn">注 册</button>
            </form>
            <div class="checkbox mg-b25 row">
                <div class="col-md-5">
                    <a href="login.jsp">
                        <p>返回登录界面</p>
                    </a>
                </div>
            </div>
        </div>
    </div><!--row end-->
</div>
<!--container end-->
</body>
</html>

