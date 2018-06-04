<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>云桌面计算器</title>
    <link href="../static/css/calcSS3.css" rel="stylesheet" type="text/css" />
    <link href="../static/css/index.css" rel="stylesheet" type="text/css" />
    <!--[if IE]>
    <script src="http://libs.baidu.com/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="calc-main">
    <div class="calc-display">
        <span>0</span>
        <div class="calc-rad">Rad</div>
        <div class="calc-hold"></div>
        <div class="calc-buttons" style="display: none;">
            <div class="calc-info">?</div>
            <div class="calc-smaller">&gt;</div>
            <div class="calc-ln">.</div>
        </div>
    </div>
    <div class="calc-left">
        <div><div>2nd</div></div>
        <div><div>(</div></div>
        <div><div>)</div></div>
        <div><div>%</div></div>
        <div><div>1/x</div></div>
        <div><div>x<sup>2</sup></div></div>
        <div><div>x<sup>3</sup></div></div>
        <div><div>y<sup>x</sup></div></div>
        <div><div>x!</div></div>
        <div><div>&radic;</div></div>
        <div><div class="calc-radxy">
            <sup>x</sup><em>&radic;</em><span>y</span>
        </div></div>
        <div><div>log</div></div>
        <div><div>sin</div></div>
        <div><div>cos</div></div>
        <div><div>tan</div></div>
        <div><div>ln</div></div>
        <div><div>sinh</div></div>
        <div><div>cosh</div></div>
        <div><div>tanh</div></div>
        <div><div>e<sup>x</sup></div></div>
        <div><div>Deg</div></div>
        <div><div>&pi;</div></div>
        <div><div>EE</div></div>
        <div><div>Rand</div></div>
    </div>
    <div class="calc-right">
        <div><div>mc</div></div>
        <div><div>m+</div></div>
        <div><div>m-</div></div>
        <div><div>mr</div></div>
        <div class="calc-brown"><div >AC</div></div>
        <div class="calc-brown"><div>+/&#8211;</div></div>
        <div class="calc-brown calc-f19"><div>&divide;</div></div>
        <div class="calc-brown calc-f21"><div>&times;</div></div>
        <div class="calc-black"><div>7</div></div>
        <div class="calc-black"><div>8</div></div>
        <div class="calc-black"><div>9</div></div>
        <div class="calc-brown calc-f18"><div>&#8211;</div></div>
        <div class="calc-black"><div>4</div></div>
        <div class="calc-black"><div >5</div></div>
        <div class="calc-black"><div>6</div></div>
        <div class="calc-brown calc-f18"><div>+</div></div>
        <div class="calc-black"><div>1</div></div>
        <div class="calc-black"><div>2</div></div>
        <div class="calc-black"><div>3</div></div>
        <div class="calc-blank"><textarea></textarea></div>
        <div class="calc-orange calc-eq calc-f17"><div>
            <div class="calc-down">=</div>
        </div></div>
        <div class="calc-black calc-zero"><div>
            <span>0</span>
        </div></div>
        <div class="calc-black calc-f21"><div>.</div></div>
    </div>
</div>
<script type="text/javascript" src="../static/js/calcSS3.js"></script>
</body>
</html>