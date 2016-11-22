<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>

<main>
<div class="content-container">
	<div>
		<h1>관리자 목록</h1>
		<form action="admin-add" method="post">
			<fieldset>
				<table class="table-style">
					<thead>
						<tr>
							<th>번호</th>
							<th>경고한 포스트</th>
							<th>경고한 댓글</th>
							<th>경고 아이디</th>
							<th>경고 횟수</th>
							<th>경고 이유</th>
							<th>관리자 아이디</th>
							<th>경고 날짜</th>
						</tr>
					</thead>
					<c:forEach var="w" items="${wlist}">
						<tr>
							<td>${w.code}</td>
							<td>${w.post_code}</td>
							<td>${w.cmt_code}</td>
							<td>${w.email}</td>
							<td>${w.num}</td>
							<td>${w.cause}</td>
							<td>${w.admin_email}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
									value="${w.regdate}" /></td>
							<td><a href="admin-del?acode=${w.code}">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>
		</form>
	</div>
</div>
</main>