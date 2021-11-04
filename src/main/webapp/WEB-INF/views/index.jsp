<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="static/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed overflow-hidden" data-panel-auto-height-mode="height">
<div class="wrapper">
    <!-- navbar -->
    <%@ include file="item/index_navbar.jsp" %>
    <!-- /.navbar -->

    <!-- aside -->
    <%@ include file="item/index_aside.jsp" %>
    <!-- /.aside -->

    <!-- Content Wrapper -->
    <%@ include file="item/index_content.jsp" %>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<%@ include file="../layout/footer.jsp" %>
<script src="static/plugins/jquery-ui/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button)
    </script>
<script src="static/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<script src="static/dist/js/adminlte.min.js"></script>
<script src="static/dist/js/demo.js"></script>
<script>
($=>{
   $(()=>{
  //监听主界面搜索按钮的点击事件
 $(".navbar-search-block>form").submit(()=> {
     //获取input框的输入内容
     const val =$(".navbar-search-block>form").find("input[type='search']").val();
     if (!val) {
         new swal({
             icon:"warning",
             title:"搜索警告",
             text:"搜索内容不能为空！"
         });
         return false;
     }
     //创建一个虚拟的搜索标签
     const aTag=$(document.createElement("a"));
     aTag.attr("href","master/searchTag?param="+val);
     aTag.text(val);
     const pTag = $(document.createElement("p"));
     pTag.text("搜索："+val);
     aTag.append(pTag);
     //创建搜索界面
     aTag.IFrame("openTabSidebar",aTag[0]);
     return false;//阻止表单的默认提交事件
    });
   });
})(jQuery);
</script>
</body>
</html>

