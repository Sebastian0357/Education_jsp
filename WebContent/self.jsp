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
            <img alt="" src="../image/touxiang.jpg" id="touxiang">

        </div>

        <div id="main">
            <h1 id="hh1">个人信息</h1>
            <form>
                <div>
                    <label>账号:<input type="text" value="wangyi123"></label>
                    <label>密码:<input type="password" value="123456"></label>
                </div>
                <div>
                    <label>性别:</label><input type="radio" name="gender">男
                    <input type="radio" name="gender">女
                    <input type="radio" checked="checked" name="gender">保密
                </div>
                <div>
                    <label>邮箱:</label><input type="email" value="12138@163.com">
                </div>
                <div>
                    <label>爱好:</label><input type="checkbox" name="aihao" checked=“checked”>足球
                    <input type="checkbox" name="aihao">篮球
                    <input type="checkbox" name="aihao">羽毛球
                    <input type="checkbox" name="aihao">唱歌
                    <input type="checkbox" name="aihao">跳舞
                </div>
                <div>
                    <label>简介:</label><br><textarea cols="30" rows="4">精于心、简于形、成于细节。</textarea>
                </div>
                <div>
                    <label>生日:</label><br><input type="date"  value="2003-05-07">
                </div>
                <div>
                    <label>组织:</label><input type="text" value="大连外国语大学">
                </div>
                <div>
                    <label>电话:</label><input type="tel" value="13694105330">
                </div>
                <div>
                    <button type="submit">更新信息</button>
                </div>
            </form>

        </div>
    </div>

</body>
</html>