<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>云桌面</title>
    <link rel='Shortcut Icon' type='image/x-icon' href='./static/img/windows.ico'>
    <link href="./static/css/animate.css" rel="stylesheet">
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="./static/css/default.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./static/weather/css/climacons.css"/>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/component2.css"/>
    <link rel="stylesheet" type="text/css" href="./static/css/audio.css">
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/win10.js"></script>
    <script type="text/javascript" src="./static/js/socket/promptWebSocket.js"></script>
    <script type="text/javascript" src="./static/js/audio.js"></script>
    <style>
        * {
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu
        }

        /*磁贴自定义样式*/
        .win10-block-content-text {
            line-height: 44px;
            text-align: center;
            font-size: 16px;
        }
    </style>
    <script>
        Win10.onReady(function () {
            //设置壁纸
            Win10.setBgUrl({
                main: '${userInfo.userBgimg}',
                mobile: '${userInfo.userSmbgimg}',
            });

            if (${mainBg?c}) {
                setTimeout(function () {
                    Win10.newMsg("更换壁纸提醒", "<a onclick='Win10.openUrl(\"/wallpaper\",\"<i class=\\\"fa fa-google-wallet icon blue\\\"></i>桌面壁纸\")'>系统检测到，你使用的是默认壁纸，点击更换</a>");
                }, 4000);
            }

            if (${software?c}) {
                setTimeout(function () {
                    Win10.newMsg("安装软件提醒", "<a onclick='Win10.openUrl(\"/software\",\"<i class=\\\"fa fa-gears icon blue\\\"></i>软件中心\")'>系统检测到，你还没有安装任何软件，点击安装</a>");
                }, 3000);
            }

            Win10.setAnimated([
                'animated flip',
                'animated bounceIn',
            ], 0.01);

            setTimeout(function () {
                Win10.openUrl('/news', '<i class="fa fa-newspaper-o icon"></i>最新资讯', [['650px', '450px'], 'rt'])
            }, 2000);
        });
    </script>
