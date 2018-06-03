<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>软件中心</title>
    <link rel="stylesheet" href="./static/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./static/weather/css/climacons.css"/>
    <link rel="stylesheet" type="text/css" href="./static/css/software.css"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-success alert-dismissable">
                请点击一下应用进行安装。
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column software">
            <div class="row clearfix">
                <#list  cdSoftware as soft>
                    <div class="col-md-3 column softItem">
                        <div class="s_img">
                            <i class="${soft.softImg}"></i>
                        </div>
                        <div class="s_check" data-img="${soft.softImg}" data-title="${soft.softTitle}"
                             data-desc="${soft.softDesc}"
                             data-src="${soft.softUrl}">
                            ${cdDesktopList?seq_contains('${soft.softUrl}')?string("<i class='fa fa-check'></i>&nbsp;&nbsp;<span>已安装</span>", "<i class='fa fa-plus'></i>&nbsp;&nbsp;<span>安装${soft.softTitle}</span>")}
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript" src="./static/js/win10.child.js"></script>
<script type="text/javascript">
    $(".s_check").click(function () {
        var obj = $(this);
        var desktopImg = obj.attr("data-img");
        var desktopTitle = obj.attr("data-title");
        var desktopDesc = obj.attr("data-desc");
        var desktopOpensrc = obj.attr("data-src");
        if (obj.find("i").attr("class") == "fa fa-check") {
            layer.confirm('确认卸载' + desktopTitle + '吗?', {icon: 3, title: "提示"}, function (index) {
                $.ajax({
                    type: 'post',
                    url: "/dealSoft",
                    data: {
                        "desktopOpensrc": desktopOpensrc
                    },
                    dataType: "json",
                    beforeSend: function () {
                        layer.close(index);
                        index = layer.load(2, {time: 10 * 1000});
                    },
                    success: function (msg) {
                        layer.close(index);
                        obj.find("i").attr("class", "fa fa-plus");
                        obj.find("span").text("安装" + desktopTitle);
                    },
                    error: function () {
                        layer.close(index);
                        layer.alert("出错了，请稍后重试");
                    }
                });
            });
        } else {
            layer.confirm('确认安装' + obj.attr("data-title") + '吗?', {icon: 3, title: "提示"}, function (index) {
                $.ajax({
                    type: 'post',
                    url: "/insertDesk",
                    data: {
                        "desktopImg": desktopImg,
                        "desktopTitle": desktopTitle,
                        "desktopDesc": desktopDesc,
                        "desktopOpensrc": desktopOpensrc
                    },
                    dataType: "json",
                    beforeSend: function () {
                        layer.close(index);
                        index = layer.load(2, {time: 10 * 1000});
                    },
                    success: function (msg) {
                        layer.close(index);
                        obj.find("i").attr("class", "fa fa-check");
                        obj.find("span").text("已安装");
                        Win10_parent._installSoft(desktopOpensrc, desktopImg, desktopTitle);
                    },
                    error: function () {
                        layer.close(index);
                        layer.alert("出错了，请稍后重试");
                    }
                });
            });
        }
    });
</script>
</body>
</html>
