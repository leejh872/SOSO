
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join Page</title>
<link href="../css/SosoJoin.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<header>
		<div class="content-container">
			<h1>
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
						<li><a href="login" class="link">JOIN/LOGIN</a></li>
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
			<form action="join" method="post">
				<fieldset id="join-form">
				<label>Welcome</label>
					<table align="center" id="join-table" >
						<tr>
							<option></option>
						</tr>
						<tr>
							<td ><input type="text" name="cellphone" placeholder="ex)+82)010-1234-5678" value = "${j.cellphone}"></td>
						</tr>
						<tr>
							<td ><input type="text" name="email" placeholder="E-mail" value="${j.email}"></td>
						</tr>
						<tr>
							<td><input type="password" name="password" placeholder="Password" value="${j.password}"></td>
						</tr>
					</table>
					<div id="join-menu">
						<div id="radio"><input type="radio" name="gender" value="M">M</div>
						<div id="radio"><input type="radio" name="gender" value="W">W</div>
						<div>
							<a href ="joinsuccess" class="link">
							<!-- <button type="button" name="join" class=" join-button">Join</button> -->
							<input type="submit" value="join"  class=" join-button"/>
							</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</main>
	<!-- --------------------footer-------------------- -->
	<footer id="footer">
		<div class="content-container">
			<dl class="soso">
				<dt class="dt">CREATED BY SOSOHEA</dt>
			</dl>
		
			<button type="button" name="upload" class="upload_button" ><a href="upload" class="link">UPLOAD</a></button>
	</div>
	</footer>
</body>
</html>