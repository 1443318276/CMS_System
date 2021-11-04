<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/master/index.do" class="brand-link">
        <img src="${loginUser.masterThumb}" alt="${loginUser.masterName}User Image"
             class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">${loginUser.masterName}</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- SidebarSearch Form -->
        <div class="form-inline mt-3">
            <div class="input-group" data-widget="sidebar-search">
                <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-sidebar">
                        <i class="fas fa-search fa-fw"></i>
                    </button>
                </div>
            </div>
        </div>
        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <c:forEach items="${ruleList}" var="item">
                    <!-- item无子类-->
                    <c:if test="${fn:length(item.childList)==0}">
                        <!-- 单独说明标签-->
                        <c:if test="${item.ruleUrl=='' ||item.ruleUrl=='#'}">
                            <li class="nav-header">${item.ruleName}</li>
                        </c:if>
                        <!-- /单独说明标签-->
                        <!-- 无子菜单的导航-->
                        <c:if test="${fn:length(item.ruleUrl)>1}">
                            <li class="nav-item">
                                <a href="${item.ruleUrl}" class="nav-link">
                                    <i class="nav-icon fa fa-${item.ruleIcon}"></i>
                                    <p>${item.ruleName}</p>
                                </a>
                            </li>
                        </c:if>
                        <!-- /无子菜单的导航-->
                    </c:if>
                    <!-- /item无子类-->
                    <!-- item有子类-->
                    <c:if test="${fn:length(item.childList)>0}">
                        <!-- 如果href=# 那么就是单独说明标签，否则是有子菜单的导航-->
                        <c:if test="${item.ruleUrl=='#'}">
                            <!-- 单独说明标签-->
                            <li class="nav-header">${item.ruleName}</li>
                            <c:forEach items="${item.childList}" var="ii">
                                <!-- 无子菜单的导航-->
                                <c:if test="${fn:length(ii.childList)==0}">
                                    <li class="nav-item">
                                        <a href="${ii.ruleUrl}" class="nav-link">
                                            <i class="nav-icon fa fa-${ii.ruleIcon}"></i>
                                            <p>${ii.ruleName}</p>
                                        </a>
                                    </li>
                                </c:if>
                                <!-- /无子菜单的导航-->
                                <!-- 有子菜单的导航-->
                                <c:if test="${fn:length(ii.childList)>0}">
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="nav-icon fa fa-${ii.ruleIcon}"></i>
                                            <p>${ii.ruleName}<i class="fas fa-angle-left right"></i></p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <c:forEach items="${ii.childList}" var="child">
                                                <li class="nav-item">
                                                    <a href="${child.ruleUrl}" class="nav-link">
                                                        <i class="far fa-circle nav-icon"></i>
                                                        <p>${child.ruleName}</p>
                                                    </a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:if>
                                <!-- /有子菜单的导航-->
                            </c:forEach>
                        </c:if>
                        <c:if test="${item.ruleUrl!='#'}">
                            <!-- 有子菜单的导航-->
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fa fa-${item.ruleIcon}"></i>
                                    <p>${item.ruleName}<i class="fas fa-angle-left right"></i></p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <c:forEach items="${item.childList}" var="ii">
                                        <li class="nav-item">
                                            <a href="${ii.ruleUrl}" class="nav-link">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>${ii.ruleName}</p>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                        <!-- /如果href=# 那么就是单独说明标签，否则是有子菜单的导航-->
                    </c:if>
                    <!-- /item有子类-->
                </c:forEach>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>

