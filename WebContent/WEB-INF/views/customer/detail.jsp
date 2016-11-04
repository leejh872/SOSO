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
			<a href="main" class="link">SOSOHEA</a>
		</h1>
		<section id="menu"> <section>
		<form id="search">
			<input value=""> <input type="submit" value="검색" />
		</form>
		</section> <nav id="main-menu" class="h-menu">
		<ul>
			<li><a href="user" class="link">JOIN/LOGIN</a></li>
			<li><a href="mypage" class="link">MY PAGE</a></li>
			<li><a href="aboutus" class="link">ABOUT US</a></li>
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
		<a href="detail">
			<div id="photo">
				<div class="text">
					<table>
						<tr>
							<td>조회수</td>
							<td>좋아요</td>
						</tr>
						<tr>
							<td>${p.hit}</td>
							<td>${pl}</td>
						</tr>
					</table>
				</div>
			</div>
		</a>
		<div>
			<table id="story">
				<tbody>
					<tr>
						<c:forEach var="t" items="${list}">
							<td>${t.name}</td>
							<c:if test="${t.code == 3}">
					</tr>
					<tr>
						</c:if>
						</c:forEach>
					</tr>
					<tr>
						<td colspan="7" style="text-align: right;"><fmt:formatDate
								pattern="yyyy-MM-dd hh:mm:ss" value="${p.regdate}" /></td>
					</tr>
					<tr>
						<td colspan="7">${p.story}</td>
					</tr>
				</tbody>
			</table>
			<br />

		</div>
		<div>
			<table id="comment">
				<tbody>
					<c:forEach var="c" items="${clist}">
						<tr>
							<td>${c.gender}</td>
							<td>${c.content}</td>
							<td>${c.regdate}</td>
							<td>${c.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	</main>

	<!-- --------------------footer-------------------- -->
	<footer id="footer">
	<h1 class="hidden">푸터</h1>
	<dl class="soso">
		<dt class="dt">CREATED BY SOSOHEA</dt>
	</dl>

	<button type="button" name="upload" class="upload_button">
		<a href="upload" class="link">UPLOAD</a>
	</button>
	</footer>
</body>
</html>