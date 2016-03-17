<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2016/3/8
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
     <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<h3>error!</h3>
<c:out value="${captchaError}"/>
<c:out value="${userInfoError}"/>
</body>
</html>
