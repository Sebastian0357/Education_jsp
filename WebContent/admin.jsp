<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/admin.css" charset="UTF-8"/>

</head>
<body>

<div id="top">	
</div>

<div id="left">
<div id="bottom">
	欢迎
	<font color="black">${user.uname}</font>
	登录
</div>
		<dl>
			<dt onClick='showHide("items1_1")'>
				<b>城市信息管理</b>
			</dt>
			<dd style='display: block' id='items1_1'>
				<table>
					<tr>
						<td><a href="addCity.jsp" target="rightContent"
							style="text-decoration: none">添加城市</a>
						</td>
					</tr>
					<tr>
						<td><a href="updateIndexInfoServlet" target="rightContent"
							style="text-decoration: none">查询城市</a>
						</td>
					</tr>
				</table>
			</dd>
		</dl>
		<dl>
			<dt onClick='showHide("items1_2")'>
				<b>用户信息管理</b>
			</dt>
			<dd style='display: block' id='items1_2'>
				<table>
					<tr>
						<td><a href="updatePwd.jsp" 
							style="text-decoration: none" target="rightContent">修改用户信息</a>
						</td>
					</tr>
										
					<tr>
						<td><a href="exitUserServlet" 
							style="text-decoration: none">安全退出</a>
						</td>
					</tr>
				</table>
			</dd>
		</dl>
		
	</div>

<div id="right">
	<iframe name="rightContent" src="updateIndexInfoServlet" id="rightContent" frameborder="0">	
	</iframe>
</div>



</body>
</html>