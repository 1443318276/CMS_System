<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        StringBuilder builder = new StringBuilder(request.getScheme())
                .append("://")
                .append(request.getServerName());
        int port = request.getServerPort();
        if (port !=80 && port != 443) {
                builder.append(":").append(port);
        }
        builder.append(request.getServletContext().getContextPath());
    %>
<!DOCTYPE html>
<html dir="ltr" lang="zh">
<head>
<base href="<%=builder.toString() %>">
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
<title>${config.seoTitle}</title>
<meta name="keywords" content="${config.seoKeywords}">
<meta name="description" content="${config.seoDescription}">
<meta name="author" content="${config.site_author}">
<meta name="sitename" content="${config.site_name}">
<link rel="icon" type="image/png" href="${config.site_icon}">
<!--导入css样式表 -->
<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css"><!--https://v4.bootcss.com/docs-->
<link rel="stylesheet" href="static/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="static/plugins/toastr/toastr.min.css">
<link rel="stylesheet" href="static/plugins/sweetalert2/sweetalert2.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="static/dist/css/adminlte.min.css">
<link rel="stylesheet" href="static/plugins/bootstrap-table/bootstrap-table.min.css">
<link rel="stylesheet" href="static/css/peanut.css">