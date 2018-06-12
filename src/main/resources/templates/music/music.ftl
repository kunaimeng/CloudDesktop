<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>云桌面</title>
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="./static/css/music.css">
</head>
<body>
<div id="win10" class="container">
    <div class="row" style="margin-top: 28px;">
        <div class="col-sm-12">
            <div id="movieList">
                <ul>
                    <#list musicList as music>
                        <li class="col-sm-2">
                            <div class="col_img">
                                <img src="${music.songBgBg}" alt="${music.songName}">
                            </div>
                            <br>
                            <p class="m_con">${music.songName}</p>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>