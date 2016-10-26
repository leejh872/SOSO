<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/SosoMain.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<!-- --------------------header-------------------- -->
	<header>
		<div class="content-container">
			<h1>
				<a href="notice">SOSOHEA</a>
			</h1>
			<section id="menu">
				<section>
					<form id="search">
						<input value="" /> <input type="submit" value="검색" />
					</form>
				</section>
				<nav id="main-menu" class="h-menu">
					<ul>
						<li><a href="user">JOIN/LOGIN</a></li>
						<li><a href="mypage">MY PAGE</a></li>
						<li><a href="aboutus">ABOUT US</a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>
	<!-- --------------------visual-------------------- -->
	<div id="visual">
		<div class="content-container"></div>
	</div>
	<!-- --------------------main-------------------- -->
	<main>
	<div class="content-container">
		<a href="detail?code=1"><img src="../images/고해상도풍차.bmp" 
			width="300" height="300" /></a> 
		<a href="detail?code=1"> <img src="../images/고해상도하늘.bmp" 
			width="300" height="300" /></a>
		<a href="detail?code=1"><img src="../images/고해상도호수.bmp" 
			width="300" height="300" /></a> 
		<a href="detail?code=1"><img src="../images/남3.JPG" 
			width="300" height="300" /></a> 
		<a href="detail?code=1"><img src="../images/제목 없음.bmp" 
			width="300" height="300" /></a> 
		<a href="detail?code=1"><img src="../images/푸른하늘야경.jpg" 
			width="300" height="300" /></a>
		<a href="detail?code=1"><img src="../images/8C07.jpg"
            width="300" height="300"/></a>
        <a href="detail?code=1"><img src="../images/002.jpg"
           	width="300" height="300"/></a>
        <a href="detail?code=1"><img src="../images/01089_toureiffel_1680x1050.jpg"
           	width="300" height="300"/></a>
        <a href="detail?code=1"><img src="../images/02.jpg"
           	width="300" height="300"/></a>
        <a href="detail?code=1"><img src="../images/3.JPG"
           	width="300" height="300"/></a>
        <a href="detail?code=1"><img src="../images/montrealur.jpg"
           	width="300" height="300"/></a>
           	<c:forEach var="n" items="${list}">
				<tr>
					<td>${n.code}</td>
					<td><a href="notice-detail?code=${n.code}">${n.photo}</a></td>
				</tr>
			</c:forEach>
	</div>
	</main>
	<!-- --------------------footer-------------------- -->
	<footer id="footer">
		<div class="content-container">
			<dl class="soso">
				<dt class="dt">CREATED BY SOSOHEA</dt>
			</dl>
			<button type="button" name="upload"><a href="upload">UPLOAD</a></button>
		</div>
	</footer>
</body>
</html>