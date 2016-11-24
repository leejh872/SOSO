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
		<h1>회원 목록</h1>

		<form action="user" method="get">
			<table>
				<tr>
					<td><select name="t">
							<option value="">분류선택</option>

							<c:if test="${param.t == 'EMAIL'}">
								<option value="EMAIL" selected="selected">아이디</option>
							</c:if>
							<c:if test="${param.t != 'EMAIL'}">
								<option value="EMAIL">아이디</option>
							</c:if>
							<c:if test="${param.t == 'WAR_NUM'}">
								<option value="WAR_NUM" selected="selected">경고 횟수</option>
							</c:if>
							<c:if test="${param.t != 'WAR_NUM'}">
								<option value="WAR_NUM">경고 횟수</option>
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
					<th>아이디</th>
					<th>비밀번호</th>
					<th>전화번호</th>
					<th>성별</th>
					<th>가입 날짜</th>
					<th>경고 횟수</th>
					<th>권한</th>
				</tr>
			</thead>
			<c:forEach var="u" items="${ulist}">
				<tr>
					<td><a href="user-detail?wemail=${u.email}">${u.email}</a></td>
					<td>${u.pw}</td>
					<td>${u.cellphone}</td>
					<td>${u.gender}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${u.regdate}" /></td>
					<td>${u.war_num}</td>
					<td>${u.roleDName}</td>
					<td><a href="user-role?remail=${u.email}">권한변경</a></td>
					<td><a href="user-del?aemail=${u.email}">삭제</a></td>
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