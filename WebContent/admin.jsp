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
		<dl>
			<dt onClick='showHide("items1_1")'>
				<b>朋友信息管理</b>
			</dt>
			<dd style='display: block' id='items1_1'>
				<table>
					<tr>
						<td><a href="addFriend.jsp" target="rightContent"
							style="text-decoration: none">添加朋友</a>
						</td>
					</tr>
					<tr>
						<td><a href="queryFriendServlet?flag=modify" target="rightContent"
							style="text-decoration: none">修改朋友</a>
						</td>
					</tr>
					<tr>
						<td><a href="queryFriendServlet?flag=delete" target="rightContent"
							style="text-decoration: none">删除朋友</a>
						</td>
					</tr>
					<tr>
						<td><a href="queryFriendServlet" target="rightContent"
							style="text-decoration: none">查询朋友</a>
						</td>
					</tr>
				</table>
			</dd>
		</dl>
		<dl>
			<dt onClick='showHide("items1_2")'>
				<b>个人信息管理</b>
			</dt>
			<dd style='display: block' id='items1_2'>
				<table>
					<tr>
						<td><a href="updatePwd.jsp" 
							style="text-decoration: none" target="rightContent">修改密码</a>
						</td>
					</tr>
										
					<tr>
						<td><a href="exitUserServlet" 
							style="text-decoration: none">退出系统</a>
						</td>
					</tr>
				</table>
			</dd>
		</dl>
		
		<dl>
			<dt onClick='showHide("items1_3")'>
				<b>其他信息管理</b>
			</dt>
			<dd style='display: block' id='items1_3'>
				<table>
					<tr>
						<td><a href="#" 
							style="text-decoration: none">XXXX</a>
						</td>
					</tr>
										
					<tr>
						<td><a href="#" 
							style="text-decoration: none">XXXX</a>
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

<div id="bottom">
	欢迎
	<font color="yellow">${user.uname}</font>
	登录
	<font color="blue">朋友信息管理系统</font>
</div>

</body>
</html>