<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html dir="ltr" lang="zh">
<head>
    <base href="http://localhost/">
    <meta charset="UTF-8">
    <!--浏览器的适配 -->
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <!--禁止百度转码-->
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <!--站点基础信息-->
    <title>TD-CMS-0103</title>
    <meta name="keywords" content="cms,通达学院,edu">
    <meta name="description" content="CMS">
    <meta name="author" content="yanyu">
    <meta name="sitename" content="CMS_System">
    <link rel="icon" type="image/png" href="/static/dist/img/AdminLTELogo.png"> <!--不再使用默认的.icon作为站点图片，而是用png代替-->
    <!--导入css样式表 -->
    <link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css"><!--https://v4.bootcss.com/docs-->
    <link rel="stylesheet" href="/static/plugins/fontawesome-free/css/all.css">
    <link rel="stylesheet" href="/static/plugins/toastr/toastr.min.css">
    <link rel="stylesheet" href="/static/plugins/sweetalert2/sweetalert2.min.css">
</head>
<body class="bg-gray">
<div class="container mt-5" >
  <h3>${msg}</h3>
</div>
<!-- 引入js脚本库  -->
<script src="/static/plugins/jquery/jquery.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/static/plugins/sweetalert2/sweetalert2.all.min.js"></script>
<script src="/static/plugins/toastr/toastr.min.js"></script>
<script>
    setTimeout(()=>{
        window.location.href="${url}";  // return; 加不加都行，有些浏览器不加return;不会执行跳转页面
    },3000);  //指定3秒刷新一次
</script>

</body>
</html>
