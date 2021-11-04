<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editContentType.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>上级分类</label>
        <select class="form-control" name="pid">
            <option value="">无上级分类</option>
            <c:forEach items="${typeList}" var="i">
                <option
                        <c:if test="${i.id==editItem.pid}">selected</c:if> value="${i.id}"
                        data-indent="${i.level}">${i.typeName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>分类模板</label>
        <select class="form-control" name="typeTemplate"><c:forEach items="${templateList}" var="i"><option <c:if test="${i.id==editItem.typeTemplate}">selected</c:if> value="${i.id}">${i.templateType}_${i.templateName}</option></c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>详情页模板</label>
        <select class="form-control" name="contentTemplate"><c:forEach items="${templateList}" var="i"><option <c:if test="${i.id==editItem.contentTemplate}">selected</c:if> value="${i.id}">${i.templateType}_${i.templateName}</option></c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>静态文件存储的相对目录</label>
        <input class="form-control" name="typeFolder" value="${editItem.typeFolder}">
    </div>
    </div>
    <div class="form-group mb-2">
        <label>分类名称</label>
        <input class="form-control" name="typeName" value="${editItem.typeName}">
    </div>
    <div class="form-group mb-2">
        <label>分类排序</label>
        <input class="form-control" type="number" name="typeSort" value="${editItem.typeSort}">
    </div>

    <div class="form-group mb-2">
        <label>SEO标题</label>
        <input class="form-control" name="typeTitle" value="${editItem.typeTitle}">
    </div>
    <div class="form-group mb-2">
        <label>SEO关键字</label>
        <input class="form-control" name="typeKeywords" value="${editItem.typeKeywords}">
    </div>
    <div class="form-group mb-2">
        <label>SEO描述信息</label>
        <input class="form-control" name="typeDescription" value="${editItem.typeDescription}">
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>
