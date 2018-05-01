<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>云桌面</title>
    <link type="text/css" rel="stylesheet" href="./static/css/animate.css">
    <link type="text/css" rel="stylesheet" href="./static/css/default.css">
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/win10.js"></script>
    <link type="text/css" rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="./static/css/explorer.css">
<body>
<div class="container explorer">
    <div class="tab-group">
        <div class="search">
            <div class="s_btn">
                <i class="fa fa-arrow-left"></i>
                <i class="fa fa-arrow-right"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-folder-open"></i>
                <i class="fa fa-refresh"></i>
            </div>
            <div class="s_input">
                <input type="text">
            </div>
        </div>
        <hr style="height:1px;border:none;border-top:1px solid #444;"/>
        <section id="tab1" title="百度一下，你就知道 ">
            <p>
                <iframe src="http://www.baidu.com" style="width: 100%;" frameborder="0"></iframe>
            </p>
        </section>
        <section id="tab2" title="新标签页">
            <p>
                <iframe src="http://www.qq.com" style="width: 100%;" frameborder="0"></iframe>
            </p>
        </section>
    </div>
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/js/prefixfree.min.js"></script>
    <script type="text/javascript" src="./static/js/jquery-tab.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.tab-group').tabify();
            $("section p iframe").css("height", ($("body").height() - 115) + "px");

            //输入框回车
            $(".search .s_input input").keydown(function (e) {
                if (e.keyCode == 13) {
                    var tabId = $(".container  .tab-group .tab-nav .active a").attr("href");
                    $(tabId + " p iframe").attr("src", $(".search .s_input input").val());
                }
            });

            //刷新按钮
            $(".search .s_btn .fa-refresh").click(function () {
                var tabId = $(".container  .tab-group .tab-nav .active a").attr("href");
                $(tabId + " p iframe").attr("src", $(tabId + " p iframe").attr("src"));
            });

            $(".tab-nav .fa-times").click(function () {
                $(this).parent().remove();
            });
        })
    </script>
</body>
</html>