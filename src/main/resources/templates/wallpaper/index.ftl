<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>天气</title>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/default.css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="./static/css/search.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="main">
        <form id="search" method="post" action="weather.htm">
            <div class="search" style="width: 100%;height: 80px;">
                <div class="m_s_content">
                    <input type="text" class="m_s_c_input" name="province"/>
                    <div class="m_s_c_address">
                        <ul>

                        </ul>
                    </div>
                </div>
                <span class="m_s_searcch">
             <i class="fa fa-search"></i>
                搜索
            </span>
            </div>
        </form>
        <ul id="rb-grid" class="rb-grid clearfix">

        </ul>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
    $(function () {

    });
</script>
</body>
</html>
