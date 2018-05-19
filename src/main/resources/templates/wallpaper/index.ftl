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
        Win10_parent.setBgUrl({main:pic});
    });
</script>
</body>
</html>
