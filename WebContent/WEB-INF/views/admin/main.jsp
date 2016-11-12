<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<main>
<div class="content-container">
	<div class="admin-menu">
		<a href="">관리자</a> <a href="">회원</a>
	</div>
	<div>
		<h1>관리자 목록</h1>
		<table>
			<thead>
				<tr>
					<th>관리자 아이디</th>
					<th>경고한 포스트</th>
					<th>경고한 댓글</th>
					<th>경고 날짜</th>
				</tr>
			</thead>
			<c:forEach var="a" items="${alist}">
				<tr>
					<td>${a.email}</td>
					<td>${a.post_code}</td>
					<td>${a.cmt_code}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
							value="${a.regdate}" /></td>
					<td><a href="admin-del?acode=${a.code}">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><input type="text" name="aemail" value="${aemail}" /></td>
				<td><input type="submit" value="추가" /></td>
			</tr>
		</table>
	</div>
</div>
</main>