<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>带功能控件的地图</title>
    <link href="./static/css/main1119.css" rel="stylesheet" type="text/css">
    <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
    <script src="http://webapi.amap.com/maps?v=1.4.6&key=75f236151c2b4db5448988003b4771aa&&plugin=AMap.Scale,AMap.OverView,AMap.ToolBar,AMap.Autocomplete,AMap.PlaceSearch"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <style>
        #myPageTop{left: 80px !important;right: !important;}
    </style>
</head>
<body>
<div id="container"></div>
<div id="myPageTop">
    <table>
        <tr>
            <td>
                <label>请输入关键字：</label>
            </td>
        </tr>
        <tr>
            <td>
                <input id="tipinput"/>
            </td>
        </tr>
    </table>
</div>
<div class='button-group' style="background-color: #0d9bf2;right: 20px">
    <input type="checkbox" id="toolbar" onclick="toggleToolBar(this)" style="display: none;"/>
    <input type="checkbox" id="toolbarDirection" disabled onclick="toggleToolBarDirection(this)"/>
    <input type="checkbox" id="toolbarRuler" disabled onclick="toggleToolBarRuler(this)" style="display: none;"/>
    <input type="checkbox" id="overview" onclick="toggleOverViewShow(this)" style="display: none;"/>
    <input type="checkbox" id="overviewOpen" disabled onclick="toggleOverViewOpen(this)" style="display: none;"/>
</div>
<script>
    var scale = new AMap.Scale({
                visible: false
            }),
            toolBar = new AMap.ToolBar({
                visible: false
            }),
            overView = new AMap.OverView({
                visible: false
            }),
            map = new AMap.Map("container", {
                resizeEnable: true
            });
    map.addControl(scale);
    map.addControl(toolBar);
    map.addControl(overView);
    //比例尺
    scale.show();

    //工具条
    showToolBar();
    showToolBarDirection();
    showToolBarRuler();
    //工具条方向
    toolBar.showDirection();
    //工具条标尺
    toolBar.showRuler();
    //显示鹰眼
    overView.show();
    document.getElementById('overviewOpen').disabled = false;
    //展开鹰眼
    overView.open();

    function toggleToolBarRuler(checkbox) {
        if (checkbox.checked) {
            toolBar.showRuler();
        } else {
            toolBar.hideRuler();
        }
    }

    function toggleOverViewShow(checkbox) {
        if (checkbox.checked) {
            overView.show();
            document.getElementById('overviewOpen').disabled = false;
        } else {
            overView.hide();
            document.getElementById('overviewOpen').disabled = true;
        }
    }

    function toggleOverViewOpen(checkbox) {
        if (checkbox.checked) {
            overView.open();
        }
        else {
            overView.close();
        }
    }

    function showToolBar() {
        document.getElementById('toolbar').checked = true;
        document.getElementById('toolbarDirection').disabled = false;
        document.getElementById('toolbarRuler').disabled = false;
        toolBar.show();
    }


    function showToolBarDirection() {
        document.getElementById('toolbarDirection').checked = true;
        toolBar.showDirection();
    }


    function showToolBarRuler() {
        document.getElementById('toolbarRuler').checked = true;
        toolBar.showRuler();
    }

    //输入提示
    var autoOptions = {
        input: "tipinput"
    };
    var auto = new AMap.Autocomplete(autoOptions);
    var placeSearch = new AMap.PlaceSearch({
        map: map
    });  //构造地点查询类
    AMap.event.addListener(auto, "select", select);//注册监听，当选中某条记录时会触发
    function select(e) {
        placeSearch.setCity(e.poi.adcode);
        placeSearch.search(e.poi.name);  //关键字查询查询
    }
</script>
</body>
</html>