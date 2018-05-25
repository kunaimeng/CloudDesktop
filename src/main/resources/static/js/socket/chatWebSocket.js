var websocket = null;

//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8080/chatSocket/"+userId);
} else {
    Win10.newMsg("连接失败", "主人的浏览器不支持websocket，无法使用通知信息咯。");
}

//连接发生错误的回调方法
websocket.onerror = function () {
    Win10.newMsg("连接失败", "哎呀，不好了。连接发生错误！");
};

//连接成功建立的回调方法
websocket.onopen = function (event) {
    Win10.newMsg("连接成功", "成功与服务器建立连接！");
};

//接收到消息的回调方法
websocket.onmessage = function (event) {
    var data = eval('(' + event.data + ')');
    if(data.code=="CHAT001"||data.code=="CHAT002"){
        showPrompt(data);
    }else{
        if(!data.from.userId==userId){
            answers(data.message);
        }
    }
};

//连接关闭的回调方法
websocket.onclose = function () {
    Win10.newMsg("提示", "连接关闭！");
};

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    websocket.close();
};

//关闭连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
function send(message) {
    websocket.send(message);
}

//显示通知消息
function showPrompt(data) {
    $(".headConfig").html("<img src='"+data.from.userImg+"'><p>"+data.title+"</p><span>当前人数："+data.onLineCount+"人</span>");
}



$('.conLeft li').on('click', function () {
    $(this).addClass('bg').siblings().removeClass('bg');
    var intername = $(this).children('.liRight').children('.intername').text();
    $('.headName').text(intername);
    $('.newsList').html('');
});
$('.sendBtn').on('click', function () {
    var news = $('#dope').val();
    if (news == '') {
        alert('不能为空');
    } else {
        $('#dope').val('');
        var str = '';
        str += '<li>' +
            '<div class="nesHead"><img src="./static/img/qq/6.jpg"/></div>' +
            '<div class="news"><img class="jiao" src="./static/img/qq/20170926103645_03_02.jpg">' + news + '</div>' +
            '</li>';
        $('.newsList').append(str);
        send(news);
        $('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
        $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
    }
});

function answers(ansmsg) {
    var answer = '';
    answer += '<li>' +
        '<div class="answerHead"><img src="./static/img/qq/tou.jpg"/></div>' +
        '<div class="answers"><img class="jiao" src="./static/img/qq/jiao.jpg">' + ansmsg + '</div>' +
        '</li>';
    $('.newsList').append(answer);
    $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
};

$('.ExP').on('mouseenter', function () {
    $('.emjon').show();
});
$('.emjon').on('mouseleave', function () {
    $('.emjon').hide();
});
$('.emjon li').on('click', function () {
    var imgSrc = $(this).children('img').attr('src');
    var str = "";
    str += '<li>' +
        '<div class="nesHead"><img src="./static/img/qq/6.jpg"/></div>' +
        '<div class="news"><img class="jiao" src="./static/img/qq/20170926103645_03_02.jpg"><img class="Expr" src="' + imgSrc + '"></div>' +
        '</li>';
    $('.newsList').append(str);
    $('.emjon').hide();
    $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
});