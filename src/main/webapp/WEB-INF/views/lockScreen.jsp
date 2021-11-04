<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body class="hold-transition lockscreen">
<!-- Automatic element centering -->
<div class="lockscreen-wrapper">
    <div class="lockscreen-logo">
        <a href="master/login.do"><b>NY-PEANUT</b>CMS</a>
    </div>
    <!-- User name -->
    <div class="lockscreen-name">${master.masterName}</div>

    <!-- START LOCK SCREEN ITEM -->
    <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
            <img src="${master.masterThumb}" alt="${master.masterName} 头像">
        </div>
        <!-- lockscreen-image -->

        <!-- lockscreen credentials (contains the form) -->
        <form action="master/unlock.do" method="post" class="lockscreen-credentials">
            <div class="input-group">
                <input type="password" name="password" class="form-control" placeholder="password">

                <div class="input-group-append">
                    <button type="button" class="btn">
                        <i class="fas fa-arrow-right text-muted"></i>
                    </button>
                </div>
            </div>
        </form>

    </div>
    <!-- lockscreen-item -->
    <div class="help-block text-center">
        Enter your 密码 to retrieve your session
    </div>
    <div class="text-center">
        <a href="master/login.do">Or sign in as a different 用户</a>
    </div>
</div>
<!-- center -->
    <%@ include file="/WEB-INF/layout/footer.jsp" %>
    </body>
</html>