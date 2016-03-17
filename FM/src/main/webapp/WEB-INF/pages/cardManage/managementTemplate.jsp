<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2016/3/9
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta name="description" content="">
  <meta name="author" content="">

  <title><%=titleName%></title>
  <LINK REL="SHORTCUT ICON" HREF="<%=request.getContextPath()%>/image/logo.jpg">

  <!-- Bootstrap core CSS -->
  <link href="<%=request.getContextPath()%>/css/vendor/bootstrap.min.css" rel="stylesheet">

  <!-- APP CSS -->
  <link href="<%=request.getContextPath()%>/css/app/dashboard.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/app/nav.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top main-navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">软件学院财务管理系统</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right menu">
        <li><a >登录用户：${sessionScope.session_user}</a></li>
        <li><a href="<%=request.getContextPath()%>/logout">退出</a></li>
        <li><a href="#">帮助</a></li>
      </ul>
      <!--<form class="navbar-form navbar-right">-->
      <!--<input type="text" class="form-control" placeholder="Search<%=request.getContextPath()%>.">-->
      <!--</form>-->
    </div>
  </div>
</nav>

<div class="container-fluid " id="content">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active">
          <a>银行卡管理</a>
        </li>
        <li>
          <div>
            <ul class="nav nav-sidebar">
              <li><a href="<%=request.getContextPath()%>/cards/"><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;列表</p></a></li>
              <li><a href="<%=request.getContextPath()%>/cards/new"><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加</p></a></li>
            </ul>
          </div>
        </li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

      <!--<h2 class="sub-header">Section title</h2>-->
      <div class="table-responsive">
        <div class="content">
          <jsp:include page="<%=bodyFile%>"/>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath()%>/js/vendor/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/vendor/bootstrap.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/vendor/cookie_util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vendor/md5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vendor/jquery_md5.js"></script>



<script>
  $(function(){
    $(".menu li").mouseover(function(e){
      e.preventDefault();
      $(this).tab("show");
      $(".menu li").eq($(this).index()).addClass("nav-current active").siblings().removeClass("nav-current active");
    });
    $(".menu li").mouseout(function(e){
      e.preventDefault();
      $(".menu li").eq($(this).index()).removeClass("nav-current active");
    });

  });
</script>
</body>
</html>