</head>
<body>
<div id="win10">
    <div class="desktop">
        <div id="win10-shortcuts" class="shortcuts-hidden">
            <div class="shortcut"
                 onclick='Win10.openUrl("/software","<i class=\"fa fa-gears icon blue\"></i>软件中心")'>
                <i class="fa fa-gears icon blue"></i>
                <div class="title">软件中心</div>
            </div>
            <#list cdDesktopList as soft>
                 <div class="shortcut"
                      onclick='Win10.openUrl("${soft.desktopOpensrc}","<i class=\"${soft.desktopImg}\"></i>${soft.desktopTitle}")'>
                     <i class="${soft.desktopImg}"></i>
                     <div class="title">${soft.desktopTitle}</div>
                 </div>
            </#list>
        </div>
        <div id="win10-desktop-scene"></div>
    </div>
    <div class="audio-box" style="display: none;">
        <div class="audio-container">
            <div class="audio-list">
                <div class="audio-list-head">
                    <p>歌单</p>
                    <span class="menu-close">关闭</span>
                </div>
                <ul class="audio-inline">
                </ul>
            </div>
            <div class="audio-view">
                <div class="audio-body">
                    <h3 class="audio-title">未知歌曲</h3>
                    <div class="audio-backs">
                        <div class="audio-this-time">00:00</div>
                        <div class="audio-count-time">00:00</div>
                        <div class="audio-setbacks">
                            <i class="audio-this-setbacks">
                                <span class="audio-backs-btn"></span>
                            </i>
                            <span class="audio-cache-setbacks">
							</span>
                        </div>
                    </div>
                </div>
                <div class="audio-btn">
                    <div class="audio-select">
                        <div class="audio-prev"></div>
                        <div class="audio-play"></div>
                        <div class="audio-next"></div>
                        <div class="audio-menu"></div>
                        <div class="audio-volume"></div>
                        <div class="audio-mini">
                            <i class="fa fa-window-minimize"></i>
                        </div>
                        <div class="audio-cloae">
                            <i class="fa fa-close"></i>
                        </div>
                    </div>
                    <div class="audio-set-volume">
                        <div class="volume-box">
                            <i><span></span></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="win10-menu" class="hidden">
        <div class="list win10-menu-hidden animated animated-slideOutLeft">
            <div class="item"><i class="red icon fa fa-wrench fa-fw"></i><span>应用</span></div>
            <#if isAdmin?? >
                <div class="sub-item" onclick="Win10.openUrl('/soft/index','新开发功能录入')">新开发功能录入</div>
                <div class="sub-item" onclick="Win10.openUrl('/init/newsSchedule','新闻信息初始化')">新闻信息初始化</div>
                <div class="sub-item" onclick="Win10.openUrl('/init/wallpaperSchedule','壁纸信息初始化')">壁纸信息初始化</div>
                <div class="sub-item" onclick="Win10.openUrl('/init/weatherSchedule','天气信息初始化')">天气信息初始化</div>
                <div class="sub-item" onclick="Win10.openUrl('/init/promptAdd','提示用语初始化')">提示用语初始化</div>
                <div class="sub-item" onclick="Win10.openUrl('/init/musicianData','初始化歌手信息')">初始化歌手信息</div>
                <div class="sub-item" onclick="Win10.openUrl('/init/getMusicianInfoAndMuisc','爬取歌手歌曲信息')">爬取歌手歌曲信息</div>
            </#if>
            <div class="sub-item" onclick='Win10.openUrl("/software","<i class=\"fa fa-gears icon blue\"></i>软件中心")'>
                程序与功能
            </div>
            <div class="sub-item" onclick="Win10.commandCenterOpen()">消息中心</div>
            <div class="sub-item" onclick="Win10.menuClose()">关闭菜单</div>
            <div class="item"><i class="blue icon fa fa-gavel fa-fw"></i>辅助工具</div>
            <div class="sub-item" onclick="Win10.openUrl('/assist/calculator','云桌面计算器')">
                云桌面计算器
            </div>
            <div class="sub-item" onclick="showMusic()">
                迷你播放器
            </div>
            <div class="item" onclick="Win10.aboutUs()"><i class="purple icon fa fa-info-circle fa-fw"></i>关于</div>
            <div class="item" onclick=" Win10.exit();"><i class="black icon fa fa-power-off fa-fw"></i>关闭</div>
        </div>
        <div class="blocks">
            <div class="menu_group">
                <div class="title">
                    应用示例
                </div>
                <div loc="1,1" size="6,3" class="block">
                    <div class="content red detail">
                        <iframe style="margin-top: 10px" frameborder="no" border="0" marginwidth="0" marginheight="0"
                                width=264 height=110
                                src="//music.163.com/outchain/player?type=2&id=110771&auto=0&height=90"></iframe>
                    </div>
                    <div class="content red cover">
                        <img width="264" style="position: relative;top: -50px;"
                             src="./static/img/presentation/wangyiyun.gif"/>
                    </div>
                </div>
                <div loc="1,4" size="4,4" class="block">
                    <div class="content blue cover" style="font-size: 30px;line-height: 176px;text-align: center">
                        <i class="fa fa-cloud fa-fw"></i> 天气
                    </div>
                    <div class="content detail" style="background-color: rgb(46,147,217)">
                        <iframe src="//www.seniverse.com/weather/weather.aspx?uid=U43DF172E7&cid=CHBJ000000&l=&p=SMART&a=1&u=C&s=13&m=2&x=1&d=1&fc=&bgc=2E93D9&bc=&ti=0&in=0&li="
                                frameborder="0" scrolling="no" width="200" height="300"
                                allowTransparency="true"></iframe>
                    </div>
                </div>
                <div loc="5,4" size="2,2" class="block">
                    <div class="content">
                        <img style="display: inline-block;border-radius: 4px" width="88px"
                             src="http://q2.qlogo.cn/headimg_dl?bs=824831811&dst_uin=824831811&src_uin=824831811&fid=824831811&spec=100&url_enc=0&referer=bu_interface&term_type=PC"/>
                    </div>
                </div>
                <div loc="5,6" size="2,2" class="block" onclick="win10_forgive_me()">
                    <div class="content red">
                        <div style="text-align: center;font-size: 30px;line-height: 44px"><i
                                class="fa fa-bug fa-fw"></i></div>
                        <div style="text-align: center;font-size: 16px;line-height: 44px">别点我</div>
                    </div>
                </div>
            </div>

            <div class="menu_group">
                <div class="title">
                    常用场景
                </div>
                <div loc="1,1" size="4,3" class="block">
                    <div class="content" style="background-color: orangered">
                        <div class="win10-block-content-text" style="font-size: 26px;line-height: 88px">WIN10-UI</div>
                        <div class="win10-block-content-text">显示信息</div>
                    </div>
                </div>
                <div loc="5,1" size="2,1" class="block">
                    <div class="content" style="background-color: green">
                        <div class="win10-block-content-text">文字按钮</div>
                    </div>
                </div>
                <div loc="5,2" size="2,2" class="block">
                    <div class="content">
                        <img style="width: 40px;height: 40px;margin: 5px auto;display: block"
                             src="./static/img/icon/baidu.png">
                        <div class="win10-block-content-text">图标按钮</div>
                    </div>
                </div>
                <div loc="1,4" size="6,3" class="block">
                    <div class="content"
                         style="background: url('./static/img/presentation/1.png');background-size: auto">
                        <div style="line-height:132px;text-align: center;">显示图片</div>
                    </div>
                </div>
                <div loc="1,7" size="2,1" class="block">
                    <div class="content" style="background-color: grey" onclick="Win10.openUrl('//www.baidu.com')">
                        <div class="win10-block-content-text">内部链接</div>
                    </div>
                </div>
                <div loc="3,7" size="2,1" class="block">
                    <div class="content" style="background-color: blue" onclick="window.open('https://www.baidu.com')">
                        <div class="win10-block-content-text">外部链接</div>
                    </div>
                </div>
            </div>
        </div>
        <div id="win10-menu-switcher"></div>
    </div>
    <div id="win10_command_center" class="hidden_right">
        <div class="title">
            <h4 style="float: left">消息中心 </h4>
            <span id="win10_btn_command_center_clean_all">全部清除</span>
        </div>
        <div class="msgs"></div>
    </div>
    <div id="win10_task_bar">
        <div id="win10_btn_group_left" class="btn_group">
            <div id="win10_btn_win" class="btn"><span class="fa fa-windows"></span></div>
            <div class="btn" id="win10-btn-browser"><span class="fa fa-internet-explorer"></span></div>
            <div class="btn" id="win10-btn-news"><span class="fa fa-newspaper-o"></span></div>
        </div>
        <div id="win10_btn_group_middle" class="btn_group"></div>
        <div id="win10_btn_group_right" class="btn_group">
            <div class="btn" id="win10_btn_time"></div>
            <div class="btn" id="win10_btn_command"><span id="win10-msg-nof" class="fa fa-comment-o"></span></div>
            <div class="btn" id="win10_btn_show_desktop"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var listAry = [];
         <#list musicList as music>
             listAry.push({cover: '', src: '${music.fileSystemName}', title: '${music.fileName}'});
         </#list>
        var audioFn =  audioPlay({
            song: listAry,
            autoPlay: false
        });
        //最小化
        $(".audio-mini").click(function(){
            $(".audio-box").hide();
        });
        //退出
        $(".audio-cloae").click(function(){
            audioFn.stopAudio();
            $(".audio-box").hide();
        });
    });
    //显示
    function showMusic(){
        $(".audio-box").show().addClass('animated bounceInDown');
        Win10.menuClose()
    }
</script>
</body>
</html>