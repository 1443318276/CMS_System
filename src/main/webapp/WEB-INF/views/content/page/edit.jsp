<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<link rel="stylesheet" href="static/plugins/daterangepicker/daterangepicker.css">
</head>
<body>
<form action="master/editContentPage.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>名称</label>
        <input class="form-control" name="pageName" value="${editItem.pageName}">
    </div>
    <div class="form-group mb-2">
        <label>缩略图</label>
        <div class="input-group">
            <input class="form-control" name="pageThumb" value="${editItem.pageThumb}">
            <div class="input-group-append">
                <span id="fileUpload" class="input-group-text">点击上传文件</span>
            </div>
        </div>
    </div>
    <div class="form-group mb-2">
        <label>作者</label>
        <input class="form-control" name="pageAuthor" value="${editItem.pageAuthor}">
    </div>
    <div class="form-group mb-2">
        <label>标签列表</label>
        <div style="height: auto;" class="form-control">
            <label><input name="pageFlag[]" type="checkbox" value="热点"
                          <c:if test="${fn:contains(editItem.pageFlag,'热点')}">checked</c:if>>热点</label>
            <label><input name="pageFlag[]" type="checkbox" value="推送"
                          <c:if test="${fn:contains(editItem.pageFlag,'推送')}">checked</c:if>>推送</label>
            <label><input name="pageFlag[]" type="checkbox" value="最新"
                          <c:if test="${fn:contains(editItem.pageFlag,'最新')}">checked</c:if>>最新</label>
            <label><input name="pageFlag[]" type="checkbox" value="图文"
                          <c:if test="${fn:contains(editItem.pageFlag,'图文')}">checked</c:if>>图文</label>
            <label><input name="pageFlag[]" type="checkbox" value="通知"
                          <c:if test="${fn:contains(editItem.pageFlag,'通知')}">checked</c:if>>通知</label>
        </div>
    </div>
    <div class="form-group mb-2">
        <label>SEO标题</label>
        <input class="form-control" name="pageTitle" value="${editItem.pageTitle}">
    </div>
    <div class="form-group mb-2">
        <label>SEO关键字</label>
        <input class="form-control" name="pageKeywords" value="${editItem.pageKeywords}">
    </div>
    <div class="form-group mb-2">
        <label>SEO描述信息</label>
        <input class="form-control" name="pageDescription" value="${editItem.pageDescription}">
    </div>
    <div class="form-group mb-2">
        <label>发布日期</label>
        <input id="datepicker" class="form-control" name="pageTime" value=""${editItem.pageTime}">
    </div>
    <div class="form-group mb-2">
        <label>页面模板</label>
        <select class="form-control" name="contentTemplate">
            <c:forEach items="${templateList}" var="i">
                <option
                        <c:if test="${editItem.contentTemplate==i.id}">selected</c:if>
                        value="${i.id}">${i.templateDir}_${i.templateName}</option>
            </c:forEach>
        </select>
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script src="static/plugins/moment/moment.min.js"></script>
<script src="static/plugins/daterangepicker/daterangepicker.js"></script>
<script>
    ($ => {
        $(() => {
            $("#fileUpload").peanutUploadFile({
                success(url) {
                    $("input[name='pageThumb']").val(url);
                }
            });
            $("#datepicker").daterangepicker({
                singleDatePicker: true,
                minYear: 2021,
                drops: 'up',
                autoUpdateInput: false,
                timePicker: true,
                timePicker24Hour: true,
                timePickerSeconds: true
            }, (start, end, label) => {
                $("#datepicker").val(start.format("yyyy-MM-DD HH:mm:ss"))
            });
        });
    })(jQuery);
</script>
</body>
</html>
