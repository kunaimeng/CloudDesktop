<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DeskChatTo</title>
    <link href="./static/css/qq.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="qqBox">
    <div class="BoxHead" style="background-image: url(./static/img/qq/20170926103645_01.jpg);background-size:100% 100%;">
        <div class="headImg">
            <img src="${userInfo.userImg}"/>
        </div>
        <div class="internetName">${userInfo.userName}</div>
    </div>
    <div class="context">
        <div class="conLeft">
            <ul>
                <li class="bg">
                    <div class="liLeft"><img src="./static/img/avatar.jpg"/></div>
                    <div class="liRight">
                        <span  class="intername">云桌面交流</span>
                        <span class="infor">暂时无消息</span>
                    </div>
                </li>
            </ul>
        </div>
        <div class="conRight">
            <div class="Righthead">
                <div class="headName">云桌面交流</div>
                <div class="headConfig">

                </div>
            </div>
            <div class="RightCont">
                <ul class="newsList">

                </ul>
            </div>
            <div class="RightFoot">
                <div class="footTop">
                    <ul>
                        <li><img src="./static/img/qq/20170926103645_31.jpg"/></li>
                    </ul>
                </div>
                <div class="inputBox">
                    <textarea id="dope" style="width: 99%;height: 75px; border: none;outline: none;" name="" rows="" cols=""></textarea>
                    <button class="sendBtn">发送(s)</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<script>
    var userId="${userInfo.userId}";
    var userImg="${userInfo.userImg}";

    var iframeHeight = 0;

    //定时刷新窗口高低
    setInterval(function () {
        iframeHeight = document.documentElement.clientHeight-6;
            $(".qqBox").css("height", iframeHeight);
            $(".conLeft").css("height", iframeHeight-52);

    }, 300);
</script>
<script type="text/javascript" src="./static/js/socket/chatWebSocket.js"></script>
</body>
</html>