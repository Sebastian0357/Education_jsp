<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.MyUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateCityInfoServlet" method="post" 
      name="updateFriendForm" enctype="multipart/form-data">
	<table>
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
			<td class="td_right">
				<%-- 文件上传时，type="file" --%>
				<div class="fileinput">
					<%-- 文件上传时，type="file" --%>
					选择文件上传
					<input type="file" name="picture">
				</div>
			</td>		
		</tr>
		<tr>
			<td class="td_left">示范基地</td>
			<td class="td_right">
				<input type="text" name="base" 
				value="${city.base}" class="txtStyle">
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