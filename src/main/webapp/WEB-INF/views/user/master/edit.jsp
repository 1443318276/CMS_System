<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editUserMaster.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>所属角色</label>
        <select class="form-control" name="routerId">
            <c:forEach items="${routerList}" var="item">
                <option
                        <c:if test="${editItem.routerId==item.id}">selected</c:if>
                        value="${item.id}">${item.routerName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>用户名称</label>
        <input class="form-control" name="masterName" value="${editItem.masterName}">
    </div>
    <div class="form-group mb-2">
        <label>用户头像</label>
        <input class="form-control" name="masterThumb" value="${editItem.masterThumb}">
        <div class="media">
            <img style="max-width: 100px;max-height: 100px;" src="${editItem.masterThumb}">
            <div class="media-body">
                <button type="button" id="fileUpload" class="btn btn-sm btn-info">点击上传图片</button>
            </div>
        </div>
    </div>
    <div class="form-group mb-2">
        <label>登录账号</label>
        <input class="form-control" name="masterUsername" value="${editItem.masterUsername}">
    </div>
    <div class="form-group mb-2">
        <label>联系电话</label>
        <input class="form-control" name="masterPhone" value="${editItem.masterPhone}">
    </div>
    <div class="form-group mb-2">
        <label>联系邮箱</label>
        <input class="form-control" name="masterMail" value="${editItem.masterMail}">
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script>
    ($ => {
        $(() => {
            $("#fileUpload").peanutUploadFile({
                success(imgUrl) {
                    $("input[name='masterThumb']").val(imgUrl);
                    $("#fileUpload").parents(".media-body").siblings("img").attr("src", imgUrl);
                }
            })
        })
    })(jQuery);
</script>
</body>
</html>
