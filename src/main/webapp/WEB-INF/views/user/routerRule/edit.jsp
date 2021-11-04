<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/userMasterRuleEdit.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>角色信息</label>
        <select class="form-control" name="routerId">
            <c:forEach items="${routerList}" var="item">
                <option <c:if test="${editItem.routerId==item.id}">selected</c:if> value="${item.id}">
                        ${item.routerName}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>权限信息</label>
        <select class="form-control" name="ruleId">
            <c:forEach items="${ruleList}" var="item">
                <option <c:if test="${editItem.ruleId==item.id}">selected</c:if> value="${item.id}">
                        ${item.ruleType}_${item.ruleMethod}_${item.ruleName}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>权限状态</label>
        <select class="form-control" name="ruleState">
            <option value="GRANTED">
                允许访问
            </option>
            <option value="DENIED" <c:if test="${editItem.ruleState=='DENIED'}">selected</c:if> >
                禁止访问
            </option>
        </select>
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>
