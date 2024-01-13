<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/admin.js"></script>
</head>
<body>
	<div>
		<table class="text" id="table1">
           
            <c:forEach items="${cList}" var="city" varStatus="cs">
            	<c:if test="${cs.index % 4 == 0}">
            		<tr>
            	</c:if>
            	<c:if test="${cs.index == 0}">
            		<td class="s1">
            	</c:if>
            	<c:if test="${cs.index != 0}">
            		<td>
            	</c:if>
            			<input type="hidden" value="${city.base}">
                        <div id="city"><img src="uploadPic/${city.picture}" alt="">
                            <p id="cname">${city.cityname}</p>
                        </div>
                    </td>
                 
			</c:forEach>
			
            </table>
            <table id="cityText" style="left:1em;">
            	
            </table>
            <form action="updateIndexInfoServlet?flag=detail" method="post" name="detailCityInfo">
            	<input type="hidden" name="cityname" id="cityname">
            </form>
	</div>
			
</body>
</html>