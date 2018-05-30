<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>天气</title>
    <link href="./static/weather/css/default.css" rel="stylesheet" type="text/css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="./static/css/wallpaper.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="main">
        <br>
        <br>
        <div id="column">
            <span>分类：</span>
            <form method="post" action="wallpaper.html" id="searchForm">
                <input type="hidden" name="href" id="href">
            </form>
            <#list column as col>
                <#if col_index==0&&href=="">
                    <a href="#" class="active" data-url="${col["href"]}">${col["title"]}</a>
                <#elseif href!=""&&href==col["href"]>
                    <a href="#" class="active" data-url="${col["href"]}">${col["title"]}</a>
                <#else >
                    <a href="#" class="" data-url="${col["href"]}">${col["title"]}</a>
                </#if>
            </#list>
        </div>
        <br>
        <br>
        <div>
            <ul id="photo" class="clearfix">
             <#list photoList as photo>
                 <li>
                     <img src="${photo["src"]}" alt="${photo["title"]}">
                 </li>
             </#list>
            </ul>
        </div>

    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript" src="./static/js/win10.child.js"></script>
<script type="text/javascript">
    $("#column a").click(function () {
        $("#column a").attr("class", "");
        $(this).attr("class", "active");
        $("#href").val($(this).attr("data-url"));
        $("#searchForm").submit();
    });

    $("#photo li").click(function(){
        var pic = $(this).find("img").attr("src");
        var index;
        layer.confirm('确认更换壁纸吗?', {icon: 3, title: "提示"}, function (index) {
            $.ajax({
                type: 'post',
                url: "/updateUserInfo",
                data: {"userBgimg": pic},
                dataType: "json",
                beforeSend: function () {
                    layer.close(index);
                    index = layer.load(2, {time: 10*1000});
                },
                success: function (msg) {
                    layer.close(index);
                    if (msg.code) {
                        Win10_parent.setBgUrl({main:pic});
                    } else {
                        layer.alert(msg.msg);
                    }
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
