<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>时钟</title>
    <link rel="stylesheet" href="./static/css/clock.css" media="screen" type="text/css"/>
</head>
<body>
<div class="fill">
    <div class="reference"></div>
    <div class="clock" id="utility-clock">
        <div class="centre">
            <div class="dynamic"></div>
            <div class="expand round circle-1"></div>
            <div class="anchor hour">
                <div class="element thin-hand"></div>
                <div class="element fat-hand"></div>
            </div>
            <div class="anchor minute">
                <div class="element thin-hand"></div>
                <div class="element fat-hand minute-hand"></div>
            </div>
            <div class="anchor second">
                <div class="element second-hand"></div>
            </div>
            <div class="expand round circle-2"></div>
            <div class="expand round circle-3"></div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/clock.js"></script>
</body>
</html>