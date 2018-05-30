<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>云桌面</title>
    <link href="./static/css/login.css" rel="stylesheet" type="text/css">
    <link href="./static/css/upload.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="win10-login" style="background: url('./static/img/wallpapers/login.jpg') no-repeat fixed">
    <div style="height: 10%;min-height: 120px"></div>
    <div id="win10-login-box">
        <div class="win10-login-box-square">
            <img src="./static/img/avatar.jpg" class="content"/>
        </div>
        <p style="font-size: 24px;color: white;text-align: center">云桌面注册</p>
        <form target="_self" method="post" id="RegisterForm">
            <!--用户名-->
            <input type="text" placeholder="请输入手机号" class="login-username" name="userPhone">
            <!--密码-->
            <input type="password" placeholder="请输入密码" class="login-password" name="userPassword">
            <!--请输入昵称-->
            <input type="text" placeholder="请输入昵称" class="login-username" name="userName">
            <!--请输入QQ-->
            <input type="text" placeholder="请输入QQ" class="login-username" name="userQq">
            <!--请输入QQ-->
            <input type="text" placeholder="请输入微信" class="login-username" name="userWx">
            <!--图片上传-->
            <div class="case">
                <p style="float: left;line-height:120px;color:#fff;font-size: 12px;">头像上传:</p>
                <div class="upload" action='/userPhotoUpload' data-num='1' id='case2'></div>
            </div>
            <br>
            <!--登陆按钮-->
            <input type="button" value="注册" id="btn-login" class="login-submit"/>
            <a href="/">有账户？登录</a>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/js/jQuery.upload.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<script>
    $(function(){
        $("#case2").upload();
    });
    $("#btn-login").click(function () {
        var phone= $(".login-username").val();
        var passWd= $(".login-password").val();
        $.ajax({
            type: "post",
            url: "/userRegister",
            data: $("#RegisterForm").serialize(),
            dataType: "json",
            success: function (msg) {
                if(msg.flag){
                    window.location.href="/";
                }else{
                    layer.alert(msg.msg);
                }
            }
        });
    });
</script>
</html>