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
                <h3 class="card-title">独立页面</h3>
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
                    <button class="btn btn-info publish-checked mr-2">发布选中</button>
                    <button class="btn btn-dark publish-all mr-2">发布所有</button>
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
                url: "master/contentPageData.do", // 获取数据的ajax请求接口
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
                    field: "pageName", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "名称",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pageThumb", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "缩略图",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                    formatter(value, row, index) {
                        if (value) {
                            return `<img style="max-height: 80px;max-width: 80px;" src="${"${value}"}">`;
                        }
                    }
                }, {   //代表一列的数据
                    field: "pageAuthor", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "作者",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pageFlag", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "标签",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pageTitle", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "SEO标题",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pageKeywords", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "SEO关键字",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式
                }, {   //代表一列的数据
                    field: "pageDescription", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "SEO描述信息",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pageClick", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "浏览次数",//当前列的标题名称
                    align: "center", //left center  right 单元格文字的对齐方式

                }, {   //代表一列的数据
                    field: "pageTime", // 数据对象的属性名称，当前列展示当前属性的值
                    title: "发布时间",//当前列的标题名称
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
                            '<a role="button" target="_blank" href="master/preview/pageDetail.do?id=' + row.id + '" class="text-danger" title="预览页面"><i class="fa fa-eye"></i></a>',
                            '<a role="button" class="text-danger delete" title="删除当前所选项"><i class="fa fa-trash"></i></a>',
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
                        title: "新增单页面信息",
                        url: "master/contentPageEdit.do",
                        callback($form) {
                            // 需要根据返回值的TRUE FALSE 来决定是否关闭弹出窗口 => ajax请求不能使用异步，而是改为同步请求
                            let resultCode = false;
                            const resData = $form.serializeJSON();
                            if (resData.pageFlag) {
                                resData.pageFlag = resData.pageFlag.join(",");
                            } else {
                                resData.pageFlag = "";
                            }
                            $.ajax({
                                url: $form.attr("action"),
                                data: JSON.stringify(resData),
                                async: false,
                                success(res) {
                                    resultCode = res.code === 0;
                                    if (resultCode) {
                                        toastr.success("操作成功");
                                        // 刷新表格数据
                                        table.bootstrapTable("refresh");
                                        if (res.url) {
                                            $.peanutPage.modal({
                                                title: res.title,
                                                url: res.url,
                                                size: "modal-xl"
                                            });
                                        }
                                    } else {
                                        toastr.error(res.msg, res.title);
                                    }
                                }
                            });
                            return resultCode;
                        }
                    });
                } else if (target.hasClass("del-checked")) {
                    //删除所选项
                    $.peanutPage.delElement({
                        title: "删除警告",
                        text: "是否确认删除当前选中的单页面",
                        url: "master/delContentPage.do",
                        table: "#bootstrapTable"
                    });//发布选中的单页面
                } else if (target.hasClass("publish-checked")) {
                    $.peanutPage.publishElement({
                        url: "master/html/publish.do",
                        data: {
                            idList: false,
                            type: "page",
                            category: "multiple"
                        }
                    });
                    //发布所有页面
                } else if (target.hasClass("publish-all")) {
                    $.peanutPage.publishElement({
                        url: "master/html/publish.do",
                        data: {
                            type: "page",
                            category: "all"
                        }
                    });
                }
            });
            $("#toolbar select").change(() => {
                table.bootstrapTable("refresh");
            });
        });
        //设置表格内按钮的点击事件
        window.actionEvents = {
            "click .detail": function (e, value, row, index) {
                $.peanutPage.modal({
                    title: `${"${row.pageName}"}:详情编辑`,
                    url: "master/contentPageDetail.do?id=" + row.id,
                    size: "modal-xl"
                });
            },
            "click .publish": function (e, value, row, index) {
                $.peanutPage.publishElement({
                    url: "master/html/publish.do",
                    data: {
                        idList: [row.id],
                        type: "page",
                        category: "single"
                    }
                });
            },
            "click .edit": function (e, value, row, index) {
                //修改栏目操作
                $.peanutPage.modal({
                    title: "修改单页面信息",
                    url: "master/contentPageEdit.do?id=" + row.id,
                    callback($form) {
                        // 需要根据返回值的TRUE FALSE 来决定是否关闭弹出窗口 => ajax请求不能使用异步，而是改为同步请求
                        let resultCode = false;
                        const resData = $form.serializeJSON();
                        if (resData.pageFlag) {
                            resData.pageFlag = resData.pageFlag.join(",");
                        } else {
                            resData.pageFlag = "";
                        }
                        $.ajax({
                            url: $form.attr("action"),
                            data: JSON.stringify(resData),
                            async: false,
                            success(res) {
                                resultCode = res.code === 0;
                                if (resultCode) {
                                    toastr.success("操作成功");
                                    // 刷新表格数据
                                    table.bootstrapTable("refresh");
                                    if (res.url) {
                                        $.peanutPage.modal({
                                            title: res.title,
                                            url: res.url,
                                            size: "modal-xl"
                                        });
                                    }
                                } else {
                                    toastr.error(res.msg, res.title);
                                }
                            }
                        });
                        return resultCode;
                    }
                });
            },
            "click .delete": function (e, value, row, index) {
                //删除当前栏目操作
                $.peanutPage.delElement({
                    title: "删除警告",
                    text: "是否确认删除当前单页面：" + row["pageName"] + "?",
                    url: "master/delContentPage.do",
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
