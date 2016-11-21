<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<main>

<div class="content-container-detail">

	<div class="content-container-detail-top">
		<div class="left">
			<!-- ${empty pn} -->
			<c:if test="${empty pn}">
				<!-- 이전글이 없습니다. -->
			</c:if>
			<c:if test="${not empty pn}">
				<a class="link" href="detail?code=${pn.code}"><img
					src="${ctx}/resource/images/left.png" width="30" height="30" /></a>
			</c:if>
		</div>
		<div class="left">
			<c:if test="${empty nn}">
				<!-- 다음글이 없습니다. -->
			</c:if>
			<c:if test="${not empty nn}">
				<a class="link" href="detail?code=${nn.code}"><img
					src="${ctx}/resource/images/right.png" width="30" height="30" /></a>
			</c:if>

		</div>


		<div class="right">
			<a href="detail-post-del?pcode=${p.code}" class="link">삭제</a>
		</div>
	</div>

	<h1 class="hidden">사진상세보기</h1>
	<!--  <a href="detail-like?plcode=${p.code}">-->

	<img src="${ctx}/customer/upload/${photo}" width="380" height="450"
		id="photo" class="content-container" />

	<%-- <div class="text">
				<form action="detail" method="post"/>
				<table>
					<tr>
						<td></td>
						<td><input type="submit" value="♡"/></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>좋아요</td>
					</tr>
					<tr>
						<td>${p.hit}</td>
						<td>${pl}</td>
					</tr>
				</table>
				</form>
			</div> --%>

	<!-- </a> -->
	<div id="story" class="content-container">
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
					<td colspan="7"><%-- <fmt:formatDate
							pattern="yyyy-MM-dd hh:mm:ss" value="${p.regdate}" /> --%>
							<span id="time-str"></span>
					</td>
				</tr>
				<tr>
					<td colspan="7">${p.story}</td>
				</tr>
			</tbody>
		</table>
		<br />
	</div>


	<div id="comment" class="content-container">
		<form action="detail" method="post">
			<fieldset>
				<table class="ctable">
					<thead>
						<tr>
							<input type="hidden" name="c_code" value="${p.code}" />
							<td colspan="4"><textarea name="content" rows="1" cols="100"></textarea></td>
							<td><input type="submit" value="등록" /></td>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="c" items="${clist}">
							<tr class="ctable-td">
								<td>${c.gender}</td>
								<td>${c.content}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
										value="${c.regdate}" /></td>
								<!-- admin이면 보이고 안보이고 처리하기 -->
								<td>${c.writer_email}</td>
								<td><a href="detail-cmt-del?ccode=${c.code}" class="link">삭제</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td>
								<%-- <c:if test="${empty param.p}">
									<c:set var="page" value="1" />
								</c:if> <c:if test="${not empty param.p}">
									<c:set var="page" value="${param.p}" />
								</c:if> <c:set var="start" value="${page-(page-1)%5}" /> <c:set
									var="end"
									value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" /> --%>

								<div>
									<h3 class="hidden">페이저</h3>
									<%-- <s:pager /> --%>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>

	</div>
</div>
</main>