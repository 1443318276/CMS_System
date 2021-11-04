<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editSystemConfig.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>配置名称</label>
        <input class="form-control" name="configName" value="${editItem.configName}"
               <c:if test="${editItem!=null}">readonly</c:if>>
    </div>
    <div class="form-group mb-2">
        <label>配置主键</label>
        <input class="form-control" name="configKey" value="${editItem.configKey}"
               <c:if test="${editItem!=null}">readonly</c:if>>
    </div>
    <div class="form-group mb-2">
        <label>数据类型</label>
        <div class="form-control">
            <label  role="button">
                <input
                        <c:if test="${editItem!=null}">disabled</c:if> type="radio" name="configType" value="int"
                        <c:if test="${editItem.configType=='int'}">checked</c:if>>数值型
            </label>
            <label role="button">
                <input
                        <c:if test="${editItem!=null}">disabled</c:if> type="radio" name="configType" value="string"
                        <c:if test="${editItem.configType=='string'}">checked</c:if>>字符串
            </label>
            <label  role="button">
                <input
                        <c:if test="${editItem!=null}">disabled</c:if> type="radio" name="configType" value="url"
                        <c:if test="${editItem.configType=='url'}">checked</c:if>>资源类型
            </label>
        </div>
    </div>
    <div class="form-group mb-2">
        <label>配置值</label>
        <div class="input-group">
            <input class="form-control" name="configValue" value="${editItem.configValue}">
        </div>
    </div>
    <div class="form-group mb-2">
        <label>描述信息</label>
        <textarea style="height: auto;" class="form-control" name="configDes">${editItem.configDes}</textarea>
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script>
    ($ => {
        $(() => {
            let uploadForm = null;
            //监听input[type="radio"]的变换
            $("input[name='configType']").change((e) => {
                const checkedVal = $("input[name='configType']:checked").val();
                if (checkedVal === 'url') {
                    if (uploadForm != null) return;
                    $("input[name='configValue']").after(`
                   <div id="uploadFile" class="input-group-append" role="button">
                <span class="input-group-text">点击上传文件</span>
            </div>
                   `);
                    uploadForm = $("#uploadFile").peanutUploadFile({
                        accept: "*/*",
                        success(url) {
                            $("input[name='configValue']").val(url);
                        }
                    })
                } else {
                    $("#uploadFile").remove();
                    if (uploadForm != null) {
                        uploadForm.remove();
                        uploadForm = null;
                    }
                }
            });
        })
    })(jQuery);
</script>
</body>
</html>
