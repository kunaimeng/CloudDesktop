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
    <script type="text/javascript" src="./static/js/jquery.scrollbar.min.js"></script>
    <script type="text/javascript" src="./static/js/jquery-tab.js"></script>
    <link type="text/css" rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="./static/css/jquery.scrollbar.min.css">
    <link type="text/css" rel="stylesheet" href="./static/css/explorer.css">
<body>
<div id="win10">
    <div id="win10-shortcuts" class="shortcuts-hidden">
        <div class="search">
            <div class="s_input">
                <input type="text" value="https://">
            </div>
            <div class="s_btn">
                <i class="fa fa-refresh" title="刷新"></i>
                <i class="fa fa-plus" title="新建标签页"></i>
            </div>
        </div>
        <div>
            <div class="nth-tabs" id="editor-tabs"></div>
        </div>
    </div>
</div>
<script>
    var nthTabs;
    var idValue = 'ID';
    var i = 0;
    var iframeHeight = document.documentElement.clientHeight - 100;
    $(function () {
        nthTabs = $("#editor-tabs").nthTabs();
        nthTabs.addTab({
            id: idValue + i,
            title: '新标签页',
            content: '<iframe style="height:'+iframeHeight+'px;width: 100%;" frameborder="no"></iframe>',
        }).setActTab("#" + idValue + i + "");

        //新增标签页
        $(".fa-plus").click(function () {
            i++;
            hei = document.documentElement.clientHeight - 100;
            nthTabs.addTab({
                id: idValue + i,
                title: '新标签页',
                content: '<iframe style="height:'+iframeHeight+'px;width: 100%;" frameborder="no"></iframe>',
            }).setActTab("#" + idValue + i + "");
        });
    });

    var reg = /^([hH][tT]{2}[pP]:\/\/|[hH][tT]{2}[pP][sS]:\/\/)(([A-Za-z0-9-~]+)\.)+([A-Za-z0-9-~\/])+$/;
    $('.s_input input').on('keypress', function (event) {
        if (event.keyCode == 13) {
            show();
        }
    });

    $(".fa-refresh").click(function () {
        show();
    });

    //刷新  回车
    function show() {
        var url = $('.s_input input').val();
        $(".content-tabs-container .nav-tabs .active a span").html(url);
        $(".tab-content .active iframe").attr("src", url);
    }

    //定时刷新窗口高低
    setInterval(function () {
        iframeHeight = document.documentElement.clientHeight - 100;
        $(".tab-content iframe").css("height", iframeHeight);
    }, 300);
</script>
</body>
</html>