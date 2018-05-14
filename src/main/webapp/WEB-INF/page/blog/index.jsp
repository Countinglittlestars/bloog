<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>异清轩博客</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/page/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/page/nprogress.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/page/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/page/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/image/page/icon/icon.png">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/image/page/icon/favicon.ico">
<script src="${pageContext.request.contextPath}/resources/js/page/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/page/nprogress.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/page/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
  <script src="${pageContext.request.contextPath}/resources/js/page/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/page/html5shiv.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/page/respond.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/page/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select">
<header class="header">
  <nav class="navbar navbar-default" id="navbar">
    <div class="container">
      <div class="header-topbar hidden-xs link-border">
        <ul class="site-nav topmenu">
          <li><a href="#">标签云</a></li>
          <li><a href="#" rel="nofollow">读者墙</a></li>
          <li><a href="#" rel="nofollow">友情链接</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" rel="nofollow">关注本站 <span class="caret"></span></a>
            <ul class="dropdown-menu header-topbar-dropdown-menu">
              <li><a data-toggle="modal" data-target="#WeChat" rel="nofollow"><i class="fa fa-weixin"></i> 微信</a></li>
              <li><a href="#" rel="nofollow"><i class="fa fa-weibo"></i> 微博</a></li>
              <li><a data-toggle="modal" data-target="#areDeveloping" rel="nofollow"><i class="fa fa-rss"></i> RSS</a></li>
            </ul>
          </li>
        </ul>


        <%--<a href="" rel="nofollow">找回密码</a>--%>
        <c:choose>
          <c:when test="${sessionScope.loginAdmin== null}">
            <!-- 顶部未登录 -->
            <a href="${pageContext.request.contextPath}/page/admin/loginUI" class="login" rel="nofollow">Hi,请登录</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/page/admin/registerUI" class="register" rel="nofollow">我要注册</a>&nbsp;&nbsp;

          </c:when>
          <c:otherwise>
            <!-- 顶部已登录 -->
            欢迎你！，<a href="#" target="_blank" class="login"><strong>${sessionScope.loginAdmin.name}</strong></a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/page/admin/logout" class="register">退出</a>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <h1 class="logo hvr-bounce-in"><a href="" title=""><img src="${pageContext.request.contextPath}/resources/image/page/logo.png" alt=""></a></h1>
      </div>
      <div class="collapse navbar-collapse" id="header-navbar">
        <ul class="nav navbar-nav navbar-right">

          <li><a href="${pageContext.request.contextPath}/page/blog/pageSelect">首页</a></li>
          <li><a href="#">精选文章</a></li>
          <li><a href="#">读书</a></li>
          <li><a href="#">胡言乱语</a></li>
          <li><a href="#">留言本</a></li>
        </ul>
        <form class="navbar-form visible-xs" action="/Search" method="post">
          <div class="input-group">
            <input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20" autocomplete="off">
            <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
        </form>
      </div>
    </div>
  </nav>
