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
                        <li class="col-sm-2" data-url="${music.songMp3Src}" data-img="${music.songBgBg}" data-title="${music.songName}">
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
    <br>
    <div class="win-forward">
        <span class="forward">返回</span>
    </div>
    <div class="player" >
        <div class="p_pic">
            <img src="images/1.jpg" alt="" width="80px" height="80px"/>
            <p class="p_name">绿野仙踪</p>
        </div>
        <div class="p_btn">
            <a href="#" class="b_left"></a>
            <a href="#" class="b_center"></a>
            <a href="#" class="b_pause"></a>
            <a href="#" class="b_right"></a>
        </div>
        <div class="p_left"> </div>
        <div class="p_right"> </div>
        <div id="play"><div>
        </div>
            <audio src="http://zhangmenshiting.qianqian.com/data2/music/bf160d8f4fb3bb924659f20a3b00f8b6/559184460/100575177118800128.mp3?xcode=ecb6cee984c1514037ff48ca31f559c2" autoplay="autoplay"></audio>
</div>
<script>
    $(".forward").click(function(){
        window.location.href = "/musician";
    });
</script>
</body>
</html>