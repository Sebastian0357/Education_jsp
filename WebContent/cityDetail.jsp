<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.MyUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/citydetail.css"/>
</head>
<body>
<form action="updateCityInfoServlet" method="post" 
      name="updateFriendForm" enctype="multipart/form-data">
	<table class="detail">
		<tr>
			<td class="td_left">城市</td>
			<td class="td_right">
				<input type="text" name="name" value="${city.cityname}" 
						class="txtStyle">
			</td>		
		</tr>
		<tr>
			<td class="td_left">图片</td>
			<td class="img"><img src="${city.picture}" alt="无法加载图片"></td>		
		</tr>
		<tr>
			<td class="td_left">修改城市图片</td>
			<td class="td_right">
				<input type="file" name="picture">
			</td>
		</tr>
		<tr>
			<td class="td_left">示范基地<br>(空格分割)</td>
			<td class="td_right">
				<textarea cols="60" rows="5" name="base">${city.base}</textarea>
			</td>		
		</tr>
		<tr>
			<td class="td_left"></td>
			<td class="td_right">
				<%-- 调用JS脚本函数updateFriend，检查表单中朋友信息的数据格式 --%>
				<input type="button" value="提交" onclick="submit()" id=btn_sub>
			</td>
		</tr>
	</table>
</form>          
            
</body>
</html>