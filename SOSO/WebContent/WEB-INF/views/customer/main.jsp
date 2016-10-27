<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Main Page</title>
<link href="../css/SosoMain.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<!-- --------------------header-------------------- -->
	<header>
		<div class="content-container">
			<h1 >
				<a href="main" class="link">SOSOHEA</a>
			</h1>
			<section id="menu">
				<section>
					<form id="search">
						<input name="q" value=${param.q} > 
						<input type="submit" value="검색" />
					</form>
				</section>
				<nav id="main-menu" class="h-menu">
					<ul>
						<li><a href="user" class="link">JOIN/LOGIN</a></li>
						<li><a href="mypage" class="link">MY PAGE</a></li>
						<li><a href="aboutus" class="link">ABOUT US</a></li>
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
	<div id="photo" class="left">${n.photo}</div>
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
	</div>
	</main>
	<!-- --------------------footer-------------------- -->
	<footer id="footer">
		<div class="content-container">
			<dl class="soso">
				<dt class="dt">CREATED BY SOSOHEA</dt>
			</dl>
			<button type="button" name="upload" class="upload_button"><a href="upload" class="link">UPLOAD</a></button>
		</div>
	</footer>
</body>
</html>