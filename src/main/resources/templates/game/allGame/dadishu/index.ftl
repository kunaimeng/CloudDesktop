<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8"/>
    <title>HTML5打地鼠小游戏</title>
    <link type="text/css" rel="stylesheet" href="../static/game/dadishu/css/main.css"/>
</head>
<body>
<div id="hitmouse">
    <!-- 预备界面 -->
    <div id="gameCover" class="block background">
        <!-- 声音控制按钮 -->
        <a href="javascript:void(0)" id="btnSound" class="icon">&nbsp;</a>
        <!-- 开始 -->
        <a href="javascript:void(0)" id="btnPlay" class="icon">&nbsp;</a>
        <!-- 帮助 -->
        <a href="javascript:void(0)" id="btnHelp" class="icon">&nbsp;</a>
        <!-- 关于我 -->
        <a href="javascript:void(0)" id="btnAboutMe" class="icon">&nbsp;</a>
        <!-- 加载资源 -->
        <span id="progressText"></span>
    </div>
    <!-- 帮助界面 -->
    <div id="HelpDiv">
        <!-- 帮助图片 -->
        <img src="../static/game/dadishu/images/help.png"/>
        <a href="javascript:void(0)" id="btnBack" class="icon">&nbsp;</a>
    </div>
    <!-- 游戏主体 -->
    <div id="gameBody" class="block">
        <div id="gameCanvas" class="block">
            <!-- Main背景层 -->
            <canvas width="750" height="550" id="maincanvas"></canvas>
        </div>
        <!-- 分数及暂停按钮 -->
        <div id="numberAndPause" class="block">
            <!-- 分数 -->
            <div id="numberBefore" class="icon"></div>
            <div id="number"></div>
            <!-- 暂停 -->
            <a href="javascript:void(0)" id="btnPause" class="icon">&nbsp;</a>
        </div>
        <!-- 下一关提示 -->
        <div id="nextLoding">
            <!-- 分数 -->
            <span id="currentScore"></span>
            <spqn id="requireScore"></span>
        </div>
    </div>
    <!-- 游戏结束 -->
    <div id="gameOver" class="block">
        <!-- 得分 -->
        <span id="score"></span>
        <!-- 准备 -->
        <a href="javascript:void(0)" id="btnRetry" class="icon">&nbsp;</a>
        <!-- 返回主菜单 -->
        <a href="javascript:void(0)" id="btnBackToMenu" class="icon">&nbsp;</a>
    </div>
</div>
<!--我使用这个框架的代码并不多，主要是工具类使用-->
<script type="text/javascript" src="../static/game/dadishu/myEngine/core/my.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/component/Component.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/component/DisplayObject.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/component/Bitmap.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/utils/ImageManager.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/utils/DOM.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/utils/Math.js"></script>
<script type="text/javascript" src="../static/game/dadishu/myEngine/utils/buzz.js"></script>

<script type="text/javascript" src="../static/game/dadishu/js/resources/images.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/resources/audios.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/frames/mouse.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/frames/star.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/frames/score.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/Audio.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/Animation.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/star.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/score.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/hammer.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/mouse.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/MouseHit.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/classes/UI.js"></script>
<script type="text/javascript" src="../static/game/dadishu/js/main.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>