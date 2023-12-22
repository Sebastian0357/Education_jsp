<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/self.css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div id="big">
        <div id="tou">
            <img alt="" src="../image/${user.picture }" id="touxiang">

        </div>

        <div id="main">
            <h1 id="hh1">个人信息</h1>
            <form action="updateInfoServlet" method="post">
                <div>
                    <label>用户名:${user.uname }</label>
                </div>
                <div>
                    <label>性别:</label><input name="gender" value="${user.gender }">
                </div>
                <div>
                    <label>邮箱:</label><input name="email" type="email" value="${user.email }">
                </div>
                <div>
                    <label>简介:</label><br><textarea cols="30" rows="4" name="introduce">${user.introduce }</textarea>
                </div>
                <div>
                    <label>生日:</label><br><input type="date" name="birthday" value="${user.birthday }">
                </div>
                <div>
                    <label>组织:</label><input type="text" name="organization" value="${user.organization }">
                </div>
                <div>
                    <label>电话:</label><input type="tel" name="phone" value="${user.phone }">
                </div>
                <div>
                    <button type="submit">更新信息</button>
                </div>
                <div>
                    <a href="exitUserServlet">退出系统</a>
                </div>
            </form>

        </div>
    </div>

</body>
</html>