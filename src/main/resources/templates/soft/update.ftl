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
                管理员欢迎你更新功能。
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-3 column"></div>
                <div class="col-md-6 column">
                    <form id="submitForm">
                        <input type="hidden" name="softId" value="${soft.softId}"/>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用名称:</label>
                            <div class="controls">
                                <input type="text" name="softTitle" value="${soft.softTitle}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用描述:</label>
                            <div class="controls">
                                <input type="text" name="softDesc" value="${soft.softDesc}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用图标:</label>
                            <div class="controls">
                                <input type="text" name="softImg" value="${soft.softImg}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用链接:</label>
                            <div class="controls">
                                <input type="text" name="softUrl" value="${soft.softUrl}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="btn-group">
                                <span class="span-submit">更新</span> <span class="span-forward">返回</span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-3 column"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../static/component/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript">

    $(".control-group .span-forward").click(function(){
        window.location.href = "/soft/index";
    });

    $(".control-group .span-submit").click(function () {
        var flag = false;
        $('input[type=text]').each(function () {
            if ($(this).val() == '') {
                flag = true;
            }
        });
        if (flag) {
            layer.alert("输入不完整，请检查！");
            return false;
        }
        layer.confirm('确认要更新吗?', {icon: 3, title: "提示"}, function (index) {
            $.ajax({
                type: 'post',
                url: "/soft/softUpdate",
                data: $("#submitForm").serialize(),
                dataType: "json",
                beforeSend: function () {
                    layer.close(index);
                    index = layer.load(2, {time: 10 * 1000});
                },
                success: function (msg) {
                    layer.close(index);
                    layer.alert(msg.msg+"，点击确定返回。",function(){
                        window.location.href = "/soft/index";
                    });
                },
                error: function () {
                    layer.close(index);
                    layer.alert("出错了，请稍后重试");
                }
            });
        });
    });
</script>
</body>
</html>
