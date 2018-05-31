<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>软件中心</title>
    <link rel="stylesheet" href="./static/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./static/weather/css/climacons.css"/>
    <link rel="stylesheet" type="text/css" href="./static/css/software.css"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-success alert-dismissable">
                请点击一下应用进行安装。
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column software">
            <div class="row clearfix">
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-windows icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-windows  icon blue" data-title="我的电脑" data-desc="文件管理"
                         data-src="/file">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装我的电脑</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-edge icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-internet-explorer icon blue" data-title="云桌面浏览器" data-desc="访问网络"
                         data-src="/explorer">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装云桌面浏览器</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-wechat icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-wechat icon blue" data-title="DeskChatTo" data-desc="云桌面交流"
                         data-src="/chat">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装DeskChatTo</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-caret-square-o-right icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-caret-square-o-right icon blue" data-title="视频播放器"
                         data-desc="视频播放" data-src="/video">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装视频播放器</span>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-music icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-music icon blue" data-title="音乐播放器" data-desc="音乐播放"
                         data-src="/music">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装音乐播放器</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="icon-clima-1 icon blue"></i>
                    </div>
                    <div class="s_check" data-img="icon-clima-1 icon blue" data-title="天气查询" data-desc="天气查询"
                         data-src="/weather">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装天气查询</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-google-wallet icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-google-wallet icon blue" data-title="桌面壁纸" data-desc="桌面壁纸"
                         data-src="/wallpaper">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装桌面壁纸</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-picture-o icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-picture-o icon blue" data-title="我的相册" data-desc="我的相册"
                         data-src="/picture">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装我的相册</span>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-gavel icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-gavel icon blue" data-title="打地鼠" data-desc="打地鼠小游戏"
                         data-src="/game/dadishu">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装打地鼠</span>
                    </div>
                </div>
                <div class="col-md-3 column softItem">
                    <div class="s_img">
                        <i class="fa fa-gg-circle  icon blue"></i>
                    </div>
                    <div class="s_check" data-img="fa fa-gg-circle  icon blue" data-title="捕鱼达人" data-desc="捕鱼达人小游戏"
                         data-src="/game/buyvdaren">
                        <i class="fa fa-plus"></i>&nbsp;&nbsp;<span>安装捕鱼达人</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript">
    $(".s_check").click(function () {
        var obj = $(this);
        var desktopImg = obj.attr("data-img");
        var desktopTitle = obj.attr("data-title");
        var desktopDesc = obj.attr("data-desc");
        var desktopOpensrc = obj.attr("data-src");
        layer.confirm('确认安装' + obj.attr("data-title") + '吗?', {icon: 3, title: "提示"}, function (index) {
            $.ajax({
                type: 'post',
                url: "/insertDesk",
                data: {
                    "desktopImg": desktopImg,
                    "desktopTitle": desktopTitle,
                    "desktopDesc": desktopDesc,
                    "desktopOpensrc": desktopOpensrc
                },
                dataType: "json",
                beforeSend: function () {
                    layer.close(index);
                    index = layer.load(2, {time: 10 * 1000});
                },
                success: function (msg) {
                    layer.close(index);
                    obj.find("i").attr("class", "fa fa-check");
                    obj.find("span").text("已安装");
                },
                error: function () {
                    layer.close(index);
                    layer.alert("出错了，请稍后重试");
                }
            });
        });
    });
</script>
</body>
</html>
