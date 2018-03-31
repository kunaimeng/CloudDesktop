<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>天气</title>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/default.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="./static/weather/css/climacons.css"/>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/component2.css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="./static/weather/js/modernizr.custom.js"></script>
    <style>
        .main .search input {border: 1px solid #2e8ded;width: 80%;height: 48px;float: left;margin-top: 16px;padding-left: 5px;font-size: 18px;}
        .main .search span {display: block;float: left;width: 20%;height: 48px;margin-top: 16px;background: #31c27c;color: #fff;line-height: 48px;text-align: center;cursor: pointer;}
        .main .search span:hover {background: #31C250;transition: all 0.3s ease-in;color: #f9f9f9;}
        #rb-grid li .rb-week .date {height: 70px !important;}
        #rb-grid li .rb-week .desc {font-size: 10px !important;height: 40px !important;}
    </style>
</head>
<body>
<div class="container">
    <div class="main">
        <div class="search" style="width: 100%;height: 80px;">
            <input type="text"/>
            <span>
             <i class="fa fa-search"></i>
                查询
            </span>
        </div>
        <ul id="rb-grid" class="rb-grid clearfix">
            <#list content as con>
                <#if con_index==0>
                    <li class="icon-clima-4 rb-span-4">
                <#elseif con_index==1||con_index==2>
                    <li class="icon-clima-2 rb-span-2">
                <#else >
                    <li class="icon-clima-2">
                </#if>
                <h3>${con.province}</h3>
                <span class="rb-temp">${con.city}</span>
                <br>
                <span>${con.weathers[0].minTemp}~${con.weathers[0].maxTemp}</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div>
                            <span class="rb-city">${con.province}</span>
                            <span class="icon-clima-2"></span>
                            <span>${con.weathers[0].minTemp}</span>
                        </div>
                         <#list con.weathers as week>
                             <div>
                                 <span class="date">${week.date}</span>
                                 <span class="desc">${week.week}</span>
                                 <#if week.weatherDesc?contains("晴")&&week.weatherDesc?contains("云")>
                                     <span class="icon-clima-1"></span>
                                 <#elseif week.weatherDesc?contains("雨")&&week.weatherDesc?contains("云")>
                                     <span class="icon-clima-4"></span>
                                 <#elseif week.weatherDesc?contains("晴")&&week.weatherDesc?contains("阴")>
                                     <span class="icon-clima-1"></span>
                                 <#elseif week.weatherDesc?contains("雨")&&week.weatherDesc?contains("晴")>
                                     <span class="icon-clima-4"></span>
                                 <#elseif week.weatherDesc?contains("风")&&week.weatherDesc?contains("云")>
                                     <span class="icon-clima-5"></span>
                                 <#elseif week.weatherDesc?contains("雪")&&week.weatherDesc?contains("晴")>
                                     <span class="icon-clima-11"></span>
                                 <#elseif week.weatherDesc?contains("晴")>
                                     <span class="icon-clima-2"></span>
                                 <#elseif week.weatherDesc?contains("阴")>
                                     <span class="icon-clima-5"></span>
                                 <#elseif week.weatherDesc?contains("雪")>
                                     <span class="icon-clima-7"></span>
                                 <#elseif week.weatherDesc?contains("雷")>
                                     <span class="icon-clima-8"></span>
                                 <#elseif week.weatherDesc?contains("雨")>
                                     <span class="icon-clima-9"></span>
                                 <#elseif week.weatherDesc?contains("云")>
                                     <span class="icon-clima-1"></span>
                                 <#else >
                                     <span class="icon-clima-1"></span>
                                 </#if>
                                 <span class="desc">${week.minTemp}
                                     <#if week.maxTemp!="">
                                        ~${week.maxTemp}
                                     </#if>
                                 </span>
                                 <span class="desc">${week.weatherDesc}</span>
                                 <span class="desc">${week.windFrom}~${week.winTo}</span>
                                 <span class="desc">${week.windSpeed}</span>
                             </div>
                         </#list>
                    </div>
                </div>
            </li>
            </#list>
        </ul>
    </div>
</div>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/weather/js/jquery.fittext.js"></script>
<script type="text/javascript" src="./static/weather/js/boxgrid.example2.js"></script>
<script type="text/javascript">
    $(function () {
        Boxgrid.init();
    });
</script>
</body>
</html>
