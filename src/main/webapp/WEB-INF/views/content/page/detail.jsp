<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body>
<form action="master/editContentPageDetail.do" method="post" class="container-fluid">
    <input type="hidden" name="id" value="${editItem.id}">
    <textarea name="pageContent" class="d-none">${editItem.pageContent}</textarea>
    <div id="pageContent" class="content ">${editItem.pageContent} </div>
</form>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script src="/static/plugins/wangeditor-4.7.8/wangEditor.min.js"></script>
<script>
    (($, E) => {
        $(() => {
            const editor = new E("#pageContent");
            $.extend(editor.config, {
                excludeMenus: ["video"],
                showLinkVideo: false,
                showLinkImg: false,
                uploadImgServer: "master/uploadFile.do",
                uploadImgMaxLength: 1,
                uploadFileName: "files",
                uploadImgParams: {},
                uploadImgHooks: {
                    customInsert(insertImgFn, result) {
                        if (result.code === 0) {
                            insertImgFn(result.url);
                        } else {
                            toastr.error(result.msg, result.title);
                        }
                    },
                    onchange(html){
                        $("textarea[name='pageContent']").val(html);
                    }
                }
            });
            editor.create();
           /* $("form").on("submit", function () {
                try {
                    $("textarea[name='pageContent']").val(editor.txt.html());
                } catch (e) {
                    console.log(e);
                }
                return false;
            })
            */
        });
    })(jQuery, window.wangEditor);
</script>
</body>
</html>
