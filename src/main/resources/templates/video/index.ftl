<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"/>
    <title>视频播放器</title>
    <link href="./static/css/video/reset.css" rel="stylesheet" type="text/css" />
    <link href="./static/css/video/willesPlay.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="./static/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="./static/js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="./static/js/video/willesPlay.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="container">
    <div class="search" style="width: 100%;height: 80px;">
        <div class="m_s_content">
            <input type="text" class="m_s_c_input" placeholder="请输入Mp4地址"/>
        </div>
        <span class="m_s_searcch">
             <i class="fa fa-search"></i>
                获取
            </span>
    </div>
    <div class="row">
        <div class="col-sm-9">
            <div id="willesPlay">
                <div class="playHeader">
                    <div class="videoName">
                        <#list movieList as movie>
                            <#if movie_index==0>
                                ${movie.fileName}
                            </#if>
                        </#list>
                    </div>
                </div>
                <div class="playContent">
                    <div class="turnoff">
                        <ul>
                            <li><a href="javascript:;" title="喜欢" class="glyphicon glyphicon-heart-empty"></a></li>
                            <li><a href="javascript:;" title="关灯"
                                   class="btnLight on glyphicon glyphicon-sunglasses"></a></li>
                            <li><a href="javascript:;" title="分享" class="glyphicon glyphicon-share"></a></li>
                        </ul>
                    </div>
                    <video width="100%" id="playVideo">
                        <#list movieList as movie>
                            <#if movie_index==0>
                                 <source src="${movie.fileSystemName}" type="video/mp4"></source>
                            </#if>
                        </#list>
                        当前浏览器不支持 video直接播放，点击这里下载视频： <a href="/">下载视频</a>
                    </video>
                    <div class="playTip glyphicon glyphicon-play"></div>
                </div>
                <div class="playControll">
                    <div class="playPause playIcon"></div>
                    <div class="timebar">
                        <span class="currentTime">0:00:00</span>
                        <div class="progress">
                            <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar"
                                 aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
                        </div>
                        <span class="duration">0:00:00</span>
                    </div>
                    <div class="otherControl">
                        <span class="volume glyphicon glyphicon-volume-down"></span>
                        <span class="fullScreen glyphicon glyphicon-fullscreen"></span>
                        <div class="volumeBar">
                            <div class="volumewrap">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuemin="0"
                                         aria-valuemax="100" style="width: 8px;height: 40%;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div id="movieList">
                <p class="m_title"><i class="fa fa-fire"></i>&nbsp;&nbsp;热点播放</p>
                <ul>
                    <#list movieList as movie>
                       <li data-movieUrl="${movie.fileSystemName}" data-movieName="${movie.fileName}">
                           <p class="m_con">${movie.fileName}</p>
                           <i class="fa fa-play-circle-o"></i>
                       </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
    <br>
    <div class="row info">
        <div class="col-sm-6">
            <p class="i_title"><i class="fa fa-heart"></i>&nbsp;&nbsp;收藏中心</p>
            <ul>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
            </ul>
        </div>
        <div class="col-sm-6">
            <p class="i_title"><i class="fa fa-upload"></i>&nbsp;&nbsp;上传中心</p>
            <ul>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
                <li>
                    <p class="m_con">哈哈哈哈</p>
                    <i class="fa fa-play-circle-o"></i>
                </li>
            </ul>
        </div>
    </div>
</div>
<br>
<br>
<script type="text/javascript">
    $(".m_s_searcch").click(function(){
        var url = $(".m_s_c_input").val();
        $("#playVideo").attr("src",url);
    });

    $("#movieList ul li").click(function(){
        var movieName = $(this).attr("data-movieName");
        var movieUrl = $(this).attr("data-movieUrl");
        $("#playVideo").attr("src",movieUrl);
        $(".videoName").html(movieName);
    });
</script>
</body>
</html>
