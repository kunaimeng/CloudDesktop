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
    <br>
    <div id="win10-shortcuts" class="shortcuts-hidden">
        <div class="win10-title">
            <div class="search" style="width: 100%;height: 80px;">
                <div class="m_s_content">
                    <input type="text" class="m_s_c_input" placeholder="我爱你"/>
                </div>
                <span class="m_s_searcch">
             <i class="fa fa-search"></i>
                搜索歌手
            </span>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 28px;">
        <div class="col-sm-12">
            <div id="movieList">
                <ul>
                    <#list musician as musicer>
                        <li class="col-sm-2" onclick="goMusic(${musicer.musicianBdId?c})">
                            <div class="col_img">
                                <img src="${musicer.musicianBdImg}" alt="${musicer.musicianName}">
                            </div>
                            <br>
                            <p class="m_con">${musicer.musicianName}</p>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    function goMusic(obj) {
        window.location.href = "/music?songMusicianId="+obj;
    }

</script>
</body>
</html>