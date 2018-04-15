﻿<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<style type="text/css">
body, div, canvas {image-rendering: optimizeSpeed;-webkit-image-rendering: optimizeSpeed;-webkit-interpolation-mode: nearest-neighbor;}
body{padding:0; margin:0;font-size:12px;background-color:#000;}
body, html{height: 100%;}
#outer{height:100%; overflow:hidden; position:relative; width:100%;}
#outer[id]{display:table; position:static;}
#middle{position:absolute; top:50%;} /* for ie only*/
#middle[id]{display:table-cell; vertical-align:middle; position:static;}
</style>
<title>捕鱼达人</title>
<script type="text/javascript" src="../static/game/buyvdaren/js/quark.base-1.0.0.alpha.min.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/R.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/Utils.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/fishjoy.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/FishManager.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/FishGroup.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/views/Fish.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/views/Cannon.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/views/Bullet.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/views/Num.js"></script>
<script type="text/javascript" src="../static/game/buyvdaren/src/views/Player.js"></script>
</head>
<body>
<div id="outer">
	<div id="middle">
		<div id="container" style="position:relative;width:980px;height:545px;top:-50%;margin:0 auto;"></div>
		<div id="msg"></div>
	</div>
</div>
<div id="fps" style="position:absolute;top:0;left:0;color:#fff;"></div>
<audio src="../static/game/buyvdaren/buyvdaren.wav" hidden="false" style="display: none;" autoplay="true" loop="true">
</body>
</html>