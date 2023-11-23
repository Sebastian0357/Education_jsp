<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/login.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

    <main>
        <div class="login-form">
            <h1>用户注册</h1>
            <form action="../html/Index.html" method="post" id="form_one">
                <div>
                    <label for="username">用户名：</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div>
                    <label for="password">密码：</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div>
                    <label for="confirm_password">确认密码：</label>
                    <input type="password" id="confirm_password" name="confirm_password" required>
                </div>
                <div>
                    <input type="submit" id="submit" value="注册"></input>
                </div>
            </form>

            <span id="checkPhone" style="color: red"></span><br>
            <span id="checkPass" style="color: red"></span>
            <span id="checkConPass" style="color: red"></span>
            <p>已有有账号？<a href="login.jsp">点击登录</a></p>

        </div>
    </main>
</body>>
</html>