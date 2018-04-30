<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>云桌面</title>
    <link href="./static/css/animate.css" rel="stylesheet">
    <link href="./static/css/default.css" rel="stylesheet">
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <script type="text/javascript" src="./static/js/win10.js"></script>
    <link type="text/css" rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <style type="text/css">
        .clearfix:after, .container:after, .tab-nav:after {
            content: ".";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden;
        }

        *, *:before, *:after {
            box-sizing: border-box;
        }

        body {
            font-family: 'Quicksand', sans-serif;
        }

        .container {
            position: relative;
            background: white;
            padding-top: 3em;
        }

        .tab-group {
            position: relative;
            border: 1px solid #eee;
            border-radius: 0 0 10px 10px;
        }

        .tab-group section {
            opacity: 0;
            height: 0;
            overflow: hidden;
            transition: opacity 0.4s ease, height 0.4s ease;
        }

        .tab-group section.active {
            opacity: 1;
            height: auto;
            overflow: visible;
        }

        .tab-nav {
            list-style: none;
            margin: -2.5em -1px 0 0;
            padding: 0;
            height: 2.5em;
            overflow: hidden;
        }

        .tab-nav li {
            display: inline;
        }

        .tab-nav li a {
            top: 1px;
            position: relative;
            display: block;
            float: left;
            border-radius: 10px 10px 0 0;
            background: #eee;
            line-height: 2em;
            padding: 0 1em;
            text-decoration: none;
            color: grey;
            margin-top: .5em;
            margin-right: 1px;
            transition: background .2s ease, line-height .2s ease, margin .2s ease;
        }

        .tab-nav li.active a {
            background: #6EB590;
            color: white;
            line-height: 2.5em;
            margin-top: 0;
        }

        .search {
            width: 100%;
            height: 30px;
            margin: 10px 0 10px 0;
        }

        .search .s_btn {
            width: 10%;
            height: 100%;
            float: left;
        }

        .search .s_btn i {
            color: #3B3D3F;
            width: 20%;
            line-height: 30px;
            text-align: center;
            float: left;
        }

        .search .s_btn i:hover {
            color: #1E9FFF;
            transition: all 0.1s ease-in;
        }

        .search .s_input {
            float: left;
            width: 90%;
            height: 100%;
        }

        .search .s_input input {
            margin-left: 1%;
            width: 98%;
            padding-left: 10px;
            border: 1px solid #000;
            border-radius: 3px;
            height: 100%;
        }

        .search .s_input input:focus {
            border: 1px solid #000;
            outline: none
        }
    </style>
<body>
<div class="container">
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
        <hr style="height:1px;border:none;border-top:1px solid #444;" />
        <section id="tab1" title="新标签页">
            <p>
               <iframe src="http://www.baidu.com" style="width: 100%;" frameborder="0"></iframe>
            </p>
        </section>
    </div>
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/js/prefixfree.min.js"></script>
    <script type="text/javascript" src="./static/js/jquery-tab.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.tab-group').tabify();
            $("section p iframe").css("height",($("body").height()-115)+"px");
        })
    </script>
</body>
</html>