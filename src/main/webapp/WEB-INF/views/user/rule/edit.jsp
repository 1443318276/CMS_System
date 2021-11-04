<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editUserRule.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <div class="form-group mb-2">
        <label>父级权限</label>
        <select class="form-control" name="pid">
            <option value="">无父级权限</option>
            <c:forEach items="${ruleList}" var="item" varStatus="status">
                <option
                        <c:if test="${editItem.pid==item.id}">selected</c:if>
                        value="${item.id}">${item.ruleName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>权限名称</label>
        <input class="form-control" name="ruleName" value="${editItem.ruleName}">
    </div>
    <div class="form-group mb-2">
        <label>权限路径</label>
        <input class="form-control" name="ruleUrl" value="${editItem.ruleUrl}">
    </div>
    <div class="form-group mb-2">
        <label>请求方法</label>
        <select class="form-control" name="ruleMethod">
            <option value="GET">GET</option>
            <option
                    <c:if test="${editItem.ruleMethod=='POST'}">selected</c:if> value="POST">POST
            </option>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>权限类型</label>
        <select class="form-control" name="ruleType">
            <option value="API">API</option>
            <option
                    <c:if test="${editItem.ruleType=='NAV'}">selected</c:if> value="NAV">NAV
            </option>
            <option
                    <c:if test="${editItem.ruleType=='PAGE'}">selected</c:if> value="PAGE">PAGE
            </option>
        </select>
    </div>
    <div class="form-group mb-2">
        <label>权限图标</label>
        <input id="iconPicker" class="form-control" name="ruleIcon" value="${editItem.ruleIcon}">
    </div>
    <div class="form-group mb-2">
        <label>解释文档</label>
        <textarea style="height: auto" class="form-control" name="ruleDes">${editItem.ruleDes}</textarea>
    </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script>
    ($ => {
        $(() => {
            const $iconPicker = $("#iconPicker");
            $iconPicker.on("click focus", (e) => {
                if ($(".font-awesome-picker").length > 0) return;
                //定义一窗口样式
                const _html = `
                  <div class="font-awesome-picker shadow position-absolute">
            <div class="awesome-header">
                <h3 class="awesome-title">图标筛选器</h3>
            </div>
            <!--筛选fa图标的正则<i\\sclass="fa\\sfa-[0-9a-z\\-\\s]+"\\s(aria-hidden="true")?></i> -->
            <ul class="awesome-list">
                <li><i class="fa fa-address-book"></i></li>
                <li><i class="fa fa-address-card"></i></li>
                <li><i class="fa fa-adjust"></i></li>
                <li><i class="fa fa-american-sign-language-interpreting"></i></li>
                <li><i class="fa fa-anchor"></i></li>
                <li><i class="fa fa-archive"></i></li>
                <li><i class="fa fa-assistive-listening-systems"></i></li>
                <li><i class="fa fa-asterisk"></i></li>
                <li><i class="fa fa-at"></i></li>
                <li><i class="fa fa-audio-description"></i></li>
                <li><i class="fa fa-balance-scale"></i></li>
                <li><i class="fa fa-ban"></i></li>
                <li><i class="fa fa-barcode"></i></li>
                <li><i class="fa fa-bars"></i></li>
                <li><i class="fa fa-bath"></i></li>
                <li><i class="fa fa-battery-empty"></i></li>
                <li><i class="fa fa-battery-full"></i></li>
                <li><i class="fa fa-battery-half"></i></li>
                <li><i class="fa fa-battery-quarter"></i></li>
                <li><i class="fa fa-battery-three-quarters"></i></li>
                <li><i class="fa fa-bed"></i></li>
                <li><i class="fa fa-beer"></i></li>
                <li><i class="fa fa-bell"></i></li>
                <li><i class="fa fa-bell-slash"></i></li>
                <li><i class="fa fa-bicycle"></i></li>
                <li><i class="fa fa-binoculars"></i></li>
                <li><i class="fa fa-birthday-cake"></i></li>
                <li><i class="fa fa-blind"></i></li>
                <li><i class="fa fa-bolt"></i></li>
                <li><i class="fa fa-bomb"></i></li>
                <li><i class="fa fa-book"></i></li>
                <li><i class="fa fa-bookmark"></i></li>
                <li><i class="fa fa-braille"></i></li>
                <li><i class="fa fa-briefcase"></i></li>
                <li><i class="fa fa-bug"></i></li>
                <li><i class="fa fa-building"></i></li>
                <li><i class="fa fa-bullhorn"></i></li>
                <li><i class="fa fa-bullseye"></i></li>
                <li><i class="fa fa-bus"></i></li>
                <li><i class="fa fa-calculator"></i></li>
                <li><i class="fa fa-calendar"></i></li>
                <li><i class="fa fa-camera"></i></li>
                <li><i class="fa fa-camera-retro"></i></li>
                <li><i class="fa fa-car"></i></li>
                <li><i class="fa fa-cart-arrow-down"></i></li>
                <li><i class="fa fa-cart-plus"></i></li>
                <li><i class="fa fa-certificate"></i></li>
                <li><i class="fa fa-check"></i></li>
                <li><i class="fa fa-check-circle"></i></li>
                <li><i class="fa fa-check-square"></i></li>
                <li><i class="fa fa-child"></i></li>
                <li><i class="fa fa-circle"></i></li>
                <li><i class="fa fa-clone"></i></li>
                <li><i class="fa fa-cloud"></i></li>
                <li><i class="fa fa-code"></i></li>
                <li><i class="fa fa-coffee"></i></li>
                <li><i class="fa fa-cog"></i></li>
                <li><i class="fa fa-cogs"></i></li>
                <li><i class="fa fa-comment"></i></li>
                <li><i class="fa fa-comments"></i></li>
                <li><i class="fa fa-compass"></i></li>
                <li><i class="fa fa-copyright"></i></li>
                <li><i class="fa fa-credit-card"></i></li>
                <li><i class="fa fa-crop"></i></li>
                <li><i class="fa fa-crosshairs"></i></li>
                <li><i class="fa fa-cube"></i></li>
                <li><i class="fa fa-cubes"></i></li>
                <li><i class="fa fa-database"></i></li>
                <li><i class="fa fa-desktop"></i></li>
                <li><i class="fa fa-download"></i></li>
                <li><i class="fa fa-edit"></i></li>
                <li><i class="fa fa-ellipsis-h"></i></li>
                <li><i class="fa fa-ellipsis-v"></i></li>
                <li><i class="fa fa-envelope"></i></li>
                <li><i class="fa fa-envelope-open"></i></li>
                <li><i class="fa fa-envelope-square"></i></li>
                <li><i class="fa fa-eraser"></i></li>
                <li><i class="fa fa-exclamation"></i></li>
                <li><i class="fa fa-exclamation-circle"></i></li>
                <li><i class="fa fa-exclamation-triangle"></i></li>
                <li><i class="fa fa-eye"></i></li>
                <li><i class="fa fa-eye-slash"></i></li>
                <li><i class="fa fa-fax"></i></li>
                <li><i class="fa fa-male"></i></li>
                <li><i class="fa fa-female"></i></li>
                <li><i class="fa fa-fighter-jet"></i></li>
                <li><i class="fa fa-film"></i></li>
                <li><i class="fa fa-filter"></i></li>
                <li><i class="fa fa-fire"></i></li>
                <li><i class="fa fa-fire-extinguisher"></i></li>
                <li><i class="fa fa-flag"></i></li>
                <li><i class="fa fa-flag-checkered"></i></li>
                <li><i class="fa fa-flask"></i></li>
                <li><i class="fa fa-folder"></i></li>
                <li><i class="fa fa-folder-open"></i></li>
                <li><i class="fa fa-gamepad"></i></li>
                <li><i class="fa fa-gavel"></i></li>
                <li><i class="fa fa-gift"></i></li>
                <li><i class="fa fa-globe"></i></li>
                <li><i class="fa fa-graduation-cap"></i></li>
                <li><i class="fa fa-hashtag"></i></li>
                <li><i class="fa fa-headphones"></i></li>
                <li><i class="fa fa-heart"></i></li>
                <li><i class="fa fa-heartbeat"></i></li>
                <li><i class="fa fa-history"></i></li>
                <li><i class="fa fa-home"></i></li>
                <li><i class="fa fa-hotel"></i></li>
                <li><i class="fa fa-hourglass"></i></li>
                <li><i class="fa fa-hourglass-end"></i></li>
                <li><i class="fa fa-hourglass-half"></i></li>
                <li><i class="fa fa-hourglass-start"></i></li>
                <li><i class="fa fa-i-cursor"></i></li>
                <li><i class="fa fa-id-badge"></i></li>
                <li><i class="fa fa-id-card"></i></li>
                <li><i class="fa fa-image"></i></li>
                <li><i class="fa fa-inbox"></i></li>
                <li><i class="fa fa-industry"></i></li>
                <li><i class="fa fa-info"></i></li>
                <li><i class="fa fa-info-circle"></i></li>
                <li><i class="fa fa-key"></i></li>
                <li><i class="fa fa-language"></i></li>
                <li><i class="fa fa-laptop"></i></li>
                <li><i class="fa fa-leaf"></i></li>
                <li><i class="fa fa-life-ring"></i></li>
                <li><i class="fa fa-location-arrow"></i></li>
                <li><i class="fa fa-lock"></i></li>
                <li><i class="fa fa-low-vision"></i></li>
                <li><i class="fa fa-magic"></i></li>
                <li><i class="fa fa-magnet"></i></li>
                <li><i class="fa fa-male"></i></li>
                <li><i class="fa fa-map"></i></li>
                <li><i class="fa fa-map-marker"></i></li>
                <li><i class="fa fa-map-pin"></i></li>
                <li><i class="fa fa-map-signs"></i></li>
                <li><i class="fa fa-microchip"></i></li>
                <li><i class="fa fa-microphone"></i></li>
                <li><i class="fa fa-microphone-slash"></i></li>
                <li><i class="fa fa-minus"></i></li>
                <li><i class="fa fa-minus-circle"></i></li>
                <li><i class="fa fa-minus-square"></i></li>
                <li><i class="fa fa-mobile"></i></li>
                <li><i class="fa fa-motorcycle"></i></li>
                <li><i class="fa fa-mouse-pointer"></i></li>
                <li><i class="fa fa-music"></i></li>
                <li><i class="fa fa-object-group"></i></li>
                <li><i class="fa fa-object-ungroup"></i></li>
                <li><i class="fa fa-paint-brush"></i></li>
                <li><i class="fa fa-paper-plane"></i></li>
                <li><i class="fa fa-paw"></i></li>
                <li><i class="fa fa-percent"></i></li>
                <li><i class="fa fa-phone"></i></li>
                <li><i class="fa fa-phone-square"></i></li>
                <li><i class="fa fa-plane"></i></li>
                <li><i class="fa fa-plug"></i></li>
                <li><i class="fa fa-plus"></i></li>
                <li><i class="fa fa-plus-circle"></i></li>
                <li><i class="fa fa-plus-square"></i></li>
                <li><i class="fa fa-podcast"></i></li>
                <li><i class="fa fa-power-off"></i></li>
                <li><i class="fa fa-print"></i></li>
                <li><i class="fa fa-puzzle-piece"></i></li>
                <li><i class="fa fa-qrcode"></i></li>
                <li><i class="fa fa-question"></i></li>
                <li><i class="fa fa-question-circle"></i></li>
                <li><i class="fa fa-quote-left"></i></li>
                <li><i class="fa fa-quote-right"></i></li>
                <li><i class="fa fa-random"></i></li>
                <li><i class="fa fa-recycle"></i></li>
                <li><i class="fa fa-registered"></i></li>
                <li><i class="fa fa-reply"></i></li>
                <li><i class="fa fa-reply-all"></i></li>
                <li><i class="fa fa-retweet"></i></li>
                <li><i class="fa fa-road"></i></li>
                <li><i class="fa fa-rocket"></i></li>
                <li><i class="fa fa-rss"></i></li>
                <li><i class="fa fa-rss-square"></i></li>
                <li><i class="fa fa-search"></i></li>
                <li><i class="fa fa-search-minus"></i></li>
                <li><i class="fa fa-search-plus"></i></li>
                <li><i class="fa fa-server"></i></li>
                <li><i class="fa fa-share"></i></li>
                <li><i class="fa fa-share-alt"></i></li>
                <li><i class="fa fa-share-alt-square"></i></li>
                <li><i class="fa fa-share-square"></i></li>
                <li><i class="fa fa-ship"></i></li>
                <li><i class="fa fa-shopping-bag"></i></li>
                <li><i class="fa fa-shopping-basket"></i></li>
                <li><i class="fa fa-shopping-cart"></i></li>
                <li><i class="fa fa-shower"></i></li>
                <li><i class="fa fa-sign-language"></i></li>
                <li><i class="fa fa-signal"></i></li>
                <li><i class="fa fa-sitemap"></i></li>
                <li><i class="fa fa-sort"></i></li>
                <li><i class="fa fa-sort-down"></i></li>
                <li><i class="fa fa-sort-up"></i></li>
                <li><i class="fa fa-space-shuttle"></i></li>
                <li><i class="fa fa-spinner"></i></li>
                <li><i class="fa fa-square"></i></li>
                <li><i class="fa fa-star"></i></li>
                <li><i class="fa fa-star-half"></i></li>
                <li><i class="fa fa-sticky-note"></i></li>
                <li><i class="fa fa-street-view"></i></li>
                <li><i class="fa fa-suitcase"></i></li>
                <li><i class="fa fa-tablet"></i></li>
                <li><i class="fa fa-tag"></i></li>
                <li><i class="fa fa-tags"></i></li>
                <li><i class="fa fa-tasks"></i></li>
                <li><i class="fa fa-taxi"></i></li>
                <li><i class="fa fa-terminal"></i></li>
                <li><i class="fa fa-thermometer"></i></li>
                <li><i class="fa fa-thermometer-empty"></i></li>
                <li><i class="fa fa-thermometer-full"></i></li>
                <li><i class="fa fa-thermometer-half"></i></li>
                <li><i class="fa fa-thermometer-quarter"></i></li>
                <li><i class="fa fa-thermometer-three-quarters"></i></li>
                <li><i class="fa fa-thumbs-down"></i></li>
                <li><i class="fa fa-thumbs-up"></i></li>
                <li><i class="fa fa-times"></i></li>
                <li><i class="fa fa-times-circle"></i></li>
                <li><i class="fa fa-tint"></i></li>
                <li><i class="fa fa-toggle-off"></i></li>
                <li><i class="fa fa-toggle-on"></i></li>
                <li><i class="fa fa-trademark"></i></li>
                <li><i class="fa fa-trash"></i></li>
                <li><i class="fa fa-tree"></i></li>
                <li><i class="fa fa-trophy"></i></li>
                <li><i class="fa fa-truck"></i></li>
                <li><i class="fa fa-tty"></i></li>
                <li><i class="fa fa-tv"></i></li>
                <li><i class="fa fa-umbrella"></i></li>
                <li><i class="fa fa-universal-access"></i></li>
                <li><i class="fa fa-university"></i></li>
                <li><i class="fa fa-unlock"></i></li>
                <li><i class="fa fa-unlock-alt"></i></li>
                <li><i class="fa fa-upload"></i></li>
                <li><i class="fa fa-user"></i></li>
                <li><i class="fa fa-user-circle"></i></li>
                <li><i class="fa fa-user-times"></i></li>
                <li><i class="fa fa-users"></i></li>
                <li><i class="fa fa-volume-down"></i></li>
                <li><i class="fa fa-volume-off"></i></li>
                <li><i class="fa fa-volume-up"></i></li>
                <li><i class="fa fa-wheelchair"></i></li>
                <li><i class="fa fa-wifi"></i></li>
                <li><i class="fa fa-window-close"></i></li>
                <li><i class="fa fa-window-maximize"></i></li>
                <li><i class="fa fa-window-minimize"></i></li>
                <li><i class="fa fa-window-restore"></i></li>
                <li><i class="fa fa-wrench"></i></li>
                <li><i class="fa fa-ambulance"></i></li>
                <li><i class="fa fa-subway"></i></li>
                <li><i class="fa fa-train"></i></li>
                <li><i class="fa fa-mars"></i></li>
                <li><i class="fa fa-mars-double"></i></li>
                <li><i class="fa fa-mars-stroke"></i></li>
                <li><i class="fa fa-mars-stroke-h"></i></li>
                <li><i class="fa fa-mars-stroke-v"></i></li>
                <li><i class="fa fa-mercury"></i></li>
                <li><i class="fa fa-neuter"></i></li>
                <li><i class="fa fa-transgender"></i></li>
                <li><i class="fa fa-transgender-alt"></i></li>
                <li><i class="fa fa-venus"></i></li>
                <li><i class="fa fa-venus-double"></i></li>
                <li><i class="fa fa-venus-mars"></i></li>
                <li><i class="fa fa-file"></i></li>
                <li><i class="fa fa-font"></i></li>
                <li><i class="fa fa-indent"></i></li>
                <li><i class="fa fa-italic"></i></li>
                <li><i class="fa fa-link"></i></li>
                <li><i class="fa fa-list"></i></li>
                <li><i class="fa fa-list-alt"></i></li>
                <li><i class="fa fa-list-ol"></i></li>
                <li><i class="fa fa-list-ul"></i></li>
                <li><i class="fa fa-outdent"></i></li>
                <li><i class="fa fa-paperclip"></i></li>
                <li><i class="fa fa-paragraph"></i></li>
                <li><i class="fa fa-paste"></i></li>
                <li><i class="fa fa-save"></i></li>
                <li><i class="fa fa-strikethrough"></i></li>
                <li><i class="fa fa-subscript"></i></li>
                <li><i class="fa fa-superscript"></i></li>
                <li><i class="fa fa-table"></i></li>
                <li><i class="fa fa-text-height"></i></li>
                <li><i class="fa fa-text-width"></i></li>
                <li><i class="fa fa-th"></i></li>
                <li><i class="fa fa-th-large"></i></li>
                <li><i class="fa fa-th-list"></i></li>
                <li><i class="fa fa-underline"></i></li>
                <li><i class="fa fa-undo"></i></li>
                <li><i class="fa fa-unlink"></i></li>
                <li><i class="fa fa-angle-double-down"></i></li>
                <li><i class="fa fa-angle-double-left"></i></li>
                <li><i class="fa fa-angle-double-right"></i></li>
                <li><i class="fa fa-angle-double-up"></i></li>
                <li><i class="fa fa-angle-down"></i></li>
                <li><i class="fa fa-angle-left"></i></li>
                <li><i class="fa fa-angle-right"></i></li>
                <li><i class="fa fa-angle-up"></i></li>
                <li><i class="fa fa-arrow-circle-down"></i></li>
                <li><i class="fa fa-arrow-circle-left"></i></li>
                <li><i class="fa fa-arrow-circle-right"></i></li>
                <li><i class="fa fa-arrow-circle-up"></i></li>
                <li><i class="fa fa-arrow-down"></i></li>
                <li><i class="fa fa-arrow-left"></i></li>
                <li><i class="fa fa-arrow-right"></i></li>
                <li><i class="fa fa-arrow-up"></i></li>
                <li><i class="fa fa-arrows-alt"></i></li>
                <li><i class="fa fa-caret-down"></i></li>
                <li><i class="fa fa-caret-left"></i></li>
                <li><i class="fa fa-caret-right"></i></li>
                <li><i class="fa fa-caret-up"></i></li>
                <li><i class="fa fa-chevron-circle-down"></i></li>
                <li><i class="fa fa-chevron-circle-left"></i></li>
                <li><i class="fa fa-chevron-circle-right"></i></li>
                <li><i class="fa fa-chevron-circle-up"></i></li>
                <li><i class="fa fa-chevron-down"></i></li>
                <li><i class="fa fa-chevron-left"></i></li>
                <li><i class="fa fa-chevron-right"></i></li>
                <li><i class="fa fa-chevron-up"></i></li>
                <li><i class="fa fa-backward"></i></li>
                <li><i class="fa fa-compress"></i></li>
                <li><i class="fa fa-eject"></i></li>
                <li><i class="fa fa-expand"></i></li>
                <li><i class="fa fa-fast-backward"></i></li>
                <li><i class="fa fa-fast-forward"></i></li>
                <li><i class="fa fa-forward"></i></li>
                <li><i class="fa fa-pause"></i></li>
                <li><i class="fa fa-pause-circle"></i></li>
                <li><i class="fa fa-play"></i></li>
                <li><i class="fa fa-play-circle"></i></li>
                <li><i class="fa fa-step-backward"></i></li>
                <li><i class="fa fa-step-forward"></i></li>
                <li><i class="fa fa-stop"></i></li>
                <li><i class="fa fa-stop-circle"></i></li>
                <li><i class="fa fa-h-square"></i></li>
                <li><i class="fa fa-medkit"></i></li>
                <li><i class="fa fa-stethoscope"></i></li>
                <li><i class="fa fa-user-md"></i></li>
            </ul>
        </div>
                `;
                //添加到页面
                $iconPicker.parents(".form-group").append(_html);
                //添加遮蒙罩板
                $("body").append('<div class="modal-backdrop show"></div>');
                //点击蒙板销毁，点击li标签选中
                $(".modal-backdrop").on("click", (e) => {
                    $(e.target).remove();
                    $(".font-awesome-picker").remove();
                });
                $(".font-awesome-picker").one("click", "li", (e) => {
                    let str = null;
                    if (e.target.tagName === "LI") {
                        str = $(e.target).find("i").attr("class");
                    } else {
                        str = $(e.target).attr("class")
                    }
                    //写入input
                    $("input[name='ruleIcon']").val(str.replace("fa fa-", ""));
                    //触发销毁
                    $(".modal-backdrop").trigger("click");
                });
            });
        })
    })(jQuery);
</script>
</body>
</html>