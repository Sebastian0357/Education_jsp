<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/login.css">
	<script src="js/jquery.min.js"></script>     
    <script src="js/login.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

    <main>
        <div class="login-form">
            <h1><c:if test="${title == null }">
            		用户登录
            	</c:if>
            	<c:if test="${title != null }">
            		${title }
            	</c:if>
            </h1>
            <form action="LoginServlet" method="post" id="form_one">
                <div>
                	<input type="hidden" name="flag" <c:if test="${title != null }">value="2"</c:if>>
                    <label for="username">用户名：</label>
                    <input type="text" id="username" name="username" required>

                </div>
                <div>
                    <label for="password">密码：</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div>
                    <input type="submit" id="sub" value="登录"></input>
                </div>
            </form>
            <span id="checkPhone" style="color: red">${NameError }</span><br>
            <span id="checkPass" style="color: red">${PwdError }</span>
            
            <p>
            	<c:if test="${title == null }">
            		<p>还没有账号？<a href="register.jsp">点击注册</a></p>
            		<a href="LoginServlet?flag=1">管理员登录</a>
            	</c:if>
            	<c:if test="${title != null }">
            		<a href="login.jsp">用户登录</a>
            	</c:if>
            </p>
        </div>
    </main>
</body>
</html>