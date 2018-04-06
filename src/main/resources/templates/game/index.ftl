<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>游戏</title>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/default.css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/win10.js"></script>
    <style>
        .main .search input {border: 1px solid #2e8ded;width: 80%;height: 48px;float: left;margin-top: 16px;padding-left: 5px;font-size: 18px;}
        .main .search span {display: block;float: left;width: 20%;height: 48px;margin-top: 16px;background: #31c27c;color: #fff;line-height: 48px;text-align: center;cursor: pointer;}
        .main .search span:hover {background: #31C250;transition: all 0.3s ease-in;color: #f9f9f9;}
        .main .game{width: 18%;height: 166px;margin: 1%;border: 1px solid #1E9FFF;border-radius:3px;box-shadow:3px #999;float: left;text-align: center;cursor: pointer;}
        .main .game:hover{transition: all 0.3s ease-in;-webkit-transform:scale(1.1);-moz-transform:scale(1.1);-o-transform:scale(1.1) }
        .main .game img{width: 100px;height: 100px;border-radius: 50%;margin-top: 10px;}
        .main .game span{margin-top: 5px;font-size: 12px;color: #3B3D3F;}
    </style>
</head>
<body>
<div class="container">
    <div class="main">
        <div class="search" style="width: 100%;height: 80px;">
            <input type="text"/>
            <span>
             <i class="fa fa-search"></i>
                查询
            </span>
        </div>
        <div class="game" onclick="Win10.openUrl('/game/dadishu','<img class=\'icon\' src=\'./static/img/icon/win10.png\'/>打地鼠')">
            <img src="./static/img/wallpapers/login.jpg">
            <br>
            <span>打地鼠</span>
            <br>
            <span>
                <i class="fa fa-star fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="fa fa-share-alt fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="fa fa-info-circle fa-lg"></i>
            </span>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
</body>
</html>
