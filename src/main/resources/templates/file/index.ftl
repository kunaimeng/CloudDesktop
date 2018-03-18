<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <!-- swfupload css -->
    <link href="./static/js/swfupload/upload/upload.css" rel="stylesheet" type="text/css" />
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <style>
        *{font-size:12px;}
        body{-webkit-touch-callout: none;-webkit-user-select: none;-khtml-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none;}
        ul li{list-style: none;width: 98%;height: 30px;line-height: 30px;cursor: pointer;color: rgba(49, 49, 50, 0.94);}
        #d_top{width: 99%;height: 40px;border-bottom: 3px solid #777;margin:0 auto;}
        #d_top .d_t_left{width:10%;height: 100%;float: left;}
        #d_top .d_t_left span{background: #2e8ded;height: 80%;margin-top:4px;width:80%;display: block;border-radius: 3px;text-align: center;margin-left: 10%;}
        #d_top .d_t_left span i{font-size: 12px;color: #fff;margin-top: 10px;}
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
        #d_right{width: 85%;height: auto;float: left;}
        #d_right ul{padding-left: 1%;}
        #d_right ul .d_r_con:hover{padding-left: 1%;transition: all 0.3s ease;border:1px solid #2e8ded;background:#4898d5;color: #fff;}
        #d_right ul li span{float: left;height: 30px;line-height: 30px;}
        #d_right ul li span p{float: left;}
        #d_right ul li .d_r_one{width: 60%;}
        #d_right ul li .d_r_two{width: 10%;}
    </style>
</head>
<body>
<div id="win10">
    <div class="desktop">
        <div id="d_top">
            <div class="d_t_left">
                <span>
                    <i class="fa fa-plus" data-id="0">&nbsp;新建文件夹</i>
                </span>
            </div>
            <div class="d_t_center">
                <span><i class="fa fa-list"></i>&nbsp;根目录</span>
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
                <#list content as con>
                <li class="d_r_con">
                    <span class="d_r_one
                        <#if con.fileType == "1">
                            Folder
                        </#if>"
                          data-id="${con.fileId}" data-name="${con.fileName}">&nbsp;
                        <#if con.fileType == "1">
                            <i class="fa fa-folder"></i>
                        <#else>
                            <i class="fa fa-file"></i>
                        </#if>
                        &nbsp;&nbsp;${con.fileName}
                    </span>
                    <span class="d_r_two">${(con.updateTime)?string("yyyy-MM-dd")}</span>
                    <span class="d_r_two">
                        <#if con.fileType == "1">
                            文件夹
                        <#else>
                            ${con.fileExt}文件
                        </#if>
                    </span>
                    <span class="d_r_two">${con.fileSimpleSize}</span>
                    <span class="d_r_two">
                        <a href="./static/upload/${con.fileSystemName}">
                            <i class="fa fa-arrow-down"></i>
                        </a>
                        &nbsp;&nbsp;
                        <i class="fa fa-close"></i>
                        <#if con.fileType == "1">
                        &nbsp;&nbsp;
                        <i class="fa fa-folder-open-o"></i>
                        </#if>
                    </span>
                </li>
                </#list>
            </ul>
        </div>
    </div>
</div>
<div id="console"></div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/js/win10.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<!-- swfipload js -->
<script type="text/javascript" src="./static/js/swfupload/upload/tz_upload.js"></script>
<script type="text/javascript" src="./static/js/common/common.js"></script>
<script type="text/javascript">

    $("#d_top .d_t_center").on("click","span",function () {
        var obj = $(this).attr("data-id");
        var span = $(this);
        $.ajax({
            type: 'post',
            url: "/queryFileList.ftl",
            data: {"fileParentId":obj},
            dataType: "json",
            success: function (msg) {
                if(msg.flag){
                    span.nextAll().remove();
                    $("#d_right ul .d_r_con").remove();
                    $("#d_right ul .d_r_first").after(ViewOfList(msg));
                }else{
                    layer.alert(Win10.lang(msg.msg,'Ops...There seems to be a little problem.'));
                }
            },
            error:function () {
                layer.alert(Win10.lang("出错了，请稍后重试",'Ops...There seems to be a little problem.'));
            }
        });

    });

    $("#d_right ul").on("dblclick",".Folder",function(){
        var obj = $(this).attr("data-id");
        var con = $(this).attr("data-name");
        $.ajax({
            type: 'post',
            url: "/queryFileList.ftl",
            data: {"fileParentId":obj},
            dataType: "json",
            success: function (msg) {
                if(msg.flag){
                    $("#d_top .d_t_center").append("<span data-id="+obj+"><i class=\"fa fa-list\"></i>&nbsp;"+con+"</span>");
                    $("#d_right ul .d_r_con").remove();
                    $("#d_right ul .d_r_first").after(ViewOfList(msg));
                }else{
                    layer.alert(Win10.lang(msg.msg,'Ops...There seems to be a little problem.'));
                }
            },
            error:function () {
                layer.alert(Win10.lang("出错了，请稍后重试",'Ops...There seems to be a little problem.'));
            }
        });
    });

    /*解析内容*/
    function ViewOfList(msg) {
        var html = "";
        for(var i =0;i<msg.list.length;i++){
            if(msg.list[i].fileType==1){
                html = html+"<li class=\"d_r_con\">\n" +
                        "                    <span class=\"d_r_one Folder\" data-id="+msg.list[i].fileId+" data-name="+msg.list[i].fileName+">&nbsp;\n" +
                        "                            <i class=\"fa fa-folder\"></i>\n" +
                        "                        &nbsp;&nbsp;"+msg.list[i].fileName+"\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">"+fmtDate(msg.list[i].updateTime)+"</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                            文件夹\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">"+msg.list[i].fileSimpleSize+"</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                        <a href=\"./static/upload/"+msg.list[i].fileSystemName+"\">\n" +
                        "                            <i class=\"fa fa-arrow-down\"></i>\n" +
                        "                        </a>\n" +
                        "                        &nbsp;&nbsp;\n" +
                        "                        <i class=\"fa fa-close\"></i>\n" +
                        "                    </span>\n" +
                        "                </li>";
            }else{
                html = html+" <li class=\"d_r_con\">\n" +
                        "                    <span class=\"d_r_one\">&nbsp;\n" +
                        "                            <i class=\"fa fa-file\"></i>\n" +
                        "                        &nbsp;&nbsp;"+msg.list[i].fileName+"\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">"+fmtDate(msg.list[i].updateTime)+"</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                            "+msg.list[i].fileExt+"文件\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">"+msg.list[i].fileSimpleSize+"</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                        <a href=\"./static/upload/"+msg.list[i].fileSystemName+"\">\n" +
                        "                            <i class=\"fa fa-arrow-down\"></i>\n" +
                        "                        </a>\n" +
                        "                        &nbsp;&nbsp;\n" +
                        "                        <i class=\"fa fa-close\"></i>\n" +
                        "                    </span>\n" +
                        "                </li>";
            }
        }
        return html;

    }

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