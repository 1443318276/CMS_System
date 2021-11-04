<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
</head>
<body style="background-color: #e3e3e3;">
<div class="container-fluid mt-2">
    <div class="content">
        <div class="card">
            <section class="card-header">
                <h3 class="card-title">分类管理</h3>
                <span class="float-right">
                    <a class="refresh-page text-dark" href="javascript:window.location.reload();" title="刷新当前页面">
                        <i class="fa fa-sync"></i>
                    </a>
                </span>
            </section>
            <section class="card-body">
                <div id="toolbar" class="input-group">
                    <button class="btn btn-success add-item mr-2">新增分类</button>
                    <button class="btn btn-danger del-checked mr-2">删除选中</button>
                    <button class="btn btn-info publish-checked mr-2">发布选中</button>
                    <button class="btn btn-primary publish-all mr-2">发布所有</button>
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
                url: "master/contentTypeData.do", // 获取数据的ajax请求接口
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
                    formatter(value, row, index) {
                        const option = table.bootstrapTable("getOptions");
                        return index + 1 + (option.pageNumber - 1) * option.pageSize;
                    }

                }, {   //代表一列的数据
                    field: "level", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "分类层级",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pid", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "上级分类",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    formatter(value, row, index) {
                        function pName(parentType) {
                            if (parentType == null) return "";
                            return pName(parentType["parentType"]) + "_" + parentType["typeName"];
                        }

                        return pName(row["extra"]["parentType"]);
                    }

                }, {   //代表一列的数据
                    field: "typeName", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "分类名称",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                }, {   //代表一列的数据
                    field: "typeFolder", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "存放目录",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "typeTemplate", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "分类模板",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    formatter(value, row, index) {
                        return row["extra"]["typeTemplate"]["templateName"];
                    }

                }, {   //代表一列的数据
                    field: "contentTemplate", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "字文章模板",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    formatter(value, row, index) {
                        return row["extra"]["contentTemplate"]["templateName"];
                    }


                }, {   //代表一列的数据
                    field: "typeClick", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "访问次数",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "typeSort", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "排序字段",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "typeTitle", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "SEO标题",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                }, {   //代表一列的数据
                    field: "typeKeywords", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "SEO关键字",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                }, {   //代表一列的数据
                    field: "typeDescription", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "SEO描述信息",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "addTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "添加时间",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    visible: false
                }, {   //代表一列的数据
                    field: "updateTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "修改时间",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    visible: false
                }, {   //代表一列的数据
                    field: "delTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "操作栏",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    events: "actionEvents", //指定单元格内事件处理的对象名称 必须保存
                    formatter(value, row, index) {   //用于格式化显示内容
                        return [
                            '<a role="button" class="text-info edit" title="修改基础信息"><i class="fa fa-edit"></i></a>',
                            '<a role="button" class="text-success detail" title="修改详情"><i class="fa fa-copy"></i></a>',
                            '<a role="button" class="text-warning publish" title="发布HTML"><i class="fa fa-rocket"></i></a>',
                            '<a role="button" target="_blank" href="master/preview/typeDetail.do?id=' + row.id + '" class="text-danger" title="预览页面"><i class="fa fa-eye"></i></a>',
                            '<a role="button" class="text-danger delete" title="删除当前所选项"><i class="fa fa-trash"></i></a>',
                        ].join("<span class='mr-2'></span>");
                    }
                }],  //是一个数组，用于定义列的名称，列的显示方式，列的显示字段
                detailView: true, //启用子表
                onExpandRow(index, row, $detail) {
                    //查看是否存在表格
                    let subTable = $detail.find("table");
                    if (subTable.length > 0) {
                        subTable.bootstrapTable("refresh");
                        return;
                    }
                    //向新加的布局内添加表格
                    subTable = $('<table></table>');
                    $detail.html(subTable);
                    //获取父级表格的option 自定义子类
                    const subOptions = $.extend({}, table.bootstrapTable("getOptions"), {
                        toolbar: "", // 指定自定义工具栏所在dom的筛选
                        search: false, // 搜索框
                        pagination: false, // 数据分页模式
                        showColumns: false, // 工具按钮：用于控制正在显示的列，可以隐藏或显示某些列
                        showRefresh: false, // 刷新表格数据按钮
                        striped: true, // 数据隔行显示不同的背景色
                        queryParams(params) {
                            return JSON.stringify($.extend({}, params, {
                                extras: {
                                    pid: row.id
                                } // 附加的额外请求参数
                            }));
                        },
                    });
                    subOptions.columns[0][0]["checkbox"] = false;
                    //初始化表格
                    subTable.bootstrapTable(subOptions);
                }
            });
            //设置筛选监听
            $("#toolbar").on("click", "button", function (e) {
                //需要用到this对象所以不用箭头函数
                //console.log(this,e.target,e.currentTarget);
                const target = $(this); //获取被点击对象
                if (target.hasClass("add-item")) {
                    //新增新内容
                    $.peanutPage.modal({
                        table:"#bootstrapTable",
                        title: "新增分类信息",
                        url: "master/contentTypeEdit.do",
                        success(res){
                            $.peanutPage.modal({
                                title: res.title+`:详情编辑`,
                                url: res.url,
                                size: "modal-xl"
                            });
                        }
                    });
                } else if (target.hasClass("del-checked")) {
                    //删除所选项
                    $.peanutPage.delElement({
                        title: "删除警告",
                        text: "是否确认删除当前选中的分类",
                        url: "master/delContentType.do",
                        table: "#bootstrapTable"
                    });//发布选中的单页面
                } else if (target.hasClass("publish-checked")) {
                    $.peanutPage.publishElement({
                        url: "master/html/publish.do",
                        data: {
                            idList: false,
                            type: "contentType",
                            category: "multiple"
                        }
                    });
                    //发布所有页面
                } else if (target.hasClass("publish-all")) {
                    $.peanutPage.publishElement({
                        url: "master/html/publish.do",
                        data: {
                            type: "contentType",
                            category: "all"
                        }
                    });
                }
            });
        });
        //设置表格内按钮的点击事件
        window.actionEvents = {
            "click .detail": function (e, value, row, index) {
                $.peanutPage.modal({
                    title: `${"${row.typeName}"}:详情编辑`,
                    url: "master/contentTypeDetail.do?id=" + row.id,
                    size: "modal-xl"
                });
            },
            "click .publish": function (e, value, row, index) {
                $.peanutPage.publishElement({
                    url: "master/html/publish.do",
                    data: {
                        idList: [row.id],
                        type: "contentType",
                        category: "single"
                    }
                });
            },
            "click .edit": function (e, value, row, index) {
                //修改栏目操作
                $.peanutPage.modal({
                    table:"#bootstrapTable",
                    title: "修改分类信息",
                    url: "master/contentTypeEdit.do?id=" + row.id,
                    success(res){
                        $.peanutPage.modal({
                            title: res.title+`:详情编辑`,
                            url: res.url,
                            size: "modal-xl"
                        });
                    }
                });
            },
            "click .delete": function (e, value, row, index) {
                //删除当前栏目操作
                $.peanutPage.delElement({
                    title: "删除警告",
                    text: "是否确认删除当前分类：" + row["typeName"] + "?",
                    url: "master/delContentType.do",
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
