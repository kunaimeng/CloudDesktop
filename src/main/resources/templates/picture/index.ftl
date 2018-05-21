<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>天气</title>
    <link href="./static/weather/css/default.css" rel="stylesheet" type="text/css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="./static/css/wallpaper.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="main">
        <div>
            <ul id="photo" class="clearfix">
             <#list photoList as photo>
                 <li>${photo.fileName}
                     <img src="${photo.fileSystemName}" alt="${photo.fileName}">
                 </li>
             </#list>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
</body>
</html>
