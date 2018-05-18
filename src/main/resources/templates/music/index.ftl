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
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">
            &times;
        </a>
        <strong>提示！</strong>音乐搜索出来的内容是其他用户上传的。
    </div>
    <div id="win10-shortcuts" class="shortcuts-hidden">
        <div class="win10-title">
            <div class="search" style="width: 100%;height: 80px;">
                <div class="m_s_content">
                    <input type="text" class="m_s_c_input" placeholder="我爱你"/>
                </div>
                <span class="m_s_searcch">
             <i class="fa fa-search"></i>
                搜索
            </span>
            </div>
        </div>
        <div class="win10-left">
            <p class="m_title"><i class="fa fa-fire"></i>&nbsp;&nbsp;热点播放</p>
            <ul>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
                <li data-src="./static/music/10.mp3" data-name="我爱你"><p>我爱你</p><i class="fa fa-play"></i></li>
            </ul>
        </div>
        <div class="win10-right">
            <div id="music">
                <div class="m_play">
                    <div class="m_p_title">相伴潭州</div>
                    <div class="m_p_but">
                        <i class="fa fa-backward"></i>
                        <i class="fa fa-play btn"></i>
                        <i class="fa fa-forward"></i>
                    </div>
                    <div class="m_lrc"></div>
                </div>
            </div>
            <textarea style="display:none" id='text'>
			[00:00.60]相伴潭州——潭州学院校歌（作词/编曲/演唱：潭州学院）
			[00:01.55]歌词制作
			[00:02.25]古潭州   源流长     书院镇潇湘
			[00:07.26]到如今    薪火旺    再铸新辉煌
			[00:12.86]跨深壑    品类广    传道授业忙
			[00:17.96]攀险峰    传奇唱     续书新篇章
			[00:23.37]风雨同舟  江湖共闯  劈破万里浪
			[00:28.50]相伴有你   日月光芒  将前途照亮
			[00:33.97]夙兴夜寐   心念联网   只为学员想
			[00:39.32]相伴有你   携手图强   奋斗在路上
			[00:46.53]筑平台   伟业昌   悲欢众担当
			[00:56.42]虹之玉   各一方   甘苦齐分尝
			[01:06.30]风雨同舟   江湖共闯   劈破万里浪
			[01:12.43]相伴有你   日月光芒   将前途照亮
			[01:18.00]夙兴夜寐   心念联网   只为学员想
			[01:23.23]相伴有你   携手图强   奋斗在路上
			[01:28.66]相伴有你   携手图强   奋斗在路上
			[01:36.67]
		</textarea>
            <audio src="./static/music/10.mp3" id="myMusic"></audio>
        </div>
    </div>
</div>
<script>
    var btn = document.getElementsByClassName("btn")[0];
    //找到音乐标签
    var music = document.getElementById("myMusic");
    var txt = document.getElementById("text");
    var m_song = document.getElementsByClassName("m_lrc")[0];
    var mark = true;//做一个标记来保存音乐播放的状态
    //绑定一个点击事件 点击播放音乐
    $(".btn").click(function () {
        if (mark)//若果mark为true
        {
            music.play();//播放
            mark = false;
            $(this).attr("class", "fa fa-pause btn");
        } else {
            music.pause();//暂停
            mark = true;
            $(this).attr("class", "fa fa-play btn");
        }
    });
    //console.log(txt.value);//控制台输出
    var lrc = txt.value;//获取歌词
    var lrcArr = lrc.split("[");//去除里面的[
    //console.log(lrcArr);
    var html = '';//保存歌词
    for (var i = 0; i < lrcArr.length; i++) {
        var arr = lrcArr[i].split("]");//去除]
        //console.log(arr[1]);//获取数组里面的值
        //console.log(arr[0]);
        var times = arr[0].split(".");
        var time = times[0].split(":");
        //把时间转换为秒钟
        var ms = time[0] * 60 + time[1] * 1;
        //console.log(ms);
        if (arr[1]) {
            html += "<p id=" + ms + ">" + arr[1] + "</p>";//用一个变量来保存所有的歌词
        }
        m_song.innerHTML = html;//在歌词盒子里面显示
    }
    //歌词同步
    var oP = document.getElementsByTagName("p");
    music.addEventListener("timeupdate", function () {
        var cuTime = parseInt(this.currentTime);//获取当前的播放时间
        //console.log(cuTime);
        if (document.getElementById(cuTime))//若果存在的话就让他变色
        {
            //先把所有的p都改为白色然后再把当前播放的这一句变为红色
            for (var i = 0; i < oP.length; i++) {
                oP[i].style.color = "#000";
            }
            document.getElementById(cuTime).style.color = "#1E9FFF";
        }
    });

    $(".win10-left ul li").click(function () {
        $(".win10-left ul li").attr("class", "");
        $(this).attr("class", "active");
        $(".win10-left ul li i").attr("class", "fa fa-play");
        $(".win10-left ul li i").css({"color": "#fff"});
        $(this).find("i").attr("class", "fa fa-pause")
        $(this).find("i").css({"color": "#1E9FFF"});
        $(".m_p_title").html($(this).attr("data-name"));
        $("#myMusic").attr("src", $(this).attr("data-src"));
        mark = true;
        $(".btn").click();
    });

    $(".fa-backward").click(function () {
        var length = $(".win10-left ul li").length;
        var i = $(".win10-left ul .active").index();
        if (i == 0) {
            layer.alert('亲，到头了呦！', 'Ops...There seems to be a little problem.');
        } else {
            $(".win10-left ul .active").prev().click();
        }
    });
    $(".fa-forward").click(function () {
        var length = $(".win10-left ul li").length;
        var i = $(".win10-left ul .active").index();
        if (i == length - 1) {
            layer.alert('亲，到底了呦！', 'Ops...There seems to be a little problem.');
        } else {
            $(".win10-left ul .active").next().click();
        }
    });
</script>
</body>
</html>