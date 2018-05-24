var websocket = null;

//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8080/promptWebSocket");
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
    Win10.newMsg(data.title, data.message);
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