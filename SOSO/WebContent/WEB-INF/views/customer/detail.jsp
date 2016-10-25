<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사진 상세보기</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- --------------------header-------------------- -->
	<header> </header>
	<!-- --------------------aside-------------------- -->
	<aside> </aside>
	<!-- --------------------main-------------------- -->
	<!-- <main> --> 
	<h1>사진상세보기</h1>
	<table border="1">
		<tbody>
			<tr>
				<td rowspan="5">${n.photo}</td>
			</tr>
			
			<c:forEach var="t" items="${list}">
					<td>${t.name}</td>

			</c:forEach>
				<%-- <td>${t.name}</td>
				<td>${t.name}</td>
				<td>${t.name}</td>
				<td>${t.name}</td>
				<td>${t.name}</td>
				<td>${t.name}</td>
				<td>${t.name}</td> --%>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="6">${n["regdate"]}</td>
			</tr>
			<tr>
				<td colspan="7">${n.story}</td>
			</tr>
		</tbody>
	</table>
	<br/>
	<h2>댓글</h2>
	<table border="1">
		<tbody>
			<tr>
				<td>아이디</td>
				<td>성별</td>
				<td>내용</td>
				<td>날짜</td>
			</tr>
			<tr>
				<td>${c.email}</td>
				<td>성별</td>
				<td>${c.content}</td>
				<td>${c.regdate}</td>
			</tr>
		</tbody>
	</table>
	<!-- </main> -->
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