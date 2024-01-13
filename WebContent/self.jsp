<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.MyUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/self.css"/>
<title>用户个人信息</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div id="big">
        <div id="tou">
            <img alt="" src="uploadPic/${user.picture }" id="touxiang"><br>
        </div>
		
        <div id="main">
            <h1 id="hh1">个人信息</h1>
            <form action="updateInfoServlet" method="post" enctype="multipart/form-data">
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
                <div class="quit">
                    <a href="exitUserServlet">退出登录</a>
                </div>
                <div class="fileinput">
                	<input type="file" name="picture">
                </div>
                
            </form>

        </div>
    </div>

</body>
</html>