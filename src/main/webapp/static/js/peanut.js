'use strict';
(($, window, document, undefined) => {
    const $body = $("body"); // 定义常量 body的jquery筛选对象， 避免频繁使用 $("..")去查找对象
    // 设置ajax的默认值
    $.ajaxSetup({
        type: "post",
        dataType: "json",
        async: true,
        cache: false,
        contentType: "application/json;charset=utf-8",
        error() {
            toastr.error("由于未知原因失败，请稍后重试", "请求失败");
        }
    });
    // 初始化bootstrapTable
    $.extend($.fn.bootstrapTable.defaults, {
        toolbar: "#toolbar", // 指定自定义工具栏所在dom的筛选
        buttonsClass: "secondary",// 指定表格内按钮的默认样式 btn-default,info,success,warning,danger,secondary
        search: true, // 开启搜索框
        searchOnEnterKey: true, // 当在搜索框输入内容后，按回车键进行搜索
        pagination: true, // 开启数据分页模式
        sidePagination: "server", // client:在客户端进行分页
                                  // server: 在服务器端实现分页
        pageNumber: 1, // 默认加载的页面是第一页
        pageSize: 10, // 默认每一页加载的数据条数
        pageList: [10, 20, 50, 100, 200], // 用于切换每一页可加载的数据条数的待选项
        sortName: "addTime", // 默认参与排序的字段
        sortOrder: "DESC", // 默认排序方式
        showColumns: true, // 显示工具按钮：用于控制正在显示的列，可以隐藏或显示某些列
        showRefresh: true, // 显示刷新表格数据按钮
        striped: true, // 数据隔行显示不同的背景色
        cache: false,// 关闭ajax的请求缓存
        method: "post", // ajax请求获取数据的请求方法
        contentType: "application/json;charset=utf-8",
        uniqueId: "id", // 从服务器获取数据用于区分不同数据的关键字段--主键
    });
    // 拓展jQuery的方法
    $.extend({
        peanutPage: {
            publishElement(userConfig) {
                this.delElement($.extend({
                    title: "发布确认",
                    text: "即将发布页面的HTML文件，新的文件会覆盖旧文件，是否确认发布",
                    noSelectTitle: "发布失败",
                    noSelectText: "请优先选择你想发布的数据",
                    successText: "页面发布成功",
                    confirmButtonText: "确认发布",
                    cancelButtonText: "取消发布",
                }, userConfig));
            },
            delElement(options) {
                const config = $.extend({
                    url: "",
                    data: {idList: false},
                    title: "删除警告",
                    text: "即将删除选中数据，是否确认是否删除",
                    noSelectTitle: "删除失败",
                    noSelectText: "请优先选择你想删除的数据",
                    successText: "数据删除成功",
                    confirmButtonText: "确认删除",
                    cancelButtonText: "取消",
                    table: "#bootstrapTable"
                }, options);
                // 判断是否是删除表格数据
                const $table = $(config.table);
                if (typeof config.data == "object" && config.data.idList === false) {
                    // 删除所选项
                    const idList = [];
                    $.each($table.bootstrapTable("getSelections"), (k, v) => {
                        idList.push(v.id);
                    });
                    if (idList.length === 0) {
                        new swal({
                            icon: 'warning',
                            title: config.noSelectTitle,
                            text: config.noSelectText
                        });
                        return;
                    }
                    config.data.idList = idList;
                }
                // 开始删除流程的编写
                new swal({
                    icon: "warning",
                    title: config.title,
                    text: config.text,
                    showCancelButton: true,
                    confirmButtonText: config.confirmButtonText,
                    cancelButtonText: config.cancelButtonText
                }).then((value) => {
                    if (value.isConfirmed) {
                        // 表示确认删除数据，开始执行删除请求
                        $.ajax({
                            url: config.url,
                            data: JSON.stringify(config.data),
                            success(res) {
                                if (res.code === 0) {
                                    toastr.success(config.successText);
                                    // 刷新表格数据
                                    $(config.table).bootstrapTable("refresh");
                                } else {
                                    toastr.error(res.msg, res.title);
                                }
                            }
                        })
                    }
                });
            },
            modal(options) { // 使用模态框打开指定修改或新增页面
                const config = $.extend({
                    id: new Date().getTime(),
                    url: "", // 需要加载的页面路径
                    size: "",
                    title: "新增|修改信息",
                    table: "#bootstrapTable",
                    callback($form) {
                        // 需要根据返回值的TRUE FALSE 来决定是否关闭弹出窗口 => ajax请求不能使用异步，而是改为同步请求
                        let resultCode = false;
                        $.ajax({
                            url: $form.attr("action"),
                            data: JSON.stringify($form.serializeJSON()),
                            async: false,
                            success(res) {
                                resultCode = res.code === 0;
                                if (resultCode) {
                                    toastr.success("操作成功");
                                    // 刷新表格数据
                                    if (typeof config.table == "string") {
                                        $(config.table).bootstrapTable("refresh");
                                    }
                                    if (typeof config.success == "function") {
                                        config.success(res);
                                    }
                                } else {
                                    toastr.error(res.msg, res.title);
                                }
                            }
                        });
                        return resultCode;
                    }
                }, options);
                const _html = [
                    '<div id="modal_', config.id, '" class="modal" tabindex="-1">',
                    '<div class="modal-dialog ', config.size, '">',
                    '<div class="modal-content">',
                    '<div class="modal-header">',
                    '<h3 class="modal-title">', config.title, '</h3>',
                    '<button type="button" class="close" data-dismiss="modal">&times;</button>',
                    '</div>',
                    '<iframe src="', config.url, '" frameborder="0" class="modal-body"></iframe>',
                    '<div class="modal-footer">',
                    '<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>',
                    '<button type="submit" class="btn btn-info">提交</button>',
                    '</div> </div> </div> </div>'
                ].join("");
                // 将页面加载到body内
                $body.append(_html);
                // 获取iframe筛选器和modal筛选器
                const $modal = $("#modal_" + config.id);
                const $iframe = $modal.find("iframe");
                // 监听iframe的加载成功的事件
                $iframe.on("load", () => {
                    // 显示模态框
                    $modal.modal("show");
                    // 表示iframe内容已经加载成功
                    $iframe.height($iframe[0].contentWindow.document.body.offsetHeight + 8);
                    // 监听窗口大小发生改变,重写绘制iframe页面高度
                    $iframe[0].contentWindow.onresize = function () {
                        $iframe.height($iframe[0].contentWindow.document.body.offsetHeight + 8);
                    }
                    // 监听模态框的关闭事件，如果关闭了直接销毁模态框
                    $modal.one("hidden.bs.modal", () => {
                        $modal.remove();
                    });
                    // 监听提交按钮的点击事件
                    $modal.on("click", "button[type='submit']", () => {
                        if (config.callback($($iframe[0].contentWindow.document).find("form"))) {
                            $modal.modal("hide");
                        }
                    });
                });
            }
        }
    });
    //拓展jQuery Dom 的调用方法
    $.fn.extend({
        //自动调整textarea尺寸
        peanutTextAreaAutoHeight: function () {
            $(this).each(function (k, v) {
                //处理textArea高度
                const $textArea = $(v);
                //阻止其自动改变高度
                $textArea.css({
                    "resize": "none",
                    "overflow-x": "auto",
                    "overflow-y": "hidden",
                });
                $textArea.attr("data-init-height", $textArea.outerHeight());
                $textArea.attr("data-scroll-height", $textArea[0].scrollHeight);
                //监听textarea内容的输入
                $textArea.on("input propertychange", (e) => {
                    const initHeight = parseInt($textArea.attr("data-init-height"));
                    const scrollHeight = parseInt($textArea.attr("data-scroll-height"));
                    $textArea.css("height", initHeight).height($textArea[0].scrollHeight + scrollHeight - initHeight);
                    $(window).trigger("resize");
                });
            });
        },
        peanutUploadFile: function (options) {
            //初始化配置属性
            const config = $.extend({
                id: new Date().getTime(),
                url: "master/uploadFile.do",
                accept: ".jpg,.png,.jpeg",
                fileName: "files",
                data: {},//需要放置在form表单中随文件一起传递给服务器的数据
                timeout: 6000,
            }, options);
            //重写拼接出两个独立id
            config.formId = "peanutUploadForm_" + config.id;
            config.inputId = "peanutUploadFile_" + config.id;

            function createFrom() {
                //创建form表单
                const _form = `
               <form id="${config.formId}" action="${config.url}" method="post" enctype="multipart/form-data" class="d-none">
               <input id="${config.inputId}" type="file" accept="${config.accept}" name="${config.fileName}">
               </form>
               `;
                //通过html文本创建对象
                const $form = $(_form);
                //添加额外参数
                $.each(config.data, (key, value) => {
                    $form.append(`<input name="${key}" value="${value}">`);
                });
                //将form表单添加在页面上
                $body.append($form);
                //返回form对象
                return $form;
            }

            //获取表单以及表单内选择文件的input标签
            const $form = createFrom();
            const $input = $form.find("#" + config.inputId);
            //获取调用当前上传的组件
            const target = $(this);
            //监听组件的点击时间
            target.on("click", (e) => {
                $input.trigger("click");
            });
            //监听file input 框选取文件的事件
            $input.on("change", (e) => {
                //获取拿到的文件内容
                const val = $input.val();
                if (!val) return;//没有选取任何文件，直接返回
                //TODO defence double click
                target.off("click");
                //实现文件的上传
                $.ajax({
                    url: config.url,
                    data: new FormData($form[0]),
                    processData: false,
                    contentType: false,
                    cache: false,
                    timeout: config.timeout,
                    success(res) {
                        if (res.code === 0) {
                            toastr.success("文件上传成功");
                            if (typeof config.success == "function") {
                                config.success(res.url);
                            }
                        } else {
                            toastr.error(res.msg, res.title);
                        }
                    },
                    error() {
                        toastr.error("由于特殊异常导致文件上传失败，请查看文件大小是否超出限制或者文件类型是否正确");
                    },
                    complete() {
                        $input.val("");//避免无法上传同一文件
                        //重新监听
                        target.on("click", (e) => {
                            $input.trigger("click");
                        });
                    }
                });
            });
            //返回form标签
            return $form;
        }
    });
})(jQuery, window, document);