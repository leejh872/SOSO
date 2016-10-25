<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사진 상세보기</title>
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
				<td rowspan="5"></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3">${n["regdate"]}</td>
			</tr>
			<tr>
				<td colspan="4">${n.content}</td>
			</tr>
			<tr>
				<td>성별</td>
				<td colspan="2">내용</td>
				<td>날짜</td>
			</tr>
			<tr>
				<td>성별</td>
				<td colspan="2">${c.content}</td>
				<td>날짜</td>
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