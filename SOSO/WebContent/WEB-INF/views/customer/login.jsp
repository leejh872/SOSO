<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<header>
	<div class="content-container">
		<h1>
			<a href="">SOSOHEA</a>
		</h1>
		<section id="menu"> <section>
		<form id="search">
			<input value="" /> <input type="submit" value="검색" />
		</form>
		</section> <nav id="main-menu" class="h-menu">
		<ul>
			<li><a href="login.jsp">JOIN/LOGIN</a></li>
			<li><a href="mypage.jsp">MY PAGE</a></li>
			<li><a href="aboutus.jsp">ABOUT US</a></li>
		</ul>
		</nav> </section>
	</div>
	</header>
	<!-- --------------------aside-------------------- -->
	<aside> </aside>
	<!-- --------------------main-------------------- -->
	<main>
		<table border = "1">
			<tr>
				<td>아이디</td> 
				<td>이메일을 입력하세요</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>비밀번호를 입력하세요</td>
			</tr>
			<button type="button" name="login" class="login_button">Login</button>
		</table> 
	</main>
	<!-- --------------------footer-------------------- -->
	<footer id="footer">
	<dl class="soso">
		<dt class="dt">CREATED BY SOSOHEA</dt>
		<dd>CEO: SOSOHEA</dd>

	</dl>

	<button type="button" name="upload" class="upload_button">UPLOAD</button>

	</footer>
</body>
</html>