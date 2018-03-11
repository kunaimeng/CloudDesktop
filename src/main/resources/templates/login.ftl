<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>云桌面</title>
    <style>
        #win10-login {
            background: url("./static/img/wallpapers/login.jpg") no-repeat fixed;
            width: 100%;
            height: 100%;
            background-size: 100% 100%;
            position: fixed;
            z-index: -1;
            top: 0;
            left: 0;
        }

        #win10-login-box {
            width: 300px;
            overflow: hidden;
            margin: 0 auto;
        }

        .win10-login-box-square {
            width: 105px;
            margin: 0 auto;
            border-radius: 50%;
            background-color: darkgray;
            position: relative;
            overflow: hidden;
        }

        .win10-login-box-square::after {
            content: "";
            display: block;
            padding-bottom: 100%;
        }

        .win10-login-box-square .content {
            position: absolute;
            width: 100%;
            height: 100%;
        }

        input {
            width: 90%;
            display: block;
            border: 0;
            line-height: 36px;
            font-size: 20px;
            padding: 0 1em;
            border-radius: 5px;
            margin-bottom: 11px;
        }

        .login-username, .login-password {
            width: 91%;
            font-size: 13px;
            color: #999;
        }

        .login-submit {
            margin: 0px;
            border-radius: 5px;
            background-color: #009688;
            width: 54px;
            display: inline-block;
            width: 100%;
            line-height: 36px;
            padding: 0 auto;
            color: #fff;
            white-space: nowrap;
            text-align: center;
            font-size: 14px;
            border: none;
            cursor: pointer;
            opacity: .9;
            filter: alpha(opacity=90);
        }
    </style>
</head>
<body>
<div id="win10-login">
    <div style="height: 10%;min-height: 120px"></div>
    <div id="win10-login-box">
        <div class="win10-login-box-square">
            <img src="./static/img/avatar.jpg" class="content"/>
        </div>
        <p style="font-size: 24px;color: white;text-align: center">游客</p>
        <form target="_self" method="post" action="/index">
            <!--用户名-->
            <input type="text" placeholder="请输入登录名" class="login-username">
            <!--密码-->
            <input type="password" placeholder="请输入密码" class="login-password">
            <!--登陆按钮-->
            <input type="button" value="登录" id="btn-login" class="login-submit"/>
        </form>
    </div>
</div>
</body>
<script src="./static/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="./static/js/win10.js" type="text/javascript" ></script>
<script src="./static/component/layer-v3.0.3/layer/layer.js" type="text/javascript"></script>
<script>
    $("#btn-login").click(function () {
        var phone= $(".login-username").val();
        var passWd= $(".login-password").val();
        $.ajax({
            type: "post",
            url: "/userLogin.ftl",
            data: {"userPhone": phone,"userPassword":passWd},
            dataType: "json",
            success: function (msg) {
                if(msg.flag){
                    window.location.href="/index";
                }else{
                    layer.alert(Win10.lang('哎呀,好像登录失败了呢。','Ops...There seems to be a little problem.'));
                }
            }
        });
    });
</script>
</html>