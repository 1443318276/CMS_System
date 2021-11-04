<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editUserRouter.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>角色名称</label>
        <input class="form-control" name="routerName" value="${editItem.routerName}">
    </div>
    <div class="form-group mb-2">
        <label>描述信息</label>
        <textarea class="form-control" style="height: auto;" name="routerDes">${editItem.routerDes}</textarea>
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>
