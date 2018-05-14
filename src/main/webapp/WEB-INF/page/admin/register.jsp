<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>注册 - GengRen</title>
  <!--${pageContext.request.contextPath}/resources/js/page/-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin/login.css">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/image/admin/icon/icon.png">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/image/admin/icon/favicon.ico">
<script src="${pageContext.request.contextPath}/resources/js/admin/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
      $(document).ready(function(){
          //给账号文本框绑定失去焦点的事件
          $("#account").blur(function(){
              //alert("测试"+$(this).val());
              $.ajax({
                  url:"${pageContext.request.contextPath}/page/admin/exist",//设置服务器地址，即为servlet配置的url-pattern
                  type:"post",//提交的方式
                  data:{account:$(this).val()},//提交到服务器的数据，多个值以逗号分割开{account:$(this).val(),...}
                  success:function(data){//回调函数，data是返回的数据
                      $("#errorAccount").html(data);
                  }
              });
          });
      });

  </script>
<!--[if gte IE 9]>
  <script src="${pageContext.request.contextPath}/resources/js/admin/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/admin/html5shiv.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/admin/respond.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/admin/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select">
<div class="container">
  <div class="siteIcon"><img src="${pageContext.request.contextPath}/resources/image/admin/icon/icon.png" alt="" data-toggle="tooltip" data-placement="top" title="欢迎使用异清轩博客管理系统" draggable="false" /></div>
  <form action="${pageContext.request.contextPath}/page/admin/register" method="post" autocomplete="off" class="form-signin">
    <h2 class="form-signin-heading">用户注册:</h2>

    <label for="account" class="sr-only">用户名</label>
    <input type="text" id="account" name="account" class="form-control" placeholder="请输入用户名" required autofocus autocomplete="off" maxlength="10">
    <div id="errorAccount" style="color:red;display:inline;"></div>
    <label for="password" class="sr-only">密码</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" required autocomplete="off" maxlength="18">
    <label  class="sr-only">姓名</label>
    <input type="password" id="name" name="name" class="form-control" placeholder="请输入姓名" required autocomplete="off" maxlength="18">
    <a href="#"><button class="btn btn-lg btn-primary btn-block" type="submit" id="signinSubmit">注册</button></a>

  </form>
  <%--<div class="footer">--%>
    <%--<p><a href="/Home/index.html" data-toggle="tooltip" data-placement="left" title="不知道自己在哪?">回到异清轩博客 →</a></p>--%>
  <%--</div>--%>
</div>
<script src="${pageContext.request.contextPath}/resources/js/admin/js/bootstrap.min.js"></script>
<script>
$('[data-toggle="tooltip"]').tooltip();
window.oncontextmenu = function(){
	//return false;
};
$('.siteIcon img').click(function(){
	window.location.reload();
});
$('#signinSubmit').click(function(){
	if($('#userName').val() === ''){
		$(this).text('用户名不能为空');
	}else if($('#userPwd').val() === ''){
		$(this).text('密码不能为空');
	}else{
		$(this).text('请稍后...');
	}
});
</script>
</body>
</html>