</header>
<section class="container">
  <div class="content-wrap">
    <div class="content">
      <div class="jumbotron">
        <h1>欢迎访问异清轩博客</h1>
        <p>在这里可以看到前端技术，后端程序，网站内容管理系统等文章，还有我的程序人生！</p>
      </div>
      <div id="focusslide" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#focusslide" data-slide-to="0" class="active"></li>
          <li data-target="#focusslide" data-slide-to="1"></li>
          <li data-target="#focusslide" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active"> <a href="" target="_blank"><img src="${pageContext.request.contextPath}/resources/image/page/banner/banner_01.jpg" alt="" class="img-responsive"></a>
            <!--<div class="carousel-caption"> </div>--> 
          </div>
          <div class="item"> <a href="" target="_blank"><img src="${pageContext.request.contextPath}/resources/image/page/banner/banner_02.jpg" alt="" class="img-responsive"></a>
            <!--<div class="carousel-caption"> </div>--> 
          </div>
          <div class="item"> <a href="" target="_blank"><img src="${pageContext.request.contextPath}/resources/image/page/banner/banner_03.jpg" alt="" class="img-responsive"></a>
            <!--<div class="carousel-caption"> </div>--> 
          </div>
        </div>
        <a class="left carousel-control" href="#focusslide" role="button" data-slide="prev" rel="nofollow"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">上一个</span> </a> <a class="right carousel-control" href="#focusslide" role="button" data-slide="next" rel="nofollow"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">下一个</span> </a> </div>

        <div class="title">
          <h3>最新发布</h3>
          <div class="more">
            <a href="${pageContext.request.contextPath}/page/blog/pageSelect?">首页</a>
            <a href="${pageContext.request.contextPath}/page/blog/pageSelect?sign=JAVA">JAVA</a>
            <a href="${pageContext.request.contextPath}/page/blog/pageSelect?sign=JVM">JVM</a>
            <a href="${pageContext.request.contextPath}/page/blog/pageSelect?sign=Mysql">Mysql</a>
            <a href="${pageContext.request.contextPath}/page/blog/pageSelect?sign=ssm">ssm</a>
          </div>
        </div>
      <c:forEach items="${blogList}" var="blog">
        <article class="excerpt excerpt-1">
          <a class="focus" href="${pageContext.request.contextPath}/page/blog/detail?blogId=${blog.blogId}" title=""></a>
          <header><a class="cat" href="${pageContext.request.contextPath}/page/blog/detail?blogId=${blog.blogId}">${blog.sign}<i></i></a>
            <h2><a href="${pageContext.request.contextPath}/page/blog/detail?blogId=${blog.blogId}" title="">${blog.title}</a></h2>
          </header>
          <p class="meta">
            <time class="time"><i class="glyphicon glyphicon-time"></i>
              发布时间：<fmt:formatDate value="${blog.releaseDate}" pattern="yyyy-mm-dd"/>
            </time>
            <span class="views"><i class="glyphicon glyphicon-eye-open"></i>阅读：${blog.clickHit}</span> <a class="comment" href="article.html#comment">
            <i class="glyphicon glyphicon-comment"></i> 评论：${blog.replyHit}</a></p>
          <p class="note">${blog.summary}<p>
        </article>
      </c:forEach>
    </div>
  </div>
  <aside class="sidebar">
    <div class="fixed">
      <div class="widget widget-tabs">
        <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#notice" aria-controls="notice" role="tab" data-toggle="tab">网站公告</a></li>
          <li role="presentation"><a href="#" aria-controls="centre" role="tab" data-toggle="tab">会员中心</a></li>
          <li role="presentation"><a href="#" aria-controls="contact" role="tab" data-toggle="tab">联系站长</a></li>
        </ul>
        <div class="tab-content">
          <div role="tabpanel" class="tab-pane notice active" id="notice">
            <ul>
              <li>
                <time datetime="2016-01-04">01-04</time>
                <a href="" target="_blank">欢迎访问GengRen博客</a></li>
              <li>
                <time datetime="2016-01-04">01-04</time>
                <a target="_blank" href="">enjoy programming,enjoy live</a></li>
              <li>
                <time datetime="2016-01-04">01-04</time>
                <a target="_blank" href=">学习使我快乐</a></li>
            </ul>
          </div>
          <%--<div role="tabpanel"  class="tab-pane centre" id="centre">--%>
            <%--<h4>需要登录才可以</h4>--%>
            <%--&lt;%&ndash;<p> <a data-toggle="modal" data-target="#loginModal" class="btn btn-primary">立即登录</a> <a href="javascript:;" class="btn btn-default">现在注册</a> </p>&ndash;%&gt;--%>
          <%--</div>--%>
          <div role="tabpanel" class="tab-pane contact" id="contact">
                <%--<h2>Email:<br/>--%>
                  <%--<a href="mailto:admin@ylsat.com" data-toggle="tooltip" data-placement="bottom" title="admin@ylsat.com">949105264@qq.com</a></h2>--%>
          </div>
        </div>
      </div>
      <div class="widget widget_search">
        <form class="navbar-form" action="/Search" method="post">
          <div class="input-group">
            <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
            <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
        </form>
      </div>
    </div>
    <%--<div class="widget widget_sentence">--%>
      <%--<h3>每日一句</h3>--%>
      <%--<div class="widget-sentence-content">--%>
        <%--<h4>2016年01月05日星期二</h4>--%>
        <%--<p>Do not let what you cannot do interfere with what you can do.<br />--%>
          <%--别让你不能做的事妨碍到你能做的事。（John Wooden）</p>--%>
      <%--</div>--%>
    <%--</div>--%>
    <div class="widget widget_hot">
      <h3>热门文章</h3>
      <ul>
        <c:forEach items="${blogClickList}" var="blog1">
          <li>
            <a href="${pageContext.request.contextPath}/page/blog/detail?id=${blog.blogId}">
              <span class="text">${blog1.title}</span>
              <span class="muted"><i class="glyphicon glyphicon-time"></i> ${blog1.releaseDate} </span>
              <span class="muted"><i class="glyphicon glyphicon-eye-open"></i> ${blog1.clickHit}</span>
            </a>
          </li>
        </c:forEach>
      </ul>
    </div>
  </aside>
</section>
<footer class="footer">
  <div class="container">
    <p>&copy; 2016 <a href="">ylsat.com</a> &nbsp; <a href="http://www.miitbeian.gov.cn/" target="_blank" rel="nofollow">豫ICP备20151109-1</a> &nbsp; <a href="sitemap.xml" target="_blank" class="sitemap">网站地图</a></p>
  </div>
  <div id="gotop"><a class="gotop"></a></div>
</footer>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="${pageContext.request.contextPath}/resources/image/page/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--该功能正在日以继夜的开发中-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="${pageContext.request.contextPath}/resources/image/page/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--登录注册模态框-->
<div class="modal fade user-select" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <form action="/Admin/Index/login" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="loginModalLabel">登录</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label for="loginModalUserNmae">用户名</label>
            <input type="text" class="form-control" id="loginModalUserNmae" placeholder="请输入用户名" autofocus maxlength="15" autocomplete="off" required>
          </div>
          <div class="form-group">
            <label for="loginModalUserPwd">密码</label>
            <input type="password" class="form-control" id="loginModalUserPwd" placeholder="请输入密码" maxlength="18" autocomplete="off" required>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">登录</button>
        </div>
      </form>
    </div>
  </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问异清轩博客</li>
    <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
    <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
    <li class="list-group-item"><span>系统：</span>Windows10 </li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div>
<script src="${pageContext.request.contextPath}/resources/js/page/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/page/jquery.ias.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/page/scripts.js"></script>
</body>
</html>