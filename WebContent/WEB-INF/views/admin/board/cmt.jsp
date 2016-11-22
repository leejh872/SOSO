<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <%@ taglib prefix="s" tagdir="/WEB-INF/tags"%> --%>

<main>
<div class="content-container">
	<div>
		<h1>댓글 목록</h1>

		<form action="" method="post">
			<table  class="table-style">
				<tr>
					<td>검색창</td>
					<td colspan="3"><input type="text" name="title"
						value="${title}" /></td>
					<td><input type="submit" value="검색" /></td>

				</tr>
			</table>
		</form>

		<fieldset>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>내용</th>
						<th>포스트 번호</th>
						<th>날짜</th>
					</tr>
				</thead>
				<c:forEach var="c" items="${clist}">
					<tr>
						<td>${c.code}</td>
						<td>${c.writer_email}</td>
						<td>${c.content}</td>
						<td>${c.post_code}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
								value="${c.regdate}" /></td>
						<td><a href="cmt-del?ccode=${c.code}&cemail=${c.writer_email}">삭제</a></td>
					</tr>
					<tr>
						<c:if test="${empty param.p}">
							<c:set var="page" value="1" />
						</c:if>
						<c:if test="${not empty param.p}">
							<c:set var="page" value="${param.p}" />
						</c:if>
						<c:set var="start" value="${page-(page-1)%5}" />
						<c:set var="end"
							value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" />

						<div>
							<h3 class="hidden">페이저</h3>
							<s:pager />
						</div>
					</tr>
				</c:forEach>
			</table>
		</fieldset>

	</div>
</div>
</main>