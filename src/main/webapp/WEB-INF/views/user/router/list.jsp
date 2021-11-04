<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body style="background-color: #e3e3e3;">
<div class="container-fluid mt-2">
    <div class="content">
        <div class="card">
            <section class="card-header">
                <h3 class="card-title">角色列表</h3>
                <span class="float-right">
                    <a class="refresh-page text-dark" href="javascript:window.location.reload();" title="刷新当前页面">
                        <i class="fa fa-sync"></i>
                    </a>
                </span>
            </section>
            <section class="card-body">
                <div id="toolbar" class="input-group">
                    <button class="btn btn-success add-item mr-2">新增内容</button>
                    <button class="btn btn-danger del-checked mr-2">删除选中</button>
                </div>
                <table id="bootstrapTable"></table>
            </section>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/layout/footer.jsp" %>
<script>
    ($ => {
        const table = $("#bootstrapTable"); //获取Dom对象
        //初始化数据表格
        $(() => {
            table.bootstrapTable({
                url: "master/userRouterData.do", // 获取数据的ajax请求接口
                queryParams(params) {
                    return JSON.stringify($.extend({}, params, {
                        extras: {} // 附加的额外请求参数
                    }));
                },
                columns: [{   //代表一列的数据
                    checkbox: true
                }, {   //代表一列的数据
                    field: "id", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "编号",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "routerName", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "角色名称",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "routerDes", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "描述信息",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "addTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "添加时间",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "updateTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "修改时间",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "delTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "操作栏",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    events: "actionEvents", //指定单元格内事件处理的对象名称 必须保存
                    formatter(value, row, index) {   //用于格式化显示内容

                        return [
                            '<a class="text-info edit"><i class="fa fa-edit"></i></a>',
                            '<a class="text-danger delete"><i class="fa fa-trash"></i></a>'
                        ].join("<span class='mr-2'></span>");
                    }
                }],  //是一个数组，用于定义列的名称，列的显示方式，列的显示字段
            });
            //设置筛选监听
            $("#toolbar").on("click", "button", function (e) {
                //需要用到this对象所以不用箭头函数
                //console.log(this,e.target,e.currentTarget);
                const target = $(this); //获取被点击对象
                if (target.hasClass("add-item")) {
                    //新增新内容
                    $.peanutPage.modal({
                        title: "新增角色信息",
                        url: "master/userRouterEdit.do"
                    });
                } else if (target.hasClass("del-checked")) {
                    //删除所选项
                    $.peanutPage.delElement({
                        title: "删除警告",
                        text: "是否确认删除当前选中的角色",
                        url: "master/delUserRouter.do",
                        table: "#bootstrapTable"
                    });
                }
            });
            $("#toolbar select").change(() => {
                table.bootstrapTable("refresh");
            });
        });
        //设置表格内按钮的点击事件
        window.actionEvents = {
            "click .edit": function (e, value, row, index) {
                //修改栏目操作
                $.peanutPage.modal({
                    title: "修改角色信息",
                    url: "master/userRouterEdit.do?id=" + row.id
                });
            },
            "click .delete": function (e, value, row, index) {
                //删除当前栏目操作
                $.peanutPage.delElement({
                    title: "删除警告",
                    text: "是否确认删除当前角色：" + row["routerName"] + "?",
                    url: "master/delUserRouter.do",
                    data: {
                        idList: [row.id]
                    },
                    table: "#bootstrapTable"
                }); //删除结束
            }
        }; //优先于bootstrapTable初始化前定义执行
    })(jQuery);
</script>
</body>
</html>
