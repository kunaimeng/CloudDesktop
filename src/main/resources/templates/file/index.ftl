<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <!-- swfupload css -->
    <link href="./static/js/swfupload/upload/upload.css" rel="stylesheet" type="text/css" />
    <style>
        *{font-size:12px;}
        ul li{list-style: none;width: 98%;height: 30px;line-height: 30px;cursor: pointer;color: rgba(49, 49, 50, 0.94);}
        #d_top{width: 99%;height: 40px;border: 1px solid #777;margin:0 auto;}
        #d_top .d_t_left{width:10%;height: 100%;float: left;}
        #d_top .d_t_center{width:70%;height: 100%;float: left;}
        #d_top .d_t_center span{display:block;height: 100%;float: left;margin-right: 5px;padding:0 10px 0 10px;line-height: 40px;cursor: pointer;}
        #d_top .d_t_center span:hover{background: #2e8ded;transition: all 0.3s ease;color: #fff;}
        #d_top .d_t_right{width: 10%;height: 100%;float: left;text-align: center;}
        #d_top .d_t_right input{width: 90%;height: 25px;margin-top: 5px;border-radius: 3px;padding-left: 3px;}
        #d_top .d_t_upload{width: 10%;float: left;text-align: center;}
        #d_top .d_t_upload .swfupload{margin-top: 4px;}
        #d_left{width: 10%;height: auto;float: left;border-right: #3B3D3F;}
        #d_left ul{padding-left: 10%;}
        #d_left ul li:hover{padding-left: 4%;line-height:36px;transition: all 0.3s ease;border-left: 6px solid #1E9FFF;}
        #d_right{width: 60%;height: auto;float: left;}
        #d_right ul{padding-left: 1%;}
        #d_right ul .d_r_con:hover{padding-left: 1%;transition: all 0.3s ease;border:1px solid #2e8ded;background:#4898d5;color: #fff;}
        #d_right ul li span{float: left;height: 30px;line-height: 30px;}
        #d_right ul li .d_r_one{width: 40%;}
        #d_right ul li .d_r_two{width: 20%;}
    </style>
</head>
<body>
<div id="win10">
    <div class="desktop">
        <div id="d_top">
            <div class="d_t_left">

            </div>
            <div class="d_t_center">
                <span>A盘</span>
                <span>B盘</span>
                <span>C盘</span>
                <span>D盘</span>
            </div>
            <div class="d_t_right">
                <input type="text">
            </div>
            <div class="d_t_upload">
                <span id="upload"></span>
            </div>
        </div>
        <div id="d_left">
            <ul>
                <li>目录</li>
                <li>视频</li>
                <li>图片</li>
                <li>文档</li>
                <li>音乐</li>
                <li>回收站</li>
            </ul>
        </div>
        <div id="d_right">
            <ul>
                <li class="d_r_first">
                    <span class="d_r_one">名称</span>
                    <span class="d_r_two">修改日期</span>
                    <span class="d_r_two">类型</span>
                    <span class="d_r_two">大小</span>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="console"></div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<!-- swfipload js -->
<script type="text/javascript" src="./static/js/swfupload/upload/tz_upload.js"></script>
<script type="text/javascript" src="./static/js/common/common.js"></script>
<script type="text/javascript">
    $.tmUpload({
        btnId:"upload",
        url:"/fileUpload.ftl",
        limitSize:"100 MB",
        fileTypes:"*.*",
        multiple:true,
        callback:function(serverData,file){
            var jsonData = eval("("+serverData+")");
            $("#d_right .d_r_first").after("<li class=\"d_r_con\">\n" +
                    "                    <span class=\"d_r_one\">"+jsonData.fileName+"</span>\n" +
                    "                    <span class=\"d_r_two\">"+fmtDate(jsonData.createTime)+"</span>\n" +
                    "                    <span class=\"d_r_two\">"+jsonData.fileExt+"</span>\n" +
                    "                    <span class=\"d_r_two\">"+jsonData.fileSimpleSize+"</span>\n" +
                    "                </li>");
        }
    });
</script>
</body>
</html>