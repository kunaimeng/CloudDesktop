<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <!-- swfupload css -->
    <link href="./static/js/swfupload/upload/upload.css" rel="stylesheet" type="text/css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="./static/css/file.css" rel="stylesheet" type="text/css">
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
                <span data-id="0"><i class="fa fa-list"></i>&nbsp;根目录</span>
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

            </ul>
        </div>
        <div id="d_right">
            <ul>
                <div class="d_r_first">
                    <span class="d_r_one"><i class="fa fa-th" style="margin-left: 10px;"></i>&nbsp;&nbsp名称</span>
                    <span class="d_r_two"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;修改日期</span>
                    <span class="d_r_two"><i class="fa fa-tasks"></i>&nbsp;&nbsp;类型</span>
                    <span class="d_r_two"><i class="fa fa-pie-chart"></i>&nbsp;&nbsp;大小</span>
                    <span class="d_r_two"><i class="fa fa-gears"></i>&nbsp;&nbsp;操作</span>
                </div>
                <div style="clear:both"></div>
                <li class="d_r_input">
                        <span class="d_r_one">
                        <i class="fa fa-folder"></i>
                        <input>
                        <i class="fa fa-check"></i>
                        <i class="fa fa-close"></i>
                        </span>
                    <span class="d_r_two"></span>
                    <span class="d_r_two"></span>
                    <span class="d_r_two"></span>
                    <span class="d_r_two"></span>
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
                            <#if con.fileType == "1">
                            <#else>
                               <a href="${con.fileSystemName}" download="${con.fileName}">
                                    <i class="fa fa-arrow-down"></i>
                                </a>
                            &nbsp;&nbsp;
                            </#if>

                            <i class="fa fa-close"></i>
                        </span>
                    </li>
                </#list>
        </div>
        </ul>
    </div>
