<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/head.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/head.js"></script>
<title></title>
</head>
<body>
	<div id="header">
        <ul id="nav">
            <li>
                <img src="uploadPic/image/logo.png" alt="">
            </li>
            <li><a href="./index.jsp">首页</a></li>
            <li>
                <p id="goto1">爱国主义教育示范基地的意义</p>
            </li>
            <li>
                <p id="goto2">全国爱国主义教育示范基地</p>
            </li>
            <li>
                <p id="goto3">新时代好少年 • 红心向党</p>
            </li>
            <li><c:if test="${user == null }">
   					<a href="./login.jsp">登录</a>
				</c:if>
				<c:if test="${user != null }">
   					<a id="user" href="./self.jsp">${user.uname }</a>
				</c:if>
            </li>
            
        </ul>
    </div>
</body>
</html>