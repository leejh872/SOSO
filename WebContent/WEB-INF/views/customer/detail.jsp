<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main>
	<h1 class="hidden">사진상세보기</h1>
	<div class="content-container-detail">
		<a href="detail?code=${p.code}">
			<div id="photo">
				<div class="text">
					<table>
						<tr>
							<td>조회수</td>
							<td>좋아요</td>
						</tr>
						<tr>
							<td>${p.hit}</td>
							<td>${pl}</td>
						</tr>
					</table>
				</div>
			</div>
		</a>
		<div id="story">
			<table>
				<tbody>
					<tr>
						<c:forEach var="t" items="${list}">
							<td>${t.name}</td>
							<c:if test="${t.code == 3}">
					</tr>
					<tr>
						</c:if>
						</c:forEach>
					</tr>
					<tr>
						<td colspan="7" style="text-align: right;"><fmt:formatDate
								pattern="yyyy-MM-dd hh:mm:ss" value="${p.regdate}" /></td>
					</tr>
					<tr>
						<td colspan="7">${p.story}</td>
					</tr>
				</tbody>
			</table>
			<br />

		</div>
		<div class="comment">
			<form action="detail" method="post">
				<fieldset>
					<table class="ctable">
						<thead>
							<tr>
								<input type="hidden" name="c_code" value="${p.code}" />
								<td colspan="4"><textarea name="content" rows="1" cols="90"></textarea></td>
								<td><input type="submit" value="등록" /></td>

							</tr>
						</thead>

						<tbody>
							<c:forEach var="c" items="${clist}">
								<tr>
									<td>${c.gender}</td>
									<td>${c.content}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
											value="${c.regdate}" /></td>
									<td>${c.writer_email}</td>
									<td><a href="detail-del?code=${c.code}">삭제</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</fieldset>
			</form>
		</div>

	</div>
	</main>

	