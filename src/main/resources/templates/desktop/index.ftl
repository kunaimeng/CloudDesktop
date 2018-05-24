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
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/win10.js"></script>
    <script type="text/javascript" src="./static/js/socket/promptWebSocket.js"></script>
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
                main: './static/img/wallpapers/main.jpg',
                mobile: './static/img/wallpapers/mobile.jpg',
            });

            Win10.setAnimated([
                'animated flip',
                'animated bounceIn',
            ], 0.01);

            setTimeout(function () {
                Win10.openUrl('/news', '<i class="fa fa-newspaper-o icon red"></i>最新资讯', [['650px', '450px'], 'rt'])
            }, 2000);
        });
    </script>
</head>
<body>
<div id="win10">
    <div class="desktop">
        <div id="win10-shortcuts" class="shortcuts-hidden">
            <div class="shortcut"
                 onclick="Win10.openUrl('/file','<img class=\'icon\' src=\'./static/img/icon/win10.png\'/>我的电脑')">
                <img class="icon" src="./static/img/icon/win10.png"/>
                <div class="title">我的电脑</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/explorer","<i class=\"fa fa-edge icon blue\"></i>云桌面浏览器")'>
                <i class="fa fa-edge icon blue"></i>
                <div class="title">云桌面浏览器</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/chat","<i class=\"fa fa-wechat icon blue\"></i>DeskChatTo")'>
                <i class="fa fa-wechat icon blue"></i>
                <div class="title">DeskChatTo</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/video","<i class=\"fa fa-caret-square-o-right icon blue\"></i>视频播放器")'>
                <i class="fa fa-caret-square-o-right icon blue"></i>
                <div class="title">视频播放器</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/music","<i class=\"fa fa-music icon blue\"></i>音乐")'>
                <i class="fa fa-music icon blue"></i>
                <div class="title">音乐</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/weather","<i class=\"icon-clima-1 icon blue\"></i>天气")'>
                <i class="icon-clima-1 icon blue"></i>
                <div class="title">天气</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/wallpaper","<i class=\"fa fa-photo icon blue\"></i>壁纸")'>
                <i class="fa fa-photo icon blue"></i>
                <div class="title">壁纸</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/picture","<i class=\"fa fa-picture-o icon blue\"></i>相册")'>
                <i class="fa fa-picture-o icon blue"></i>
                <div class="title">相册</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/game/dadishu","<i class=\"fa fa-gavel icon blue\"></i>打地鼠")'>
                <i class="fa fa-gavel icon blue"></i>
                <div class="title">打地鼠</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("/game/buyvdaren","<i class=\"fa fa-gg-circle icon blue\"></i>捕鱼达人")'>
                <i class="fa fa-gg-circle icon blue"></i>
                <div class="title">捕鱼达人</div>
            </div>
            <div class="shortcut"
                 onclick="Win10.openUrl('win10ui.yuri2.cn/src/doc.php','<img class=\'icon\' src=\'./static/img/icon/doc.png\'/>在线文档')">
                <img class="icon" src="./static/img/icon/doc.png"/>
                <div class="title">在线文档</div>
            </div>
            <div class="shortcut"
                 onclick='Win10.openUrl("win10ui.yuri2.cn/src/workshop.php","<i class=\"fa fa-gears icon purple\"></i>设置")'>
                <i class="fa fa-gears icon purple"></i>
                <div class="title">设置</div>
            </div>
        </div>
        <div id="win10-desktop-scene"></div>
    </div>
    <div id="win10-menu" class="hidden">
        <div class="list win10-menu-hidden animated animated-slideOutLeft">
            <div class="item"><i class="red icon fa fa-wrench fa-fw"></i><span>API测试</span></div>
            <div class="sub-item" onclick="Win10.openUrl('./child.html','子页')">父子页沟通</div>
            <div class="sub-item" onclick="Win10.commandCenterOpen()">打开消息中心</div>
            <div class="sub-item"
                 onclick="Win10.newMsg('API测试','通过API可以发送消息至消息中心，自定义标题与内容(点击我试试)',function() {alert('click')})">发送带回调的消息
            </div>
            <div class="sub-item" onclick="Win10.menuClose()">关闭菜单</div>
            <div class="item"><i class="blue icon fa fa-gavel fa-fw"></i>辅助工具</div>
            <div class="sub-item" onclick="Win10.openUrl('win10ui.yuri2.cn/src/tools/builder-shortcut.html','图标代码生成器')">
                桌面图标代码生成器
            </div>
            <div class="sub-item" onclick="Win10.openUrl('win10ui.yuri2.cn/src/tools/builder-tile.html','磁贴代码生成器')">
                磁贴代码生成器
            </div>
            <div class="sub-item" onclick="Win10.openUrl('win10ui.yuri2.cn/src/tools/builder-menu.html','菜单代码生成器')">
                菜单代码生成器
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
        </div>
        <div id="win10_btn_group_middle" class="btn_group"></div>
        <div id="win10_btn_group_right" class="btn_group">
            <div class="btn" id="win10_btn_time"></div>
            <div class="btn" id="win10_btn_command"><span id="win10-msg-nof" class="fa fa-comment-o"></span></div>
            <div class="btn" id="win10_btn_show_desktop"></div>
        </div>
    </div>
</div>
</body>
</html>