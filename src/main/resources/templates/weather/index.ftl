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
    <link href="./static/css/search.css" rel="stylesheet" type="text/css">
    <style>
        #rb-grid li .rb-week .date {height: 70px !important;}
        #rb-grid li .rb-week .desc {font-size: 10px !important;height: 40px !important;}
        #rb-grid li .rb-week .desc i{cursor: pointer;}
    </style>
</head>
<body>
<div class="container">
    <div class="main">
        <form id="search" method="post" action="weather.htm">
            <div class="search" style="width: 100%;height: 80px;">
                <div class="m_s_content">
                    <input type="text" class="m_s_c_input" name="province" value="${search.province!}"/>
                    <input type="hidden" name="addressId" class="addressId" value="${search.addressId!}">
                    <div class="m_s_c_address">
                        <ul>
                        <#list address as addre>
                            <li data-addressPlatId="${addre.addressPlatId?c}" data-address="${addre.addressProvince}">${addre.addressProvince}&nbsp;${addre.addressCity}</li>
                        </#list>
                        </ul>
                    </div>
                </div>
                <span class="m_s_searcch">
             <i class="fa fa-search"></i>
                查询
            </span>
            </div>
        </form>
        <#if content?? && (content?size > 0)>
        <#else >
        <p class="noPic">没有搜索到相关数据</p>
        </#if>
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
                <span>
                    ${con.weathers[0].minTemp}
                     <#if con.weathers[0].maxTemp!="">
                         ~${con.weathers[0].maxTemp}
                     </#if>
                </span>
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

        $(".m_s_c_input").focus(function(){
            $(".main .search .m_s_content .m_s_c_address").show();
        });

        $(".main .search .m_s_content .m_s_c_address ul li").click(function () {
            $(".m_s_c_input").val($(this).attr("data-address"));
            $(".addressId").val($(this).attr("data-addressPlatId"));
            $(".main .search .m_s_content .m_s_c_address").hide();
        });

        $("#rb-grid").click(function(){
            $(".main .search .m_s_content .m_s_c_address").hide();
        });
        
        $(".m_s_searcch").click(function () {
            $("#search").submit();
        });
    });
</script>
</body>
</html>
