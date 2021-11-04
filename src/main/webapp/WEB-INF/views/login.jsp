<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<!--导入自定义css样式表 -->
<link rel="stylesheet" href="static/css/login.css">
</head>
<body class="bg-light">
<div class="container text-dark">
    <section class="card shadow float-right border-0">
        <form action="/master/loginDeal.do"  method="post" class="card-body"> <!-- div改为form（）提交表单-->
            <h3 class="text-center mb-3">TD-CMS-0103</h3>
            <div class="input-group mb-2">
        <span class="input-group-prepend">
            <i class="fa fa-user"></i>
             </span>
                <input class="form-control" type="text" name="tdUsername" placeholder="请输入用户名">
            </div>
            <div class="input-group mb-2">
        <span class="input-group-prepend">
            <i class="fa fa-key"></i>
             </span>
                <input class="form-control" type="password" name="tdPassword" placeholder="请输入登录密码">
            </div>
            <div class="input-group mb-2">
        <span class="input-group-prepend">
            <i class="fa fa-keyboard"></i>
             </span>
                <input class="form-control" type="text" name="tdCode" placeholder="请输入右侧验证码" value="${code}">
                <span class="input-group-append">
                            <span class="input-group-text">${code}</span>
                        </span>
            </div>
            <input type="hidden" name="token" value="${token}">
            <button type="submit" class="btn btn-info w-100">登 录</button>
        </form>
    </section>
</div>

<%@ include file="../layout/footer.jsp" %>

<script>
    (($) => {
        $(() => {
            //1:获取表单对象
            const _form = $("form"); //const定义的是常量
            //2:监听表单的提交事件
            _form.on("submit",() => {
                try {
                    //获取表单数据
                    const formData ={
                        tdUsername:_form.find("input[name='tdUsername']").val(),
                        tdPassword:_form.find("input[name='tdPassword']").val(),
                        tdCode:_form.find("input[name='tdCode']").val(),
                        token:_form.find("input[name='token']").val()
                    };
                    if (formData.tdUsername.length<3) {
                        new swal({
                            icon:"warning",
                            title:"提示",
                            text:"账号长度大于3"
                        });
                        return false;
                    }
                    if (formData.tdPassword.length<6) {
                        new swal({
                            icon:"warning",
                            title:"提示",
                            text:"登录密码长度大于6"
                        });
                        return false;
                    }
                    if (formData.tdCode.length!==6) {
                        new swal({
                            icon:"warning",
                            title:"提示",
                            text:"验证码是6位"
                        });
                        return false;
                    }
                    //通过ajax提交数据给接口
                    $.ajax({
                        url:_form.attr("action"),
                        data:JSON.stringify(formData),  //contentType为application/json时，请求数据也必须是json字符串
                        success(res){
                            if (res.code === 0) {
                                _form.find("bottom").hide();
                                toastr.success(res.msg,res.title);
                                setTimeout(()=>{
                                    window.location.href=res.url;
                                    return;
                                },1000);
                            }else{
                                toastr.warning(res.msg,res.title);
                            }
                        },
                    });
                }catch (e) {
                    console.error(e);
                }
                //3:阻止表单的默认提交行为
                return false;
            })
        })
    })(jQuery);
</script>
</body>
</html>
