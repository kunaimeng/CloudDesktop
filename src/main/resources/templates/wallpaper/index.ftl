<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>天气</title>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/default.css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="./static/css/search.css" rel="stylesheet" type="text/css">
    <style>
        #column span {
            width: 48px;
            text-align: left;
            color: #565656;
            float: left;
            font-weight: bold;
        }

        #column a {
            height: 22px;
            line-height: 22px;
            padding: 0 7px;
            margin: 2px 0;
            display: block;
            float: left;
            font-size: 14px;
            border-radius: 2px;
            color: #565656;
        }

        #column a:hover {
            background-color: #00a2ff;
            color: #fff;
            transition: all 0.3s ease;
        }
        #column .active{
            background-color: #00a2ff;
            color: #fff;
        }
        #photo li{list-style: none;width:18%;float: left;margin:5px 1% 5px 1%;}
        #photo li img{width:100%;}
    </style>
</head>
<body>
<div class="container">
    <div class="main">
        <form id="search" method="post" action="weather.htm">
            <div class="search" style="width: 100%;height: 80px;">
                <div class="m_s_content">
                    <input type="text" class="m_s_c_input" name="province"/>
                </div>
                <span class="m_s_searcch">
             <i class="fa fa-search"></i>
                获取
            </span>
            </div>
        </form>
        <div id="column">
            <span>分类：</span>
            <#list column as col>
                <#if col_index==0>
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
    });

    $("#photo li").click(function(){
        var pic = $(this).find("img").attr("src");
        Win10_parent.setBgUrl({main:pic});
    });


</script>
</body>
</html>
