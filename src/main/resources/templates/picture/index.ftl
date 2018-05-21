<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>相册</title>
    <link rel="stylesheet" href="./static/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="./static/css/picture.css">
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<section id="gallery-wrapper">
    <#list photoList as photo>
        <article class="white-panel">
            <img src="${photo.fileSystemName}" class="thumb" alt="${photo.fileName}">
            <span>
                ${photo.fileDesc!"点击添加描述"}
            </span>
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
</script>
</body>
</html>

