<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사진 상세보기</title>
<link href="../css/SosoDetail.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- --------------------header-------------------- -->
	<header>
	<div class="content-container">
		<h1>
			<a href="notice">SOSOHEA</a>
		</h1>
		<section id="menu"> <section>
		<form id="search">
			<input value="" /> <input type="submit" value="검색" />
		</form>
		</section> <nav id="main-menu" class="h-menu">
		<ul>
			<li><a href="">JOIN/LOGIN</a></li>
			<li><a href="mypage">MY PAGE</a></li>
			<li><a href="aboutus">ABOUT US</a></li>
		</ul>
		</nav> </section>
	</div>
	</header>
	<!-- --------------------aside-------------------- -->
	<aside> </aside>
	<!-- --------------------main-------------------- -->
	<main>
	<h1 class="hidden">사진상세보기</h1>
	<div class="content-container-detail">
		<div id="photo" class="left">${n.photo}</div>
		<div>
			<table id="story">

				<tbody>
					<c:forEach var="t" items="${list}">
						<td>${t.name}</td>

					</c:forEach>
					</tr>
					<tr>
						<td colspan="7" style="text-align:right;">${n["regdate"]}</td>
					</tr>
					<tr>
						<td colspan="7">${n.story}</td>
					</tr>
				</tbody>
			</table>
			<br />

		</div>
		<div class="left">
		<table id="comment">
			<tbody>
				<tr>
					<td>성별</td>
					<td>${c.content}</td>
					<td>${c.regdate}</td>
					<td>${c.email}</td>
				</tr>
			</tbody>
		</table>
		</div>
		
	</div>
	
	</main>
	
	<!-- --------------------footer-------------------- -->
	<footer id="footer">
	<dl class="soso">
		<dt class="dt">CREATED BY SOSOHEA</dt>
		<dd>CEO: 이지혜</dd>

	</dl>

	<button type="button" name="upload" class="upload_button">UPLOAD</button>

	</footer>

</body>
</html>