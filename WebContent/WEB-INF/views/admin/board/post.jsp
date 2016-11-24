<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<main>
<div class="content-container">
	<div>
		<h1>포스트 목록</h1>

		<form action="post" method="get">
			<table>
				<tr>
					<td><select name="t">
							<option value="">분류선택</option>

							<c:if test="${param.t == 'STORY'}">
								<option value="STORY" selected="selected">내용</option>
							</c:if>
							<c:if test="${param.t != 'STORY'}">
								<option value="STORY">내용</option>
							</c:if>
							<c:if test="${param.t == 'EMAIL'}">
								<option value="EMAIL" selected="selected">작성자</option>
							</c:if>
							<c:if test="${param.t != 'EMAIL'}">
								<option value="EMAIL">작성자</option>
							</c:if>
							<c:if test="${param.t == 'TEMP_DEL'}">
								<option value="TEMP_DEL" selected="selected">임시 삭제</option>
							</c:if>
							<c:if test="${param.t != 'TEMP_DEL'}">
								<option value="TEMP_DEL">임시 삭제</option>
							</c:if>

					</select></td>

					<td colspan="3"><input type="text" name="q" value="${query}" /></td>
					<td><input type="submit" value="검색" /></td>

				</tr>
			</table>
		</form>

		<table class="table table-size table-style">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>내용</th>
					<th>날짜</th>
					<th>조회수</th>
					<th>임시 삭제</th>
				</tr>
			</thead>
			<c:forEach var="p" items="${plist}">
				<tr>
					<td>${p.code}</td>
					<td>${p.email}</td>
					<td><a href="${ctx}/customer/detail?code=${p.code}">${p.story}</a></td>
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
				</tr>
			</c:forEach>
		</table>
		<div>
			<h3 class="hidden">페이저</h3>
			<s:pager />
		</div>

	</div>
</div>
</main>