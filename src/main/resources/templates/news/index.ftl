<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新闻</title>
    <link href="./static/weather/css/default.css" rel="stylesheet" type="text/css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/win10.js"></script>
    <link href="./static/css/news.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="main">
        <ul>
            <#list news as new>
                <li onclick='Win10.openUrl("${new.url}","<i class=\"fa fa-newspaper-o icon red\"></i>最新资讯")'><i class="fa fa-link"></i>${new.title}</li>
            </#list>
        </ul>
    </div>
</div>
</body>
</html>
