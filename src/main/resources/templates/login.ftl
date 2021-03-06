<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>云桌面</title>
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <link rel='Shortcut Icon' type='image/x-icon' href='./static/img/windows.ico'>
    <link href="./static/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="win10-login" style="background: url('./static/img/wallpapers/login.jpg') no-repeat fixed">
    <div style="height: 10%;min-height: 120px"></div>
    <div id="win10-login-box">
        <div class="win10-login-box-square">
            <img src="./static/img/avatar.jpg" class="content"/>
        </div>
        <p style="font-size: 24px;color: white;text-align: center">云桌面登录</p>
        <form target="_self" method="post" action="/index">
            <!--用户名-->
            <input type="text" placeholder="请输入登录名" class="login-username">
            <!--密码-->
            <input type="password" placeholder="请输入密码" class="login-password">
            <!--登陆按钮-->
            <input type="button" value="登录" id="btn-login" class="login-submit"/>
            <a class="regOrLogin" href="/register">没有账户？注册</a>
        </form>
    </div>
</div>
</body>

<script>
    $("#btn-login").click(function () {
        var phone= $(".login-username").val();
        var passWd= $(".login-password").val();
        $.ajax({
            type: "post",
            url: "/userLogin",
            data: {"userPhone": phone,"userPassword":passWd},
            dataType: "json",
            success: function (msg) {
                if(msg.flag){
                    window.location.href="/index";
                }else{
                    layer.alert('哎呀,好像登录失败了呢！');
                }
            }
        });
    });
</script>
</html>