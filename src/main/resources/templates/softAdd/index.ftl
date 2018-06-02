<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>软件初始化中心</title>
    <link rel="stylesheet" href="./static/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <style>
        .control-group {
            width: 100%;
            height: 60px;
            float: left;
        }

        .control-label {
            width: 25%;
            float: left;
            text-align: right;
            line-height: 60px;
            padding-right: 10px;
        }

        .controls {
            width: 75%;
            float: left;
        }

        .controls input {
            width: 80%;
            height: 34px;
            margin: 13px 0 13px 10px;
            outline: none;
            padding-left: 8px;
        }

        .control-group span {
            display: block;
            font-size: 10px;
            cursor: pointer;
            width: 50%;
            height: 40px;
            border-radius: 4px;
            background: #1E9FFF;
            color: #fff;
            text-align: center;
            line-height: 40px;
            margin: 25px auto;
        }

        .control-group span:hover {
            background: #2e8ded;
            transition: all 0.3s ease-in-out;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-success alert-dismissable">
                管理员欢迎你录入新开发功能。
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-3 column"></div>
                <div class="col-md-6 column">
                    <form id="submitForm">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用名称:</label>
                            <div class="controls">
                                <input type="text" name="softTitle"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用描述:</label>
                            <div class="controls">
                                <input type="text" name="softDesc"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用图标:</label>
                            <div class="controls">
                                <input type="text" name="softImg"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">应用链接:</label>
                            <div class="controls">
                                <input type="text" name="softUrl"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <span>确定</span>
                        </div>
                    </form>
                </div>
                <div class="col-md-3 column"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript">
    $(".control-group span").click(function () {
        var flag = false;
        $('input[type=text]').each(function () {
            if ($(this).val() == '') {
                flag =true;
            }
        });
        if(flag){
            layer.alert("输入不完整，请检查！");
            return false;
        }
        layer.confirm('确认要提交吗吗?', {icon: 3, title: "提示"}, function (index) {
            $.ajax({
                type: 'post',
                url: "/softInsert",
                data: $("#submitForm").serialize(),
                dataType: "json",
                beforeSend: function () {
                    layer.close(index);
                    index = layer.load(2, {time: 10 * 1000});
                },
                success: function (msg) {
                    layer.close(index);
                    layer.alert(msg.msg);
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
