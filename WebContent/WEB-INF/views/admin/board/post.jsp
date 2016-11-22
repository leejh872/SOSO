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
		<h1>포스트 목록</h1>

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
						<th>날짜</th>
						<th>조회수</th>
						<th>보임</th>
					</tr>
				</thead>
				<c:forEach var="p" items="${plist}">
					<tr>
						<td>${p.code}</td>
						<td>${p.email}</td>
						<td>${p.story}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
								value="${p.regdate}" /></td>
						<td>${p.hit}</td>
						<td>${p.temp_del}</td>
						<td><a href="post-del?pcode=${p.code}">삭제</a></td>
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