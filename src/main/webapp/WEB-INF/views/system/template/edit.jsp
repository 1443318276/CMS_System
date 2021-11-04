<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editSystemTemplate.do" method="post" class="container-fluid">
    <div class="row">
        <input type="hidden" name="id" value="${editItem.id}">
        <div class="form-group mb-2 col-12 col-md-6">
            <label>模板名称</label>
            <input class="form-control" type="text" name="templateName" value="${editItem.templateName}">
        </div>
        <div class="form-group mb-2 col-12 col-md-6">
            <label>模板分类</label>
            <input class="form-control" type="text" name="templateType" value="${editItem.templateType}">
        </div>
        <div class="form-group mb-2 col-12 col-md-6">
            <label>存放目录</label>
            <input class="form-control" type="text" name="templateDir" value="${editItem.templateDir}">
        </div>
        <div class="form-group mb-2 col-12 col-md-6">
            <label>文件名称</label>
            <input class="form-control" type="text" name="templateFile" value="${editItem.templateFile}">
        </div>
        <div class="form-group mb-2 col-12 col-md-6">
            <label>模板预览图片</label>
            <input class="form-control" type="text" name="templateThumb" value="${editItem.templateThumb}">
            <div class="media">
                <img style="max-width: 100px;max-height: 100px;" src="${editItem.templateThumb}">
                <div class="media-body">
                    <button type="button" id="fileUpload" class="btn btn-sm btn-info">点击上传图片</button>
                </div>
            </div>
        </div>
        <div class="form-group mb-2 col-12 col-md-6">
            <label>模板描述信息</label>
            <textarea style="height: auto;" class="form-control" type="text"
                      name="templateDes">${editItem.templateDes}</textarea>
        </div>
        <div class="form-group mb-2 col-12">
            <label>模板内容</label>
            <textarea id="templateContent" style="height: auto;" rows="10" class="form-control" type="text"
                      name="templateContent">${editItem.templateContent}</textarea>
        </div>
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script>
    ($ => {
        $(() => {
            $("#fileUpload").peanutUploadFile({
                success(imgUrl) {
                    $("input[name='templateThumb']").val(imgUrl);
                    $("#fileUpload").parents(".media-body").siblings("img").attr("src", imgUrl);
                }
            });
            //textarea高度自适应
            $("textarea").peanutTextAreaAutoHeight();
        })
    })(jQuery);
</script>
</body>
</html>
