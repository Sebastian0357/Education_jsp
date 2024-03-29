<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/city.js"></script>
<title>主页</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div id="banner">
        <pre><img src="uploadPic/image/banner.jpg" alt="" id="img1"></pre>
        <div id="weather"></div>
    </div>
	
    <div id="main">
        <div id="main1">
            <div class="title" id="title1">
                <h2>爱国主义教育示范基地的意义</h2>
            </div>
            <pre class="text" id="text1">
        对于如何用好爱国主义教育基地等红色资源，习近平总书记作出一系列重要论述和重要指示，强调中国革命历史是最
好的教科书、清醒剂、营养剂。
        遍布全国的爱国主义教育示范基地，全方位、全景式地展示了中华民族悠久灿烂的历史文化，书写了中国人民英勇奋
斗的壮丽篇章，已日益成为传承红色基因，加强革命传统教育、爱国主义教育、青少年思想道德教育的重要场所，也成为
中国共产党人的精神殿堂、中国人民的精神家园、中华民族的精神高地。
            </pre>
        </div>
        <div id="main2">
            <div class="title" id="title2">
                <h2>全国爱国主义教育示范基地</h2>
            </div>
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
                            <p>${city.cityname}</p>
                        </div>
                    </td>
                 
			</c:forEach>

            </table>
            <table id="cityText">
            	
            </table>
        </div>
        <div id="main3">
            <div class="title" id="title3">
                <h2>新时代好少年 • 红心向党</h2>
            </div>
            <table class="text" id="table2">
                <tr>
                    <td><img src="uploadPic/image/hxxd.png" alt="">
                        <P class="p1">红心向党</P>
                        <P class="p2">贵州 贞丰县民族中学</P>
                    </td>
                    <td><img src="uploadPic/image/zgmwdm.png" alt="">
                        <P class="p1">中国梦我的梦</P>
                        <P class="p2">上海 洛川学校</P>
                    </td>
                    <td><img src="uploadPic/image/xsdhsn.png" alt="">
                        <P class="p1">红心向党做新时代好少年</P>
                        <P class="p2">辽宁 朝阳市光明小学</P>
                    </td>
                    <td><img src="uploadPic/image/lbt.png" alt="">
                        <P class="p1">小萝卜头</P>
                        <P class="p2">甘肃 庆阳市东方红小学</P>
                    </td>
                </tr>
                <tr>
                    <td><img src="uploadPic/image/wdhsxl.png" alt="">
                        <P class="p1">我的红色心路</P>
                        <P class="p2">湖南 长沙市天心区幼幼小学</P>
                    </td>
                    <td><img src="uploadPic/image/txxd.png" alt="">
                        <P class="p1">童心向党 梦想飞扬</P>
                        <P class="p2">河北 四公中心小学</P>
                    </td>
                    <td><img src="uploadPic/image/tmskzw.png" alt="">
                        <P class="p1">他们是刻在我生命力的红色</P>
                        <P class="p2">贵州 贞丰县民族中学</P>
                    </td>
                    <td><img src="uploadPic/image/wdhxczl.png" alt="">
                        <P class="p1">我的红色成长路</P>
                        <P class="p2">北京 平谷区第三小学</P>
                    </td>
                </tr>
                <tr>
                    <td><img src="uploadPic/image/qczx.jpg" alt="">
                        <P class="p1">清澈之心 礼赞百年</P>
                        <P class="p2">河北 南董镇南董小学</P>
                    </td>
                    <td><img src="uploadPic/image/dzg.jpg" alt="">
                        <P class="p1">读中国</P>
                        <P class="p2">海南 海南师范大学实验小学</P>
                    </td>
                    <td><img src="uploadPic/image/tfbzg.jpg" alt="">
                        <P class="p1">腾飞吧祖国</P>
                        <P class="p2">贵州 民族希望小学</P>
                    </td>
                    <td><img src="uploadPic/image/zdsyzrsy.jpg" alt="">
                        <P class="p1">峥嵘岁月</P>
                        <P class="p2">广州 湖州市实验学校</P>
                    </td>
                </tr>
            </table>

        </div>
    </div>
    <div id="footer">
        <div id="about">
            <h2>关于我们</h2>
            <p>传承红色精神 汲取青春奋进力量</p>
            <p>版权所有 &copy; 2023 </p>
        </div>
    </div>

</body>

</html>