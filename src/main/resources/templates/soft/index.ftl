<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>软件初始化中心</title>
    <link rel="stylesheet" href="../static/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../static/css/softadd.css">
</head>
<body>
<div class="container">
    <br>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-success alert-dismissable">
                管理员欢迎你录入新开发功能。
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <table class="table table-bordered">
            <thead>
            <tr class="success">
                <th>软件编号</th>
                <th>软件名称</th>
                <th>软件图标</th>
                <th>软件描述</th>
                <th>软件链接</th>
                <th>创建时间</th>
                <th>更新时间</th>
                <th>是否有效</th>
                <th>相关操作</th>
            </tr>
            </thead>
            <tbody>
                <#list softList as soft>
                <tr>
                    <th>${soft.softId}</th>
                    <th>${soft.softTitle}</th>
                    <th>${soft.softImg}</th>
                    <th>${soft.softDesc}</th>
                    <th>${soft.softUrl}</th>
                    <th>${soft.createTime?datetime}</th>
                    <th>${soft.updateTime?datetime}</th>
                    <th>
                        <#if soft.yn?string == "1">
                            已上线
                        <#elseif soft.yn?string == "0">
                            已下线
                        <#else >
                            未定义类型
                        </#if>
                    </th>
                    <th>
                         <#if soft.yn?string == "1">
                            <button class="btn btn-danger" type="button" data-id="${soft.softId}"
                                    data-name="${soft.softTitle}">下线
                            </button>
                         <#elseif soft.yn?string == "0">
                            <button class="btn btn-primary" type="button" data-id="${soft.softId}"
                                    data-name="${soft.softTitle}">上线
                            </button>
                         <#else >
                            <button class="btn btn-warning" type="button">异常</button>
                         </#if>
                        <button class="btn btn-info" type="button" data-id="${soft.softId}"
                                data-name="${soft.softTitle}">更新
                        </button>
                    </th>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" src="../static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../static/component/layer-v3.0.3/layer/layer.js"></script>
<script>
    $(".btn-danger").click(function () {
        var softId = $(this).attr("data-id");
        var softName = $(this).attr("data-name");
        var yn = 0;
        ajaxPost(softId, softName, yn);
    });

    $(".btn-primary").click(function () {
        var softId = $(this).attr("data-id");
        var softName = $(this).attr("data-name");
        var yn = 1;
        ajaxPost(softId, softName, yn);
    });

    function ajaxPost(softId, softName, yn) {
        var str = "上线";
        if (yn == 0) {
            str = "下线";
        }
        layer.confirm('确认' + str + '' + softName + '应用吗?', {icon: 3, title: "提示"}, function (index) {
            $.ajax({
                type: 'post',
                url: "/soft/updateSoft",
                data: {
                    "softId": softId, "yn": yn
                },
                dataType: "json",
                beforeSend: function () {
                    layer.close(index);
                    index = layer.load(2, {time: 10 * 1000});
                },
                success: function (msg) {
                    layer.close(index);
                    window.location.href = "/soft/index";
                },
                error: function () {
                    layer.close(index);
                    layer.alert("出错了，请稍后重试");
                }
            });
        });
    }
</script>
</body>
</html>
