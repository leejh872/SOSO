<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/SosoLogin.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- h1 타이틀 -->
	<h1>
		<a href="">soso</a>
	</h1>
	
	
	
	<table border="10">
		<thead>
			<tr>
				<td><a href="detail?code=1">사진</a></td>
				<td>태그</td>
			</tr>
		</thead>
	<tbody>
			<c:forEach var="n" items="${list}">
				<tr>
					<td>${n.code}</td>
					<td><a href="notice-detail?code=${n.code}">${n.photo}</a></td>
				</tr>
			</c:forEach>


		</tbody>
	
	
	
	
	
	
	
	<footer id="footer">
	<dl class="soso">
		<dt class="dt">CREATED BY SOSOHEA</dt>
		<dd>CEO: 이지혜</dd>

	</dl>

	<button type="button" name="upload" class="upload_button"><a href="upload">UPLOAD</a></button>

	</footer>
</body>
</html>