<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>HTML5+jquery实现九宫格每周天气预报展示效果-xw素材网</title>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/default.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="./static/weather/css/climacons.css"/>
    <link rel="stylesheet" type="text/css" href="./static/weather/css/component2.css"/>
    <link href="./static/component/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="./static/weather/js/modernizr.custom.js"></script>
    <style>
        .main .search input{border: 1px solid #2e8ded;width: 80%;height: 48px;float: left;margin-top: 16px;padding-left: 5px;font-size: 18px;}
        .main .search span{display: block;float: left;width: 20%;height: 48px;margin-top: 16px;background: #31c27c;color: #fff;line-height: 48px;text-align: center;cursor: pointer;}
        .main .search span:hover{background:#31C250;transition: all 0.3s ease-in;color:#f9f9f9;}
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
            <li class="icon-clima-2">
                <h3>Paris</h3><span class="rb-temp">11°C</span>
                <div class="rb-overlay">
                    <span class="fa fa-close">close</span>
                    <div class="rb-week">
                        <div><span class="rb-city">Paris</span><span class="icon-clima-2"></span><span>11°C</span></div>
                        <div><span>Mon</span><span class="icon-clima-1"></span><span>12°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-4"></span><span>11°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-4"></span><span>10°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-4"></span><span>9°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-2"></span><span>10°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-2"></span><span>10°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-2"></span><span>12°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-1">
                <h3>Belgrade</h3><span class="rb-temp">15°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Belgrade</span><span class="icon-clima-1"></span><span>15°C</span>
                        </div>
                        <div><span>Mon</span><span class="icon-clima-3"></span><span>16°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-3"></span><span>17°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-3"></span><span>15°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-4"></span><span>13°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-3"></span><span>10°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-1"></span><span>11°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-1"></span><span>12°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-4">
                <h3>Moscow</h3><span class="rb-temp">2°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Moscow</span><span class="icon-clima-4"></span><span>1°C</span></div>
                        <div><span>Mon</span><span class="icon-clima-4"></span><span>-1°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-6"></span><span>-2°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-6"></span><span>-6°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-6"></span><span>-4°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-5"></span><span>-5°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-6"></span><span>-6°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-6"></span><span>-8°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-1">
                <h3>New Delhi</h3><span class="rb-temp">17°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">New Delhi</span><span class="icon-clima-1"></span><span>17°C</span>
                        </div>
                        <div><span>Mon</span><span class="icon-clima-1"></span><span>18°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-8"></span><span>19°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-8"></span><span>16°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-10"></span><span>17°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-10"></span><span>18°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-2"></span><span>17°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-1"></span><span>17°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-1 rb-span-2">
                <h3>Lisbon</h3><span class="rb-temp">21°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Lisbon</span><span class="icon-clima-1"></span><span>21°C</span>
                        </div>
                        <div><span>Mon</span><span class="icon-clima-1"></span><span>19°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-2"></span><span>19°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-2"></span><span>18°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-2"></span><span>17°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-1"></span><span>19°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-1"></span><span>22°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-1"></span><span>18°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-1">
                <h3>Tel Aviv</h3><span class="rb-temp">23°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Tel Aviv</span><span class="icon-clima-1"></span><span>22°C</span>
                        </div>
                        <div><span>Mon</span><span class="icon-clima-1"></span><span>23°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-2"></span><span>22°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-2"></span><span>22°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-2"></span><span>21°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-1"></span><span>21°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-2"></span><span>21°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-2"></span><span>24°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-2">
                <h3>Cairo</h3><span class="rb-temp">21°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Cairo</span><span class="icon-clima-2"></span><span>21°C</span></div>
                        <div><span>Mon</span><span class="icon-clima-1"></span><span>22°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-1"></span><span>20°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-1"></span><span>21°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-1"></span><span>21°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-2"></span><span>21°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-2"></span><span>22°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-2"></span><span>23°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-11">
                <h3>New York</h3><span class="rb-temp">3°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">New York</span><span class="icon-clima-11"></span><span>3°C</span>
                        </div>
                        <div><span>Mon</span><span class="icon-clima-11"></span><span>3°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-11"></span><span>-1°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-11"></span><span>-2°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-7"></span><span>1°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-7"></span><span>0°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-11"></span><span>2°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-11"></span><span>3°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-2">
                <h3>Tokyo</h3><span class="rb-temp">8°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Tokyo</span><span class="icon-clima-2"></span><span>8°C</span></div>
                        <div><span>Mon</span><span class="icon-clima-1"></span><span>7°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-2"></span><span>6°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-1"></span><span>8°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-1"></span><span>8°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-2"></span><span>6°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-2"></span><span>5°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-2"></span><span>5°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-2 rb-span-2">
                <h3>San Francisco</h3><span class="rb-temp">15°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">San Francisco</span><span
                                class="icon-clima-2"></span><span>15°C</span></div>
                        <div><span>Mon</span><span class="icon-clima-2"></span><span>16°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-2"></span><span>14°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-2"></span><span>13°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-2"></span><span>15°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-2"></span><span>15°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-1"></span><span>16°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-1"></span><span>15°C</span></div>
                    </div>
                </div>
            </li>
            <li class="icon-clima-4 rb-span-4">
                <h3>Sydney</h3><span class="rb-temp">25°C</span>
                <div class="rb-overlay">
                    <span class="rb-close"></span>
                    <div class="rb-week">
                        <div><span class="rb-city">Sydney</span><span class="icon-clima-4"></span><span>28°C</span>
                        </div>
                        <div><span>Mon</span><span class="icon-clima-4"></span><span>24°C</span></div>
                        <div><span>Tue</span><span class="icon-clima-4"></span><span>26°C</span></div>
                        <div><span>Wed</span><span class="icon-clima-2"></span><span>27°C</span></div>
                        <div><span>Thu</span><span class="icon-clima-2"></span><span>30°C</span></div>
                        <div><span>Fri</span><span class="icon-clima-8"></span><span>31°C</span></div>
                        <div><span>Sat</span><span class="icon-clima-8"></span><span>29°C</span></div>
                        <div><span>Sun</span><span class="icon-clima-8"></span><span>29°C</span></div>
                    </div>
                </div>
            </li>
        </ul>

    </div>

</div><!-- /container -->

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