</div>
</div>
<div id="console"></div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<!-- swfipload js -->
<script type="text/javascript" src="./static/js/swfupload/upload/tz_upload.js"></script>
<script type="text/javascript" src="./static/js/common/common.js"></script>
<script type="text/javascript">

    var foldId=0;
    //新建文件夹操作
    $(".d_r_input .d_r_one").on('click', '.fa-check', function (event) {
        var obj = $("#d_right .d_r_input input").val();
        var fileParentId = $("#d_top .d_t_center span").last().attr("data-id");
        if (obj == "" || obj == null || obj == "undefined") {
            layer.alert('亲，描述不合法呦！', 'Ops...There seems to be a little problem.');
            return false;
        } else {
            $.ajax({
                type: 'post',
                url: "/newBuildFolder",
                data: {"fileParentId": fileParentId, "fileName": obj},
                dataType: "json",
                success: function (msg) {
                    $(".d_r_input").hide();
                    if (msg.flag) {
                        appendFolder(msg);
                        layer.alert(msg.msg);
                    } else {
                        layer.alert(msg.msg);
                    }
                },
                error: function () {
                    layer.alert("出错了，请稍后重试");
                }
            });
        }
    });

    //隐藏输入框操作
    $(".d_r_input .d_r_one").on('click', '.fa-close', function (event) {
        $(this).parents(".d_r_input").hide();
    });

    $("#d_right ul .d_r_con .d_r_two").on("click", ".fa-close", function () {
        var id = $(this).parents(".d_r_con").find(".d_r_one").attr("data-id");
        var obj = $(this).parents(".d_r_con");
        layer.confirm('确认要删除吗?', {icon: 3, title: "提示"}, function (index) {
            $.ajax({
                type: 'post',
                url: "/updateFile",
                data: {"fileId": id, "yn": 0},
                dataType: "json",
                success: function (msg) {
                    if (msg.flag) {
                        obj.remove();
                        layer.alert(msg.msg);
                    } else {
                        layer.alert(msg.msg);
                    }
                },
                error: function () {
                    layer.alert("出错了，请稍后重试");
                }
            });
        });
    });

    $("#d_top .d_t_center").on("click", "span", function () {
        var obj = $(this).attr("data-id");
        foldId = obj;
        var span = $(this);
        $.ajax({
            type: 'post',
            url: "/queryFileList",
            data: {"fileParentId": obj},
            dataType: "json",
            success: function (msg) {
                if (msg.flag) {
                    span.nextAll().remove();
                    $("#d_right ul .d_r_con").remove();
                    $("#d_right ul").append(ViewOfList(msg));
                } else {
                    layer.alert(msg.msg);
                }
            },
            error: function () {
                layer.alert("出错了，请稍后重试");
            }
        });

    });

    $("#d_right ul").on("dblclick", ".Folder", function () {
        var obj = $(this).attr("data-id");
        foldId = obj;
        var con = $(this).attr("data-name");
        $.ajax({
            type: 'post',
            url: "/queryFileList",
            data: {"fileParentId": obj},
            dataType: "json",
            success: function (msg) {
                if (msg.flag) {
                    $("#d_top .d_t_center").append("<span data-id=" + obj + "><i class=\"fa fa-list\"></i>&nbsp;" + con + "</span>");
                    $("#d_right ul .d_r_con").remove();
                    $("#d_right ul").append(ViewOfList(msg));
                } else {
                    layer.alert(msg.msg);
                }
            },
            error: function () {
                layer.alert("出错了，请稍后重试");
            }
        });
    });

    /*解析内容*/
    function ViewOfList(msg) {
        var html = "";
        for (var i = 0; i < msg.list.length; i++) {
            if (msg.list[i].fileType == 1) {
                html = html + "<li class=\"d_r_con\">\n" +
                        "                    <span class=\"d_r_one Folder\" data-id=" + msg.list[i].fileId + " data-name=" + msg.list[i].fileName + ">&nbsp;\n" +
                        "                            <i class=\"fa fa-folder\"></i>\n" +
                        "                        &nbsp;&nbsp;" + msg.list[i].fileName + "\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">" + fmtDate(msg.list[i].updateTime) + "</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                            文件夹\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">" + msg.list[i].fileSimpleSize + "</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                        <i class=\"fa fa-close\"></i>\n" +
                        "                    </span>\n" +
                        "                </li>";
            } else {
                html = html + " <li class=\"d_r_con\">\n" +
                        "                    <span class=\"d_r_one\">&nbsp;\n" +
                        "                            <i class=\"fa fa-file\"></i>\n" +
                        "                        &nbsp;&nbsp;" + msg.list[i].fileName + "\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">" + fmtDate(msg.list[i].updateTime) + "</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                            " + msg.list[i].fileExt + "文件\n" +
                        "                    </span>\n" +
                        "                    <span class=\"d_r_two\">" + msg.list[i].fileSimpleSize + "</span>\n" +
                        "                    <span class=\"d_r_two\">\n" +
                        "                        <a href=\"" + msg.list[i].fileSystemName + "\"download="+msg.list[i].fileName+">\n" +
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
        btnId: "upload",
        url: "/fileUpload",
        limitSize: "100 MB",
        params:{"fileParentId":foldId},
        fileTypes: "*.*",
        multiple: true,
        callback: function (serverData, file) {
            var jsonData = eval("(" + serverData + ")");
            $("#d_right .d_r_input").after("<li class=\"d_r_con\">\n" +
                    "                    <span class=\"d_r_one\">&nbsp;\n" +
                    "                            <i class=\"fa fa-file\"></i>\n" +
                    "                        &nbsp;&nbsp;" + jsonData.fileName + "\n" +
                    "                    </span>\n" +
                    "                    <span class=\"d_r_two\">" + fmtDate(jsonData.createTime) + "</span>\n" +
                    "                    <span class=\"d_r_two\">" + jsonData.fileExt + "</span>\n" +
                    "                    <span class=\"d_r_two\">" + jsonData.fileSimpleSize + "</span>\n" +
                    "                    <span class=\"d_r_two\">\n" +
                    "                        <a href=\"" +jsonData.fileSystemName + "\"download="+jsonData.fileName+">\n" +
                    "                            <i class=\"fa fa-arrow-down\"></i>\n" +
                    "                        </a>\n" +
                    "                        &nbsp;&nbsp;\n" +
                    "                        <i class=\"fa fa-close\"></i>\n" +
                    "                    </span>\n" +
                    "                </li>");
        }
    });

    $("#d_top .d_t_left span").click(function () {
        $("#d_right .d_r_input").show();
    });


    $("#d_top .d_t_right input").bind('keypress', function (event) {
        if (event.keyCode == "13") {
            var obj = $(this).val();
            if (obj == "" || obj == null || obj == "undefined") {
                layer.alert("您没输入任何搜索内容！");
            } else {
                $.ajax({
                    type: 'post',
                    url: "/queryFileList",
                    data: {"fileName": obj, "fileType": 2},
                    dataType: "json",
                    success: function (msg) {
                        if (msg.flag) {
                            $("#d_right ul .d_r_con").remove();
                            $("#d_right ul").append(ViewOfList(msg));
                        } else {
                            layer.alert(msg.msg);
                        }
                    },
                    error: function () {
                        layer.alert("出错了，请稍后重试");
                    }
                });
            }
        }
    });

    function appendFolder(data) {
        var html = "<li class=\"d_r_con\">\n" +
                "                    <span class=\"d_r_one Folder\" data-id=" + data.fileId + " data-name=" + data.fileName + ">&nbsp;\n" +
                "                            <i class=\"fa fa-folder\"></i>\n" +
                "                        &nbsp;&nbsp;" + data.fileName +
                "                    </span>\n" +
                "                    <span class=\"d_r_two\">"+fmtDate(new Date())+"</span>\n" +
                "                    <span class=\"d_r_two\">\n" +
                "                            文件夹\n" +
                "                    </span>\n" +
                "                    <span class=\"d_r_two\">0.00</span>\n" +
                "                    <span class=\"d_r_two\">\n" +
                "                        <i class=\"fa fa-close\"></i>\n" +
                "                    </span>\n" +
                "                </li>";
        $("#d_right ul").append(html);
    }
</script>
</body>
</html>