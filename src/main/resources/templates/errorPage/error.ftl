<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>云桌面</title>
    <style>
        #win10-login {
            background: url("../../static/img/wallpapers/login.jpg") no-repeat fixed;
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
    </style>
</head>
<body>
<div id="win10-login">
    <div style="height: 10%;min-height: 120px"></div>
    <div id="win10-login-box">
        <div class="win10-login-box-square">
            <img src="./static/img/avatar.jpg" class="content"/>
        </div>
        <p style="font-size: 18px;color: white;text-align: center">${msg}</p>
        <p style="font-size: 18px;color: white;text-align: center">${email}</p>
    </div>
</div>
</body>
</html>