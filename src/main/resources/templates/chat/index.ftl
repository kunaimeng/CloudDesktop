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
                <li>
                    <div class="liLeft"><img src="./static/img/qq/20170926103645_04.jpg"/></div>
                    <div class="liRight">
                        <span class="intername">前端交流群</span>
                        <span class="infor">厉害了</span>
                    </div>
                </li>
                <li class="bg">
                    <div class="liLeft"><img src="./static/img/qq/20170926103645_19.jpg"/></div>
                    <div class="liRight">
                        <span  class="intername">赵鹏</span>
                        <span class="infor">[流泪]</span>
                    </div>
                </li>
            </ul>
        </div>
        <div class="conRight">
            <div class="Righthead">
                <div class="headName">赵鹏</div>
                <div class="headConfig">

                </div>
            </div>
            <div class="RightCont">
                <ul class="newsList">

                </ul>
            </div>
            <div class="RightFoot">
                <div class="emjon">
                    <ul>
                        <li><img src="./static/img/qq/em_02.jpg"/></li>
                        <li><img src="./static/img/qq/em_05.jpg"/></li>
                        <li><img src="./static/img/qq/em_07.jpg"/></li>
                        <li><img src="./static/img/qq/em_12.jpg"/></li>
                        <li><img src="./static/img/qq/em_14.jpg"/></li>
                        <li><img src="./static/img/qq/em_16.jpg"/></li>
                        <li><img src="./static/img/qq/em_20.jpg"/></li>
                        <li><img src="./static/img/qq/em_23.jpg"/></li>
                        <li><img src="./static/img/qq/em_25.jpg"/></li>
                        <li><img src="./static/img/qq/em_30.jpg"/></li>
                        <li><img src="./static/img/qq/em_31.jpg"/></li>
                        <li><img src="./static/img/qq/em_33.jpg"/></li>
                        <li><img src="./static/img/qq/em_37.jpg"/></li>
                        <li><img src="./static/img/qq/em_38.jpg"/></li>
                        <li><img src="./static/img/qq/em_40.jpg"/></li>
                        <li><img src="./static/img/qq/em_45.jpg"/></li>
                        <li><img src="./static/img/qq/em_47.jpg"/></li>
                        <li><img src="./static/img/qq/em_48.jpg"/></li>
                        <li><img src="./static/img/qq/em_52.jpg"/></li>
                        <li><img src="./static/img/qq/em_54.jpg"/></li>
                        <li><img src="./static/img/qq/em_55.jpg"/></li>
                    </ul>
                </div>
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
<script>
    var userId="${userInfo.userId}";
</script>
<script type="text/javascript" src="./static/js/socket/chatWebSocket.js"></script>
</body>
</html>