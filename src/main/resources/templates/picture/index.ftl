<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>相册</title>
    <link rel="stylesheet" href="./static/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="./static/css/picture.css">
    <script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="./static/component/layer-v3.0.3/layer/layer.js"></script>
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<section id="gallery-wrapper">
    <#list photoList as photo>
        <article class="white-panel">
            <img src="${photo.fileSystemName}" class="thumb" alt="${photo.fileName}">
            <div class="descInput">
                 <span>
                     ${photo.fileDesc!"点击添加描述"}
                 </span>
                <input data-id="${photo.fileId}" value="${photo.fileDesc!"点击添加描述"}" type="hidden">
            </div>
        </article>
    </#list>
</section>
<script type="text/javascript" src="./static/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="./static/js/pinterest_grid.js"></script>
<script type="text/javascript">
    $(function () {
        $("#gallery-wrapper").pinterest_grid({
            no_columns: 5,
            padding_x: 10,
            padding_y: 10,
            margin_bottom: 50,
            single_column_breakpoint: 700
        });
    });

    $("section article span").click(function(){
        $("section article input").attr("type","hidden");
        $(this).next().attr("type","text");
        $(this).next().focus();
    });

    $('section article input').bind('keypress',function(event){
        if(event.keyCode == "13") {
            var desc = $(this).val();
            var fileId = $(this).attr("data-id");
            var input = $(this);
            var span = $(this).prev();
            if (desc == "" || desc == null || desc == "undefined") {
                layer.alert('亲，描述不合法呦！', 'Ops...There seems to be a little problem.');
                return false;
            }else if(desc.length>10){
                layer.alert('亲，写的太多啦，10个字符足够呦！', 'Ops...There seems to be a little problem.');
                return false;
            } else {
                $.ajax({
                    type: "post",
                    url: "/updateFile",
                    data: {"fileId": fileId,"fileDesc":desc},
                    dataType: "json",
                    success: function (msg) {
                        if(msg.flag){
                            input.attr("type","hidden");
                            span.text(desc);
                            layer.alert(msg.msg);
                        }else{
                            layer.alert(msg.msg);
                        }
                    }
                });
            }
        }
    });
</script>
</body>
</html>

