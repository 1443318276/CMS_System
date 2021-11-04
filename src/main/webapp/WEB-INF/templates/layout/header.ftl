<!DOCTYPE html>
<html dir="ltr" lang="zh">
<head>
    <base href="${config.site_url?if_exists}">
    <meta charset="UTF-8">
    <!--浏览器的适配 -->
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <!--禁止百度转码-->
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <!--站点基础信息-->
    <title>${config.seoTitle?if_exists}</title>
    <meta name="keywords" content="${config.seoKeywords?if_exists}">
    <meta name="description" content="${config.seoDescription?if_exists}">
    <meta name="author" content="${config.site_author?if_exists}">
    <meta name="sitename" content="${config.site_name?if_exists}">
    <link rel="icon" type="image/png" href="${config.site_icon?if_exists}">
    <!--导入css样式表 -->
    <link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/plugins/fontawesome-free/css/all.min.css">
    <script>if (window.top !== window.self) window.top.location.href = window.location;</script>
</head>
<body>
